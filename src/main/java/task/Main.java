package task;

import static task.ConstantMap.*;

import com.ibm.mq.MQMessage;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.headers.MQDataException;
import com.ibm.mq.headers.pcf.*;
import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.mq.jms.MQDestination;
import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import org.apache.commons.text.CaseUtils;
import org.apache.commons.text.WordUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.jms.Queue;
import javax.jms.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static String CONNECTION_LIST;
    private static String CHANNEL;
    private static String QMGR;
    private static String INPUT_QUEUE_NAME;
    private static String OUTPUT_QUEUE_NAME;
    private static boolean DEBUG_MODE;
    private static boolean OUTPUT_PERSISTENT;
    private static boolean SYNCPOINT_ENABLED;
    private static volatile boolean SHUTDOWN = false;
    private static Logger logger = null;

    private static final Map<Integer, String> openOptions = new LinkedHashMap<>() {{
        put(MQConstants.MQOO_ALTERNATE_USER_AUTHORITY, "altusr");
        // MQOO_BIND_AS_Q_DEF is default; value 0
        put(MQConstants.MQOO_BIND_ON_OPEN, "bind_on_open");
        put(MQConstants.MQOO_BIND_NOT_FIXED, "bind_not_fixed");
        put(MQConstants.MQOO_BIND_ON_GROUP, "bind_on_group");
        put(MQConstants.MQOO_BROWSE, "browse");
        put(MQConstants.MQOO_CO_OP, "coop");
        put(MQConstants.MQOO_FAIL_IF_QUIESCING, "fail_if_quiescing");
        put(MQConstants.MQOO_INPUT_AS_Q_DEF, "input_as_queue_def");
        put(MQConstants.MQOO_INPUT_SHARED, "input_shared");
        put(MQConstants.MQOO_INPUT_EXCLUSIVE, "input_exclusive");
        put(MQConstants.MQOO_INQUIRE, "inq");
        // MQOO_READ_AHEAD_AS_Q_DEF is default; value 0
        put(MQConstants.MQOO_NO_READ_AHEAD, "no_read_ahead");
        put(MQConstants.MQOO_OUTPUT, "output");
        put(MQConstants.MQOO_PASS_ALL_CONTEXT, "passall");
        put(MQConstants.MQOO_PASS_IDENTITY_CONTEXT, "passid");
        put(MQConstants.MQOO_READ_AHEAD, "read_ahead");
        put(MQConstants.MQOO_RESOLVE_LOCAL_Q, "resolve_queue");
        put(MQConstants.MQOO_RESOLVE_NAMES, "resolve_names");
        put(MQConstants.MQOO_SAVE_ALL_CONTEXT, "save_context");
        put(MQConstants.MQOO_SET, "set");
        put(MQConstants.MQOO_SET_ALL_CONTEXT, "setall");
        put(MQConstants.MQOO_SET_IDENTITY_CONTEXT, "setid");
    }};
    private static final Map<Integer, String> closeOptions = new LinkedHashMap<>() {{
        put(MQConstants.MQCO_DELETE, "delete");
        put(MQConstants.MQCO_DELETE_PURGE, "delete_purge");
        put(MQConstants.MQCO_KEEP_SUB, "keep_sub");
        put(MQConstants.MQCO_REMOVE_SUB, "remove_sub");
        put(MQConstants.MQCO_QUIESCE, "quiesce");
    }};
    private static final Map<Integer, String> subOptions = new LinkedHashMap<>() {{
        put(MQConstants.MQSO_ALTERNATE_USER_AUTHORITY, "altusr");
        put(MQConstants.MQSO_ALTER, "alter");
        put(MQConstants.MQSO_CREATE, "create");
        put(MQConstants.MQSO_RESUME, "resume");
        put(MQConstants.MQSO_DURABLE, "durable");
        put(MQConstants.MQSO_GROUP_SUB, "group_sub");
        put(MQConstants.MQSO_MANAGED, "managed");
        put(MQConstants.MQSO_SET_IDENTITY_CONTEXT, "setid");
        put(MQConstants.MQSO_NO_MULTICAST, "no_multicast");
        put(MQConstants.MQSO_FIXED_USERID, "fixed_user_id");
        put(MQConstants.MQSO_ANY_USERID, "any_user_id");
        put(MQConstants.MQSO_PUBLICATIONS_ON_REQUEST, "pub_on_request");
        put(MQConstants.MQSO_NEW_PUBLICATIONS_ONLY, "new_pub_only");
        put(MQConstants.MQSO_FAIL_IF_QUIESCING, "fail_if_quiescing");
        put(MQConstants.MQSO_WILDCARD_CHAR, "wildcard_char");
        put(MQConstants.MQSO_WILDCARD_TOPIC, "wildcard_topic");
        put(MQConstants.MQSO_SET_CORREL_ID, "set_correl_id");
        put(MQConstants.MQSO_SCOPE_QMGR, "scope_qmgr");
        put(MQConstants.MQSO_NO_READ_AHEAD, "no_read_ahead");
        put(MQConstants.MQSO_READ_AHEAD, "read_ahead");
    }};

    public static void main(String[] args) {
        // Add SIGTERM handling
        setupLogging();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Received SIGTERM, shutting down");
            SHUTDOWN = true;
        }));
        // In exceptional circumstances, log exceptions we cannot expect.
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> logger.fatal(thread + "threw exception " + exception));

        Main main = new Main();
        main.initialise();
    }

    public Main() {}

    private void initialise() {
        try {
            readConfig();
            // TODO: Maybe make this application process messages in batches? This allows for more efficient MQCMIT
            // Which therefore means we should get better performance.
            commonStartup();
        } catch (JMSException | IOException | MQDataException | JSONException exception) {
            List<String> exceptionMessages = new ArrayList<>();
            exceptionMessages.add(exception.getMessage());
            Throwable exceptionCause = exception.getCause();
            while (exceptionCause != null) {
                exceptionMessages.add(exceptionCause.getMessage());
                exceptionCause = exceptionCause.getCause();
            }
            for (String message : exceptionMessages) {
                logger.fatal(message);
            }
        }
    }

    private static void setupLogging() {
        System.setProperty("log4j2.configurationFile", "config/log4j2.properties");
        logger = LogManager.getLogger();
    }

    private static void readConfig() throws IOException {
        Properties config = new Properties();
        String fileName = "config/app.properties";

        FileInputStream inputFileStream = new FileInputStream(fileName);
        config.load(inputFileStream);

        DEBUG_MODE = Boolean.parseBoolean(config.getProperty("debug_mode"));
        CONNECTION_LIST = config.getProperty("connection_list");
        CHANNEL = config.getProperty("channel");
        QMGR = config.getProperty("queue_manager");
        INPUT_QUEUE_NAME = config.getProperty("input_queue_name");
        OUTPUT_QUEUE_NAME = config.getProperty("output_queue_name");
        OUTPUT_PERSISTENT = Boolean.parseBoolean(config.getProperty("output_message_persistent"));
        SYNCPOINT_ENABLED = Boolean.parseBoolean(config.getProperty("syncpoint_enabled"));

        inputFileStream.close();
    }

    private void commonStartup() throws JSONException, JMSException, IOException, MQDataException {
        MQConnectionFactory connectionFactory = setupConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        logger.info("Created and started connection to queue manager {} on {}", QMGR, CONNECTION_LIST);
        Session session = connection.createSession(SYNCPOINT_ENABLED, Session.AUTO_ACKNOWLEDGE);
        MQDestination inputQueue = (MQDestination) session.createQueue("queue:///" + INPUT_QUEUE_NAME);
        inputQueue.setReceiveConversion(WMQConstants.WMQ_RECEIVE_CONVERSION_QMGR);
        inputQueue.setReceiveCCSID(WMQConstants.CCSID_UTF8);
        MQDestination outputQueue = (MQDestination) session.createQueue("queue:///" + OUTPUT_QUEUE_NAME);
        outputQueue.setMessageBodyStyle(WMQConstants.WMQ_MESSAGE_BODY_MQ);
        if (OUTPUT_PERSISTENT) {
            outputQueue.setPersistence(WMQConstants.DELIVERY_PERSISTENT);
        }

        if (DEBUG_MODE) {
            startupDebugMode(session, inputQueue, outputQueue);
        } else {
            startupProductionMode(session, inputQueue, outputQueue);
        }

        session.close();
        logger.info("Successfully closed session to queue manager {}", QMGR);
        connection.close();
        logger.info("Successfully closed connection to queue manager {} on {}", QMGR, CONNECTION_LIST);
    }

    private void startupDebugMode(Session session, MQDestination inputQueue, MQDestination outputQueue) throws JMSException, JSONException, IOException, MQDataException {
        long startTime = System.currentTimeMillis();
        int counter = 0;
        logger.info("System running in debug mode! Messages will not be destructively consumed from the input queue.");

        QueueBrowser browser = session.createBrowser((Queue) inputQueue);
        logger.info("Created browser to queue {}", INPUT_QUEUE_NAME);
        Enumeration<Message> messages = (Enumeration<Message>) browser.getEnumeration();
        MessageProducer producer = session.createProducer(outputQueue);
        logger.info("Created producer to queue {}", OUTPUT_QUEUE_NAME);

        logger.info("Beginning message processing...");
        while(messages.hasMoreElements()) {
            Message message = messages.nextElement();
            JSONObject jsonMessage = processMessage(message);

            // If message is null, this means it failed basic sanity checks or otherwise was unable to be
            // processed at all. Backout this message if we encounter this scenario.
            if (jsonMessage == null) {
                session.rollback();
                logger.error("Backed out current transaction!");
                continue;
            }

            TextMessage outputMessage = session.createTextMessage(jsonMessage.toString());
            producer.send(outputMessage);
            counter += 1;

            if (counter % 100 == 0) {
                session.commit();
                logger.debug("Committed current transaction");
            }
        }
        // Commit remaining batch before shutting down.
        session.commit();

        browser.close();
        logger.info("Successfully closed browser to queue {}", INPUT_QUEUE_NAME);
        producer.close();
        logger.info("Successfully closed producer to queue {}", OUTPUT_QUEUE_NAME);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        logger.info("We processed {} messages in {} milliseconds", counter, totalTime);
    }

    private void startupProductionMode(Session session, MQDestination inputQueue, MQDestination outputQueue) throws JMSException, JSONException, IOException, MQDataException {
        MessageProducer producer = session.createProducer(outputQueue);
        logger.info("Created producer to queue {}", OUTPUT_QUEUE_NAME);
        MessageConsumer consumer = session.createConsumer(inputQueue);
        logger.info("Created consumer to queue {}", INPUT_QUEUE_NAME);

        logger.info("Beginning message processing...");
        while (!SHUTDOWN) {
            Message message = consumer.receive();
            logger.debug("Received new message, started new transaction");

            if (message == null) {
                throw new IllegalStateException("Message consumer is closed!");
            }

            JSONObject jsonMessage = processMessage(message);
            // If message is null, this means it failed basic sanity checks or otherwise was unable to be
            // processed at all. Backout this message if we encounter this scenario.
            if (jsonMessage == null) {
                session.rollback();
                logger.error("Backed out current transaction!");
                continue;
            }

            TextMessage outputMessage = session.createTextMessage(jsonMessage.toString());
            producer.send(outputMessage);
            // We commit for every message at the moment, less performant but there are plans to add the
            // capability to handle batching. Needs to be configurable by the user, because the amount of
            // load will determine the need for batched commits or not.
            session.commit();
            logger.debug("Committed current transaction");
            logger.info("Completed processing for current message.");
        }

        producer.close();
        logger.info("Successfully closed producer to queue {}", OUTPUT_QUEUE_NAME);
        consumer.close();
        logger.info("Successfully closed consumer to queue {}", INPUT_QUEUE_NAME);
    }

    private MQConnectionFactory setupConnectionFactory() throws JMSException {
        JmsFactoryFactory jmsFactoryFactory = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
        JmsConnectionFactory jmsConnectionFactory = jmsFactoryFactory.createConnectionFactory();
        MQConnectionFactory mqConnectionFactory = (MQConnectionFactory) jmsConnectionFactory;

        mqConnectionFactory.setConnectionNameList(CONNECTION_LIST);
        mqConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
        mqConnectionFactory.setChannel(CHANNEL);
        mqConnectionFactory.setQueueManager(QMGR);
        mqConnectionFactory.setAppName("Event Consumer");

        return mqConnectionFactory;
    }

    private JSONObject processMessage(Message receivedMessage) throws IOException, MQDataException, JSONException, JMSException {
        MQMessage mqMessage = convertToMQMessage(receivedMessage);

        if (!checkMessageSanity(mqMessage)) {
            logger.error("Message failed basic sanity checks!");
            return null;
        }

        PCFMessage pcfMessage = new PCFMessage(mqMessage);
        MQCFH pcfHeader = pcfMessage.getHeader();

        JSONObject jsonMessage = new JSONObject();
        // We use a mix of pcfHeader + receivedMessage here because after converting
        // to MQMessage, we lose all the JMS data. So get what we need from the
        // message descriptor using the JMS getters.
        jsonMessage.put("eventType", getEventType(pcfHeader));
        jsonMessage.put("eventReason", getEventReason(pcfHeader));
        jsonMessage.put("eventCreation", getEventTime(receivedMessage));
        getCorrelationID(pcfMessage, receivedMessage, jsonMessage);
        getConfigEventType(pcfHeader, jsonMessage);

        JSONObject eventData = new JSONObject();
        processPCFParameters(pcfMessage, eventData);
        jsonMessage.put("eventData", eventData);
        return jsonMessage;
    }

    private MQMessage convertToMQMessage(Message receivedMessage) throws JMSException, IOException {
        BytesMessage bytesMessage = (BytesMessage) receivedMessage;
        byte[] bytesReceived = new byte[(int) bytesMessage.getBodyLength()];
        bytesMessage.readBytes(bytesReceived);

        // Convert to MQ Message, then to PCF Message to fix little endian dramas
        MQMessage mqMessage = new MQMessage();
        mqMessage.write(bytesReceived);
        mqMessage.encoding = receivedMessage.getIntProperty("JMS_IBM_Encoding");
        mqMessage.format = receivedMessage.getStringProperty("JMS_IBM_Format");
        mqMessage.seek(0);

        return mqMessage;
    }

    private JSONObject getEventType(MQCFH pcfHeader) throws JSONException {
        int commandInt = pcfHeader.getCommand();
        String commandString = MQCMD_STR(commandInt);
        commandString = formatConstant(commandString);
        JSONObject eventType = new JSONObject();
        eventType.put("name", commandString);
        eventType.put("value", commandInt);
        return eventType;
    }

    private JSONObject getEventReason(MQCFH pcfHeader) throws JSONException {
        int eventReasonInt = pcfHeader.getReason();
        String eventReasonString = MQRC_STR(eventReasonInt);
        eventReasonString = formatConstant(eventReasonString);
        JSONObject eventReason = new JSONObject();
        eventReason.put("name", eventReasonString);
        eventReason.put("value", eventReasonInt);
        return eventReason;
    }

    private JSONObject getEventTime(Message receivedMessage) throws JMSException, JSONException {
        Instant instant = Instant.ofEpochMilli(receivedMessage.getJMSTimestamp());
        ZonedDateTime zonedDateTime = instant.atZone(ZoneOffset.UTC);
        JSONObject eventCreation = new JSONObject();
        eventCreation.put("timestamp", zonedDateTime.toString());
        eventCreation.put("epoch", receivedMessage.getJMSTimestamp());
        return eventCreation;
    }

    private void getCorrelationID(PCFMessage pcfMessage, Message receivedMessage, JSONObject jsonMessage) throws JMSException, JSONException {
        if (pcfMessage.getCommand() == MQConstants.MQCMD_CONFIG_EVENT
                || pcfMessage.getCommand() == MQConstants.MQCMD_COMMAND_EVENT) {
            String correlationID = receivedMessage.getJMSCorrelationID().substring(3);
            // Was easier to just strip off the "ID:" that's prepended to the correlation
            // ID by the JMS method. The alternative is get it as bytes and use a StringBuilder
            // to rebuild the hex string but that's considerably less performant for no gain.
            jsonMessage.put("correlationID", correlationID.toUpperCase());
        }
    }

    private void getConfigEventType(MQCFH pcfHeader, JSONObject jsonMessage) throws JSONException {
        if (pcfHeader.getReason() == MQConstants.MQRC_CONFIG_CHANGE_OBJECT) {
            if (pcfHeader.getControl() == MQConstants.MQCFC_LAST) {
                jsonMessage.put("objectState", "After Change");
            } else {
                jsonMessage.put("objectState", "Before Change");
            }
        }
    }

    private boolean checkMessageSanity(MQMessage mqMessage) {
        switch (mqMessage.format) {
            case MQConstants.MQFMT_EVENT:
            case MQConstants.MQFMT_PCF:
            case MQConstants.MQFMT_EMBEDDED_PCF:
            case MQConstants.MQFMT_ADMIN:
                break;
            default:
                logger.error("Message is not a recognised event format");
                logger.error(mqMessage.format);
                return false;
        }

        if (mqMessage.messageType > MQConstants.MQCFT_STATUS) {
            logger.error("Message is not in event message range. It is of type {}", mqMessage.messageType);
            return false;
        }

        int messageVersion = mqMessage.getVersion();
        if (messageVersion < MQConstants.MQCFH_VERSION_1 || messageVersion > MQConstants.MQCFH_CURRENT_VERSION) {
            logger.error("Message header is the wrong version. Version is {}", messageVersion);
            return false;
        }

        return true;
    }

    private void processPCFParameters(PCFMessage message, JSONObject eventData) throws JSONException {
        Enumeration<PCFParameter> parameters = message.getParameters();

        while (parameters.hasMoreElements()) {
            PCFParameter parameter = parameters.nextElement();
            processPCFParameter(parameter, eventData);
        }
    }

    private void processPCFParameter(PCFParameter parameter, JSONObject eventData) throws JSONException {
        switch (parameter.getType()) {
            // Recursively process parameters inside groups. Usually will only have depths
            // of 1 or 2 from what I've seen.
            case MQConstants.MQCFT_GROUP:
                processCFGR((MQCFGR) parameter, eventData);
                break;

            case MQConstants.MQCFT_INTEGER64_LIST:
                processCFIL64((MQCFIL64) parameter, eventData);
                break;

            case MQConstants.MQCFT_INTEGER_LIST:
                processCFIL((MQCFIL) parameter, eventData);
                break;

            case MQConstants.MQCFT_STRING_LIST:
                processCFSL((MQCFSL) parameter, eventData);
                break;

            case MQConstants.MQCFT_STRING:
                processCFST((MQCFST) parameter, eventData);
                break;

            case MQConstants.MQCFT_INTEGER64:
                processCFIN64((MQCFIN64) parameter, eventData);
                break;

            case MQConstants.MQCFT_INTEGER:
                processCFIN((MQCFIN) parameter, eventData);
                break;

            case MQConstants.MQCFT_BYTE_STRING:
                processCFBS((MQCFBS) parameter, eventData);
                break;

            case MQConstants.MQCFT_INTEGER_FILTER:
                processCFIF((MQCFIF) parameter, eventData);
                break;

            case MQConstants.MQCFT_STRING_FILTER:
                processCFSF((MQCFSF) parameter, eventData);
                break;

            case MQConstants.MQCFT_BYTE_STRING_FILTER:
                processCFBF((MQCFBF) parameter, eventData);
                break;
        }
    }

    private void processCFGR(MQCFGR parameter, JSONObject eventData) throws JSONException {
        Enumeration<PCFParameter> parameters = parameter.getParameters();

        String parameterName = MQGACF_STR(parameter.getParameter());
        String formattedParameterName = formatConstant(parameterName, true);
        JSONObject groupData = new JSONObject();
        while (parameters.hasMoreElements()) {
            PCFParameter pcfParameter = parameters.nextElement();
            processPCFParameter(pcfParameter, groupData);
            eventData.put(formattedParameterName, groupData);
        }
    }

    private void processCFIL64(MQCFIL64 parameter, JSONObject eventData) throws JSONException {
        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQIA");
        if (parameterName != null) {
            String formattedParameterName = formatConstant(parameterName, true);
            long[] values = parameter.getValues();
            eventData.put(formattedParameterName, values);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFIL64 returned null. Integer value was: %d", parameter.getParameter()));
        }
    }

    private void processCFIL(MQCFIL parameter, JSONObject eventData) throws JSONException {
        int[] values = parameter.getValues();
        String valueName;

        List<Object> valueNames = new ArrayList<>();

        for (int value : values) {
            switch (parameter.getParameter()) {
                case MQConstants.MQIACH_HDR_COMPRESSION:
                case MQConstants.MQIACH_MSG_COMPRESSION:
                    valueName = MQCOMPRESS_STR(value);
                    valueName = formatConstant(valueName);
                    valueNames.add(valueName);
                    break;
                case MQConstants.MQIACF_AUTH_ADD_AUTHS:
                case MQConstants.MQIACF_AUTH_REMOVE_AUTHS:
                case MQConstants.MQIACF_AUTHORIZATION_LIST:
                    valueName = MQAUTH_STR(value);
                    valueName = formatConstant(valueName);
                    valueNames.add(valueName);
                    break;
                case MQConstants.MQIACF_AMQP_ATTRS:
                case MQConstants.MQIACF_AUTH_INFO_ATTRS:
                case MQConstants.MQIACF_AUTH_PROFILE_ATTRS:
                case MQConstants.MQIACF_AUTH_SERVICE_ATTRS:
                case MQConstants.MQIACF_CF_STRUC_ATTRS:
                case MQConstants.MQIACF_CHANNEL_ATTRS:
                case MQConstants.MQIACF_CHLAUTH_ATTRS:
                case MQConstants.MQIACF_CLUSTER_Q_MGR_ATTRS:
                case MQConstants.MQIACF_COMM_INFO_ATTRS:
                case MQConstants.MQIACF_CONNECTION_ATTRS:
                case MQConstants.MQIACF_INT_ATTRS:
                case MQConstants.MQIACF_LISTENER_ATTRS:
                case MQConstants.MQIACF_LISTENER_STATUS_ATTRS:
                case MQConstants.MQIACF_NAMELIST_ATTRS:
                case MQConstants.MQIACF_PROCESS_ATTRS:
                case MQConstants.MQIACF_PUBSUB_STATUS_ATTRS:
                case MQConstants.MQIACF_Q_ATTRS:
                case MQConstants.MQIACF_Q_MGR_ATTRS:
                case MQConstants.MQIACF_Q_MGR_STATUS_ATTRS:
                case MQConstants.MQIACF_Q_STATUS_ATTRS:
                case MQConstants.MQIACF_SECURITY_ATTRS:
                case MQConstants.MQIACF_SERVICE_ATTRS:
                case MQConstants.MQIACF_SERVICE_STATUS_ATTRS:
                case MQConstants.MQIACF_SMDS_ATTRS:
                case MQConstants.MQIACF_STORAGE_CLASS_ATTRS:
                case MQConstants.MQIACF_SUB_ATTRS:
                case MQConstants.MQIACF_SUB_STATUS_ATTRS:
                case MQConstants.MQIACF_TOPIC_ATTRS:
                case MQConstants.MQIACF_TOPIC_STATUS_ATTRS:
                case MQConstants.MQIACF_XR_ATTRS:
                case MQConstants.MQIACH_CHANNEL_INSTANCE_ATTRS:
                case MQConstants.MQIACH_CHANNEL_SUMMARY_ATTRS:
                    valueName = lookupMultiMQConstant(value, "MQIA");

                    if (valueName == null) {
                        valueName = lookupMultiMQConstant(value, "MQCA");
                    }

                    if (valueName == null) {
                        valueName = MQBACF_STR(value);
                    }

                    valueName = formatConstant(valueName);
                    valueNames.add(valueName);
                    break;
                case MQConstants.MQIA_SUITE_B_STRENGTH:
                    valueName = MQ_SUITE_STR(value);
                    valueName = formatConstant(valueName);
                    valueNames.add(valueName);
                    break;
                default:
                    // If the value is not one of the above, it's likely coming from
                    // an accounting or statistics message. In that case, we just
                    // add the raw value to the output list. In the future a dedicated
                    // function to handle accounting & statistics messages may be
                    // created.
                    valueNames.add(value);
                    break;
            }
        }

        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQIA");
        if (parameterName != null) {
            String formattedParameterName = formatConstant(parameterName, true);
            eventData.put(formattedParameterName, valueNames);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFIL returned null! Integer value was: %d", parameter.getParameter()));
        }
    }

    private void processCFSL(MQCFSL parameter, JSONObject eventData) throws JSONException {
        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQCA");
        if (parameterName != null) {
            String formattedParameterName = formatConstant(parameterName, true);
            String[] values = parameter.getStrings();
            eventData.put(formattedParameterName, values);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFSL returned null! Integer value was: %d", parameter.getParameter()));
        }
    }

    private void processCFST(MQCFST parameter, JSONObject eventData) throws JSONException {
        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQCA");
        if (parameterName != null) {
            String formattedParameterName = formatConstant(parameterName, true);
            // Trim off the excess spaces that come from IBM's spacing requirements.
            String value = parameter.getString().trim();
            eventData.put(formattedParameterName, value);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFST returned null! Integer value was: %d", parameter.getParameter()));
        }
    }

    private void processCFIN64(MQCFIN64 parameter, JSONObject eventData) throws JSONException {
        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQIA");
        if (parameterName != null) {
            String formattedParameterName = formatConstant(parameterName, true);
            long value = parameter.getLongValue();
            eventData.put(formattedParameterName, value);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFIN64 returned null! Integer value was: %d", parameter.getParameter()));
        }
    }

    private void processCFIN(MQCFIN parameter, JSONObject eventData) throws JSONException {
        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQIA");
        String formattedParameterName;
        if (parameterName != null) {
            formattedParameterName = formatConstant(parameterName, true);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFIN returned null! Integer value was: %d", parameter.getParameter()));
        }

        final int parameterValue = parameter.getIntValue();
        String valueName;
        Supplier<String> filter = null;
        JSONObject optionsJSON;

        switch (parameter.getParameter()) {
            case MQConstants.MQIA_ACCOUNTING_CONN_OVERRIDE:
            case MQConstants.MQIA_ACCOUNTING_MQI:
            case MQConstants.MQIA_ACCOUNTING_Q:
            case MQConstants.MQIA_ACTIVITY_CONN_OVERRIDE:
            case MQConstants.MQIA_ACTIVITY_TRACE:
            case MQConstants.MQIA_MONITORING_AUTO_CLUSSDR:
            case MQConstants.MQIA_MONITORING_CHANNEL:
            case MQConstants.MQIA_MONITORING_Q:
            case MQConstants.MQIA_STATISTICS_AUTO_CLUSSDR:
            case MQConstants.MQIA_STATISTICS_CHANNEL:
            case MQConstants.MQIA_STATISTICS_MQI:
            case MQConstants.MQIA_STATISTICS_Q:
                // We can't alter the parameterValue as it's final (this is done to satisfy lambda requirements)
                // But what we can do is copy it, and then manually handle the z/OS bug.
                int tempValue = parameterValue;
                if (parameterValue == 253) {
                    // Bug in some z/OS versions - ported from amqsevt
                    tempValue = -3;
                }

                valueName = MQMON_STR(tempValue);
                valueName = formatConstant(valueName);
                eventData.put(formattedParameterName, valueName);
                break;
            case MQConstants.MQIA_ACTIVITY_RECORDING:
            case MQConstants.MQIA_TRACE_ROUTE_RECORDING:
                filter = () -> MQRECORDING_STR(parameterValue);
                break;
            case MQConstants.MQIA_ADOPT_CONTEXT:
                filter = () -> MQADPCTX_STR(parameterValue);
                break;
            case MQConstants.MQIA_ADOPTNEWMCA_CHECK:
                filter = () -> MQADOPT_CHECK_STR(parameterValue);
                break;
            case MQConstants.MQIA_ADOPTNEWMCA_TYPE:
                filter = () -> MQADOPT_TYPE_STR(parameterValue);
                break;
            case MQConstants.MQIA_APPL_TYPE:
            case MQConstants.MQIACF_EVENT_APPL_TYPE:
                filter = () -> MQAT_STR(parameterValue);
                break;
            case MQConstants.MQIA_AUTH_INFO_TYPE:
                filter = () -> MQAIT_STR(parameterValue);
                break;
            case MQConstants.MQIA_AUTHENTICATION_METHOD:
                filter = () -> MQAUTHENTICATE_STR(parameterValue);
                break;
            case MQConstants.MQIA_AUTHORITY_EVENT:
            case MQConstants.MQIA_BRIDGE_EVENT:
            case MQConstants.MQIA_CHANNEL_AUTO_DEF_EVENT:
            case MQConstants.MQIA_CHANNEL_EVENT:
            case MQConstants.MQIA_COMMAND_EVENT:
            case MQConstants.MQIA_COMM_EVENT:
            case MQConstants.MQIA_CONFIGURATION_EVENT:
            case MQConstants.MQIA_INHIBIT_EVENT:
            case MQConstants.MQIA_LOCAL_EVENT:
            case MQConstants.MQIA_LOGGER_EVENT:
            case MQConstants.MQIA_PERFORMANCE_EVENT:
            case MQConstants.MQIA_Q_DEPTH_HIGH_EVENT:
            case MQConstants.MQIA_Q_DEPTH_LOW_EVENT:
            case MQConstants.MQIA_Q_DEPTH_MAX_EVENT:
            case MQConstants.MQIA_Q_SERVICE_INTERVAL_EVENT:
            case MQConstants.MQIA_REMOTE_EVENT:
            case MQConstants.MQIA_START_STOP_EVENT:
            case MQConstants.MQIA_SSL_EVENT:
                filter = () -> MQEVR_STR(parameterValue);
                break;
            case MQConstants.MQIA_AUTO_REORGANIZATION:
                filter = () -> MQREORG_STR(parameterValue);
                break;
            case MQConstants.MQIA_BASE_TYPE :
                filter = () -> MQOT_STR(parameterValue);
                break;
            case MQConstants.MQIA_CERT_VAL_POLICY:
                filter = () -> MQ_CERT_STR(parameterValue);
                break;
            case MQConstants.MQIA_CF_CFCONLOS:
            case MQConstants.MQIA_QMGR_CFCONLOS:
                filter = () -> MQCFCONLOS_STR(parameterValue);
                break;
            case MQConstants.MQIA_CF_RECAUTO:
                filter = () -> MQRECAUTO_STR(parameterValue);
                break;
            case MQConstants.MQIA_CF_RECOVER:
                filter = () -> MQCFR_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHANNEL_AUTO_DEF:
                filter = () -> MQCHAD_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHECK_CLIENT_BINDING:
            case MQConstants.MQIA_CHECK_LOCAL_BINDING:
                filter = () -> MQCHK_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHINIT_CONTROL:
            case MQConstants.MQIA_CMD_SERVER_CONTROL:
            case MQConstants.MQIA_SERVICE_CONTROL:
            case MQConstants.MQIACH_LISTENER_CONTROL:
                filter = () -> MQSVC_CONTROL_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHINIT_TRACE_AUTO_START:
                filter = () -> MQTRAXSTR_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHLAUTH_RECORDS:
                filter = () -> MQCHLA_STR(parameterValue);
                break;
            case MQConstants.MQIA_CLUSTER_PUB_ROUTE:
                filter = () -> MQCLROUTE_STR(parameterValue);
                break;
            case MQConstants.MQIA_CLWL_USEQ :
                filter = () -> MQCLWL_STR(parameterValue);
                break;
            case MQConstants.MQIA_COMM_INFO_TYPE:
                filter = () -> MQCIT_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_BIND:
                filter = () -> MQBND_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_CLUSTER_XMIT_Q_TYPE:
                filter = () -> MQCLXQ_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_INPUT_OPEN_OPTION:
                filter = () -> MQOO_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_PERSISTENCE:
            case MQConstants.MQIA_TOPIC_DEF_PERSISTENCE:
                filter = () -> MQPER_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_PUT_RESPONSE_TYPE:
                filter = () -> MQPRT_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_READ_AHEAD:
                filter = () -> MQREADA_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEFINITION_TYPE :
                filter = () -> MQQDT_STR(parameterValue);
                break;
            case MQConstants.MQIA_DIST_LISTS:
                filter = () -> MQDL_STR(parameterValue);
                break;
            case MQConstants.MQIA_DNS_WLM:
                filter = () -> MQDNSWLM_STR(parameterValue);
                break;
            case MQConstants.MQIA_DURABLE_SUB:
                filter = () -> MQSUB_STR(parameterValue);
                break;
            case MQConstants.MQIA_ENCRYPTION_ALGORITHM:
                filter = () -> MQMLP_ENCRYPTION_STR(parameterValue);
                break;
            case MQConstants.MQIA_GROUP_UR:
                filter = () -> MQGUR_STR(parameterValue);
                break;
            case MQConstants.MQIA_HARDEN_GET_BACKOUT:
                filter = () -> MQQA_BACKOUT_STR(parameterValue);
                break;
            case MQConstants.MQIA_IGQ_PUT_AUTHORITY:
                filter = () -> MQIGQPA_STR(parameterValue);
                break;
            case MQConstants.MQIA_INDEX_TYPE :
                filter = () -> MQIT_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_GET :
                filter = () -> MQQA_GET_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_PUB :
                filter = () -> MQTA_PUB_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_PUT :
                filter = () -> MQQA_PUT_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_SUB :
                filter = () -> MQTA_SUB_STR(parameterValue);
                break;
            case MQConstants.MQIA_INTRA_GROUP_QUEUING:
                filter = () -> MQIGQ_STR(parameterValue);
                break;
            case MQConstants.MQIA_IP_ADDRESS_VERSION:
                filter = () -> MQIPADDR_STR(parameterValue);
                break;
            case MQConstants.MQIA_LDAP_AUTHORMD:
                filter = () -> MQLDAP_AUTHORMD_STR(parameterValue);
                break;
            case MQConstants.MQIA_LDAP_NESTGRP:
                filter = () -> MQLDAP_NESTGRP_STR(parameterValue);
                break;
            case MQConstants.MQIA_LDAP_SECURE_COMM:
                filter = () -> MQSECCOMM_STR(parameterValue);
                break;
            case MQConstants.MQIA_MCAST_BRIDGE:
                filter = () -> MQMCB_STR(parameterValue);
                break;
            case MQConstants.MQIA_MSG_DELIVERY_SEQUENCE :
                filter = () -> MQMDS_STR(parameterValue);
                break;
            case MQConstants.MQIA_MULTICAST:
                filter = () -> MQMC_STR(parameterValue);
                break;
            case MQConstants.MQIA_NAMELIST_TYPE:
                filter = () -> MQNT_STR(parameterValue);
                break;
            case MQConstants.MQIA_NPM_CLASS:
                filter = () -> MQNPM_STR(parameterValue);
                break;
            case MQConstants.MQIA_PLATFORM:
                filter = () -> MQPL_STR(parameterValue);
                break;
            case MQConstants.MQIA_PM_DELIVERY:
            case MQConstants.MQIA_NPM_DELIVERY:
                filter = () -> MQDLV_STR(parameterValue);
                break;
            case MQConstants.MQIA_PROPERTY_CONTROL:
                filter = () -> MQPROP_STR(parameterValue);
                break;
            case MQConstants.MQIA_PROXY_SUB:
                filter = () -> MQTA_PROXY_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUB_SCOPE :
            case MQConstants.MQIA_SUB_SCOPE :
                filter = () -> MQSCOPE_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_CLUSTER:
                filter = () -> MQPSCLUS_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_MODE:
                filter = () -> MQPSM_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_NP_MSG:
            case MQConstants.MQIA_PUBSUB_NP_RESP:
                filter = () -> MQUNDELIVERED_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_SYNC_PT:
                filter = () -> MQSYNCPOINT_STR(parameterValue);
                break;
            case MQConstants.MQIA_Q_TYPE :
                filter = () -> MQQT_STR(parameterValue);
                break;
            case MQConstants.MQIA_QSG_DISP:
                filter = () -> MQQSGD_STR(parameterValue);
                break;
            case MQConstants.MQIA_RECEIVE_TIMEOUT_TYPE:
                filter = () -> MQRCVTIME_STR(parameterValue);
                break;
            case MQConstants.MQIACF_REFRESH_TYPE:
                filter = () -> MQRT_STR(parameterValue);
                break;
            case MQConstants.MQIA_REVERSE_DNS_LOOKUP:
                filter = () -> MQRDNS_STR(parameterValue);
                break;
            case MQConstants.MQIA_SCOPE:
                filter = () -> MQSCO_STR(parameterValue);
                break;
            case MQConstants.MQIA_SECURITY_CASE:
                filter = () -> MQSCYC_STR(parameterValue);
                break;
            case MQConstants.MQIA_SERVICE_TYPE:
                filter = () -> MQSVC_TYPE_STR(parameterValue);
                break;
            case MQConstants.MQIA_SHARED_Q_Q_MGR_NAME:
                filter = () -> MQSQQM_STR(parameterValue);
                break;
            case MQConstants.MQIA_SIGNATURE_ALGORITHM:
                filter = () -> MQMLP_SIGN_STR(parameterValue);
                break;
            case MQConstants.MQIA_SSL_FIPS_REQUIRED:
                filter = () -> MQSSL_STR(parameterValue);
                break;
            case MQConstants.MQIA_SYNCPOINT:
                filter = () -> MQSP_STR(parameterValue);
                break;
            case MQConstants.MQIA_TCP_KEEP_ALIVE:
                filter = () -> MQTCPKEEP_STR(parameterValue);
                break;
            case MQConstants.MQIA_TCP_STACK_TYPE:
                filter = () -> MQTCPSTACK_STR(parameterValue);
                break;
            case MQConstants.MQIA_TOLERATE_UNPROTECTED:
                filter = () -> MQMLP_TOLERATE_STR(parameterValue);
                break;
            case MQConstants.MQIA_TOPIC_TYPE:
                filter = () -> MQTOPT_STR(parameterValue);
                break;
            case MQConstants.MQIA_TRIGGER_CONTROL:
                filter = () -> MQTC_STR(parameterValue);
                break;
            case MQConstants.MQIA_TRIGGER_TYPE :
                filter = () -> MQTT_STR(parameterValue);
                break;
            case MQConstants.MQIA_USAGE:
                filter = () -> MQUS_STR(parameterValue);
                break;
            case MQConstants.MQIA_USE_DEAD_LETTER_Q:
                filter = () -> MQUSEDLQ_STR(parameterValue);
                break;
            case MQConstants.MQIA_WILDCARD_OPERATION:
                filter = () -> MQTA_STR(parameterValue);
                break;
            case MQConstants.MQIA_CODED_CHAR_SET_ID:
                if (parameterValue <= 0) {
                    valueName = MQCCSI_STR(parameterValue);
                    valueName = formatConstant(valueName);
                    eventData.put(formattedParameterName, valueName);
                } else {
                    eventData.put(formattedParameterName, parameterValue);
                }
                break;
            case MQConstants.MQIA_MAX_PROPERTIES_LENGTH:
                if (parameterValue <= 0) {
                    valueName = MQPROP_STR(parameterValue);
                    valueName = formatConstant(valueName);
                    eventData.put(formattedParameterName, valueName);
                } else {
                    eventData.put(formattedParameterName, parameterValue);
                }
                break;
            case MQConstants.MQIA_DEF_PRIORITY:
                if (parameterValue < 0) {
                    valueName = MQPRI_STR(parameterValue);
                    valueName = formatConstant(valueName);
                    eventData.put(formattedParameterName, valueName);
                } else {
                    eventData.put(formattedParameterName, parameterValue);
                }
                break;
            case MQConstants.MQIA_SHAREABILITY:
                if (parameterValue == MQConstants.MQQA_SHAREABLE) {
                    eventData.put(formattedParameterName, formatConstant("MQQA_SHAREABLE"));
                } else {
                    eventData.put(formattedParameterName, formatConstant("MQQA_NOT_SHAREABLE"));
                }
                break;
            case MQConstants.MQIA_MEDIA_IMAGE_SCHEDULING:
                filter = () -> MQMEDIMGSCHED_STR(parameterValue);
                break;
            case MQConstants.MQIA_MEDIA_IMAGE_INTERVAL:
            case MQConstants.MQIA_MEDIA_IMAGE_LOG_LENGTH:
                eventData.put(formattedParameterName, parameterValue);
                break;
            case MQConstants.MQIA_MEDIA_IMAGE_RECOVER_OBJ:
            case MQConstants.MQIA_MEDIA_IMAGE_RECOVER_Q:
                filter = () -> MQIMGRCOV_STR(parameterValue);
                break;
            case MQConstants.MQIA_MAX_Q_FILE_SIZE:
                if (parameterValue == MQConstants.MQQFS_DEFAULT) {
                    filter = () -> MQQFS_STR(parameterValue);
                } else {
                    eventData.put(formattedParameterName, parameterValue);
                }
                break;

            // MQIACF attributes
            case MQConstants.MQIACF_ACTION:
                filter = () -> MQACT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_AUTH_REC_TYPE :
            case MQConstants.MQIACH_CHANNEL_INSTANCE_TYPE :
            case MQConstants.MQIACF_OBJECT_TYPE :
                filter = () -> MQOT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_CF_SMDS_BLOCK_SIZE:
                filter = () -> MQDSB_STR(parameterValue);
                break;
            case MQConstants.MQIACF_CF_SMDS_EXPAND:
                filter = () -> MQUSAGE_EXPAND_STR(parameterValue);
                break;
            case MQConstants.MQIACF_CHLAUTH_TYPE:
                filter = () -> MQCAUT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_COMMAND :
                filter = () -> MQCMD_STR(parameterValue);
                break;
            case MQConstants.MQIACF_ENTITY_TYPE:
                filter = () -> MQZAET_STR(parameterValue);
                break;
            case MQConstants.MQIACF_EVENT_ORIGIN :
                filter = () -> MQEVO_STR(parameterValue);
                break;
            case MQConstants.MQIACF_OPERATION_ID:
                filter = () -> MQXF_STR(parameterValue);
                break;
            case MQConstants.MQIACF_OPERATION_TYPE:
                filter = () -> MQOPER_STR(parameterValue);
                break;
            case MQConstants.MQIACF_MSG_TYPE:
                filter = () -> MQMT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_Q_STATUS_TYPE :
                valueName = lookupMultiMQConstant(parameterValue, "MQIA");
                valueName = formatConstant(valueName);
                eventData.put(formattedParameterName, valueName);
                break;
            case MQConstants.MQIACF_REASON_QUALIFIER:
                filter = () -> MQRQ_STR(parameterValue);
                break;
            case MQConstants.MQIACF_SECURITY_TYPE:
                filter = () -> MQSECTYPE_STR(parameterValue);
                break;
            case MQConstants.MQIACF_SECURITY_ITEM:
                filter = () -> MQSECITEM_STR(parameterValue);
                break;
            case MQConstants.MQIACF_COMP_CODE:
                filter = () -> MQCC_STR(parameterValue);
                break;
            case MQConstants.MQIACF_REASON_CODE:
                filter = () -> MQRC_STR(parameterValue);
                break;
            case MQConstants.MQIACF_ERROR_ID:
            case MQConstants.MQIACF_ENCODING:
            case MQConstants.MQIACF_CONNECT_OPTIONS:
            case MQConstants.MQIACF_GET_OPTIONS:
            case MQConstants.MQIACF_MQCB_OPTIONS:
            case MQConstants.MQIACF_PUT_OPTIONS:
            case MQConstants.MQIACF_SUBRQ_OPTIONS:
                // Note: The options should only show up if formatting activity trace messages
                // This is not a formally supported function of this program.
                // Nonetheless, we can at least format the data into hex and put it in the JSON.
                eventData.put(formattedParameterName, String.format("0x%08X", parameterValue));
                break;
            case MQConstants.MQIACF_LOG_REDUCTION:
                filter = () -> MQLR_STR(parameterValue);
                break;
            case MQConstants.MQIACF_IGNORE_STATE:
                filter = () -> MQIS_STR(parameterValue);
                break;

            // MQIACH attributes
            case MQConstants.MQIACH_AMQP_KEEP_ALIVE:
            case MQConstants.MQIACH_KEEP_ALIVE_INTERVAL:
                if (parameterValue < 0) {
                    eventData.put(formattedParameterName, formatConstant("MQKAI_AUTO"));
                } else {
                    eventData.put(formattedParameterName, parameterValue);
                }
                break;
            case MQConstants.MQIACH_CHANNEL_DISP:
            case MQConstants.MQIACH_DEF_CHANNEL_DISP:
                filter = () -> MQCHLD_STR(parameterValue);
                break;
            case MQConstants.MQIACH_CHANNEL_TABLE :
                filter = () -> MQCHTAB_STR(parameterValue);
                break;
            case MQConstants.MQIACH_CHANNEL_TYPE :
                filter = () -> MQCHT_STR(parameterValue);
                break;
            case MQConstants.MQIACH_CONNECTION_AFFINITY:
                filter = () -> MQCAFTY_STR(parameterValue);
                break;
            case MQConstants.MQIACH_DATA_CONVERSION:
                filter = () -> MQCDC_STR(parameterValue);
                break;
            case MQConstants.MQIACH_DEF_RECONNECT:
                filter = () -> MQRCN_STR(parameterValue);
                break;
            case MQConstants.MQIACH_MCA_TYPE:
                filter = () -> MQMCAT_STR(parameterValue);
                break;
            case MQConstants.MQIACH_MULTICAST_PROPERTIES:
                filter = () -> MQMCP_STR(parameterValue);
                break;
            case MQConstants.MQIACH_NEW_SUBSCRIBER_HISTORY:
                filter = () -> MQNSH_STR(parameterValue);
                break;
            case MQConstants.MQIACH_NPM_SPEED:
                filter = () -> MQNPMS_STR(parameterValue);
                break;
            case MQConstants.MQIACH_PUT_AUTHORITY:
                filter = () -> MQPA_STR(parameterValue);
                break;
            case MQConstants.MQIACH_SSL_CLIENT_AUTH:
                filter = () -> MQSCA_STR(parameterValue);
                break;
            case MQConstants.MQIACH_USE_CLIENT_ID:
                filter = () -> MQUCI_STR(parameterValue);
                break;
            case MQConstants.MQIACH_USER_SOURCE:
                filter = () -> MQUSRC_STR(parameterValue);
                break;
            case MQConstants.MQIACH_WARNING:
                filter = () -> MQWARN_STR(parameterValue);
                break;
            case MQConstants.MQIACH_XMIT_PROTOCOL_TYPE:
                filter = () -> MQXPT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_OPEN_OPTIONS:
                optionsJSON = formatOptions(parameterValue, openOptions);
                eventData.put(formattedParameterName, optionsJSON);
                break;
            case MQConstants.MQIACF_CLOSE_OPTIONS:
                optionsJSON = formatOptions(parameterValue, closeOptions);
                eventData.put(formattedParameterName, optionsJSON);
                break;
            case MQConstants.MQIACF_SUB_OPTIONS:
                optionsJSON = formatOptions(parameterValue, subOptions);
                eventData.put(formattedParameterName, optionsJSON);
                break;
            default:
                eventData.put(formattedParameterName, parameterValue);
        }

        if (filter != null) {
            valueName = filter.get();
            valueName = formatConstant(valueName);
            eventData.put(formattedParameterName, valueName);
        }
    }

    private void processCFBS(MQCFBS parameter, JSONObject eventData) throws JSONException {
        String parameterName = MQBACF_STR(parameter.getParameter());
        String formattedParameterName = formatConstant(parameterName, true);
        byte[] hexBytes = parameter.getString();

        StringBuilder result = new StringBuilder();
        for (byte aByte : hexBytes) {
            result.append(String.format("%02X", aByte));
        }

        String hexString = result.toString();
        eventData.put(formattedParameterName, hexString);
    }

    private void processCFIF(MQCFIF parameter, JSONObject eventData) throws JSONException {
        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQIA");
        if (parameterName != null) {
            String formattedParameterName = formatConstant(parameterName);
            String operatorName = MQCFOP_STR(parameter.getOperator());
            String formattedOperatorName = formatConstant(operatorName);
            String output = String.format("WHERE '%s' %s '%d'", formattedParameterName, formattedOperatorName, parameter.getFilterValue());
            eventData.put("filter", output);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFIF returned null! Integer value was: %d", parameter.getParameter()));
        }
    }

    private void processCFSF(MQCFSF parameter, JSONObject eventData) throws JSONException {
        String parameterName = lookupMultiMQConstant(parameter.getParameter(), "MQCA");
        if (parameterName != null) {
            String formattedParameterName = formatConstant(parameterName);
            String operator = MQCFOP_STR(parameter.getOperator());
            String formattedOperator = formatConstant(operator);
            String output = String.format("WHERE '%s' %s '%s'", formattedParameterName, formattedOperator, parameter.getFilterValue());
            eventData.put("filter", output);
        } else {
            throw new IllegalArgumentException(String.format("Parameter name lookup for CFSF returned null! Integer value was: %d", parameter.getParameter()));
        }
    }

    private void processCFBF(MQCFBF parameter, JSONObject eventData) throws JSONException {
        String parameterName = MQBACF_STR(parameter.getParameter());
        String formattedParameterName = formatConstant(parameterName);
        String operatorName = MQCFOP_STR(parameter.getOperator());
        String formattedOperatorName = formatConstant(operatorName);
        byte[] hexBytes = parameter.getFilterValue();

        StringBuilder result = new StringBuilder();
        for (byte aByte : hexBytes) {
            result.append(String.format("%02X", aByte));
        }

        String hexString = result.toString();
        String output = String.format("WHERE '%s' %s '%s'", formattedParameterName, formattedOperatorName, hexString);
        eventData.put("filter", output);
    }

    /*
        This function should only be used for MQIA or MQCA lookups. All others can be done
        normally with ConstantMap lookups. These two are... "painful" because of the overlap
        they have between eachother, and some parameter values can be any single one of these.
        Rather than doing these searches individually in the case statement, this has been
        wrapped into a helper method to keep the switch/case statements tidier.
    */
    private String lookupMultiMQConstant(int parameterValue, String filter) {
        String valueName;
        List<Supplier<String>> filters;

        if (filter.equals("MQIA")) {
            filters = Arrays.asList(
                    () -> MQIA_STR(parameterValue),
                    () -> MQIACF_STR(parameterValue),
                    () -> MQIACH_STR(parameterValue),
                    () -> MQIAMO_STR(parameterValue),
                    () -> MQIAMO64_STR(parameterValue)
            );
        } else if (filter.equals("MQCA")) {
            filters = Arrays.asList(
                    () -> MQCA_STR(parameterValue),
                    () -> MQCACF_STR(parameterValue),
                    () -> MQCACH_STR(parameterValue),
                    () -> MQCAMO_STR(parameterValue)
            );
        } else {
            throw new IllegalArgumentException(String.format("Illegal filter type passed in: %s", filter));
        }

        for (Supplier<String> currentFilter : filters) {
            valueName = currentFilter.get();
            // Default value returned from ConstantMap methods is "". Therefore if we get ""
            // then keep going.
            if (!valueName.equals("")) {
                return valueName;
            }
        }

        // Return null if we don't find anything, same as MQConstants.lookup()
        return null;
    }

    // These specific strings look better as uppercase.
    private static final Map<String, String> replacements = new LinkedHashMap<>() {{
        put("Amqp", "AMQP");
        put("Clwl", "CLWL");
        put("Cpi", "CPI");
        put("Crl", "CRL");
        put("Csp", "CSP");
        put("Dns", "DNS"); // Do this before "Dn"
        put("Dn", "DN");
        put("Idpw", "IDPW");
        put("Igq", "IGQ");
        put("Ip ", "IP "); // note trailing space
        put("Ipv", "IPV");
        put("Ldap", "LDAP");
        put("Lu62", "LU62");
        put("Mca ", "MCA "); // note trailing space
        put("Mqi", "MQI");
        put("Mqsc", "MQSC");
        put("Mr ", "MR ");
        put("Mru", "MRU");
        put("Pcf", "PCF");
        put("Sctq", "SCTQ");
        put("Ssl", "SSL");
        put("Tcp", "TCP");
    }};

    private String formatConstant(String rawConstant) {
        return formatConstant(rawConstant, false);
    }

    private String formatConstant(String rawConstant, boolean jsonMode) {
        if (!rawConstant.contains("_")) {
            return rawConstant;
        }

        if (rawConstant.equals("MQOT_Q")) {
            return "Queue";
        }

        if (rawConstant.contains("_Q_"))
            rawConstant = rawConstant.replace("_Q_", "_QUEUE_");
        else if (rawConstant.endsWith("_Q"))
            rawConstant = rawConstant.replace("_Q", "_QUEUE");

        String outputString = rawConstant.substring(rawConstant.indexOf("_") + 1);
        // we use apache commons here because it is *significantly* easier to do so, and
        // why not. Don't re-invent the wheel.
        outputString = WordUtils.capitalizeFully(outputString, '_');
        outputString = outputString.replace('_', ' ');

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            if (outputString.contains(entry.getKey())) {
                outputString = outputString.replace(entry.getKey(), entry.getValue());
            }
        }

        if (jsonMode) {
            outputString = CaseUtils.toCamelCase(outputString, false, ' ');
        }

        return outputString;
    }

    private JSONObject formatOptions(int options, Map<Integer, String> optionMappings) throws JSONException {
        JSONObject optionsJSON = new JSONObject();
        List<String> stringOptions = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : optionMappings.entrySet()) {
            if ((options & entry.getKey()) != 0) {
                stringOptions.add(entry.getValue());
            }
        }

        optionsJSON.put("options", options);
        optionsJSON.put("optionsString", stringOptions);

        return optionsJSON;
    }
}


