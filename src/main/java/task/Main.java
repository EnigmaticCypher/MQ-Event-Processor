package task;

import static task.ConstantMap.*;

import com.ibm.mq.MQMessage;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.headers.MQDataException;
import com.ibm.mq.headers.pcf.*;
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
    private static String HOST;
    private static int PORT;
    private static String CHANNEL;
    private static String QMGR;
    private static String INPUT_QUEUE_NAME;
    private static String OUTPUT_QUEUE_NAME;
    private static boolean DEBUG;
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
            if (DEBUG) {
                startupDebugMode();
            } else {
                startupProductionMode();
            }
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

        DEBUG = Boolean.parseBoolean(config.getProperty("debug"));
        HOST = config.getProperty("hostname");
        PORT = Integer.parseInt(config.getProperty("port"));
        CHANNEL = config.getProperty("channel");
        QMGR = config.getProperty("queue_manager");
        INPUT_QUEUE_NAME = config.getProperty("input_queue_name");
        OUTPUT_QUEUE_NAME = config.getProperty("output_queue_name");
    }

    private void startupDebugMode() throws JMSException, JSONException, IOException, MQDataException {
        JmsConnectionFactory connectionFactory = setupConnectionFactory();

        long startTime = System.currentTimeMillis();
        int counter = 0;

        // TODO: Refactor the duplicate code here into a method maybe? Not quite sure how to go about this.
        logger.info("System running in debug mode! Messages will not be destructively consumed from the input queue.");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        logger.info("Created and started connection to queue manager {} on {}({})", QMGR, HOST, PORT);
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        MQDestination inputQueue = (MQDestination) session.createQueue("queue:///" + INPUT_QUEUE_NAME);
        inputQueue.setReceiveConversion(WMQConstants.WMQ_RECEIVE_CONVERSION_QMGR);
        inputQueue.setReceiveCCSID(WMQConstants.CCSID_UTF8);
        MQDestination outputQueue = (MQDestination) session.createQueue("queue:///" + OUTPUT_QUEUE_NAME);
        outputQueue.setMessageBodyStyle(WMQConstants.WMQ_MESSAGE_BODY_MQ);
        outputQueue.setPersistence(WMQConstants.DELIVERY_PERSISTENT);
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
        session.close();
        logger.info("Successfully closed session to queue manager {}", QMGR);
        connection.close();
        logger.info("Successfully closed connection to queue manager {} on {}({})", QMGR, HOST, PORT);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        logger.info("We processed {} messages in {} milliseconds", counter, totalTime);
    }

    private void startupProductionMode() throws JMSException, JSONException, IOException, MQDataException {
        // TODO: Make transacted a config option. Users may not want syncpoint enabled if they want to use this
        // with non-persistent event messages.
        JmsConnectionFactory connectionFactory = setupConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        logger.info("Created and started connection to queue manager {} on {}({})", QMGR, HOST, PORT);

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        MQDestination inputQueue = (MQDestination) session.createQueue("queue:///" + INPUT_QUEUE_NAME);
        inputQueue.setReceiveConversion(WMQConstants.WMQ_RECEIVE_CONVERSION_QMGR);
        inputQueue.setReceiveCCSID(WMQConstants.CCSID_UTF8);
        MQDestination outputQueue = (MQDestination) session.createQueue("queue:///" + OUTPUT_QUEUE_NAME);
        outputQueue.setMessageBodyStyle(WMQConstants.WMQ_MESSAGE_BODY_MQ);
        outputQueue.setPersistence(WMQConstants.DELIVERY_PERSISTENT);

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
        session.close();
        logger.info("Successfully closed session to queue manager {}", QMGR);
        connection.close();
        logger.info("Successfully closed connection to queue manager {} on {}({})", QMGR, HOST, PORT);
    }

    private JmsConnectionFactory setupConnectionFactory() throws JMSException {
        JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
        JmsConnectionFactory cf = ff.createConnectionFactory();

        cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, HOST);
        cf.setIntProperty(WMQConstants.WMQ_PORT, PORT);
        cf.setStringProperty(WMQConstants.WMQ_CHANNEL, CHANNEL);
        cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
        cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, QMGR);
        cf.setStringProperty(WMQConstants.WMQ_APPLICATIONNAME, "Event Consumer");

        return cf;
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
        String command = MQConstants.lookup(pcfHeader.getCommand(), "MQCMD_.*");
        command = formatConstant(command);
        JSONObject eventType = new JSONObject();
        eventType.put("name", command);
        eventType.put("value", pcfHeader.getCommand());
        return eventType;
    }

    private JSONObject getEventReason(MQCFH pcfHeader) throws JSONException {
        String eventReasonString = MQConstants.lookupReasonCode(pcfHeader.getReason());
        eventReasonString = formatConstant(eventReasonString);
        JSONObject eventReason = new JSONObject();
        eventReason.put("name", eventReasonString);
        eventReason.put("value", pcfHeader.getReason());
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

        String formattedParameterName = formatConstant(parameter.getParameterName(), true);
        JSONObject groupData = new JSONObject();
        while (parameters.hasMoreElements()) {
            PCFParameter pcfParameter = parameters.nextElement();
            processPCFParameter(pcfParameter, groupData);
            eventData.put(formattedParameterName, groupData);
        }
    }

    private void processCFIL64(MQCFIL64 parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName(), true);
        long[] values = parameter.getValues();
        eventData.put(formattedParameterName, values);
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

        eventData.put(formatConstant(parameter.getParameterName(), true), valueNames);
    }

    private void processCFSL(MQCFSL parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName(), true);
        String[] values = parameter.getStrings();
        eventData.put(formattedParameterName, values);
    }

    private void processCFST(MQCFST parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName(), true);
        // Trim off the excess spaces that come from IBM's spacing requirements.
        String value = parameter.getString().trim();
        eventData.put(formattedParameterName, value);
    }

    private void processCFIN64(MQCFIN64 parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName(), true);
        long value = parameter.getLongValue();
        eventData.put(formattedParameterName, value);
    }

    private void processCFIN(MQCFIN parameter, JSONObject eventData) throws JSONException {
        String parameterName = parameter.getParameterName();

        // Bugfix for IBM Parameter lookup having a conflict on
        // MQIAMO and MQIA for the int value 2. No other parameter
        // names present this issue, so we explicitly look for
        // char set. The MQIA value comes from CMQC and the MQIAMO
        // value comes from CMQCFC.
        if (parameterName.contains("CODED_CHAR_SET")) {
            parameterName = "MQIA_CODED_CHAR_SET_ID";
        }

        String formattedParameterName = formatConstant(parameterName, true);

        final int parameterValue = parameter.getIntValue();
        String valueName;
        Supplier<String> newFilter = null;
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
                newFilter = () -> MQRECORDING_STR(parameterValue);
                break;
            case MQConstants.MQIA_ADOPT_CONTEXT:
                newFilter = () -> MQADPCTX_STR(parameterValue);
                break;
            case MQConstants.MQIA_ADOPTNEWMCA_CHECK:
                newFilter = () -> MQADOPT_CHECK_STR(parameterValue);
                break;
            case MQConstants.MQIA_ADOPTNEWMCA_TYPE:
                newFilter = () -> MQADOPT_TYPE_STR(parameterValue);
                break;
            case MQConstants.MQIA_APPL_TYPE :
            case MQConstants.MQIACF_EVENT_APPL_TYPE :
                // Manual handling for parameter name here because MQConstants.lookup() returns
                // ambiguous results which are not applicable.
                int parameterNameInt = parameter.getParameter();
                parameterName = lookupMultiMQConstant(parameterNameInt, "MQIA");
                // Handle potential null return from lookupMultiMQConstant().
                if (parameterName == null) {
                    throw new IllegalStateException(
                            String.format("Parameter name for CFIN related constant is null! Integer value: %d",
                                    parameterNameInt));
                }
                valueName = MQAT_STR(parameterValue);
                formattedParameterName = formatConstant(parameterName, true);
                valueName = formatConstant(valueName);

                eventData.put(formattedParameterName, valueName);
                break;
            case MQConstants.MQIA_AUTH_INFO_TYPE :
                newFilter = () -> MQAIT_STR(parameterValue);
                break;
            case MQConstants.MQIA_AUTHENTICATION_METHOD:
                newFilter = () -> MQAUTHENTICATE_STR(parameterValue);
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
                newFilter = () -> MQEVR_STR(parameterValue);
                break;
            case MQConstants.MQIA_AUTO_REORGANIZATION:
                newFilter = () -> MQREORG_STR(parameterValue);
                break;
            case MQConstants.MQIA_BASE_TYPE :
                newFilter = () -> MQOT_STR(parameterValue);
                break;
            case MQConstants.MQIA_CERT_VAL_POLICY:
                newFilter = () -> MQ_CERT_STR(parameterValue);
                break;
            case MQConstants.MQIA_CF_CFCONLOS:
            case MQConstants.MQIA_QMGR_CFCONLOS:
                newFilter = () -> MQCFCONLOS_STR(parameterValue);
                break;
            case MQConstants.MQIA_CF_RECAUTO:
                newFilter = () -> MQRECAUTO_STR(parameterValue);
                break;
            case MQConstants.MQIA_CF_RECOVER:
                newFilter = () -> MQCFR_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHANNEL_AUTO_DEF:
                newFilter = () -> MQCHAD_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHECK_CLIENT_BINDING:
            case MQConstants.MQIA_CHECK_LOCAL_BINDING:
                newFilter = () -> MQCHK_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHINIT_CONTROL:
            case MQConstants.MQIA_CMD_SERVER_CONTROL:
            case MQConstants.MQIA_SERVICE_CONTROL:
            case MQConstants.MQIACH_LISTENER_CONTROL:
                newFilter = () -> MQSVC_CONTROL_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHINIT_TRACE_AUTO_START:
                newFilter = () -> MQTRAXSTR_STR(parameterValue);
                break;
            case MQConstants.MQIA_CHLAUTH_RECORDS:
                newFilter = () -> MQCHLA_STR(parameterValue);
                break;
            case MQConstants.MQIA_CLUSTER_PUB_ROUTE:
                newFilter = () -> MQCLROUTE_STR(parameterValue);
                break;
            case MQConstants.MQIA_CLWL_USEQ :
                newFilter = () -> MQCLWL_STR(parameterValue);
                break;
            case MQConstants.MQIA_COMM_INFO_TYPE:
                newFilter = () -> MQCIT_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_BIND:
                newFilter = () -> MQBND_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_CLUSTER_XMIT_Q_TYPE:
                newFilter = () -> MQCLXQ_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_INPUT_OPEN_OPTION:
                newFilter = () -> MQOO_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_PERSISTENCE:
            case MQConstants.MQIA_TOPIC_DEF_PERSISTENCE:
                newFilter = () -> MQPER_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_PUT_RESPONSE_TYPE:
                newFilter = () -> MQPRT_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEF_READ_AHEAD:
                newFilter = () -> MQREADA_STR(parameterValue);
                break;
            case MQConstants.MQIA_DEFINITION_TYPE :
                newFilter = () -> MQQDT_STR(parameterValue);
                break;
            case MQConstants.MQIA_DIST_LISTS:
                newFilter = () -> MQDL_STR(parameterValue);
                break;
            case MQConstants.MQIA_DNS_WLM:
                newFilter = () -> MQDNSWLM_STR(parameterValue);
                break;
            case MQConstants.MQIA_DURABLE_SUB:
                newFilter = () -> MQSUB_STR(parameterValue);
                break;
            case MQConstants.MQIA_ENCRYPTION_ALGORITHM:
                newFilter = () -> MQMLP_ENCRYPTION_STR(parameterValue);
                break;
            case MQConstants.MQIA_GROUP_UR:
                newFilter = () -> MQGUR_STR(parameterValue);
                break;
            case MQConstants.MQIA_HARDEN_GET_BACKOUT:
                newFilter = () -> MQQA_BACKOUT_STR(parameterValue);
                break;
            case MQConstants.MQIA_IGQ_PUT_AUTHORITY:
                newFilter = () -> MQIGQPA_STR(parameterValue);
                break;
            case MQConstants.MQIA_INDEX_TYPE :
                newFilter = () -> MQIT_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_GET :
                newFilter = () -> MQQA_GET_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_PUB :
                newFilter = () -> MQTA_PUB_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_PUT :
                newFilter = () -> MQQA_PUT_STR(parameterValue);
                break;
            case MQConstants.MQIA_INHIBIT_SUB :
                newFilter = () -> MQTA_SUB_STR(parameterValue);
                break;
            case MQConstants.MQIA_INTRA_GROUP_QUEUING:
                newFilter = () -> MQIGQ_STR(parameterValue);
                break;
            case MQConstants.MQIA_IP_ADDRESS_VERSION:
                newFilter = () -> MQIPADDR_STR(parameterValue);
                break;
            case MQConstants.MQIA_LDAP_AUTHORMD:
                newFilter = () -> MQLDAP_AUTHORMD_STR(parameterValue);
                break;
            case MQConstants.MQIA_LDAP_NESTGRP:
                newFilter = () -> MQLDAP_NESTGRP_STR(parameterValue);
                break;
            case MQConstants.MQIA_LDAP_SECURE_COMM:
                newFilter = () -> MQSECCOMM_STR(parameterValue);
                break;
            case MQConstants.MQIA_MCAST_BRIDGE:
                newFilter = () -> MQMCB_STR(parameterValue);
                break;
            case MQConstants.MQIA_MSG_DELIVERY_SEQUENCE :
                newFilter = () -> MQMDS_STR(parameterValue);
                break;
            case MQConstants.MQIA_MULTICAST:
                newFilter = () -> MQMC_STR(parameterValue);
                break;
            case MQConstants.MQIA_NAMELIST_TYPE:
                newFilter = () -> MQNT_STR(parameterValue);
                break;
            case MQConstants.MQIA_NPM_CLASS:
                newFilter = () -> MQNPM_STR(parameterValue);
                break;
            case MQConstants.MQIA_PLATFORM:
                newFilter = () -> MQPL_STR(parameterValue);
                break;
            case MQConstants.MQIA_PM_DELIVERY:
            case MQConstants.MQIA_NPM_DELIVERY:
                newFilter = () -> MQDLV_STR(parameterValue);
                break;
            case MQConstants.MQIA_PROPERTY_CONTROL:
                newFilter = () -> MQPROP_STR(parameterValue);
                break;
            case MQConstants.MQIA_PROXY_SUB:
                newFilter = () -> MQTA_PROXY_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUB_SCOPE :
            case MQConstants.MQIA_SUB_SCOPE :
                newFilter = () -> MQSCOPE_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_CLUSTER:
                newFilter = () -> MQPSCLUS_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_MODE:
                newFilter = () -> MQPSM_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_NP_MSG:
            case MQConstants.MQIA_PUBSUB_NP_RESP:
                newFilter = () -> MQUNDELIVERED_STR(parameterValue);
                break;
            case MQConstants.MQIA_PUBSUB_SYNC_PT:
                newFilter = () -> MQSYNCPOINT_STR(parameterValue);
                break;
            case MQConstants.MQIA_Q_TYPE :
                newFilter = () -> MQQT_STR(parameterValue);
                break;
            case MQConstants.MQIA_QSG_DISP:
                newFilter = () -> MQQSGD_STR(parameterValue);
                break;
            case MQConstants.MQIA_RECEIVE_TIMEOUT_TYPE:
                newFilter = () -> MQRCVTIME_STR(parameterValue);
                break;
            case MQConstants.MQIACF_REFRESH_TYPE:
                newFilter = () -> MQRT_STR(parameterValue);
                break;
            case MQConstants.MQIA_REVERSE_DNS_LOOKUP:
                newFilter = () -> MQRDNS_STR(parameterValue);
                break;
            case MQConstants.MQIA_SCOPE:
                newFilter = () -> MQSCO_STR(parameterValue);
                break;
            case MQConstants.MQIA_SECURITY_CASE:
                newFilter = () -> MQSCYC_STR(parameterValue);
                break;
            case MQConstants.MQIA_SERVICE_TYPE:
                newFilter = () -> MQSVC_TYPE_STR(parameterValue);
                break;
            case MQConstants.MQIA_SHARED_Q_Q_MGR_NAME:
                newFilter = () -> MQSQQM_STR(parameterValue);
                break;
            case MQConstants.MQIA_SIGNATURE_ALGORITHM:
                newFilter = () -> MQMLP_SIGN_STR(parameterValue);
                break;
            case MQConstants.MQIA_SSL_FIPS_REQUIRED:
                newFilter = () -> MQSSL_STR(parameterValue);
                break;
            case MQConstants.MQIA_SYNCPOINT:
                newFilter = () -> MQSP_STR(parameterValue);
                break;
            case MQConstants.MQIA_TCP_KEEP_ALIVE:
                newFilter = () -> MQTCPKEEP_STR(parameterValue);
                break;
            case MQConstants.MQIA_TCP_STACK_TYPE:
                newFilter = () -> MQTCPSTACK_STR(parameterValue);
                break;
            case MQConstants.MQIA_TOLERATE_UNPROTECTED:
                newFilter = () -> MQMLP_TOLERATE_STR(parameterValue);
                break;
            case MQConstants.MQIA_TOPIC_TYPE:
                newFilter = () -> MQTOPT_STR(parameterValue);
                break;
            case MQConstants.MQIA_TRIGGER_CONTROL:
                newFilter = () -> MQTC_STR(parameterValue);
                break;
            case MQConstants.MQIA_TRIGGER_TYPE :
                newFilter = () -> MQTT_STR(parameterValue);
                break;
            case MQConstants.MQIA_USAGE:
                newFilter = () -> MQUS_STR(parameterValue);
                break;
            case MQConstants.MQIA_USE_DEAD_LETTER_Q:
                newFilter = () -> MQUSEDLQ_STR(parameterValue);
                break;
            case MQConstants.MQIA_WILDCARD_OPERATION:
                newFilter = () -> MQTA_STR(parameterValue);
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
                newFilter = () -> MQMEDIMGSCHED_STR(parameterValue);
                break;
            case MQConstants.MQIA_MEDIA_IMAGE_INTERVAL:
            case MQConstants.MQIA_MEDIA_IMAGE_LOG_LENGTH:
                eventData.put(formattedParameterName, parameterValue);
                break;
            case MQConstants.MQIA_MEDIA_IMAGE_RECOVER_OBJ:
            case MQConstants.MQIA_MEDIA_IMAGE_RECOVER_Q:
                newFilter = () -> MQIMGRCOV_STR(parameterValue);
                break;
            case MQConstants.MQIA_MAX_Q_FILE_SIZE:
                if (parameterValue == MQConstants.MQQFS_DEFAULT) {
                    newFilter = () -> MQQFS_STR(parameterValue);
                } else {
                    eventData.put(formattedParameterName, parameterValue);
                }
                break;

            // MQIACF attributes
            case MQConstants.MQIACF_ACTION:
                newFilter = () -> MQACT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_AUTH_REC_TYPE :
            case MQConstants.MQIACH_CHANNEL_INSTANCE_TYPE :
            case MQConstants.MQIACF_OBJECT_TYPE :
                newFilter = () -> MQOT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_CF_SMDS_BLOCK_SIZE:
                newFilter = () -> MQDSB_STR(parameterValue);
                break;
            case MQConstants.MQIACF_CF_SMDS_EXPAND:
                newFilter = () -> MQUSAGE_EXPAND_STR(parameterValue);
                break;
            case MQConstants.MQIACF_CHLAUTH_TYPE:
                newFilter = () -> MQCAUT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_COMMAND :
                newFilter = () -> MQCMD_STR(parameterValue);
                break;
            case MQConstants.MQIACF_ENTITY_TYPE:
                newFilter = () -> MQZAET_STR(parameterValue);
                break;
            case MQConstants.MQIACF_EVENT_ORIGIN :
                newFilter = () -> MQEVO_STR(parameterValue);
                break;
            case MQConstants.MQIACF_OPERATION_ID:
                newFilter = () -> MQXF_STR(parameterValue);
                break;
            case MQConstants.MQIACF_OPERATION_TYPE:
                newFilter = () -> MQOPER_STR(parameterValue);
                break;
            case MQConstants.MQIACF_MSG_TYPE:
                newFilter = () -> MQMT_STR(parameterValue);
                break;
            case MQConstants.MQIACF_Q_STATUS_TYPE :
                valueName = lookupMultiMQConstant(parameterValue, "MQIA");
                valueName = formatConstant(valueName);
                eventData.put(formattedParameterName, valueName);
                break;
            case MQConstants.MQIACF_REASON_QUALIFIER:
                newFilter = () -> MQRQ_STR(parameterValue);
                break;
            case MQConstants.MQIACF_SECURITY_TYPE:
                newFilter = () -> MQSECTYPE_STR(parameterValue);
                break;
            case MQConstants.MQIACF_SECURITY_ITEM:
                newFilter = () -> MQSECITEM_STR(parameterValue);
                break;
            case MQConstants.MQIACF_COMP_CODE:
                valueName = MQCC_STR(parameterValue);
                valueName = formatConstant(valueName);
                eventData.put(formattedParameterName, valueName);
                break;
            case MQConstants.MQIACF_REASON_CODE:
                valueName = MQRC_STR(parameterValue);
                valueName = formatConstant(valueName);
                eventData.put(formattedParameterName, valueName);
                break;
            case MQConstants.MQIACF_ERROR_ID:
                // Manual fix for the formatted lookup returning two values.
                formattedParameterName = "errorId";
                eventData.put(formattedParameterName, String.format("0x%08X", parameterValue));
                break;
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
                newFilter = () -> MQLR_STR(parameterValue);
                break;
            case MQConstants.MQIACF_IGNORE_STATE:
                newFilter = () -> MQIS_STR(parameterValue);
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
                newFilter = () -> MQCHLD_STR(parameterValue);
                break;
            case MQConstants.MQIACH_CHANNEL_TABLE :
                newFilter = () -> MQCHTAB_STR(parameterValue);
                break;
            case MQConstants.MQIACH_CHANNEL_TYPE :
                newFilter = () -> MQCHT_STR(parameterValue);
                break;
            case MQConstants.MQIACH_CONNECTION_AFFINITY:
                newFilter = () -> MQCAFTY_STR(parameterValue);
                break;
            case MQConstants.MQIACH_DATA_CONVERSION:
                newFilter = () -> MQCDC_STR(parameterValue);
                break;
            case MQConstants.MQIACH_DEF_RECONNECT:
                newFilter = () -> MQRCN_STR(parameterValue);
                break;
            case MQConstants.MQIACH_MCA_TYPE:
                newFilter = () -> MQMCAT_STR(parameterValue);
                break;
            case MQConstants.MQIACH_MULTICAST_PROPERTIES:
                newFilter = () -> MQMCP_STR(parameterValue);
                break;
            case MQConstants.MQIACH_NEW_SUBSCRIBER_HISTORY:
                // filter = "MQNSH_.*";
                newFilter = () -> MQNSH_STR(parameterValue);
                break;
            case MQConstants.MQIACH_NPM_SPEED:
                newFilter = () -> MQNPMS_STR(parameterValue);
                break;
            case MQConstants.MQIACH_PUT_AUTHORITY:
                newFilter = () -> MQPA_STR(parameterValue);
                break;
            case MQConstants.MQIACH_SSL_CLIENT_AUTH:
                newFilter = () -> MQSCA_STR(parameterValue);
                break;
            case MQConstants.MQIACH_USE_CLIENT_ID:
                newFilter = () -> MQUCI_STR(parameterValue);
                break;
            case MQConstants.MQIACH_USER_SOURCE:
                newFilter = () -> MQUSRC_STR(parameterValue);
                break;
            case MQConstants.MQIACH_WARNING:
                newFilter = () -> MQWARN_STR(parameterValue);
                break;
            case MQConstants.MQIACH_XMIT_PROTOCOL_TYPE:
                newFilter = () -> MQXPT_STR(parameterValue);
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

        if (newFilter != null) {
            valueName = newFilter.get();
            valueName = formatConstant(valueName);
            eventData.put(formattedParameterName, valueName);
        }
    }

    private void processCFBS(MQCFBS parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName(), true);
        byte[] hexBytes = parameter.getString();

        StringBuilder result = new StringBuilder();
        for (byte aByte : hexBytes) {
            result.append(String.format("%02X", aByte));
        }

        String hexString = result.toString();
        eventData.put(formattedParameterName, hexString);
    }

    private void processCFIF(MQCFIF parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName());
        String operatorName = MQCFOP_STR(parameter.getOperator());
        String formattedOperatorName = formatConstant(operatorName);
        String output = String.format("WHERE '%s' %s '%d'", formattedParameterName, formattedOperatorName, parameter.getFilterValue());
        eventData.put("filter", output);
    }

    private void processCFSF(MQCFSF parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName());
        String operator = MQCFOP_STR(parameter.getOperator());
        String formattedOperator = formatConstant(operator);
        String output = String.format("WHERE '%s' %s '%s'", formattedParameterName, formattedOperator, parameter.getFilterValue());
        eventData.put("filter", output);
    }

    private void processCFBF(MQCFBF parameter, JSONObject eventData) throws JSONException {
        String formattedParameterName = formatConstant(parameter.getParameterName());
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


