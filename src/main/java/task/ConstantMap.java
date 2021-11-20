package task;

public class ConstantMap {
    /*
    Client version generated from: 9.2.0.1

    The following methods are ported from cmqstrc.h in the MQ client libraries. A simple python
    script with some regular expressions can refactor the C code into syntactically valid Java,
    which is then reformatted by IntelliJ or another acceptable IDE with code formatting capabilities.

    This class will completely eliminate the many problems associated with duplicate string constants
    referencing the same integer, causing headaches in the JSON key/value pairs. If any IBMers read this,
    PLEASE put a cmqstrc.h port into your official MQ Classes for JMS so that I can remove this.
    */
    public static String MQACTIVE_STR(int value) {
        switch (value) {
            case 0:
                return "MQACTIVE_NO";
            case 1:
                return "MQACTIVE_YES";
            default:
                return "";
        }
    }

    public static String MQACTP_STR(int value) {
        switch (value) {
            case 0:
                return "MQACTP_NEW";
            case 1:
                return "MQACTP_FORWARD";
            case 2:
                return "MQACTP_REPLY";
            case 3:
                return "MQACTP_REPORT";
            default:
                return "";
        }
    }

    public static String MQACTV_STR(int value) {
        switch (value) {
            case 1:
                return "MQACTV_DETAIL_LOW";
            case 2:
                return "MQACTV_DETAIL_MEDIUM";
            case 3:
                return "MQACTV_DETAIL_HIGH";
            default:
                return "";
        }
    }

    public static String MQACT_STR(int value) {
        switch (value) {
            case 1:
                return "MQACT_FORCE_REMOVE";
            case 2:
                return "MQACT_ADVANCE_LOG";
            case 3:
                return "MQACT_COLLECT_STATISTICS";
            case 4:
                return "MQACT_PUBSUB";
            case 5:
                return "MQACT_ADD";
            case 6:
                return "MQACT_REPLACE";
            case 7:
                return "MQACT_REMOVE";
            case 8:
                return "MQACT_REMOVEALL";
            case 9:
                return "MQACT_FAIL";
            case 10:
                return "MQACT_REDUCE_LOG";
            case 11:
                return "MQACT_ARCHIVE_LOG";
            default:
                return "";
        }
    }

    public static String MQADOPT_CHECK_STR(int value) {
        switch (value) {
            case 0:
                return "MQADOPT_CHECK_NONE";
            case 1:
                return "MQADOPT_CHECK_ALL";
            case 2:
                return "MQADOPT_CHECK_Q_MGR_NAME";
            case 4:
                return "MQADOPT_CHECK_NET_ADDR";
            case 8:
                return "MQADOPT_CHECK_CHANNEL_NAME";
            default:
                return "";
        }
    }

    public static String MQADOPT_TYPE_STR(int value) {
        switch (value) {
            case 0:
                return "MQADOPT_TYPE_NO";
            case 1:
                return "MQADOPT_TYPE_ALL";
            case 2:
                return "MQADOPT_TYPE_SVR";
            case 4:
                return "MQADOPT_TYPE_SDR";
            case 8:
                return "MQADOPT_TYPE_RCVR";
            case 16:
                return "MQADOPT_TYPE_CLUSRCVR";
            default:
                return "";
        }
    }

    public static String MQADPCTX_STR(int value) {
        switch (value) {
            case 0:
                return "MQADPCTX_NO";
            case 1:
                return "MQADPCTX_YES";
            default:
                return "";
        }
    }

    public static String MQAIT_STR(int value) {
        switch (value) {
            case 0:
                return "MQAIT_ALL";
            case 1:
                return "MQAIT_CRL_LDAP";
            case 2:
                return "MQAIT_OCSP";
            case 3:
                return "MQAIT_IDPW_OS";
            case 4:
                return "MQAIT_IDPW_LDAP";
            default:
                return "";
        }
    }

    public static String MQAPPL_STR(int value) {
        switch (value) {
            case 0:
                return "MQAPPL_IMMOVABLE";
            case 1:
                return "MQAPPL_MOVABLE";
            default:
                return "";
        }
    }

    public static String MQAS_STR(int value) {
        switch (value) {
            case 0:
                return "MQAS_NONE";
            case 1:
                return "MQAS_STARTED";
            case 2:
                return "MQAS_START_WAIT";
            case 3:
                return "MQAS_STOPPED";
            case 4:
                return "MQAS_SUSPENDED";
            case 5:
                return "MQAS_SUSPENDED_TEMPORARY";
            case 6:
                return "MQAS_ACTIVE";
            case 7:
                return "MQAS_INACTIVE";
            default:
                return "";
        }
    }

    public static String MQAT_STR(int value) {
        switch (value) {
            case -1:
                return "MQAT_UNKNOWN";
            case 0:
                return "MQAT_NO_CONTEXT";
            case 1:
                return "MQAT_CICS";
            case 2:
                return "MQAT_ZOS";
            case 3:
                return "MQAT_IMS";
            case 4:
                return "MQAT_OS2";
            case 5:
                return "MQAT_DOS";
            case 6:
                return "MQAT_UNIX";
            case 7:
                return "MQAT_QMGR";
            case 8:
                return "MQAT_OS400";
            case 9:
                return "MQAT_WINDOWS";
            case 10:
                return "MQAT_CICS_VSE";
            case 11:
                return "MQAT_WINDOWS_NT";
            case 12:
                return "MQAT_VMS";
            case 13:
                return "MQAT_NSK";
            case 14:
                return "MQAT_VOS";
            case 15:
                return "MQAT_OPEN_TP1";
            case 18:
                return "MQAT_VM";
            case 19:
                return "MQAT_IMS_BRIDGE";
            case 20:
                return "MQAT_XCF";
            case 21:
                return "MQAT_CICS_BRIDGE";
            case 22:
                return "MQAT_NOTES_AGENT";
            case 23:
                return "MQAT_TPF";
            case 25:
                return "MQAT_USER";
            case 26:
                return "MQAT_QMGR_PUBLISH";
            case 28:
                return "MQAT_JAVA";
            case 29:
                return "MQAT_DQM";
            case 30:
                return "MQAT_CHANNEL_INITIATOR";
            case 31:
                return "MQAT_WLM";
            case 32:
                return "MQAT_BATCH";
            case 33:
                return "MQAT_RRS_BATCH";
            case 34:
                return "MQAT_SIB";
            case 35:
                return "MQAT_SYSTEM_EXTENSION";
            case 36:
                return "MQAT_MCAST_PUBLISH";
            case 37:
                return "MQAT_AMQP";
            default:
                return "";
        }
    }

    public static String MQAUTHENTICATE_STR(int value) {
        switch (value) {
            case 0:
                return "MQAUTHENTICATE_OS";
            case 1:
                return "MQAUTHENTICATE_PAM";
            default:
                return "";
        }
    }

    public static String MQAUTHOPT_STR(int value) {
        switch (value) {
            case 1:
                return "MQAUTHOPT_ENTITY_EXPLICIT";
            case 2:
                return "MQAUTHOPT_ENTITY_SET";
            case 16:
                return "MQAUTHOPT_NAME_EXPLICIT";
            case 32:
                return "MQAUTHOPT_NAME_ALL_MATCHING";
            case 64:
                return "MQAUTHOPT_NAME_AS_WILDCARD";
            case 256:
                return "MQAUTHOPT_CUMULATIVE";
            case 512:
                return "MQAUTHOPT_EXCLUDE_TEMP";
            default:
                return "";
        }
    }

    public static String MQAUTH_STR(int value) {
        switch (value) {
            case -3:
                return "MQAUTH_ALL_MQI";
            case -2:
                return "MQAUTH_ALL_ADMIN";
            case -1:
                return "MQAUTH_ALL";
            case 0:
                return "MQAUTH_NONE";
            case 1:
                return "MQAUTH_ALT_USER_AUTHORITY";
            case 2:
                return "MQAUTH_BROWSE";
            case 3:
                return "MQAUTH_CHANGE";
            case 4:
                return "MQAUTH_CLEAR";
            case 5:
                return "MQAUTH_CONNECT";
            case 6:
                return "MQAUTH_CREATE";
            case 7:
                return "MQAUTH_DELETE";
            case 8:
                return "MQAUTH_DISPLAY";
            case 9:
                return "MQAUTH_INPUT";
            case 10:
                return "MQAUTH_INQUIRE";
            case 11:
                return "MQAUTH_OUTPUT";
            case 12:
                return "MQAUTH_PASS_ALL_CONTEXT";
            case 13:
                return "MQAUTH_PASS_IDENTITY_CONTEXT";
            case 14:
                return "MQAUTH_SET";
            case 15:
                return "MQAUTH_SET_ALL_CONTEXT";
            case 16:
                return "MQAUTH_SET_IDENTITY_CONTEXT";
            case 17:
                return "MQAUTH_CONTROL";
            case 18:
                return "MQAUTH_CONTROL_EXTENDED";
            case 19:
                return "MQAUTH_PUBLISH";
            case 20:
                return "MQAUTH_SUBSCRIBE";
            case 21:
                return "MQAUTH_RESUME";
            case 22:
                return "MQAUTH_SYSTEM";
            default:
                return "";
        }
    }

    public static String MQAUTO_STR(int value) {
        switch (value) {
            case 0:
                return "MQAUTO_START_NO";
            case 1:
                return "MQAUTO_START_YES";
            default:
                return "";
        }
    }

    public static String MQBACF_STR(int value) {
        switch (value) {
            case 7001:
                return "MQBACF_EVENT_ACCOUNTING_TOKEN";
            case 7002:
                return "MQBACF_EVENT_SECURITY_ID";
            case 7003:
                return "MQBACF_RESPONSE_SET";
            case 7004:
                return "MQBACF_RESPONSE_ID";
            case 7005:
                return "MQBACF_EXTERNAL_UOW_ID";
            case 7006:
                return "MQBACF_CONNECTION_ID";
            case 7007:
                return "MQBACF_GENERIC_CONNECTION_ID";
            case 7008:
                return "MQBACF_ORIGIN_UOW_ID";
            case 7009:
                return "MQBACF_Q_MGR_UOW_ID";
            case 7010:
                return "MQBACF_ACCOUNTING_TOKEN";
            case 7011:
                return "MQBACF_CORREL_ID";
            case 7012:
                return "MQBACF_GROUP_ID";
            case 7013:
                return "MQBACF_MSG_ID";
            case 7014:
                return "MQBACF_CF_LEID";
            case 7015:
                return "MQBACF_DESTINATION_CORREL_ID";
            case 7016:
                return "MQBACF_SUB_ID";
            case 7019:
                return "MQBACF_ALTERNATE_SECURITYID";
            case 7020:
                return "MQBACF_MESSAGE_DATA";
            case 7021:
                return "MQBACF_MQBO_STRUCT";
            case 7022:
                return "MQBACF_MQCB_FUNCTION";
            case 7023:
                return "MQBACF_MQCBC_STRUCT";
            case 7024:
                return "MQBACF_MQCBD_STRUCT";
            case 7025:
                return "MQBACF_MQCD_STRUCT";
            case 7026:
                return "MQBACF_MQCNO_STRUCT";
            case 7027:
                return "MQBACF_MQGMO_STRUCT";
            case 7028:
                return "MQBACF_MQMD_STRUCT";
            case 7029:
                return "MQBACF_MQPMO_STRUCT";
            case 7030:
                return "MQBACF_MQSD_STRUCT";
            case 7031:
                return "MQBACF_MQSTS_STRUCT";
            case 7032:
                return "MQBACF_SUB_CORREL_ID";
            case 7033:
                return "MQBACF_XA_XID";
            case 7034:
                return "MQBACF_XQH_CORREL_ID";
            case 7035:
                return "MQBACF_XQH_MSG_ID";
            case 7036:
                return "MQBACF_REQUEST_ID";
            case 7037:
                return "MQBACF_PROPERTIES_DATA";
            case 7038:
                return "MQBACF_CONN_TAG";
            default:
                return "";
        }
    }

    public static String MQBALANCED_STR(int value) {
        switch (value) {
            case 0:
                return "MQBALANCED_NO";
            case 1:
                return "MQBALANCED_YES";
            case 2:
                return "MQBALANCED_NOT_APPLICABLE";
            case 3:
                return "MQBALANCED_UNKNOWN";
            default:
                return "";
        }
    }

    public static String MQBALSTATE_STR(int value) {
        switch (value) {
            case 0:
                return "MQBALSTATE_NOT_APPLICABLE";
            case 1:
                return "MQBALSTATE_LOW";
            case 2:
                return "MQBALSTATE_OK";
            case 3:
                return "MQBALSTATE_HIGH";
            case 4:
                return "MQBALSTATE_UNKNOWN";
            default:
                return "";
        }
    }

    public static String MQBL_STR(int value) {
        switch (value) {
            case -1:
                return "MQBL_NULL_TERMINATED";
            default:
                return "";
        }
    }

    public static String MQBMHO_STR(int value) {
        switch (value) {
            case 0:
                return "MQBMHO_NONE";
            case 1:
                return "MQBMHO_DELETE_PROPERTIES";
            default:
                return "";
        }
    }

    public static String MQBND_STR(int value) {
        switch (value) {
            case 0:
                return "MQBND_BIND_ON_OPEN";
            case 1:
                return "MQBND_BIND_NOT_FIXED";
            case 2:
                return "MQBND_BIND_ON_GROUP";
            default:
                return "";
        }
    }

    public static String MQBO_STR(int value) {
        switch (value) {
            case 0:
                return "MQBO_NONE";
            default:
                return "";
        }
    }

    public static String MQBPLOCATION_STR(int value) {
        switch (value) {
            case 0:
                return "MQBPLOCATION_BELOW";
            case 1:
                return "MQBPLOCATION_ABOVE";
            case 2:
                return "MQBPLOCATION_SWITCHING_ABOVE";
            case 3:
                return "MQBPLOCATION_SWITCHING_BELOW";
            default:
                return "";
        }
    }

    public static String MQBT_STR(int value) {
        switch (value) {
            case 1:
                return "MQBT_OTMA";
            default:
                return "";
        }
    }

    public static String MQCACF_STR(int value) {
        switch (value) {
            case 3001:
                return "MQCACF_FROM_Q_NAME";
            case 3002:
                return "MQCACF_TO_Q_NAME";
            case 3003:
                return "MQCACF_FROM_PROCESS_NAME";
            case 3004:
                return "MQCACF_TO_PROCESS_NAME";
            case 3005:
                return "MQCACF_FROM_NAMELIST_NAME";
            case 3006:
                return "MQCACF_TO_NAMELIST_NAME";
            case 3007:
                return "MQCACF_FROM_CHANNEL_NAME";
            case 3008:
                return "MQCACF_TO_CHANNEL_NAME";
            case 3009:
                return "MQCACF_FROM_AUTH_INFO_NAME";
            case 3010:
                return "MQCACF_TO_AUTH_INFO_NAME";
            case 3011:
                return "MQCACF_Q_NAMES";
            case 3012:
                return "MQCACF_PROCESS_NAMES";
            case 3013:
                return "MQCACF_NAMELIST_NAMES";
            case 3014:
                return "MQCACF_ESCAPE_TEXT";
            case 3015:
                return "MQCACF_LOCAL_Q_NAMES";
            case 3016:
                return "MQCACF_MODEL_Q_NAMES";
            case 3017:
                return "MQCACF_ALIAS_Q_NAMES";
            case 3018:
                return "MQCACF_REMOTE_Q_NAMES";
            case 3019:
                return "MQCACF_SENDER_CHANNEL_NAMES";
            case 3020:
                return "MQCACF_SERVER_CHANNEL_NAMES";
            case 3021:
                return "MQCACF_REQUESTER_CHANNEL_NAMES";
            case 3022:
                return "MQCACF_RECEIVER_CHANNEL_NAMES";
            case 3023:
                return "MQCACF_OBJECT_Q_MGR_NAME";
            case 3024:
                return "MQCACF_APPL_NAME";
            case 3025:
                return "MQCACF_USER_IDENTIFIER";
            case 3026:
                return "MQCACF_AUX_ERROR_DATA_STR_1";
            case 3027:
                return "MQCACF_AUX_ERROR_DATA_STR_2";
            case 3028:
                return "MQCACF_AUX_ERROR_DATA_STR_3";
            case 3029:
                return "MQCACF_BRIDGE_NAME";
            case 3030:
                return "MQCACF_STREAM_NAME";
            case 3031:
                return "MQCACF_TOPIC";
            case 3032:
                return "MQCACF_PARENT_Q_MGR_NAME";
            case 3033:
                return "MQCACF_CORREL_ID";
            case 3034:
                return "MQCACF_PUBLISH_TIMESTAMP";
            case 3035:
                return "MQCACF_STRING_DATA";
            case 3036:
                return "MQCACF_SUPPORTED_STREAM_NAME";
            case 3037:
                return "MQCACF_REG_TOPIC";
            case 3038:
                return "MQCACF_REG_TIME";
            case 3039:
                return "MQCACF_REG_USER_ID";
            case 3040:
                return "MQCACF_CHILD_Q_MGR_NAME";
            case 3041:
                return "MQCACF_REG_STREAM_NAME";
            case 3042:
                return "MQCACF_REG_Q_MGR_NAME";
            case 3043:
                return "MQCACF_REG_Q_NAME";
            case 3044:
                return "MQCACF_REG_CORREL_ID";
            case 3045:
                return "MQCACF_EVENT_USER_ID";
            case 3046:
                return "MQCACF_OBJECT_NAME";
            case 3047:
                return "MQCACF_EVENT_Q_MGR";
            case 3048:
                return "MQCACF_AUTH_INFO_NAMES";
            case 3049:
                return "MQCACF_EVENT_APPL_IDENTITY";
            case 3050:
                return "MQCACF_EVENT_APPL_NAME";
            case 3051:
                return "MQCACF_EVENT_APPL_ORIGIN";
            case 3052:
                return "MQCACF_SUBSCRIPTION_NAME";
            case 3053:
                return "MQCACF_REG_SUB_NAME";
            case 3054:
                return "MQCACF_SUBSCRIPTION_IDENTITY";
            case 3055:
                return "MQCACF_REG_SUB_IDENTITY";
            case 3056:
                return "MQCACF_SUBSCRIPTION_USER_DATA";
            case 3057:
                return "MQCACF_REG_SUB_USER_DATA";
            case 3058:
                return "MQCACF_APPL_TAG";
            case 3059:
                return "MQCACF_DATA_SET_NAME";
            case 3060:
                return "MQCACF_UOW_START_DATE";
            case 3061:
                return "MQCACF_UOW_START_TIME";
            case 3062:
                return "MQCACF_UOW_LOG_START_DATE";
            case 3063:
                return "MQCACF_UOW_LOG_START_TIME";
            case 3064:
                return "MQCACF_UOW_LOG_EXTENT_NAME";
            case 3065:
                return "MQCACF_PRINCIPAL_ENTITY_NAMES";
            case 3066:
                return "MQCACF_GROUP_ENTITY_NAMES";
            case 3067:
                return "MQCACF_AUTH_PROFILE_NAME";
            case 3068:
                return "MQCACF_ENTITY_NAME";
            case 3069:
                return "MQCACF_SERVICE_COMPONENT";
            case 3070:
                return "MQCACF_RESPONSE_Q_MGR_NAME";
            case 3071:
                return "MQCACF_CURRENT_LOG_EXTENT_NAME";
            case 3072:
                return "MQCACF_RESTART_LOG_EXTENT_NAME";
            case 3073:
                return "MQCACF_MEDIA_LOG_EXTENT_NAME";
            case 3074:
                return "MQCACF_LOG_PATH";
            case 3075:
                return "MQCACF_COMMAND_MQSC";
            case 3076:
                return "MQCACF_Q_MGR_CPF";
            case 3078:
                return "MQCACF_USAGE_LOG_RBA";
            case 3079:
                return "MQCACF_USAGE_LOG_LRSN";
            case 3080:
                return "MQCACF_COMMAND_SCOPE";
            case 3081:
                return "MQCACF_ASID";
            case 3082:
                return "MQCACF_PSB_NAME";
            case 3083:
                return "MQCACF_PST_ID";
            case 3084:
                return "MQCACF_TASK_NUMBER";
            case 3085:
                return "MQCACF_TRANSACTION_ID";
            case 3086:
                return "MQCACF_Q_MGR_UOW_ID";
            case 3088:
                return "MQCACF_ORIGIN_NAME";
            case 3089:
                return "MQCACF_ENV_INFO";
            case 3090:
                return "MQCACF_SECURITY_PROFILE";
            case 3091:
                return "MQCACF_CONFIGURATION_DATE";
            case 3092:
                return "MQCACF_CONFIGURATION_TIME";
            case 3093:
                return "MQCACF_FROM_CF_STRUC_NAME";
            case 3094:
                return "MQCACF_TO_CF_STRUC_NAME";
            case 3095:
                return "MQCACF_CF_STRUC_NAMES";
            case 3096:
                return "MQCACF_FAIL_DATE";
            case 3097:
                return "MQCACF_FAIL_TIME";
            case 3098:
                return "MQCACF_BACKUP_DATE";
            case 3099:
                return "MQCACF_BACKUP_TIME";
            case 3100:
                return "MQCACF_SYSTEM_NAME";
            case 3101:
                return "MQCACF_CF_STRUC_BACKUP_START";
            case 3102:
                return "MQCACF_CF_STRUC_BACKUP_END";
            case 3103:
                return "MQCACF_CF_STRUC_LOG_Q_MGRS";
            case 3104:
                return "MQCACF_FROM_STORAGE_CLASS";
            case 3105:
                return "MQCACF_TO_STORAGE_CLASS";
            case 3106:
                return "MQCACF_STORAGE_CLASS_NAMES";
            case 3108:
                return "MQCACF_DSG_NAME";
            case 3109:
                return "MQCACF_DB2_NAME";
            case 3110:
                return "MQCACF_SYSP_CMD_USER_ID";
            case 3111:
                return "MQCACF_SYSP_OTMA_GROUP";
            case 3112:
                return "MQCACF_SYSP_OTMA_MEMBER";
            case 3113:
                return "MQCACF_SYSP_OTMA_DRU_EXIT";
            case 3114:
                return "MQCACF_SYSP_OTMA_TPIPE_PFX";
            case 3115:
                return "MQCACF_SYSP_ARCHIVE_PFX1";
            case 3116:
                return "MQCACF_SYSP_ARCHIVE_UNIT1";
            case 3117:
                return "MQCACF_SYSP_LOG_CORREL_ID";
            case 3118:
                return "MQCACF_SYSP_UNIT_VOLSER";
            case 3119:
                return "MQCACF_SYSP_Q_MGR_TIME";
            case 3120:
                return "MQCACF_SYSP_Q_MGR_DATE";
            case 3121:
                return "MQCACF_SYSP_Q_MGR_RBA";
            case 3122:
                return "MQCACF_SYSP_LOG_RBA";
            case 3123:
                return "MQCACF_SYSP_SERVICE";
            case 3124:
                return "MQCACF_FROM_LISTENER_NAME";
            case 3125:
                return "MQCACF_TO_LISTENER_NAME";
            case 3126:
                return "MQCACF_FROM_SERVICE_NAME";
            case 3127:
                return "MQCACF_TO_SERVICE_NAME";
            case 3128:
                return "MQCACF_LAST_PUT_DATE";
            case 3129:
                return "MQCACF_LAST_PUT_TIME";
            case 3130:
                return "MQCACF_LAST_GET_DATE";
            case 3131:
                return "MQCACF_LAST_GET_TIME";
            case 3132:
                return "MQCACF_OPERATION_DATE";
            case 3133:
                return "MQCACF_OPERATION_TIME";
            case 3134:
                return "MQCACF_ACTIVITY_DESC";
            case 3135:
                return "MQCACF_APPL_IDENTITY_DATA";
            case 3136:
                return "MQCACF_APPL_ORIGIN_DATA";
            case 3137:
                return "MQCACF_PUT_DATE";
            case 3138:
                return "MQCACF_PUT_TIME";
            case 3139:
                return "MQCACF_REPLY_TO_Q";
            case 3140:
                return "MQCACF_REPLY_TO_Q_MGR";
            case 3141:
                return "MQCACF_RESOLVED_Q_NAME";
            case 3142:
                return "MQCACF_STRUC_ID";
            case 3143:
                return "MQCACF_VALUE_NAME";
            case 3144:
                return "MQCACF_SERVICE_START_DATE";
            case 3145:
                return "MQCACF_SERVICE_START_TIME";
            case 3146:
                return "MQCACF_SYSP_OFFLINE_RBA";
            case 3147:
                return "MQCACF_SYSP_ARCHIVE_PFX2";
            case 3148:
                return "MQCACF_SYSP_ARCHIVE_UNIT2";
            case 3149:
                return "MQCACF_TO_TOPIC_NAME";
            case 3150:
                return "MQCACF_FROM_TOPIC_NAME";
            case 3151:
                return "MQCACF_TOPIC_NAMES";
            case 3152:
                return "MQCACF_SUB_NAME";
            case 3153:
                return "MQCACF_DESTINATION_Q_MGR";
            case 3154:
                return "MQCACF_DESTINATION";
            case 3156:
                return "MQCACF_SUB_USER_ID";
            case 3159:
                return "MQCACF_SUB_USER_DATA";
            case 3160:
                return "MQCACF_SUB_SELECTOR";
            case 3161:
                return "MQCACF_LAST_PUB_DATE";
            case 3162:
                return "MQCACF_LAST_PUB_TIME";
            case 3163:
                return "MQCACF_FROM_SUB_NAME";
            case 3164:
                return "MQCACF_TO_SUB_NAME";
            case 3167:
                return "MQCACF_LAST_MSG_TIME";
            case 3168:
                return "MQCACF_LAST_MSG_DATE";
            case 3169:
                return "MQCACF_SUBSCRIPTION_POINT";
            case 3170:
                return "MQCACF_FILTER";
            case 3171:
                return "MQCACF_NONE";
            case 3172:
                return "MQCACF_ADMIN_TOPIC_NAMES";
            case 3173:
                return "MQCACF_ROUTING_FINGER_PRINT";
            case 3174:
                return "MQCACF_APPL_DESC";
            case 3175:
                return "MQCACF_Q_MGR_START_DATE";
            case 3176:
                return "MQCACF_Q_MGR_START_TIME";
            case 3177:
                return "MQCACF_FROM_COMM_INFO_NAME";
            case 3178:
                return "MQCACF_TO_COMM_INFO_NAME";
            case 3179:
                return "MQCACF_CF_OFFLOAD_SIZE1";
            case 3180:
                return "MQCACF_CF_OFFLOAD_SIZE2";
            case 3181:
                return "MQCACF_CF_OFFLOAD_SIZE3";
            case 3182:
                return "MQCACF_CF_SMDS_GENERIC_NAME";
            case 3183:
                return "MQCACF_CF_SMDS";
            case 3184:
                return "MQCACF_RECOVERY_DATE";
            case 3185:
                return "MQCACF_RECOVERY_TIME";
            case 3186:
                return "MQCACF_CF_SMDSCONN";
            case 3187:
                return "MQCACF_CF_STRUC_NAME";
            case 3188:
                return "MQCACF_ALTERNATE_USERID";
            case 3189:
                return "MQCACF_CHAR_ATTRS";
            case 3190:
                return "MQCACF_DYNAMIC_Q_NAME";
            case 3191:
                return "MQCACF_HOST_NAME";
            case 3192:
                return "MQCACF_MQCB_NAME";
            case 3193:
                return "MQCACF_OBJECT_STRING";
            case 3194:
                return "MQCACF_RESOLVED_LOCAL_Q_MGR";
            case 3195:
                return "MQCACF_RESOLVED_LOCAL_Q_NAME";
            case 3196:
                return "MQCACF_RESOLVED_OBJECT_STRING";
            case 3197:
                return "MQCACF_RESOLVED_Q_MGR";
            case 3198:
                return "MQCACF_SELECTION_STRING";
            case 3199:
                return "MQCACF_XA_INFO";
            case 3200:
                return "MQCACF_APPL_FUNCTION";
            case 3201:
                return "MQCACF_XQH_REMOTE_Q_NAME";
            case 3202:
                return "MQCACF_XQH_REMOTE_Q_MGR";
            case 3203:
                return "MQCACF_XQH_PUT_TIME";
            case 3204:
                return "MQCACF_XQH_PUT_DATE";
            case 3205:
                return "MQCACF_EXCL_OPERATOR_MESSAGES";
            case 3206:
                return "MQCACF_CSP_USER_IDENTIFIER";
            case 3207:
                return "MQCACF_AMQP_CLIENT_ID";
            case 3208:
                return "MQCACF_ARCHIVE_LOG_EXTENT_NAME";
            case 3209:
                return "MQCACF_APPL_IMMOVABLE_DATE";
            case 3210:
                return "MQCACF_APPL_IMMOVABLE_TIME";
            case 5507:
                return "MQCACF_CLUS_CHAN_Q_MGR_NAME";
            case 5508:
                return "MQCACF_CLUS_SHORT_CONN_NAME";
            default:
                return "";
        }
    }

    public static String MQCACH_STR(int value) {
        switch (value) {
            case 3501:
                return "MQCACH_CHANNEL_NAME";
            case 3502:
                return "MQCACH_DESC";
            case 3503:
                return "MQCACH_MODE_NAME";
            case 3504:
                return "MQCACH_TP_NAME";
            case 3505:
                return "MQCACH_XMIT_Q_NAME";
            case 3506:
                return "MQCACH_CONNECTION_NAME";
            case 3507:
                return "MQCACH_MCA_NAME";
            case 3508:
                return "MQCACH_SEC_EXIT_NAME";
            case 3509:
                return "MQCACH_MSG_EXIT_NAME";
            case 3510:
                return "MQCACH_SEND_EXIT_NAME";
            case 3511:
                return "MQCACH_RCV_EXIT_NAME";
            case 3512:
                return "MQCACH_CHANNEL_NAMES";
            case 3513:
                return "MQCACH_SEC_EXIT_USER_DATA";
            case 3514:
                return "MQCACH_MSG_EXIT_USER_DATA";
            case 3515:
                return "MQCACH_SEND_EXIT_USER_DATA";
            case 3516:
                return "MQCACH_RCV_EXIT_USER_DATA";
            case 3517:
                return "MQCACH_USER_ID";
            case 3518:
                return "MQCACH_PASSWORD";
            case 3520:
                return "MQCACH_LOCAL_ADDRESS";
            case 3521:
                return "MQCACH_LOCAL_NAME";
            case 3524:
                return "MQCACH_LAST_MSG_TIME";
            case 3525:
                return "MQCACH_LAST_MSG_DATE";
            case 3527:
                return "MQCACH_MCA_USER_ID";
            case 3528:
                return "MQCACH_CHANNEL_START_TIME";
            case 3529:
                return "MQCACH_CHANNEL_START_DATE";
            case 3530:
                return "MQCACH_MCA_JOB_NAME";
            case 3531:
                return "MQCACH_LAST_LUWID";
            case 3532:
                return "MQCACH_CURRENT_LUWID";
            case 3533:
                return "MQCACH_FORMAT_NAME";
            case 3534:
                return "MQCACH_MR_EXIT_NAME";
            case 3535:
                return "MQCACH_MR_EXIT_USER_DATA";
            case 3544:
                return "MQCACH_SSL_CIPHER_SPEC";
            case 3545:
                return "MQCACH_SSL_PEER_NAME";
            case 3546:
                return "MQCACH_SSL_HANDSHAKE_STAGE";
            case 3547:
                return "MQCACH_SSL_SHORT_PEER_NAME";
            case 3548:
                return "MQCACH_REMOTE_APPL_TAG";
            case 3549:
                return "MQCACH_SSL_CERT_USER_ID";
            case 3550:
                return "MQCACH_SSL_CERT_ISSUER_NAME";
            case 3551:
                return "MQCACH_LU_NAME";
            case 3552:
                return "MQCACH_IP_ADDRESS";
            case 3553:
                return "MQCACH_TCP_NAME";
            case 3554:
                return "MQCACH_LISTENER_NAME";
            case 3555:
                return "MQCACH_LISTENER_DESC";
            case 3556:
                return "MQCACH_LISTENER_START_DATE";
            case 3557:
                return "MQCACH_LISTENER_START_TIME";
            case 3558:
                return "MQCACH_SSL_KEY_RESET_DATE";
            case 3559:
                return "MQCACH_SSL_KEY_RESET_TIME";
            case 3560:
                return "MQCACH_REMOTE_VERSION";
            case 3561:
                return "MQCACH_REMOTE_PRODUCT";
            case 3562:
                return "MQCACH_GROUP_ADDRESS";
            case 3563:
                return "MQCACH_JAAS_CONFIG";
            case 3564:
                return "MQCACH_CLIENT_ID";
            case 3565:
                return "MQCACH_SSL_KEY_PASSPHRASE";
            case 3566:
                return "MQCACH_CONNECTION_NAME_LIST";
            case 3567:
                return "MQCACH_CLIENT_USER_ID";
            case 3568:
                return "MQCACH_MCA_USER_ID_LIST";
            case 3569:
                return "MQCACH_SSL_CIPHER_SUITE";
            case 3570:
                return "MQCACH_WEBCONTENT_PATH";
            case 3571:
                return "MQCACH_TOPIC_ROOT";
            default:
                return "";
        }
    }

    public static String MQCADSD_STR(int value) {
        switch (value) {
            case 0:
                return "MQCADSD_NONE";
            case 1:
                return "MQCADSD_SEND";
            case 16:
                return "MQCADSD_RECV";
            case 256:
                return "MQCADSD_MSGFORMAT";
            default:
                return "";
        }
    }

    public static String MQCAFTY_STR(int value) {
        switch (value) {
            case 0:
                return "MQCAFTY_NONE";
            case 1:
                return "MQCAFTY_PREFERRED";
            default:
                return "";
        }
    }

    public static String MQCAMO_STR(int value) {
        switch (value) {
            case 2701:
                return "MQCAMO_CLOSE_DATE";
            case 2702:
                return "MQCAMO_CLOSE_TIME";
            case 2703:
                return "MQCAMO_CONN_DATE";
            case 2704:
                return "MQCAMO_CONN_TIME";
            case 2705:
                return "MQCAMO_DISC_DATE";
            case 2706:
                return "MQCAMO_DISC_TIME";
            case 2707:
                return "MQCAMO_END_DATE";
            case 2708:
                return "MQCAMO_END_TIME";
            case 2709:
                return "MQCAMO_OPEN_DATE";
            case 2710:
                return "MQCAMO_OPEN_TIME";
            case 2711:
                return "MQCAMO_START_DATE";
            case 2712:
                return "MQCAMO_START_TIME";
            case 2713:
                return "MQCAMO_MONITOR_CLASS";
            case 2714:
                return "MQCAMO_MONITOR_TYPE";
            case 2715:
                return "MQCAMO_MONITOR_DESC";
            default:
                return "";
        }
    }

    public static String MQCAP_STR(int value) {
        switch (value) {
            case 0:
                return "MQCAP_NOT_SUPPORTED";
            case 1:
                return "MQCAP_SUPPORTED";
            case 2:
                return "MQCAP_EXPIRED";
            default:
                return "";
        }
    }

    public static String MQCAUT_STR(int value) {
        switch (value) {
            case 0:
                return "MQCAUT_ALL";
            case 1:
                return "MQCAUT_BLOCKUSER";
            case 2:
                return "MQCAUT_BLOCKADDR";
            case 3:
                return "MQCAUT_SSLPEERMAP";
            case 4:
                return "MQCAUT_ADDRESSMAP";
            case 5:
                return "MQCAUT_USERMAP";
            case 6:
                return "MQCAUT_QMGRMAP";
            default:
                return "";
        }
    }

    public static String MQCA_STR(int value) {
        switch (value) {
            case 2001:
                return "MQCA_APPL_ID";
            case 2002:
                return "MQCA_BASE_OBJECT_NAME";
            case 2003:
                return "MQCA_COMMAND_INPUT_Q_NAME";
            case 2004:
                return "MQCA_CREATION_DATE";
            case 2005:
                return "MQCA_CREATION_TIME";
            case 2006:
                return "MQCA_DEAD_LETTER_Q_NAME";
            case 2007:
                return "MQCA_ENV_DATA";
            case 2008:
                return "MQCA_INITIATION_Q_NAME";
            case 2009:
                return "MQCA_NAMELIST_DESC";
            case 2010:
                return "MQCA_NAMELIST_NAME";
            case 2011:
                return "MQCA_PROCESS_DESC";
            case 2012:
                return "MQCA_PROCESS_NAME";
            case 2013:
                return "MQCA_Q_DESC";
            case 2014:
                return "MQCA_Q_MGR_DESC";
            case 2015:
                return "MQCA_Q_MGR_NAME";
            case 2016:
                return "MQCA_Q_NAME";
            case 2017:
                return "MQCA_REMOTE_Q_MGR_NAME";
            case 2018:
                return "MQCA_REMOTE_Q_NAME";
            case 2019:
                return "MQCA_BACKOUT_REQ_Q_NAME";
            case 2020:
                return "MQCA_NAMES";
            case 2021:
                return "MQCA_USER_DATA";
            case 2022:
                return "MQCA_STORAGE_CLASS";
            case 2023:
                return "MQCA_TRIGGER_DATA";
            case 2024:
                return "MQCA_XMIT_Q_NAME";
            case 2025:
                return "MQCA_DEF_XMIT_Q_NAME";
            case 2026:
                return "MQCA_CHANNEL_AUTO_DEF_EXIT";
            case 2027:
                return "MQCA_ALTERATION_DATE";
            case 2028:
                return "MQCA_ALTERATION_TIME";
            case 2029:
                return "MQCA_CLUSTER_NAME";
            case 2030:
                return "MQCA_CLUSTER_NAMELIST";
            case 2031:
                return "MQCA_CLUSTER_Q_MGR_NAME";
            case 2032:
                return "MQCA_Q_MGR_IDENTIFIER";
            case 2033:
                return "MQCA_CLUSTER_WORKLOAD_EXIT";
            case 2034:
                return "MQCA_CLUSTER_WORKLOAD_DATA";
            case 2035:
                return "MQCA_REPOSITORY_NAME";
            case 2036:
                return "MQCA_REPOSITORY_NAMELIST";
            case 2037:
                return "MQCA_CLUSTER_DATE";
            case 2038:
                return "MQCA_CLUSTER_TIME";
            case 2039:
                return "MQCA_CF_STRUC_NAME";
            case 2040:
                return "MQCA_QSG_NAME";
            case 2041:
                return "MQCA_IGQ_USER_ID";
            case 2042:
                return "MQCA_STORAGE_CLASS_DESC";
            case 2043:
                return "MQCA_XCF_GROUP_NAME";
            case 2044:
                return "MQCA_XCF_MEMBER_NAME";
            case 2045:
                return "MQCA_AUTH_INFO_NAME";
            case 2046:
                return "MQCA_AUTH_INFO_DESC";
            case 2047:
                return "MQCA_LDAP_USER_NAME";
            case 2048:
                return "MQCA_LDAP_PASSWORD";
            case 2049:
                return "MQCA_SSL_KEY_REPOSITORY";
            case 2050:
                return "MQCA_SSL_CRL_NAMELIST";
            case 2051:
                return "MQCA_SSL_CRYPTO_HARDWARE";
            case 2052:
                return "MQCA_CF_STRUC_DESC";
            case 2053:
                return "MQCA_AUTH_INFO_CONN_NAME";
            case 2060:
                return "MQCA_CICS_FILE_NAME";
            case 2061:
                return "MQCA_TRIGGER_TRANS_ID";
            case 2062:
                return "MQCA_TRIGGER_PROGRAM_NAME";
            case 2063:
                return "MQCA_TRIGGER_TERM_ID";
            case 2064:
                return "MQCA_TRIGGER_CHANNEL_NAME";
            case 2065:
                return "MQCA_SYSTEM_LOG_Q_NAME";
            case 2066:
                return "MQCA_MONITOR_Q_NAME";
            case 2067:
                return "MQCA_COMMAND_REPLY_Q_NAME";
            case 2068:
                return "MQCA_BATCH_INTERFACE_ID";
            case 2069:
                return "MQCA_SSL_KEY_LIBRARY";
            case 2070:
                return "MQCA_SSL_KEY_MEMBER";
            case 2071:
                return "MQCA_DNS_GROUP";
            case 2072:
                return "MQCA_LU_GROUP_NAME";
            case 2073:
                return "MQCA_LU_NAME";
            case 2074:
                return "MQCA_LU62_ARM_SUFFIX";
            case 2075:
                return "MQCA_TCP_NAME";
            case 2076:
                return "MQCA_CHINIT_SERVICE_PARM";
            case 2077:
                return "MQCA_SERVICE_NAME";
            case 2078:
                return "MQCA_SERVICE_DESC";
            case 2079:
                return "MQCA_SERVICE_START_COMMAND";
            case 2080:
                return "MQCA_SERVICE_START_ARGS";
            case 2081:
                return "MQCA_SERVICE_STOP_COMMAND";
            case 2082:
                return "MQCA_SERVICE_STOP_ARGS";
            case 2083:
                return "MQCA_STDOUT_DESTINATION";
            case 2084:
                return "MQCA_STDERR_DESTINATION";
            case 2085:
                return "MQCA_TPIPE_NAME";
            case 2086:
                return "MQCA_PASS_TICKET_APPL";
            case 2090:
                return "MQCA_AUTO_REORG_START_TIME";
            case 2091:
                return "MQCA_AUTO_REORG_CATALOG";
            case 2092:
                return "MQCA_TOPIC_NAME";
            case 2093:
                return "MQCA_TOPIC_DESC";
            case 2094:
                return "MQCA_TOPIC_STRING";
            case 2096:
                return "MQCA_MODEL_DURABLE_Q";
            case 2097:
                return "MQCA_MODEL_NON_DURABLE_Q";
            case 2098:
                return "MQCA_RESUME_DATE";
            case 2099:
                return "MQCA_RESUME_TIME";
            case 2101:
                return "MQCA_CHILD";
            case 2102:
                return "MQCA_PARENT";
            case 2105:
                return "MQCA_ADMIN_TOPIC_NAME";
            case 2108:
                return "MQCA_TOPIC_STRING_FILTER";
            case 2109:
                return "MQCA_AUTH_INFO_OCSP_URL";
            case 2110:
                return "MQCA_COMM_INFO_NAME";
            case 2111:
                return "MQCA_COMM_INFO_DESC";
            case 2112:
                return "MQCA_POLICY_NAME";
            case 2113:
                return "MQCA_SIGNER_DN";
            case 2114:
                return "MQCA_RECIPIENT_DN";
            case 2115:
                return "MQCA_INSTALLATION_DESC";
            case 2116:
                return "MQCA_INSTALLATION_NAME";
            case 2117:
                return "MQCA_INSTALLATION_PATH";
            case 2118:
                return "MQCA_CHLAUTH_DESC";
            case 2119:
                return "MQCA_CUSTOM";
            case 2120:
                return "MQCA_VERSION";
            case 2121:
                return "MQCA_CERT_LABEL";
            case 2122:
                return "MQCA_XR_VERSION";
            case 2123:
                return "MQCA_XR_SSL_CIPHER_SUITES";
            case 2124:
                return "MQCA_CLUS_CHL_NAME";
            case 2125:
                return "MQCA_CONN_AUTH";
            case 2126:
                return "MQCA_LDAP_BASE_DN_USERS";
            case 2127:
                return "MQCA_LDAP_SHORT_USER_FIELD";
            case 2128:
                return "MQCA_LDAP_USER_OBJECT_CLASS";
            case 2129:
                return "MQCA_LDAP_USER_ATTR_FIELD";
            case 2130:
                return "MQCA_SSL_CERT_ISSUER_NAME";
            case 2131:
                return "MQCA_QSG_CERT_LABEL";
            case 2132:
                return "MQCA_LDAP_BASE_DN_GROUPS";
            case 2133:
                return "MQCA_LDAP_GROUP_OBJECT_CLASS";
            case 2134:
                return "MQCA_LDAP_GROUP_ATTR_FIELD";
            case 2135:
                return "MQCA_LDAP_FIND_GROUP_FIELD";
            case 2136:
                return "MQCA_AMQP_VERSION";
            case 2137:
                return "MQCA_AMQP_SSL_CIPHER_SUITES";
            case 4000:
                return "MQCA_USER_LIST";
            default:
                return "";
        }
    }

    public static String MQCBCF_STR(int value) {
        switch (value) {
            case 0:
                return "MQCBCF_NONE";
            case 1:
                return "MQCBCF_READA_BUFFER_EMPTY";
            default:
                return "";
        }
    }

    public static String MQCBCT_STR(int value) {
        switch (value) {
            case 1:
                return "MQCBCT_START_CALL";
            case 2:
                return "MQCBCT_STOP_CALL";
            case 3:
                return "MQCBCT_REGISTER_CALL";
            case 4:
                return "MQCBCT_DEREGISTER_CALL";
            case 5:
                return "MQCBCT_EVENT_CALL";
            case 6:
                return "MQCBCT_MSG_REMOVED";
            case 7:
                return "MQCBCT_MSG_NOT_REMOVED";
            case 8:
                return "MQCBCT_MC_EVENT_CALL";
            default:
                return "";
        }
    }

    public static String MQCBDO_STR(int value) {
        switch (value) {
            case 0:
                return "MQCBDO_NONE";
            case 1:
                return "MQCBDO_START_CALL";
            case 4:
                return "MQCBDO_STOP_CALL";
            case 256:
                return "MQCBDO_REGISTER_CALL";
            case 512:
                return "MQCBDO_DEREGISTER_CALL";
            case 8192:
                return "MQCBDO_FAIL_IF_QUIESCING";
            case 16384:
                return "MQCBDO_EVENT_CALL";
            case 32768:
                return "MQCBDO_MC_EVENT_CALL";
            default:
                return "";
        }
    }

    public static String MQCBD_STR(int value) {
        switch (value) {
            case -1:
                return "MQCBD_FULL_MSG_LENGTH";
            default:
                return "";
        }
    }

    public static String MQCBO_STR(int value) {
        switch (value) {
            case 0:
                return "MQCBO_NONE";
            case 1:
                return "MQCBO_ADMIN_BAG";
            case 2:
                return "MQCBO_LIST_FORM_ALLOWED";
            case 4:
                return "MQCBO_REORDER_AS_REQUIRED";
            case 8:
                return "MQCBO_CHECK_SELECTORS";
            case 16:
                return "MQCBO_COMMAND_BAG";
            case 32:
                return "MQCBO_SYSTEM_BAG";
            case 64:
                return "MQCBO_GROUP_BAG";
            default:
                return "";
        }
    }

    public static String MQCBT_STR(int value) {
        switch (value) {
            case 1:
                return "MQCBT_MESSAGE_CONSUMER";
            case 2:
                return "MQCBT_EVENT_HANDLER";
            default:
                return "";
        }
    }

    public static String MQCCSI_STR(int value) {
        switch (value) {
            case -4:
                return "MQCCSI_AS_PUBLISHED";
            case -3:
                return "MQCCSI_APPL";
            case -2:
                return "MQCCSI_INHERIT";
            case -1:
                return "MQCCSI_EMBEDDED";
            case 0:
                return "MQCCSI_DEFAULT";
            default:
                return "";
        }
    }

    public static String MQCCT_STR(int value) {
        switch (value) {
            case 0:
                return "MQCCT_NO";
            case 1:
                return "MQCCT_YES";
            default:
                return "";
        }
    }

    public static String MQCC_STR(int value) {
        switch (value) {
            case -1:
                return "MQCC_UNKNOWN";
            case 0:
                return "MQCC_OK";
            case 1:
                return "MQCC_WARNING";
            case 2:
                return "MQCC_FAILED";
            default:
                return "";
        }
    }

    public static String MQCDC_STR(int value) {
        switch (value) {
            case 0:
                return "MQCDC_NO_SENDER_CONVERSION";
            case 1:
                return "MQCDC_SENDER_CONVERSION";
            default:
                return "";
        }
    }

    public static String MQCFACCESS_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFACCESS_ENABLED";
            case 1:
                return "MQCFACCESS_SUSPENDED";
            case 2:
                return "MQCFACCESS_DISABLED";
            default:
                return "";
        }
    }

    public static String MQCFCONLOS_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFCONLOS_TERMINATE";
            case 1:
                return "MQCFCONLOS_TOLERATE";
            case 2:
                return "MQCFCONLOS_ASQMGR";
            default:
                return "";
        }
    }

    public static String MQCFOFFLD_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFOFFLD_NONE";
            case 1:
                return "MQCFOFFLD_SMDS";
            case 2:
                return "MQCFOFFLD_DB2";
            case 3:
                return "MQCFOFFLD_BOTH";
            default:
                return "";
        }
    }

    public static String MQCFOP_STR(int value) {
        switch (value) {
            case 1:
                return "MQCFOP_LESS";
            case 2:
                return "MQCFOP_EQUAL";
            case 3:
                return "MQCFOP_NOT_GREATER";
            case 4:
                return "MQCFOP_GREATER";
            case 5:
                return "MQCFOP_NOT_EQUAL";
            case 6:
                return "MQCFOP_NOT_LESS";
            case 10:
                return "MQCFOP_CONTAINS";
            case 13:
                return "MQCFOP_EXCLUDES";
            case 18:
                return "MQCFOP_LIKE";
            case 21:
                return "MQCFOP_NOT_LIKE";
            case 26:
                return "MQCFOP_CONTAINS_GEN";
            case 29:
                return "MQCFOP_EXCLUDES_GEN";
            default:
                return "";
        }
    }

    public static String MQCFO_REFRESH_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFO_REFRESH_REPOSITORY_NO";
            case 1:
                return "MQCFO_REFRESH_REPOSITORY_YES";
            default:
                return "";
        }
    }

    public static String MQCFO_REMOVE_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFO_REMOVE_QUEUES_NO";
            case 1:
                return "MQCFO_REMOVE_QUEUES_YES";
            default:
                return "";
        }
    }

    public static String MQCFR_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFR_NO";
            case 1:
                return "MQCFR_YES";
            default:
                return "";
        }
    }

    public static String MQCFSTATUS_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFSTATUS_NOT_FOUND";
            case 1:
                return "MQCFSTATUS_ACTIVE";
            case 2:
                return "MQCFSTATUS_IN_RECOVER";
            case 3:
                return "MQCFSTATUS_IN_BACKUP";
            case 4:
                return "MQCFSTATUS_FAILED";
            case 5:
                return "MQCFSTATUS_NONE";
            case 6:
                return "MQCFSTATUS_UNKNOWN";
            case 7:
                return "MQCFSTATUS_RECOVERED";
            case 8:
                return "MQCFSTATUS_EMPTY";
            case 9:
                return "MQCFSTATUS_NEW";
            case 20:
                return "MQCFSTATUS_ADMIN_INCOMPLETE";
            case 21:
                return "MQCFSTATUS_NEVER_USED";
            case 22:
                return "MQCFSTATUS_NO_BACKUP";
            case 23:
                return "MQCFSTATUS_NOT_FAILED";
            case 24:
                return "MQCFSTATUS_NOT_RECOVERABLE";
            case 25:
                return "MQCFSTATUS_XES_ERROR";
            default:
                return "";
        }
    }

    public static String MQCFTYPE_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFTYPE_APPL";
            case 1:
                return "MQCFTYPE_ADMIN";
            default:
                return "";
        }
    }

    public static String MQCFT_STR(int value) {
        switch (value) {
            case 0:
                return "MQCFT_NONE";
            case 1:
                return "MQCFT_COMMAND";
            case 2:
                return "MQCFT_RESPONSE";
            case 3:
                return "MQCFT_INTEGER";
            case 4:
                return "MQCFT_STRING";
            case 5:
                return "MQCFT_INTEGER_LIST";
            case 6:
                return "MQCFT_STRING_LIST";
            case 7:
                return "MQCFT_EVENT";
            case 8:
                return "MQCFT_USER";
            case 9:
                return "MQCFT_BYTE_STRING";
            case 10:
                return "MQCFT_TRACE_ROUTE";
            case 12:
                return "MQCFT_REPORT";
            case 13:
                return "MQCFT_INTEGER_FILTER";
            case 14:
                return "MQCFT_STRING_FILTER";
            case 15:
                return "MQCFT_BYTE_STRING_FILTER";
            case 16:
                return "MQCFT_COMMAND_XR";
            case 17:
                return "MQCFT_XR_MSG";
            case 18:
                return "MQCFT_XR_ITEM";
            case 19:
                return "MQCFT_XR_SUMMARY";
            case 20:
                return "MQCFT_GROUP";
            case 21:
                return "MQCFT_STATISTICS";
            case 22:
                return "MQCFT_ACCOUNTING";
            case 23:
                return "MQCFT_INTEGER64";
            case 25:
                return "MQCFT_INTEGER64_LIST";
            case 26:
                return "MQCFT_APP_ACTIVITY";
            case 27:
                return "MQCFT_STATUS";
            default:
                return "";
        }
    }

    public static String MQCF_STR(int value) {
        switch (value) {
            case 0:
                return "MQCF_NONE";
            case 1:
                return "MQCF_DIST_LISTS";
            default:
                return "";
        }
    }

    public static String MQCGWI_STR(int value) {
        switch (value) {
            case -2:
                return "MQCGWI_DEFAULT";
            default:
                return "";
        }
    }

    public static String MQCHAD_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHAD_DISABLED";
            case 1:
                return "MQCHAD_ENABLED";
            default:
                return "";
        }
    }

    public static String MQCHIDS_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHIDS_NOT_INDOUBT";
            case 1:
                return "MQCHIDS_INDOUBT";
            default:
                return "";
        }
    }

    public static String MQCHK_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHK_OPTIONAL";
            case 1:
                return "MQCHK_NONE";
            case 2:
                return "MQCHK_REQUIRED_ADMIN";
            case 3:
                return "MQCHK_REQUIRED";
            case 4:
                return "MQCHK_AS_Q_MGR";
            default:
                return "";
        }
    }

    public static String MQCHLA_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHLA_DISABLED";
            case 1:
                return "MQCHLA_ENABLED";
            default:
                return "";
        }
    }

    public static String MQCHLD_STR(int value) {
        switch (value) {
            case -1:
                return "MQCHLD_ALL";
            case 1:
                return "MQCHLD_DEFAULT";
            case 2:
                return "MQCHLD_SHARED";
            case 4:
                return "MQCHLD_PRIVATE";
            case 5:
                return "MQCHLD_FIXSHARED";
            default:
                return "";
        }
    }

    public static String MQCHRR_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHRR_RESET_NOT_REQUESTED";
            default:
                return "";
        }
    }

    public static String MQCHSH_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHSH_RESTART_NO";
            case 1:
                return "MQCHSH_RESTART_YES";
            default:
                return "";
        }
    }

    public static String MQCHSR_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHSR_STOP_NOT_REQUESTED";
            case 1:
                return "MQCHSR_STOP_REQUESTED";
            default:
                return "";
        }
    }

    public static String MQCHSSTATE_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHSSTATE_OTHER";
            case 100:
                return "MQCHSSTATE_END_OF_BATCH";
            case 200:
                return "MQCHSSTATE_SENDING";
            case 300:
                return "MQCHSSTATE_RECEIVING";
            case 400:
                return "MQCHSSTATE_SERIALIZING";
            case 500:
                return "MQCHSSTATE_RESYNCHING";
            case 600:
                return "MQCHSSTATE_HEARTBEATING";
            case 700:
                return "MQCHSSTATE_IN_SCYEXIT";
            case 800:
                return "MQCHSSTATE_IN_RCVEXIT";
            case 900:
                return "MQCHSSTATE_IN_SENDEXIT";
            case 1000:
                return "MQCHSSTATE_IN_MSGEXIT";
            case 1100:
                return "MQCHSSTATE_IN_MREXIT";
            case 1200:
                return "MQCHSSTATE_IN_CHADEXIT";
            case 1250:
                return "MQCHSSTATE_NET_CONNECTING";
            case 1300:
                return "MQCHSSTATE_SSL_HANDSHAKING";
            case 1400:
                return "MQCHSSTATE_NAME_SERVER";
            case 1500:
                return "MQCHSSTATE_IN_MQPUT";
            case 1600:
                return "MQCHSSTATE_IN_MQGET";
            case 1700:
                return "MQCHSSTATE_IN_MQI_CALL";
            case 1800:
                return "MQCHSSTATE_COMPRESSING";
            default:
                return "";
        }
    }

    public static String MQCHS_STR(int value) {
        switch (value) {
            case 0:
                return "MQCHS_INACTIVE";
            case 1:
                return "MQCHS_BINDING";
            case 2:
                return "MQCHS_STARTING";
            case 3:
                return "MQCHS_RUNNING";
            case 4:
                return "MQCHS_STOPPING";
            case 5:
                return "MQCHS_RETRYING";
            case 6:
                return "MQCHS_STOPPED";
            case 7:
                return "MQCHS_REQUESTING";
            case 8:
                return "MQCHS_PAUSED";
            case 9:
                return "MQCHS_DISCONNECTED";
            case 13:
                return "MQCHS_INITIALIZING";
            case 14:
                return "MQCHS_SWITCHING";
            default:
                return "";
        }
    }

    public static String MQCHTAB_STR(int value) {
        switch (value) {
            case 1:
                return "MQCHTAB_Q_MGR";
            case 2:
                return "MQCHTAB_CLNTCONN";
            default:
                return "";
        }
    }

    public static String MQCHT_STR(int value) {
        switch (value) {
            case 1:
                return "MQCHT_SENDER";
            case 2:
                return "MQCHT_SERVER";
            case 3:
                return "MQCHT_RECEIVER";
            case 4:
                return "MQCHT_REQUESTER";
            case 5:
                return "MQCHT_ALL";
            case 6:
                return "MQCHT_CLNTCONN";
            case 7:
                return "MQCHT_SVRCONN";
            case 8:
                return "MQCHT_CLUSRCVR";
            case 9:
                return "MQCHT_CLUSSDR";
            case 10:
                return "MQCHT_MQTT";
            case 11:
                return "MQCHT_AMQP";
            default:
                return "";
        }
    }

    public static String MQCIH_STR(int value) {
        switch (value) {
            case 0:
                return "MQCIH_NONE";
            case 1:
                return "MQCIH_PASS_EXPIRATION";
            case 2:
                return "MQCIH_REPLY_WITHOUT_NULLS";
            case 4:
                return "MQCIH_SYNC_ON_RETURN";
            default:
                return "";
        }
    }

    public static String MQCIT_STR(int value) {
        switch (value) {
            case 1:
                return "MQCIT_MULTICAST";
            default:
                return "";
        }
    }

    public static String MQCLCT_STR(int value) {
        switch (value) {
            case 0:
                return "MQCLCT_STATIC";
            case 1:
                return "MQCLCT_DYNAMIC";
            default:
                return "";
        }
    }

    public static String MQCLROUTE_STR(int value) {
        switch (value) {
            case 0:
                return "MQCLROUTE_DIRECT";
            case 1:
                return "MQCLROUTE_TOPIC_HOST";
            case 2:
                return "MQCLROUTE_NONE";
            default:
                return "";
        }
    }

    public static String MQCLRS_STR(int value) {
        switch (value) {
            case 1:
                return "MQCLRS_LOCAL";
            case 2:
                return "MQCLRS_GLOBAL";
            default:
                return "";
        }
    }

    public static String MQCLRT_STR(int value) {
        switch (value) {
            case 1:
                return "MQCLRT_RETAINED";
            default:
                return "";
        }
    }

    public static String MQCLST_STR(int value) {
        switch (value) {
            case 0:
                return "MQCLST_ACTIVE";
            case 1:
                return "MQCLST_PENDING";
            case 2:
                return "MQCLST_INVALID";
            case 3:
                return "MQCLST_ERROR";
            default:
                return "";
        }
    }

    public static String MQCLT_STR(int value) {
        switch (value) {
            case 1:
                return "MQCLT_PROGRAM";
            case 2:
                return "MQCLT_TRANSACTION";
            default:
                return "";
        }
    }

    public static String MQCLWL_STR(int value) {
        switch (value) {
            case -3:
                return "MQCLWL_USEQ_AS_Q_MGR";
            case 0:
                return "MQCLWL_USEQ_LOCAL";
            case 1:
                return "MQCLWL_USEQ_ANY";
            default:
                return "";
        }
    }

    public static String MQCLXQ_STR(int value) {
        switch (value) {
            case 0:
                return "MQCLXQ_SCTQ";
            case 1:
                return "MQCLXQ_CHANNEL";
            default:
                return "";
        }
    }

    public static String MQCMDI_STR(int value) {
        switch (value) {
            case 1:
                return "MQCMDI_CMDSCOPE_ACCEPTED";
            case 2:
                return "MQCMDI_CMDSCOPE_GENERATED";
            case 3:
                return "MQCMDI_CMDSCOPE_COMPLETED";
            case 4:
                return "MQCMDI_QSG_DISP_COMPLETED";
            case 5:
                return "MQCMDI_COMMAND_ACCEPTED";
            case 6:
                return "MQCMDI_CLUSTER_REQUEST_QUEUED";
            case 7:
                return "MQCMDI_CHANNEL_INIT_STARTED";
            case 11:
                return "MQCMDI_RECOVER_STARTED";
            case 12:
                return "MQCMDI_BACKUP_STARTED";
            case 13:
                return "MQCMDI_RECOVER_COMPLETED";
            case 14:
                return "MQCMDI_SEC_TIMER_ZERO";
            case 16:
                return "MQCMDI_REFRESH_CONFIGURATION";
            case 17:
                return "MQCMDI_SEC_SIGNOFF_ERROR";
            case 18:
                return "MQCMDI_IMS_BRIDGE_SUSPENDED";
            case 19:
                return "MQCMDI_DB2_SUSPENDED";
            case 20:
                return "MQCMDI_DB2_OBSOLETE_MSGS";
            case 21:
                return "MQCMDI_SEC_UPPERCASE";
            case 22:
                return "MQCMDI_SEC_MIXEDCASE";
            default:
                return "";
        }
    }

    public static String MQCMDL_STR(int value) {
        switch (value) {
            case 100:
                return "MQCMDL_LEVEL_1";
            case 101:
                return "MQCMDL_LEVEL_101";
            case 110:
                return "MQCMDL_LEVEL_110";
            case 114:
                return "MQCMDL_LEVEL_114";
            case 120:
                return "MQCMDL_LEVEL_120";
            case 200:
                return "MQCMDL_LEVEL_200";
            case 201:
                return "MQCMDL_LEVEL_201";
            case 210:
                return "MQCMDL_LEVEL_210";
            case 211:
                return "MQCMDL_LEVEL_211";
            case 220:
                return "MQCMDL_LEVEL_220";
            case 221:
                return "MQCMDL_LEVEL_221";
            case 230:
                return "MQCMDL_LEVEL_230";
            case 320:
                return "MQCMDL_LEVEL_320";
            case 420:
                return "MQCMDL_LEVEL_420";
            case 500:
                return "MQCMDL_LEVEL_500";
            case 510:
                return "MQCMDL_LEVEL_510";
            case 520:
                return "MQCMDL_LEVEL_520";
            case 530:
                return "MQCMDL_LEVEL_530";
            case 531:
                return "MQCMDL_LEVEL_531";
            case 600:
                return "MQCMDL_LEVEL_600";
            case 700:
                return "MQCMDL_LEVEL_700";
            case 701:
                return "MQCMDL_LEVEL_701";
            case 710:
                return "MQCMDL_LEVEL_710";
            case 711:
                return "MQCMDL_LEVEL_711";
            case 750:
                return "MQCMDL_LEVEL_750";
            case 800:
                return "MQCMDL_LEVEL_800";
            case 801:
                return "MQCMDL_LEVEL_801";
            case 802:
                return "MQCMDL_LEVEL_802";
            case 900:
                return "MQCMDL_LEVEL_900";
            case 901:
                return "MQCMDL_LEVEL_901";
            case 902:
                return "MQCMDL_LEVEL_902";
            case 903:
                return "MQCMDL_LEVEL_903";
            case 904:
                return "MQCMDL_LEVEL_904";
            case 905:
                return "MQCMDL_LEVEL_905";
            case 910:
                return "MQCMDL_LEVEL_910";
            case 911:
                return "MQCMDL_LEVEL_911";
            case 912:
                return "MQCMDL_LEVEL_912";
            case 913:
                return "MQCMDL_LEVEL_913";
            case 914:
                return "MQCMDL_LEVEL_914";
            case 915:
                return "MQCMDL_LEVEL_915";
            case 920:
                return "MQCMDL_LEVEL_920";
            default:
                return "";
        }
    }

    public static String MQCMD_STR(int value) {
        switch (value) {
            case 0:
                return "MQCMD_NONE";
            case 1:
                return "MQCMD_CHANGE_Q_MGR";
            case 2:
                return "MQCMD_INQUIRE_Q_MGR";
            case 3:
                return "MQCMD_CHANGE_PROCESS";
            case 4:
                return "MQCMD_COPY_PROCESS";
            case 5:
                return "MQCMD_CREATE_PROCESS";
            case 6:
                return "MQCMD_DELETE_PROCESS";
            case 7:
                return "MQCMD_INQUIRE_PROCESS";
            case 8:
                return "MQCMD_CHANGE_Q";
            case 9:
                return "MQCMD_CLEAR_Q";
            case 10:
                return "MQCMD_COPY_Q";
            case 11:
                return "MQCMD_CREATE_Q";
            case 12:
                return "MQCMD_DELETE_Q";
            case 13:
                return "MQCMD_INQUIRE_Q";
            case 16:
                return "MQCMD_REFRESH_Q_MGR";
            case 17:
                return "MQCMD_RESET_Q_STATS";
            case 18:
                return "MQCMD_INQUIRE_Q_NAMES";
            case 19:
                return "MQCMD_INQUIRE_PROCESS_NAMES";
            case 20:
                return "MQCMD_INQUIRE_CHANNEL_NAMES";
            case 21:
                return "MQCMD_CHANGE_CHANNEL";
            case 22:
                return "MQCMD_COPY_CHANNEL";
            case 23:
                return "MQCMD_CREATE_CHANNEL";
            case 24:
                return "MQCMD_DELETE_CHANNEL";
            case 25:
                return "MQCMD_INQUIRE_CHANNEL";
            case 26:
                return "MQCMD_PING_CHANNEL";
            case 27:
                return "MQCMD_RESET_CHANNEL";
            case 28:
                return "MQCMD_START_CHANNEL";
            case 29:
                return "MQCMD_STOP_CHANNEL";
            case 30:
                return "MQCMD_START_CHANNEL_INIT";
            case 31:
                return "MQCMD_START_CHANNEL_LISTENER";
            case 32:
                return "MQCMD_CHANGE_NAMELIST";
            case 33:
                return "MQCMD_COPY_NAMELIST";
            case 34:
                return "MQCMD_CREATE_NAMELIST";
            case 35:
                return "MQCMD_DELETE_NAMELIST";
            case 36:
                return "MQCMD_INQUIRE_NAMELIST";
            case 37:
                return "MQCMD_INQUIRE_NAMELIST_NAMES";
            case 38:
                return "MQCMD_ESCAPE";
            case 39:
                return "MQCMD_RESOLVE_CHANNEL";
            case 40:
                return "MQCMD_PING_Q_MGR";
            case 41:
                return "MQCMD_INQUIRE_Q_STATUS";
            case 42:
                return "MQCMD_INQUIRE_CHANNEL_STATUS";
            case 43:
                return "MQCMD_CONFIG_EVENT";
            case 44:
                return "MQCMD_Q_MGR_EVENT";
            case 45:
                return "MQCMD_PERFM_EVENT";
            case 46:
                return "MQCMD_CHANNEL_EVENT";
            case 60:
                return "MQCMD_DELETE_PUBLICATION";
            case 61:
                return "MQCMD_DEREGISTER_PUBLISHER";
            case 62:
                return "MQCMD_DEREGISTER_SUBSCRIBER";
            case 63:
                return "MQCMD_PUBLISH";
            case 64:
                return "MQCMD_REGISTER_PUBLISHER";
            case 65:
                return "MQCMD_REGISTER_SUBSCRIBER";
            case 66:
                return "MQCMD_REQUEST_UPDATE";
            case 67:
                return "MQCMD_BROKER_INTERNAL";
            case 69:
                return "MQCMD_ACTIVITY_MSG";
            case 70:
                return "MQCMD_INQUIRE_CLUSTER_Q_MGR";
            case 71:
                return "MQCMD_RESUME_Q_MGR_CLUSTER";
            case 72:
                return "MQCMD_SUSPEND_Q_MGR_CLUSTER";
            case 73:
                return "MQCMD_REFRESH_CLUSTER";
            case 74:
                return "MQCMD_RESET_CLUSTER";
            case 75:
                return "MQCMD_TRACE_ROUTE";
            case 78:
                return "MQCMD_REFRESH_SECURITY";
            case 79:
                return "MQCMD_CHANGE_AUTH_INFO";
            case 80:
                return "MQCMD_COPY_AUTH_INFO";
            case 81:
                return "MQCMD_CREATE_AUTH_INFO";
            case 82:
                return "MQCMD_DELETE_AUTH_INFO";
            case 83:
                return "MQCMD_INQUIRE_AUTH_INFO";
            case 84:
                return "MQCMD_INQUIRE_AUTH_INFO_NAMES";
            case 85:
                return "MQCMD_INQUIRE_CONNECTION";
            case 86:
                return "MQCMD_STOP_CONNECTION";
            case 87:
                return "MQCMD_INQUIRE_AUTH_RECS";
            case 88:
                return "MQCMD_INQUIRE_ENTITY_AUTH";
            case 89:
                return "MQCMD_DELETE_AUTH_REC";
            case 90:
                return "MQCMD_SET_AUTH_REC";
            case 91:
                return "MQCMD_LOGGER_EVENT";
            case 92:
                return "MQCMD_RESET_Q_MGR";
            case 93:
                return "MQCMD_CHANGE_LISTENER";
            case 94:
                return "MQCMD_COPY_LISTENER";
            case 95:
                return "MQCMD_CREATE_LISTENER";
            case 96:
                return "MQCMD_DELETE_LISTENER";
            case 97:
                return "MQCMD_INQUIRE_LISTENER";
            case 98:
                return "MQCMD_INQUIRE_LISTENER_STATUS";
            case 99:
                return "MQCMD_COMMAND_EVENT";
            case 100:
                return "MQCMD_CHANGE_SECURITY";
            case 101:
                return "MQCMD_CHANGE_CF_STRUC";
            case 102:
                return "MQCMD_CHANGE_STG_CLASS";
            case 103:
                return "MQCMD_CHANGE_TRACE";
            case 104:
                return "MQCMD_ARCHIVE_LOG";
            case 105:
                return "MQCMD_BACKUP_CF_STRUC";
            case 106:
                return "MQCMD_CREATE_BUFFER_POOL";
            case 107:
                return "MQCMD_CREATE_PAGE_SET";
            case 108:
                return "MQCMD_CREATE_CF_STRUC";
            case 109:
                return "MQCMD_CREATE_STG_CLASS";
            case 110:
                return "MQCMD_COPY_CF_STRUC";
            case 111:
                return "MQCMD_COPY_STG_CLASS";
            case 112:
                return "MQCMD_DELETE_CF_STRUC";
            case 113:
                return "MQCMD_DELETE_STG_CLASS";
            case 114:
                return "MQCMD_INQUIRE_ARCHIVE";
            case 115:
                return "MQCMD_INQUIRE_CF_STRUC";
            case 116:
                return "MQCMD_INQUIRE_CF_STRUC_STATUS";
            case 117:
                return "MQCMD_INQUIRE_CMD_SERVER";
            case 118:
                return "MQCMD_INQUIRE_CHANNEL_INIT";
            case 119:
                return "MQCMD_INQUIRE_QSG";
            case 120:
                return "MQCMD_INQUIRE_LOG";
            case 121:
                return "MQCMD_INQUIRE_SECURITY";
            case 122:
                return "MQCMD_INQUIRE_STG_CLASS";
            case 123:
                return "MQCMD_INQUIRE_SYSTEM";
            case 124:
                return "MQCMD_INQUIRE_THREAD";
            case 125:
                return "MQCMD_INQUIRE_TRACE";
            case 126:
                return "MQCMD_INQUIRE_USAGE";
            case 127:
                return "MQCMD_MOVE_Q";
            case 128:
                return "MQCMD_RECOVER_BSDS";
            case 129:
                return "MQCMD_RECOVER_CF_STRUC";
            case 130:
                return "MQCMD_RESET_TPIPE";
            case 131:
                return "MQCMD_RESOLVE_INDOUBT";
            case 132:
                return "MQCMD_RESUME_Q_MGR";
            case 133:
                return "MQCMD_REVERIFY_SECURITY";
            case 134:
                return "MQCMD_SET_ARCHIVE";
            case 136:
                return "MQCMD_SET_LOG";
            case 137:
                return "MQCMD_SET_SYSTEM";
            case 138:
                return "MQCMD_START_CMD_SERVER";
            case 139:
                return "MQCMD_START_Q_MGR";
            case 140:
                return "MQCMD_START_TRACE";
            case 141:
                return "MQCMD_STOP_CHANNEL_INIT";
            case 142:
                return "MQCMD_STOP_CHANNEL_LISTENER";
            case 143:
                return "MQCMD_STOP_CMD_SERVER";
            case 144:
                return "MQCMD_STOP_Q_MGR";
            case 145:
                return "MQCMD_STOP_TRACE";
            case 146:
                return "MQCMD_SUSPEND_Q_MGR";
            case 147:
                return "MQCMD_INQUIRE_CF_STRUC_NAMES";
            case 148:
                return "MQCMD_INQUIRE_STG_CLASS_NAMES";
            case 149:
                return "MQCMD_CHANGE_SERVICE";
            case 150:
                return "MQCMD_COPY_SERVICE";
            case 151:
                return "MQCMD_CREATE_SERVICE";
            case 152:
                return "MQCMD_DELETE_SERVICE";
            case 153:
                return "MQCMD_INQUIRE_SERVICE";
            case 154:
                return "MQCMD_INQUIRE_SERVICE_STATUS";
            case 155:
                return "MQCMD_START_SERVICE";
            case 156:
                return "MQCMD_STOP_SERVICE";
            case 157:
                return "MQCMD_DELETE_BUFFER_POOL";
            case 158:
                return "MQCMD_DELETE_PAGE_SET";
            case 159:
                return "MQCMD_CHANGE_BUFFER_POOL";
            case 160:
                return "MQCMD_CHANGE_PAGE_SET";
            case 161:
                return "MQCMD_INQUIRE_Q_MGR_STATUS";
            case 162:
                return "MQCMD_CREATE_LOG";
            case 164:
                return "MQCMD_STATISTICS_MQI";
            case 165:
                return "MQCMD_STATISTICS_Q";
            case 166:
                return "MQCMD_STATISTICS_CHANNEL";
            case 167:
                return "MQCMD_ACCOUNTING_MQI";
            case 168:
                return "MQCMD_ACCOUNTING_Q";
            case 169:
                return "MQCMD_INQUIRE_AUTH_SERVICE";
            case 170:
                return "MQCMD_CHANGE_TOPIC";
            case 171:
                return "MQCMD_COPY_TOPIC";
            case 172:
                return "MQCMD_CREATE_TOPIC";
            case 173:
                return "MQCMD_DELETE_TOPIC";
            case 174:
                return "MQCMD_INQUIRE_TOPIC";
            case 175:
                return "MQCMD_INQUIRE_TOPIC_NAMES";
            case 176:
                return "MQCMD_INQUIRE_SUBSCRIPTION";
            case 177:
                return "MQCMD_CREATE_SUBSCRIPTION";
            case 178:
                return "MQCMD_CHANGE_SUBSCRIPTION";
            case 179:
                return "MQCMD_DELETE_SUBSCRIPTION";
            case 181:
                return "MQCMD_COPY_SUBSCRIPTION";
            case 182:
                return "MQCMD_INQUIRE_SUB_STATUS";
            case 183:
                return "MQCMD_INQUIRE_TOPIC_STATUS";
            case 184:
                return "MQCMD_CLEAR_TOPIC_STRING";
            case 185:
                return "MQCMD_INQUIRE_PUBSUB_STATUS";
            case 186:
                return "MQCMD_INQUIRE_SMDS";
            case 187:
                return "MQCMD_CHANGE_SMDS";
            case 188:
                return "MQCMD_RESET_SMDS";
            case 190:
                return "MQCMD_CREATE_COMM_INFO";
            case 191:
                return "MQCMD_INQUIRE_COMM_INFO";
            case 192:
                return "MQCMD_CHANGE_COMM_INFO";
            case 193:
                return "MQCMD_COPY_COMM_INFO";
            case 194:
                return "MQCMD_DELETE_COMM_INFO";
            case 195:
                return "MQCMD_PURGE_CHANNEL";
            case 196:
                return "MQCMD_MQXR_DIAGNOSTICS";
            case 197:
                return "MQCMD_START_SMDSCONN";
            case 198:
                return "MQCMD_STOP_SMDSCONN";
            case 199:
                return "MQCMD_INQUIRE_SMDSCONN";
            case 200:
                return "MQCMD_INQUIRE_MQXR_STATUS";
            case 201:
                return "MQCMD_START_CLIENT_TRACE";
            case 202:
                return "MQCMD_STOP_CLIENT_TRACE";
            case 203:
                return "MQCMD_SET_CHLAUTH_REC";
            case 204:
                return "MQCMD_INQUIRE_CHLAUTH_RECS";
            case 205:
                return "MQCMD_INQUIRE_PROT_POLICY";
            case 206:
                return "MQCMD_CREATE_PROT_POLICY";
            case 207:
                return "MQCMD_DELETE_PROT_POLICY";
            case 208:
                return "MQCMD_CHANGE_PROT_POLICY";
            case 209:
                return "MQCMD_ACTIVITY_TRACE";
            case 213:
                return "MQCMD_RESET_CF_STRUC";
            case 214:
                return "MQCMD_INQUIRE_XR_CAPABILITY";
            case 216:
                return "MQCMD_INQUIRE_AMQP_CAPABILITY";
            case 217:
                return "MQCMD_AMQP_DIAGNOSTICS";
            case 218:
                return "MQCMD_INTER_Q_MGR_STATUS";
            case 219:
                return "MQCMD_INTER_Q_MGR_BALANCE";
            case 220:
                return "MQCMD_INQUIRE_APPL_STATUS";
            default:
                return "";
        }
    }

    public static String MQCMHO_STR(int value) {
        switch (value) {
            case 0:
                return "MQCMHO_NONE";
            case 1:
                return "MQCMHO_NO_VALIDATION";
            case 2:
                return "MQCMHO_VALIDATE";
            default:
                return "";
        }
    }

    public static String MQCNO_STR(int value) {
        switch (value) {
            case 0:
                return "MQCNO_NONE";
            case 1:
                return "MQCNO_FASTPATH_BINDING";
            case 2:
                return "MQCNO_SERIALIZE_CONN_TAG_Q_MGR";
            case 4:
                return "MQCNO_SERIALIZE_CONN_TAG_QSG";
            case 8:
                return "MQCNO_RESTRICT_CONN_TAG_Q_MGR";
            case 16:
                return "MQCNO_RESTRICT_CONN_TAG_QSG";
            case 32:
                return "MQCNO_HANDLE_SHARE_NONE";
            case 64:
                return "MQCNO_HANDLE_SHARE_BLOCK";
            case 128:
                return "MQCNO_HANDLE_SHARE_NO_BLOCK";
            case 256:
                return "MQCNO_SHARED_BINDING";
            case 512:
                return "MQCNO_ISOLATED_BINDING";
            case 1024:
                return "MQCNO_LOCAL_BINDING";
            case 2048:
                return "MQCNO_CLIENT_BINDING";
            case 4096:
                return "MQCNO_ACCOUNTING_MQI_ENABLED";
            case 8192:
                return "MQCNO_ACCOUNTING_MQI_DISABLED";
            case 16384:
                return "MQCNO_ACCOUNTING_Q_ENABLED";
            case 32768:
                return "MQCNO_ACCOUNTING_Q_DISABLED";
            case 65536:
                return "MQCNO_NO_CONV_SHARING";
            case 262144:
                return "MQCNO_ALL_CONVS_SHARE";
            case 524288:
                return "MQCNO_CD_FOR_OUTPUT_ONLY";
            case 1048576:
                return "MQCNO_USE_CD_SELECTION";
            case 2097152:
                return "MQCNO_GENERATE_CONN_TAG";
            case 16777216:
                return "MQCNO_RECONNECT";
            case 33554432:
                return "MQCNO_RECONNECT_DISABLED";
            case 67108864:
                return "MQCNO_RECONNECT_Q_MGR";
            case 134217728:
                return "MQCNO_ACTIVITY_TRACE_ENABLED";
            case 268435456:
                return "MQCNO_ACTIVITY_TRACE_DISABLED";
            default:
                return "";
        }
    }

    public static String MQCODL_STR(int value) {
        switch (value) {
            case -1:
                return "MQCODL_AS_INPUT";
            default:
                return "";
        }
    }

    public static String MQCOMPRESS_STR(int value) {
        switch (value) {
            case -1:
                return "MQCOMPRESS_NOT_AVAILABLE";
            case 0:
                return "MQCOMPRESS_NONE";
            case 1:
                return "MQCOMPRESS_RLE";
            case 2:
                return "MQCOMPRESS_ZLIBFAST";
            case 4:
                return "MQCOMPRESS_ZLIBHIGH";
            case 8:
                return "MQCOMPRESS_SYSTEM";
            case 268435455:
                return "MQCOMPRESS_ANY";
            default:
                return "";
        }
    }

    public static String MQCOPY_STR(int value) {
        switch (value) {
            case 0:
                return "MQCOPY_NONE";
            case 1:
                return "MQCOPY_ALL";
            case 2:
                return "MQCOPY_FORWARD";
            case 4:
                return "MQCOPY_PUBLISH";
            case 8:
                return "MQCOPY_REPLY";
            case 16:
                return "MQCOPY_REPORT";
            case 22:
                return "MQCOPY_DEFAULT";
            default:
                return "";
        }
    }

    public static String MQCO_STR(int value) {
        switch (value) {
            case 0:
                return "MQCO_NONE";
            case 1:
                return "MQCO_DELETE";
            case 2:
                return "MQCO_DELETE_PURGE";
            case 4:
                return "MQCO_KEEP_SUB";
            case 8:
                return "MQCO_REMOVE_SUB";
            case 32:
                return "MQCO_QUIESCE";
            default:
                return "";
        }
    }

    public static String MQCQT_STR(int value) {
        switch (value) {
            case 1:
                return "MQCQT_LOCAL_Q";
            case 2:
                return "MQCQT_ALIAS_Q";
            case 3:
                return "MQCQT_REMOTE_Q";
            case 4:
                return "MQCQT_Q_MGR_ALIAS";
            default:
                return "";
        }
    }

    public static String MQCRC_STR(int value) {
        switch (value) {
            case 0:
                return "MQCRC_OK";
            case 1:
                return "MQCRC_CICS_EXEC_ERROR";
            case 2:
                return "MQCRC_MQ_API_ERROR";
            case 3:
                return "MQCRC_BRIDGE_ERROR";
            case 4:
                return "MQCRC_BRIDGE_ABEND";
            case 5:
                return "MQCRC_APPLICATION_ABEND";
            case 6:
                return "MQCRC_SECURITY_ERROR";
            case 7:
                return "MQCRC_PROGRAM_NOT_AVAILABLE";
            case 8:
                return "MQCRC_BRIDGE_TIMEOUT";
            case 9:
                return "MQCRC_TRANSID_NOT_AVAILABLE";
            default:
                return "";
        }
    }

    public static String MQCSP_STR(int value) {
        switch (value) {
            case 0:
                return "MQCSP_AUTH_NONE";
            case 1:
                return "MQCSP_AUTH_USER_ID_AND_PWD";
            default:
                return "";
        }
    }

    public static String MQCSRV_CONVERT_STR(int value) {
        switch (value) {
            case 0:
                return "MQCSRV_CONVERT_NO";
            case 1:
                return "MQCSRV_CONVERT_YES";
            default:
                return "";
        }
    }

    public static String MQCSRV_DLQ_STR(int value) {
        switch (value) {
            case 0:
                return "MQCSRV_DLQ_NO";
            case 1:
                return "MQCSRV_DLQ_YES";
            default:
                return "";
        }
    }

    public static String MQCS_STR(int value) {
        switch (value) {
            case 0:
                return "MQCS_NONE";
            case 1:
                return "MQCS_SUSPENDED_TEMPORARY";
            case 2:
                return "MQCS_SUSPENDED_USER_ACTION";
            case 3:
                return "MQCS_SUSPENDED";
            case 4:
                return "MQCS_STOPPED";
            default:
                return "";
        }
    }

    public static String MQCTES_STR(int value) {
        switch (value) {
            case 0:
                return "MQCTES_NOSYNC";
            case 256:
                return "MQCTES_COMMIT";
            case 4352:
                return "MQCTES_BACKOUT";
            case 65536:
                return "MQCTES_ENDTASK";
            default:
                return "";
        }
    }

    public static String MQCTLO_STR(int value) {
        switch (value) {
            case 0:
                return "MQCTLO_NONE";
            case 1:
                return "MQCTLO_THREAD_AFFINITY";
            case 8192:
                return "MQCTLO_FAIL_IF_QUIESCING";
            default:
                return "";
        }
    }

    public static String MQCUOWC_STR(int value) {
        switch (value) {
            case 16:
                return "MQCUOWC_MIDDLE";
            case 256:
                return "MQCUOWC_COMMIT";
            case 273:
                return "MQCUOWC_ONLY";
            case 4352:
                return "MQCUOWC_BACKOUT";
            case 65536:
                return "MQCUOWC_CONTINUE";
            default:
                return "";
        }
    }

    public static String MQDCC_STR(int value) {
        switch (value) {
            case 0:
                return "MQDCC_NONE";
            case 1:
                return "MQDCC_DEFAULT_CONVERSION";
            case 2:
                return "MQDCC_FILL_TARGET_BUFFER";
            case 4:
                return "MQDCC_INT_DEFAULT_CONVERSION";
            case 16:
                return "MQDCC_SOURCE_ENC_NORMAL";
            case 32:
                return "MQDCC_SOURCE_ENC_REVERSED";
            case 240:
                return "MQDCC_SOURCE_ENC_MASK";
            case 256:
                return "MQDCC_TARGET_ENC_NORMAL";
            case 512:
                return "MQDCC_TARGET_ENC_REVERSED";
            case 3840:
                return "MQDCC_TARGET_ENC_MASK";
            default:
                return "";
        }
    }

    public static String MQDC_STR(int value) {
        switch (value) {
            case 1:
                return "MQDC_MANAGED";
            case 2:
                return "MQDC_PROVIDED";
            default:
                return "";
        }
    }

    public static String MQDELO_STR(int value) {
        switch (value) {
            case 0:
                return "MQDELO_NONE";
            case 4:
                return "MQDELO_LOCAL";
            default:
                return "";
        }
    }

    public static String MQDHF_STR(int value) {
        switch (value) {
            case 0:
                return "MQDHF_NONE";
            case 1:
                return "MQDHF_NEW_MSG_IDS";
            default:
                return "";
        }
    }

    public static String MQDISCONNECT_STR(int value) {
        switch (value) {
            case 0:
                return "MQDISCONNECT_NORMAL";
            case 1:
                return "MQDISCONNECT_IMPLICIT";
            case 2:
                return "MQDISCONNECT_Q_MGR";
            default:
                return "";
        }
    }

    public static String MQDLV_STR(int value) {
        switch (value) {
            case 0:
                return "MQDLV_AS_PARENT";
            case 1:
                return "MQDLV_ALL";
            case 2:
                return "MQDLV_ALL_DUR";
            case 3:
                return "MQDLV_ALL_AVAIL";
            default:
                return "";
        }
    }

    public static String MQDL_STR(int value) {
        switch (value) {
            case 0:
                return "MQDL_NOT_SUPPORTED";
            case 1:
                return "MQDL_SUPPORTED";
            default:
                return "";
        }
    }

    public static String MQDMHO_STR(int value) {
        switch (value) {
            case 0:
                return "MQDMHO_NONE";
            default:
                return "";
        }
    }

    public static String MQDMPO_STR(int value) {
        switch (value) {
            case 0:
                return "MQDMPO_NONE";
            case 1:
                return "MQDMPO_DEL_PROP_UNDER_CURSOR";
            default:
                return "";
        }
    }

    public static String MQDNSWLM_STR(int value) {
        switch (value) {
            case 0:
                return "MQDNSWLM_NO";
            case 1:
                return "MQDNSWLM_YES";
            default:
                return "";
        }
    }

    public static String MQDOPT_STR(int value) {
        switch (value) {
            case 0:
                return "MQDOPT_RESOLVED";
            case 1:
                return "MQDOPT_DEFINED";
            default:
                return "";
        }
    }

    public static String MQDSB_STR(int value) {
        switch (value) {
            case 0:
                return "MQDSB_DEFAULT";
            case 1:
                return "MQDSB_8K";
            case 2:
                return "MQDSB_16K";
            case 3:
                return "MQDSB_32K";
            case 4:
                return "MQDSB_64K";
            case 5:
                return "MQDSB_128K";
            case 6:
                return "MQDSB_256K";
            case 7:
                return "MQDSB_512K";
            case 8:
                return "MQDSB_1M";
            default:
                return "";
        }
    }

    public static String MQDSE_STR(int value) {
        switch (value) {
            case 0:
                return "MQDSE_DEFAULT";
            case 1:
                return "MQDSE_YES";
            case 2:
                return "MQDSE_NO";
            default:
                return "";
        }
    }

    public static String MQEC_STR(int value) {
        switch (value) {
            case 2:
                return "MQEC_MSG_ARRIVED";
            case 3:
                return "MQEC_WAIT_INTERVAL_EXPIRED";
            case 4:
                return "MQEC_WAIT_CANCELED";
            case 5:
                return "MQEC_Q_MGR_QUIESCING";
            case 6:
                return "MQEC_CONNECTION_QUIESCING";
            default:
                return "";
        }
    }

    public static String MQEI_STR(int value) {
        switch (value) {
            case -1:
                return "MQEI_UNLIMITED";
            default:
                return "";
        }
    }

    public static String MQENC_STR(int value) {
        switch (value) {
            case -4096:
                return "MQENC_RESERVED_MASK";
            case -1:
                return "MQENC_AS_PUBLISHED";
            case 1:
                return "MQENC_INTEGER_NORMAL";
            case 2:
                return "MQENC_INTEGER_REVERSED";
            case 15:
                return "MQENC_INTEGER_MASK";
            case 16:
                return "MQENC_DECIMAL_NORMAL";
            case 32:
                return "MQENC_DECIMAL_REVERSED";
            case 240:
                return "MQENC_DECIMAL_MASK";
            case 256:
                return "MQENC_FLOAT_IEEE_NORMAL";
            case 273:
                return "MQENC_NORMAL";
            case 512:
                return "MQENC_FLOAT_IEEE_REVERSED";
            case 546:
                return "MQENC_REVERSED";
            case 768:
                return "MQENC_FLOAT_S390";
            case 785:
                return "MQENC_S390";
            case 1024:
                return "MQENC_FLOAT_TNS";
            case 1041:
                return "MQENC_TNS";
            case 3840:
                return "MQENC_FLOAT_MASK";
            default:
                return "";
        }
    }

    public static String MQEPH_STR(int value) {
        switch (value) {
            case 0:
                return "MQEPH_NONE";
            case 1:
                return "MQEPH_CCSID_EMBEDDED";
            default:
                return "";
        }
    }

    public static String MQET_STR(int value) {
        switch (value) {
            case 1:
                return "MQET_MQSC";
            default:
                return "";
        }
    }

    public static String MQEVO_STR(int value) {
        switch (value) {
            case 0:
                return "MQEVO_OTHER";
            case 1:
                return "MQEVO_CONSOLE";
            case 2:
                return "MQEVO_INIT";
            case 3:
                return "MQEVO_MSG";
            case 4:
                return "MQEVO_MQSET";
            case 5:
                return "MQEVO_INTERNAL";
            case 6:
                return "MQEVO_MQSUB";
            case 7:
                return "MQEVO_CTLMSG";
            case 8:
                return "MQEVO_REST";
            default:
                return "";
        }
    }

    public static String MQEVR_STR(int value) {
        switch (value) {
            case 0:
                return "MQEVR_DISABLED";
            case 1:
                return "MQEVR_ENABLED";
            case 2:
                return "MQEVR_EXCEPTION";
            case 3:
                return "MQEVR_NO_DISPLAY";
            case 4:
                return "MQEVR_API_ONLY";
            case 5:
                return "MQEVR_ADMIN_ONLY";
            case 6:
                return "MQEVR_USER_ONLY";
            default:
                return "";
        }
    }

    public static String MQEXPI_STR(int value) {
        switch (value) {
            case 0:
                return "MQEXPI_OFF";
            default:
                return "";
        }
    }

    public static String MQEXTATTRS_STR(int value) {
        switch (value) {
            case 0:
                return "MQEXTATTRS_ALL";
            case 1:
                return "MQEXTATTRS_NONDEF";
            default:
                return "";
        }
    }

    public static String MQEXT_STR(int value) {
        switch (value) {
            case 0:
                return "MQEXT_ALL";
            case 1:
                return "MQEXT_OBJECT";
            case 2:
                return "MQEXT_AUTHORITY";
            default:
                return "";
        }
    }

    public static String MQFB_STR(int value) {
        switch (value) {
            case 0:
                return "MQFB_NONE";
            case 256:
                return "MQFB_QUIT";
            case 258:
                return "MQFB_EXPIRATION";
            case 259:
                return "MQFB_COA";
            case 260:
                return "MQFB_COD";
            case 262:
                return "MQFB_CHANNEL_COMPLETED";
            case 263:
                return "MQFB_CHANNEL_FAIL_RETRY";
            case 264:
                return "MQFB_CHANNEL_FAIL";
            case 265:
                return "MQFB_APPL_CANNOT_BE_STARTED";
            case 266:
                return "MQFB_TM_ERROR";
            case 267:
                return "MQFB_APPL_TYPE_ERROR";
            case 268:
                return "MQFB_STOPPED_BY_MSG_EXIT";
            case 269:
                return "MQFB_ACTIVITY";
            case 271:
                return "MQFB_XMIT_Q_MSG_ERROR";
            case 275:
                return "MQFB_PAN";
            case 276:
                return "MQFB_NAN";
            case 277:
                return "MQFB_STOPPED_BY_CHAD_EXIT";
            case 279:
                return "MQFB_STOPPED_BY_PUBSUB_EXIT";
            case 280:
                return "MQFB_NOT_A_REPOSITORY_MSG";
            case 281:
                return "MQFB_BIND_OPEN_CLUSRCVR_DEL";
            case 282:
                return "MQFB_MAX_ACTIVITIES";
            case 283:
                return "MQFB_NOT_FORWARDED";
            case 284:
                return "MQFB_NOT_DELIVERED";
            case 285:
                return "MQFB_UNSUPPORTED_FORWARDING";
            case 286:
                return "MQFB_UNSUPPORTED_DELIVERY";
            case 291:
                return "MQFB_DATA_LENGTH_ZERO";
            case 292:
                return "MQFB_DATA_LENGTH_NEGATIVE";
            case 293:
                return "MQFB_DATA_LENGTH_TOO_BIG";
            case 294:
                return "MQFB_BUFFER_OVERFLOW";
            case 295:
                return "MQFB_LENGTH_OFF_BY_ONE";
            case 296:
                return "MQFB_IIH_ERROR";
            case 298:
                return "MQFB_NOT_AUTHORIZED_FOR_IMS";
            case 300:
                return "MQFB_IMS_ERROR";
            case 401:
                return "MQFB_CICS_INTERNAL_ERROR";
            case 402:
                return "MQFB_CICS_NOT_AUTHORIZED";
            case 403:
                return "MQFB_CICS_BRIDGE_FAILURE";
            case 404:
                return "MQFB_CICS_CORREL_ID_ERROR";
            case 405:
                return "MQFB_CICS_CCSID_ERROR";
            case 406:
                return "MQFB_CICS_ENCODING_ERROR";
            case 407:
                return "MQFB_CICS_CIH_ERROR";
            case 408:
                return "MQFB_CICS_UOW_ERROR";
            case 409:
                return "MQFB_CICS_COMMAREA_ERROR";
            case 410:
                return "MQFB_CICS_APPL_NOT_STARTED";
            case 411:
                return "MQFB_CICS_APPL_ABENDED";
            case 412:
                return "MQFB_CICS_DLQ_ERROR";
            case 413:
                return "MQFB_CICS_UOW_BACKED_OUT";
            case 501:
                return "MQFB_PUBLICATIONS_ON_REQUEST";
            case 502:
                return "MQFB_SUBSCRIBER_IS_PUBLISHER";
            case 503:
                return "MQFB_MSG_SCOPE_MISMATCH";
            case 504:
                return "MQFB_SELECTOR_MISMATCH";
            case 505:
                return "MQFB_NOT_A_GROUPUR_MSG";
            default:
                return "";
        }
    }

    public static String MQFC_STR(int value) {
        switch (value) {
            case 0:
                return "MQFC_NO";
            case 1:
                return "MQFC_YES";
            default:
                return "";
        }
    }

    public static String MQFIELD_STR(int value) {
        switch (value) {
            case 8000:
                return "MQFIELD_WQR_StrucId";
            case 8001:
                return "MQFIELD_WQR_Version";
            case 8002:
                return "MQFIELD_WQR_StrucLength";
            case 8003:
                return "MQFIELD_WQR_QFlags";
            case 8004:
                return "MQFIELD_WQR_QName";
            case 8005:
                return "MQFIELD_WQR_QMgrIdentifier";
            case 8006:
                return "MQFIELD_WQR_ClusterRecOffset";
            case 8007:
                return "MQFIELD_WQR_QType";
            case 8008:
                return "MQFIELD_WQR_QDesc";
            case 8009:
                return "MQFIELD_WQR_DefBind";
            case 8010:
                return "MQFIELD_WQR_DefPersistence";
            case 8011:
                return "MQFIELD_WQR_DefPriority";
            case 8012:
                return "MQFIELD_WQR_InhibitPut";
            case 8013:
                return "MQFIELD_WQR_CLWLQueuePriority";
            case 8014:
                return "MQFIELD_WQR_CLWLQueueRank";
            case 8015:
                return "MQFIELD_WQR_DefPutResponse";
            default:
                return "";
        }
    }

    public static String MQFUN_STR(int value) {
        switch (value) {
            case 0:
                return "MQFUN_TYPE_UNKNOWN";
            case 1:
                return "MQFUN_TYPE_JVM";
            case 2:
                return "MQFUN_TYPE_PROGRAM";
            case 3:
                return "MQFUN_TYPE_PROCEDURE";
            case 4:
                return "MQFUN_TYPE_USERDEF";
            case 5:
                return "MQFUN_TYPE_COMMAND";
            default:
                return "";
        }
    }

    public static String MQGACF_STR(int value) {
        switch (value) {
            case 8001:
                return "MQGACF_COMMAND_CONTEXT";
            case 8002:
                return "MQGACF_COMMAND_DATA";
            case 8003:
                return "MQGACF_TRACE_ROUTE";
            case 8004:
                return "MQGACF_OPERATION";
            case 8005:
                return "MQGACF_ACTIVITY";
            case 8006:
                return "MQGACF_EMBEDDED_MQMD";
            case 8007:
                return "MQGACF_MESSAGE";
            case 8008:
                return "MQGACF_MQMD";
            case 8009:
                return "MQGACF_VALUE_NAMING";
            case 8010:
                return "MQGACF_Q_ACCOUNTING_DATA";
            case 8011:
                return "MQGACF_Q_STATISTICS_DATA";
            case 8012:
                return "MQGACF_CHL_STATISTICS_DATA";
            case 8013:
                return "MQGACF_ACTIVITY_TRACE";
            case 8014:
                return "MQGACF_APP_DIST_LIST";
            case 8015:
                return "MQGACF_MONITOR_CLASS";
            case 8016:
                return "MQGACF_MONITOR_TYPE";
            case 8017:
                return "MQGACF_MONITOR_ELEMENT";
            case 8018:
                return "MQGACF_APPL_STATUS";
            case 8019:
                return "MQGACF_CHANGED_APPLS";
            case 8020:
                return "MQGACF_ALL_APPLS";
            case 8021:
                return "MQGACF_APPL_BALANCE";
            default:
                return "";
        }
    }

    public static String MQGMO_STR(int value) {
        switch (value) {
            case 0:
                return "MQGMO_NONE";
            case 1:
                return "MQGMO_WAIT";
            case 2:
                return "MQGMO_SYNCPOINT";
            case 4:
                return "MQGMO_NO_SYNCPOINT";
            case 8:
                return "MQGMO_SET_SIGNAL";
            case 32:
                return "MQGMO_BROWSE_NEXT";
            case 64:
                return "MQGMO_ACCEPT_TRUNCATED_MSG";
            case 128:
                return "MQGMO_MARK_SKIP_BACKOUT";
            case 256:
                return "MQGMO_MSG_UNDER_CURSOR";
            case 512:
                return "MQGMO_LOCK";
            case 1024:
                return "MQGMO_UNLOCK";
            case 2048:
                return "MQGMO_BROWSE_MSG_UNDER_CURSOR";
            case 4096:
                return "MQGMO_SYNCPOINT_IF_PERSISTENT";
            case 8192:
                return "MQGMO_FAIL_IF_QUIESCING";
            case 16384:
                return "MQGMO_CONVERT";
            case 32768:
                return "MQGMO_LOGICAL_ORDER";
            case 65536:
                return "MQGMO_COMPLETE_MSG";
            case 131072:
                return "MQGMO_ALL_MSGS_AVAILABLE";
            case 262144:
                return "MQGMO_ALL_SEGMENTS_AVAILABLE";
            case 1048576:
                return "MQGMO_MARK_BROWSE_HANDLE";
            case 2097152:
                return "MQGMO_MARK_BROWSE_CO_OP";
            case 4194304:
                return "MQGMO_UNMARK_BROWSE_CO_OP";
            case 8388608:
                return "MQGMO_UNMARK_BROWSE_HANDLE";
            case 16777216:
                return "MQGMO_UNMARKED_BROWSE_MSG";
            case 17825808:
                return "MQGMO_BROWSE_HANDLE";
            case 18874384:
                return "MQGMO_BROWSE_CO_OP";
            case 33554432:
                return "MQGMO_PROPERTIES_FORCE_MQRFH2";
            case 67108864:
                return "MQGMO_NO_PROPERTIES";
            case 134217728:
                return "MQGMO_PROPERTIES_IN_HANDLE";
            case 268435456:
                return "MQGMO_PROPERTIES_COMPATIBILITY";
            default:
                return "";
        }
    }

    public static String MQGUR_STR(int value) {
        switch (value) {
            case 0:
                return "MQGUR_DISABLED";
            case 1:
                return "MQGUR_ENABLED";
            default:
                return "";
        }
    }

    public static String MQHA_STR(int value) {
        switch (value) {
            case 4001:
                return "MQHA_BAG_HANDLE";
            default:
                return "";
        }
    }

    public static String MQHB_STR(int value) {
        switch (value) {
            case -2:
                return "MQHB_NONE";
            case -1:
                return "MQHB_UNUSABLE_HBAG";
            default:
                return "";
        }
    }

    public static String MQHC_STR(int value) {
        switch (value) {
            case -3:
                return "MQHC_UNASSOCIATED_HCONN";
            case -1:
                return "MQHC_UNUSABLE_HCONN";
            case 0:
                return "MQHC_DEF_HCONN";
            default:
                return "";
        }
    }

    public static String MQHM_STR(int value) {
        switch (value) {
            case -1:
                return "MQHM_UNUSABLE_HMSG";
            case 0:
                return "MQHM_NONE";
            default:
                return "";
        }
    }

    public static String MQHO_STR(int value) {
        switch (value) {
            case -1:
                return "MQHO_UNUSABLE_HOBJ";
            case 0:
                return "MQHO_NONE";
            default:
                return "";
        }
    }

    public static String MQHSTATE_STR(int value) {
        switch (value) {
            case 0:
                return "MQHSTATE_INACTIVE";
            case 1:
                return "MQHSTATE_ACTIVE";
            default:
                return "";
        }
    }

    public static String MQIACF_STR(int value) {
        switch (value) {
            case 1001:
                return "MQIACF_Q_MGR_ATTRS";
            case 1002:
                return "MQIACF_Q_ATTRS";
            case 1003:
                return "MQIACF_PROCESS_ATTRS";
            case 1004:
                return "MQIACF_NAMELIST_ATTRS";
            case 1005:
                return "MQIACF_FORCE";
            case 1006:
                return "MQIACF_REPLACE";
            case 1007:
                return "MQIACF_PURGE";
            case 1008:
                return "MQIACF_QUIESCE";
            case 1009:
                return "MQIACF_ALL";
            case 1010:
                return "MQIACF_EVENT_APPL_TYPE";
            case 1011:
                return "MQIACF_EVENT_ORIGIN";
            case 1012:
                return "MQIACF_PARAMETER_ID";
            case 1013:
                return "MQIACF_ERROR_ID";
            case 1014:
                return "MQIACF_SELECTOR";
            case 1015:
                return "MQIACF_CHANNEL_ATTRS";
            case 1016:
                return "MQIACF_OBJECT_TYPE";
            case 1017:
                return "MQIACF_ESCAPE_TYPE";
            case 1018:
                return "MQIACF_ERROR_OFFSET";
            case 1019:
                return "MQIACF_AUTH_INFO_ATTRS";
            case 1020:
                return "MQIACF_REASON_QUALIFIER";
            case 1021:
                return "MQIACF_COMMAND";
            case 1022:
                return "MQIACF_OPEN_OPTIONS";
            case 1023:
                return "MQIACF_OPEN_TYPE";
            case 1024:
                return "MQIACF_PROCESS_ID";
            case 1025:
                return "MQIACF_THREAD_ID";
            case 1026:
                return "MQIACF_Q_STATUS_ATTRS";
            case 1027:
                return "MQIACF_UNCOMMITTED_MSGS";
            case 1028:
                return "MQIACF_HANDLE_STATE";
            case 1070:
                return "MQIACF_AUX_ERROR_DATA_INT_1";
            case 1071:
                return "MQIACF_AUX_ERROR_DATA_INT_2";
            case 1072:
                return "MQIACF_CONV_REASON_CODE";
            case 1073:
                return "MQIACF_BRIDGE_TYPE";
            case 1074:
                return "MQIACF_INQUIRY";
            case 1075:
                return "MQIACF_WAIT_INTERVAL";
            case 1076:
                return "MQIACF_OPTIONS";
            case 1077:
                return "MQIACF_BROKER_OPTIONS";
            case 1078:
                return "MQIACF_REFRESH_TYPE";
            case 1079:
                return "MQIACF_SEQUENCE_NUMBER";
            case 1080:
                return "MQIACF_INTEGER_DATA";
            case 1081:
                return "MQIACF_REGISTRATION_OPTIONS";
            case 1082:
                return "MQIACF_PUBLICATION_OPTIONS";
            case 1083:
                return "MQIACF_CLUSTER_INFO";
            case 1084:
                return "MQIACF_Q_MGR_DEFINITION_TYPE";
            case 1085:
                return "MQIACF_Q_MGR_TYPE";
            case 1086:
                return "MQIACF_ACTION";
            case 1087:
                return "MQIACF_SUSPEND";
            case 1088:
                return "MQIACF_BROKER_COUNT";
            case 1089:
                return "MQIACF_APPL_COUNT";
            case 1090:
                return "MQIACF_ANONYMOUS_COUNT";
            case 1091:
                return "MQIACF_REG_REG_OPTIONS";
            case 1092:
                return "MQIACF_DELETE_OPTIONS";
            case 1093:
                return "MQIACF_CLUSTER_Q_MGR_ATTRS";
            case 1094:
                return "MQIACF_REFRESH_INTERVAL";
            case 1095:
                return "MQIACF_REFRESH_REPOSITORY";
            case 1096:
                return "MQIACF_REMOVE_QUEUES";
            case 1098:
                return "MQIACF_OPEN_INPUT_TYPE";
            case 1099:
                return "MQIACF_OPEN_OUTPUT";
            case 1100:
                return "MQIACF_OPEN_SET";
            case 1101:
                return "MQIACF_OPEN_INQUIRE";
            case 1102:
                return "MQIACF_OPEN_BROWSE";
            case 1103:
                return "MQIACF_Q_STATUS_TYPE";
            case 1104:
                return "MQIACF_Q_HANDLE";
            case 1105:
                return "MQIACF_Q_STATUS";
            case 1106:
                return "MQIACF_SECURITY_TYPE";
            case 1107:
                return "MQIACF_CONNECTION_ATTRS";
            case 1108:
                return "MQIACF_CONNECT_OPTIONS";
            case 1110:
                return "MQIACF_CONN_INFO_TYPE";
            case 1111:
                return "MQIACF_CONN_INFO_CONN";
            case 1112:
                return "MQIACF_CONN_INFO_HANDLE";
            case 1113:
                return "MQIACF_CONN_INFO_ALL";
            case 1114:
                return "MQIACF_AUTH_PROFILE_ATTRS";
            case 1115:
                return "MQIACF_AUTHORIZATION_LIST";
            case 1116:
                return "MQIACF_AUTH_ADD_AUTHS";
            case 1117:
                return "MQIACF_AUTH_REMOVE_AUTHS";
            case 1118:
                return "MQIACF_ENTITY_TYPE";
            case 1120:
                return "MQIACF_COMMAND_INFO";
            case 1121:
                return "MQIACF_CMDSCOPE_Q_MGR_COUNT";
            case 1122:
                return "MQIACF_Q_MGR_SYSTEM";
            case 1123:
                return "MQIACF_Q_MGR_EVENT";
            case 1124:
                return "MQIACF_Q_MGR_DQM";
            case 1125:
                return "MQIACF_Q_MGR_CLUSTER";
            case 1126:
                return "MQIACF_QSG_DISPS";
            case 1128:
                return "MQIACF_UOW_STATE";
            case 1129:
                return "MQIACF_SECURITY_ITEM";
            case 1130:
                return "MQIACF_CF_STRUC_STATUS";
            case 1132:
                return "MQIACF_UOW_TYPE";
            case 1133:
                return "MQIACF_CF_STRUC_ATTRS";
            case 1134:
                return "MQIACF_EXCLUDE_INTERVAL";
            case 1135:
                return "MQIACF_CF_STATUS_TYPE";
            case 1136:
                return "MQIACF_CF_STATUS_SUMMARY";
            case 1137:
                return "MQIACF_CF_STATUS_CONNECT";
            case 1138:
                return "MQIACF_CF_STATUS_BACKUP";
            case 1139:
                return "MQIACF_CF_STRUC_TYPE";
            case 1140:
                return "MQIACF_CF_STRUC_SIZE_MAX";
            case 1141:
                return "MQIACF_CF_STRUC_SIZE_USED";
            case 1142:
                return "MQIACF_CF_STRUC_ENTRIES_MAX";
            case 1143:
                return "MQIACF_CF_STRUC_ENTRIES_USED";
            case 1144:
                return "MQIACF_CF_STRUC_BACKUP_SIZE";
            case 1145:
                return "MQIACF_MOVE_TYPE";
            case 1146:
                return "MQIACF_MOVE_TYPE_MOVE";
            case 1147:
                return "MQIACF_MOVE_TYPE_ADD";
            case 1148:
                return "MQIACF_Q_MGR_NUMBER";
            case 1149:
                return "MQIACF_Q_MGR_STATUS";
            case 1150:
                return "MQIACF_DB2_CONN_STATUS";
            case 1151:
                return "MQIACF_SECURITY_ATTRS";
            case 1152:
                return "MQIACF_SECURITY_TIMEOUT";
            case 1153:
                return "MQIACF_SECURITY_INTERVAL";
            case 1154:
                return "MQIACF_SECURITY_SWITCH";
            case 1155:
                return "MQIACF_SECURITY_SETTING";
            case 1156:
                return "MQIACF_STORAGE_CLASS_ATTRS";
            case 1157:
                return "MQIACF_USAGE_TYPE";
            case 1158:
                return "MQIACF_BUFFER_POOL_ID";
            case 1159:
                return "MQIACF_USAGE_TOTAL_PAGES";
            case 1160:
                return "MQIACF_USAGE_UNUSED_PAGES";
            case 1161:
                return "MQIACF_USAGE_PERSIST_PAGES";
            case 1162:
                return "MQIACF_USAGE_NONPERSIST_PAGES";
            case 1163:
                return "MQIACF_USAGE_RESTART_EXTENTS";
            case 1164:
                return "MQIACF_USAGE_EXPAND_COUNT";
            case 1165:
                return "MQIACF_PAGESET_STATUS";
            case 1166:
                return "MQIACF_USAGE_TOTAL_BUFFERS";
            case 1167:
                return "MQIACF_USAGE_DATA_SET_TYPE";
            case 1168:
                return "MQIACF_USAGE_PAGESET";
            case 1169:
                return "MQIACF_USAGE_DATA_SET";
            case 1170:
                return "MQIACF_USAGE_BUFFER_POOL";
            case 1171:
                return "MQIACF_MOVE_COUNT";
            case 1172:
                return "MQIACF_EXPIRY_Q_COUNT";
            case 1173:
                return "MQIACF_CONFIGURATION_OBJECTS";
            case 1174:
                return "MQIACF_CONFIGURATION_EVENTS";
            case 1175:
                return "MQIACF_SYSP_TYPE";
            case 1176:
                return "MQIACF_SYSP_DEALLOC_INTERVAL";
            case 1177:
                return "MQIACF_SYSP_MAX_ARCHIVE";
            case 1178:
                return "MQIACF_SYSP_MAX_READ_TAPES";
            case 1179:
                return "MQIACF_SYSP_IN_BUFFER_SIZE";
            case 1180:
                return "MQIACF_SYSP_OUT_BUFFER_SIZE";
            case 1181:
                return "MQIACF_SYSP_OUT_BUFFER_COUNT";
            case 1182:
                return "MQIACF_SYSP_ARCHIVE";
            case 1183:
                return "MQIACF_SYSP_DUAL_ACTIVE";
            case 1184:
                return "MQIACF_SYSP_DUAL_ARCHIVE";
            case 1185:
                return "MQIACF_SYSP_DUAL_BSDS";
            case 1186:
                return "MQIACF_SYSP_MAX_CONNS";
            case 1187:
                return "MQIACF_SYSP_MAX_CONNS_FORE";
            case 1188:
                return "MQIACF_SYSP_MAX_CONNS_BACK";
            case 1189:
                return "MQIACF_SYSP_EXIT_INTERVAL";
            case 1190:
                return "MQIACF_SYSP_EXIT_TASKS";
            case 1191:
                return "MQIACF_SYSP_CHKPOINT_COUNT";
            case 1192:
                return "MQIACF_SYSP_OTMA_INTERVAL";
            case 1193:
                return "MQIACF_SYSP_Q_INDEX_DEFER";
            case 1194:
                return "MQIACF_SYSP_DB2_TASKS";
            case 1195:
                return "MQIACF_SYSP_RESLEVEL_AUDIT";
            case 1196:
                return "MQIACF_SYSP_ROUTING_CODE";
            case 1197:
                return "MQIACF_SYSP_SMF_ACCOUNTING";
            case 1198:
                return "MQIACF_SYSP_SMF_STATS";
            case 1199:
                return "MQIACF_SYSP_SMF_INTERVAL";
            case 1200:
                return "MQIACF_SYSP_TRACE_CLASS";
            case 1201:
                return "MQIACF_SYSP_TRACE_SIZE";
            case 1202:
                return "MQIACF_SYSP_WLM_INTERVAL";
            case 1203:
                return "MQIACF_SYSP_ALLOC_UNIT";
            case 1204:
                return "MQIACF_SYSP_ARCHIVE_RETAIN";
            case 1205:
                return "MQIACF_SYSP_ARCHIVE_WTOR";
            case 1206:
                return "MQIACF_SYSP_BLOCK_SIZE";
            case 1207:
                return "MQIACF_SYSP_CATALOG";
            case 1208:
                return "MQIACF_SYSP_COMPACT";
            case 1209:
                return "MQIACF_SYSP_ALLOC_PRIMARY";
            case 1210:
                return "MQIACF_SYSP_ALLOC_SECONDARY";
            case 1211:
                return "MQIACF_SYSP_PROTECT";
            case 1212:
                return "MQIACF_SYSP_QUIESCE_INTERVAL";
            case 1213:
                return "MQIACF_SYSP_TIMESTAMP";
            case 1214:
                return "MQIACF_SYSP_UNIT_ADDRESS";
            case 1215:
                return "MQIACF_SYSP_UNIT_STATUS";
            case 1216:
                return "MQIACF_SYSP_LOG_COPY";
            case 1217:
                return "MQIACF_SYSP_LOG_USED";
            case 1218:
                return "MQIACF_SYSP_LOG_SUSPEND";
            case 1219:
                return "MQIACF_SYSP_OFFLOAD_STATUS";
            case 1220:
                return "MQIACF_SYSP_TOTAL_LOGS";
            case 1221:
                return "MQIACF_SYSP_FULL_LOGS";
            case 1222:
                return "MQIACF_LISTENER_ATTRS";
            case 1223:
                return "MQIACF_LISTENER_STATUS_ATTRS";
            case 1224:
                return "MQIACF_SERVICE_ATTRS";
            case 1225:
                return "MQIACF_SERVICE_STATUS_ATTRS";
            case 1226:
                return "MQIACF_Q_TIME_INDICATOR";
            case 1227:
                return "MQIACF_OLDEST_MSG_AGE";
            case 1228:
                return "MQIACF_AUTH_OPTIONS";
            case 1229:
                return "MQIACF_Q_MGR_STATUS_ATTRS";
            case 1230:
                return "MQIACF_CONNECTION_COUNT";
            case 1231:
                return "MQIACF_Q_MGR_FACILITY";
            case 1232:
                return "MQIACF_CHINIT_STATUS";
            case 1233:
                return "MQIACF_CMD_SERVER_STATUS";
            case 1234:
                return "MQIACF_ROUTE_DETAIL";
            case 1235:
                return "MQIACF_RECORDED_ACTIVITIES";
            case 1236:
                return "MQIACF_MAX_ACTIVITIES";
            case 1237:
                return "MQIACF_DISCONTINUITY_COUNT";
            case 1238:
                return "MQIACF_ROUTE_ACCUMULATION";
            case 1239:
                return "MQIACF_ROUTE_DELIVERY";
            case 1240:
                return "MQIACF_OPERATION_TYPE";
            case 1241:
                return "MQIACF_BACKOUT_COUNT";
            case 1242:
                return "MQIACF_COMP_CODE";
            case 1243:
                return "MQIACF_ENCODING";
            case 1244:
                return "MQIACF_EXPIRY";
            case 1245:
                return "MQIACF_FEEDBACK";
            case 1247:
                return "MQIACF_MSG_FLAGS";
            case 1248:
                return "MQIACF_MSG_LENGTH";
            case 1249:
                return "MQIACF_MSG_TYPE";
            case 1250:
                return "MQIACF_OFFSET";
            case 1251:
                return "MQIACF_ORIGINAL_LENGTH";
            case 1252:
                return "MQIACF_PERSISTENCE";
            case 1253:
                return "MQIACF_PRIORITY";
            case 1254:
                return "MQIACF_REASON_CODE";
            case 1255:
                return "MQIACF_REPORT";
            case 1256:
                return "MQIACF_VERSION";
            case 1257:
                return "MQIACF_UNRECORDED_ACTIVITIES";
            case 1258:
                return "MQIACF_MONITORING";
            case 1259:
                return "MQIACF_ROUTE_FORWARDING";
            case 1260:
                return "MQIACF_SERVICE_STATUS";
            case 1261:
                return "MQIACF_Q_TYPES";
            case 1262:
                return "MQIACF_USER_ID_SUPPORT";
            case 1263:
                return "MQIACF_INTERFACE_VERSION";
            case 1264:
                return "MQIACF_AUTH_SERVICE_ATTRS";
            case 1265:
                return "MQIACF_USAGE_EXPAND_TYPE";
            case 1266:
                return "MQIACF_SYSP_CLUSTER_CACHE";
            case 1267:
                return "MQIACF_SYSP_DB2_BLOB_TASKS";
            case 1268:
                return "MQIACF_SYSP_WLM_INT_UNITS";
            case 1269:
                return "MQIACF_TOPIC_ATTRS";
            case 1271:
                return "MQIACF_PUBSUB_PROPERTIES";
            case 1273:
                return "MQIACF_DESTINATION_CLASS";
            case 1274:
                return "MQIACF_DURABLE_SUBSCRIPTION";
            case 1275:
                return "MQIACF_SUBSCRIPTION_SCOPE";
            case 1277:
                return "MQIACF_VARIABLE_USER_ID";
            case 1280:
                return "MQIACF_REQUEST_ONLY";
            case 1283:
                return "MQIACF_PUB_PRIORITY";
            case 1287:
                return "MQIACF_SUB_ATTRS";
            case 1288:
                return "MQIACF_WILDCARD_SCHEMA";
            case 1289:
                return "MQIACF_SUB_TYPE";
            case 1290:
                return "MQIACF_MESSAGE_COUNT";
            case 1291:
                return "MQIACF_Q_MGR_PUBSUB";
            case 1292:
                return "MQIACF_Q_MGR_VERSION";
            case 1294:
                return "MQIACF_SUB_STATUS_ATTRS";
            case 1295:
                return "MQIACF_TOPIC_STATUS";
            case 1296:
                return "MQIACF_TOPIC_SUB";
            case 1297:
                return "MQIACF_TOPIC_PUB";
            case 1300:
                return "MQIACF_RETAINED_PUBLICATION";
            case 1301:
                return "MQIACF_TOPIC_STATUS_ATTRS";
            case 1302:
                return "MQIACF_TOPIC_STATUS_TYPE";
            case 1303:
                return "MQIACF_SUB_OPTIONS";
            case 1304:
                return "MQIACF_PUBLISH_COUNT";
            case 1305:
                return "MQIACF_CLEAR_TYPE";
            case 1306:
                return "MQIACF_CLEAR_SCOPE";
            case 1307:
                return "MQIACF_SUB_LEVEL";
            case 1308:
                return "MQIACF_ASYNC_STATE";
            case 1309:
                return "MQIACF_SUB_SUMMARY";
            case 1310:
                return "MQIACF_OBSOLETE_MSGS";
            case 1311:
                return "MQIACF_PUBSUB_STATUS";
            case 1314:
                return "MQIACF_PS_STATUS_TYPE";
            case 1318:
                return "MQIACF_PUBSUB_STATUS_ATTRS";
            case 1321:
                return "MQIACF_SELECTOR_TYPE";
            case 1322:
                return "MQIACF_LOG_COMPRESSION";
            case 1323:
                return "MQIACF_GROUPUR_CHECK_ID";
            case 1324:
                return "MQIACF_MULC_CAPTURE";
            case 1325:
                return "MQIACF_PERMIT_STANDBY";
            case 1326:
                return "MQIACF_OPERATION_MODE";
            case 1327:
                return "MQIACF_COMM_INFO_ATTRS";
            case 1328:
                return "MQIACF_CF_SMDS_BLOCK_SIZE";
            case 1329:
                return "MQIACF_CF_SMDS_EXPAND";
            case 1330:
                return "MQIACF_USAGE_FREE_BUFF";
            case 1331:
                return "MQIACF_USAGE_FREE_BUFF_PERC";
            case 1332:
                return "MQIACF_CF_STRUC_ACCESS";
            case 1333:
                return "MQIACF_CF_STATUS_SMDS";
            case 1334:
                return "MQIACF_SMDS_ATTRS";
            case 1335:
                return "MQIACF_USAGE_SMDS";
            case 1336:
                return "MQIACF_USAGE_BLOCK_SIZE";
            case 1337:
                return "MQIACF_USAGE_DATA_BLOCKS";
            case 1338:
                return "MQIACF_USAGE_EMPTY_BUFFERS";
            case 1339:
                return "MQIACF_USAGE_INUSE_BUFFERS";
            case 1340:
                return "MQIACF_USAGE_LOWEST_FREE";
            case 1341:
                return "MQIACF_USAGE_OFFLOAD_MSGS";
            case 1342:
                return "MQIACF_USAGE_READS_SAVED";
            case 1343:
                return "MQIACF_USAGE_SAVED_BUFFERS";
            case 1344:
                return "MQIACF_USAGE_TOTAL_BLOCKS";
            case 1345:
                return "MQIACF_USAGE_USED_BLOCKS";
            case 1346:
                return "MQIACF_USAGE_USED_RATE";
            case 1347:
                return "MQIACF_USAGE_WAIT_RATE";
            case 1348:
                return "MQIACF_SMDS_OPENMODE";
            case 1349:
                return "MQIACF_SMDS_STATUS";
            case 1350:
                return "MQIACF_SMDS_AVAIL";
            case 1351:
                return "MQIACF_MCAST_REL_INDICATOR";
            case 1352:
                return "MQIACF_CHLAUTH_TYPE";
            case 1354:
                return "MQIACF_MQXR_DIAGNOSTICS_TYPE";
            case 1355:
                return "MQIACF_CHLAUTH_ATTRS";
            case 1356:
                return "MQIACF_OPERATION_ID";
            case 1357:
                return "MQIACF_API_CALLER_TYPE";
            case 1358:
                return "MQIACF_API_ENVIRONMENT";
            case 1359:
                return "MQIACF_TRACE_DETAIL";
            case 1360:
                return "MQIACF_HOBJ";
            case 1361:
                return "MQIACF_CALL_TYPE";
            case 1362:
                return "MQIACF_MQCB_OPERATION";
            case 1363:
                return "MQIACF_MQCB_TYPE";
            case 1364:
                return "MQIACF_MQCB_OPTIONS";
            case 1365:
                return "MQIACF_CLOSE_OPTIONS";
            case 1366:
                return "MQIACF_CTL_OPERATION";
            case 1367:
                return "MQIACF_GET_OPTIONS";
            case 1368:
                return "MQIACF_RECS_PRESENT";
            case 1369:
                return "MQIACF_KNOWN_DEST_COUNT";
            case 1370:
                return "MQIACF_UNKNOWN_DEST_COUNT";
            case 1371:
                return "MQIACF_INVALID_DEST_COUNT";
            case 1372:
                return "MQIACF_RESOLVED_TYPE";
            case 1373:
                return "MQIACF_PUT_OPTIONS";
            case 1374:
                return "MQIACF_BUFFER_LENGTH";
            case 1375:
                return "MQIACF_TRACE_DATA_LENGTH";
            case 1376:
                return "MQIACF_SMDS_EXPANDST";
            case 1378:
                return "MQIACF_ITEM_COUNT";
            case 1379:
                return "MQIACF_EXPIRY_TIME";
            case 1380:
                return "MQIACF_CONNECT_TIME";
            case 1381:
                return "MQIACF_DISCONNECT_TIME";
            case 1382:
                return "MQIACF_HSUB";
            case 1383:
                return "MQIACF_SUBRQ_OPTIONS";
            case 1384:
                return "MQIACF_XA_RMID";
            case 1385:
                return "MQIACF_XA_FLAGS";
            case 1386:
                return "MQIACF_XA_RETCODE";
            case 1387:
                return "MQIACF_XA_HANDLE";
            case 1388:
                return "MQIACF_XA_RETVAL";
            case 1389:
                return "MQIACF_STATUS_TYPE";
            case 1390:
                return "MQIACF_XA_COUNT";
            case 1391:
                return "MQIACF_SELECTOR_COUNT";
            case 1392:
                return "MQIACF_SELECTORS";
            case 1393:
                return "MQIACF_INTATTR_COUNT";
            case 1394:
                return "MQIACF_INT_ATTRS";
            case 1395:
                return "MQIACF_SUBRQ_ACTION";
            case 1396:
                return "MQIACF_NUM_PUBS";
            case 1397:
                return "MQIACF_POINTER_SIZE";
            case 1398:
                return "MQIACF_REMOVE_AUTHREC";
            case 1399:
                return "MQIACF_XR_ATTRS";
            case 1400:
                return "MQIACF_APPL_FUNCTION_TYPE";
            case 1401:
                return "MQIACF_AMQP_ATTRS";
            case 1402:
                return "MQIACF_EXPORT_TYPE";
            case 1403:
                return "MQIACF_EXPORT_ATTRS";
            case 1404:
                return "MQIACF_SYSTEM_OBJECTS";
            case 1405:
                return "MQIACF_CONNECTION_SWAP";
            case 1406:
                return "MQIACF_AMQP_DIAGNOSTICS_TYPE";
            case 1408:
                return "MQIACF_BUFFER_POOL_LOCATION";
            case 1409:
                return "MQIACF_LDAP_CONNECTION_STATUS";
            case 1410:
                return "MQIACF_SYSP_MAX_ACE_POOL";
            case 1411:
                return "MQIACF_PAGECLAS";
            case 1412:
                return "MQIACF_AUTH_REC_TYPE";
            case 1413:
                return "MQIACF_SYSP_MAX_CONC_OFFLOADS";
            case 1414:
                return "MQIACF_SYSP_ZHYPERWRITE";
            case 1415:
                return "MQIACF_Q_MGR_STATUS_LOG";
            case 1416:
                return "MQIACF_ARCHIVE_LOG_SIZE";
            case 1417:
                return "MQIACF_MEDIA_LOG_SIZE";
            case 1418:
                return "MQIACF_RESTART_LOG_SIZE";
            case 1419:
                return "MQIACF_REUSABLE_LOG_SIZE";
            case 1420:
                return "MQIACF_LOG_IN_USE";
            case 1421:
                return "MQIACF_LOG_UTILIZATION";
            case 1422:
                return "MQIACF_LOG_REDUCTION";
            case 1423:
                return "MQIACF_IGNORE_STATE";
            case 1424:
                return "MQIACF_MOVABLE_APPL_COUNT";
            case 1425:
                return "MQIACF_APPL_INFO_ATTRS";
            case 1426:
                return "MQIACF_APPL_MOVABLE";
            case 1427:
                return "MQIACF_REMOTE_QMGR_ACTIVE";
            case 1428:
                return "MQIACF_APPL_INFO_TYPE";
            case 1429:
                return "MQIACF_APPL_INFO_APPL";
            case 1430:
                return "MQIACF_APPL_INFO_QMGR";
            case 1431:
                return "MQIACF_APPL_INFO_LOCAL";
            case 1432:
                return "MQIACF_APPL_IMMOVABLE_COUNT";
            case 1433:
                return "MQIACF_BALANCED";
            case 1434:
                return "MQIACF_BALSTATE";
            case 1435:
                return "MQIACF_APPL_IMMOVABLE_REASON";
            case 1436:
                return "MQIACF_DS_ENCRYPTED";
            case 1437:
                return "MQIACF_CUR_Q_FILE_SIZE";
            case 1438:
                return "MQIACF_CUR_MAX_FILE_SIZE";
            default:
                return "";
        }
    }

    public static String MQIACH_STR(int value) {
        switch (value) {
            case 1501:
                return "MQIACH_XMIT_PROTOCOL_TYPE";
            case 1502:
                return "MQIACH_BATCH_SIZE";
            case 1503:
                return "MQIACH_DISC_INTERVAL";
            case 1504:
                return "MQIACH_SHORT_TIMER";
            case 1505:
                return "MQIACH_SHORT_RETRY";
            case 1506:
                return "MQIACH_LONG_TIMER";
            case 1507:
                return "MQIACH_LONG_RETRY";
            case 1508:
                return "MQIACH_PUT_AUTHORITY";
            case 1509:
                return "MQIACH_SEQUENCE_NUMBER_WRAP";
            case 1510:
                return "MQIACH_MAX_MSG_LENGTH";
            case 1511:
                return "MQIACH_CHANNEL_TYPE";
            case 1512:
                return "MQIACH_DATA_COUNT";
            case 1513:
                return "MQIACH_NAME_COUNT";
            case 1514:
                return "MQIACH_MSG_SEQUENCE_NUMBER";
            case 1515:
                return "MQIACH_DATA_CONVERSION";
            case 1516:
                return "MQIACH_IN_DOUBT";
            case 1517:
                return "MQIACH_MCA_TYPE";
            case 1518:
                return "MQIACH_SESSION_COUNT";
            case 1519:
                return "MQIACH_ADAPTER";
            case 1520:
                return "MQIACH_COMMAND_COUNT";
            case 1521:
                return "MQIACH_SOCKET";
            case 1522:
                return "MQIACH_PORT";
            case 1523:
                return "MQIACH_CHANNEL_INSTANCE_TYPE";
            case 1524:
                return "MQIACH_CHANNEL_INSTANCE_ATTRS";
            case 1525:
                return "MQIACH_CHANNEL_ERROR_DATA";
            case 1526:
                return "MQIACH_CHANNEL_TABLE";
            case 1527:
                return "MQIACH_CHANNEL_STATUS";
            case 1528:
                return "MQIACH_INDOUBT_STATUS";
            case 1529:
                return "MQIACH_LAST_SEQ_NUMBER";
            case 1531:
                return "MQIACH_CURRENT_MSGS";
            case 1532:
                return "MQIACH_CURRENT_SEQ_NUMBER";
            case 1533:
                return "MQIACH_SSL_RETURN_CODE";
            case 1534:
                return "MQIACH_MSGS";
            case 1535:
                return "MQIACH_BYTES_SENT";
            case 1536:
                return "MQIACH_BYTES_RCVD";
            case 1537:
                return "MQIACH_BATCHES";
            case 1538:
                return "MQIACH_BUFFERS_SENT";
            case 1539:
                return "MQIACH_BUFFERS_RCVD";
            case 1540:
                return "MQIACH_LONG_RETRIES_LEFT";
            case 1541:
                return "MQIACH_SHORT_RETRIES_LEFT";
            case 1542:
                return "MQIACH_MCA_STATUS";
            case 1543:
                return "MQIACH_STOP_REQUESTED";
            case 1544:
                return "MQIACH_MR_COUNT";
            case 1545:
                return "MQIACH_MR_INTERVAL";
            case 1562:
                return "MQIACH_NPM_SPEED";
            case 1563:
                return "MQIACH_HB_INTERVAL";
            case 1564:
                return "MQIACH_BATCH_INTERVAL";
            case 1565:
                return "MQIACH_NETWORK_PRIORITY";
            case 1566:
                return "MQIACH_KEEP_ALIVE_INTERVAL";
            case 1567:
                return "MQIACH_BATCH_HB";
            case 1568:
                return "MQIACH_SSL_CLIENT_AUTH";
            case 1570:
                return "MQIACH_ALLOC_RETRY";
            case 1571:
                return "MQIACH_ALLOC_FAST_TIMER";
            case 1572:
                return "MQIACH_ALLOC_SLOW_TIMER";
            case 1573:
                return "MQIACH_DISC_RETRY";
            case 1574:
                return "MQIACH_PORT_NUMBER";
            case 1575:
                return "MQIACH_HDR_COMPRESSION";
            case 1576:
                return "MQIACH_MSG_COMPRESSION";
            case 1577:
                return "MQIACH_CLWL_CHANNEL_RANK";
            case 1578:
                return "MQIACH_CLWL_CHANNEL_PRIORITY";
            case 1579:
                return "MQIACH_CLWL_CHANNEL_WEIGHT";
            case 1580:
                return "MQIACH_CHANNEL_DISP";
            case 1581:
                return "MQIACH_INBOUND_DISP";
            case 1582:
                return "MQIACH_CHANNEL_TYPES";
            case 1583:
                return "MQIACH_ADAPS_STARTED";
            case 1584:
                return "MQIACH_ADAPS_MAX";
            case 1585:
                return "MQIACH_DISPS_STARTED";
            case 1586:
                return "MQIACH_DISPS_MAX";
            case 1587:
                return "MQIACH_SSLTASKS_STARTED";
            case 1588:
                return "MQIACH_SSLTASKS_MAX";
            case 1589:
                return "MQIACH_CURRENT_CHL";
            case 1590:
                return "MQIACH_CURRENT_CHL_MAX";
            case 1591:
                return "MQIACH_CURRENT_CHL_TCP";
            case 1592:
                return "MQIACH_CURRENT_CHL_LU62";
            case 1593:
                return "MQIACH_ACTIVE_CHL";
            case 1594:
                return "MQIACH_ACTIVE_CHL_MAX";
            case 1595:
                return "MQIACH_ACTIVE_CHL_PAUSED";
            case 1596:
                return "MQIACH_ACTIVE_CHL_STARTED";
            case 1597:
                return "MQIACH_ACTIVE_CHL_STOPPED";
            case 1598:
                return "MQIACH_ACTIVE_CHL_RETRY";
            case 1599:
                return "MQIACH_LISTENER_STATUS";
            case 1600:
                return "MQIACH_SHARED_CHL_RESTART";
            case 1601:
                return "MQIACH_LISTENER_CONTROL";
            case 1602:
                return "MQIACH_BACKLOG";
            case 1604:
                return "MQIACH_XMITQ_TIME_INDICATOR";
            case 1605:
                return "MQIACH_NETWORK_TIME_INDICATOR";
            case 1606:
                return "MQIACH_EXIT_TIME_INDICATOR";
            case 1607:
                return "MQIACH_BATCH_SIZE_INDICATOR";
            case 1608:
                return "MQIACH_XMITQ_MSGS_AVAILABLE";
            case 1609:
                return "MQIACH_CHANNEL_SUBSTATE";
            case 1610:
                return "MQIACH_SSL_KEY_RESETS";
            case 1611:
                return "MQIACH_COMPRESSION_RATE";
            case 1612:
                return "MQIACH_COMPRESSION_TIME";
            case 1613:
                return "MQIACH_MAX_XMIT_SIZE";
            case 1614:
                return "MQIACH_DEF_CHANNEL_DISP";
            case 1615:
                return "MQIACH_SHARING_CONVERSATIONS";
            case 1616:
                return "MQIACH_MAX_SHARING_CONVS";
            case 1617:
                return "MQIACH_CURRENT_SHARING_CONVS";
            case 1618:
                return "MQIACH_MAX_INSTANCES";
            case 1619:
                return "MQIACH_MAX_INSTS_PER_CLIENT";
            case 1620:
                return "MQIACH_CLIENT_CHANNEL_WEIGHT";
            case 1621:
                return "MQIACH_CONNECTION_AFFINITY";
            case 1623:
                return "MQIACH_RESET_REQUESTED";
            case 1624:
                return "MQIACH_BATCH_DATA_LIMIT";
            case 1625:
                return "MQIACH_MSG_HISTORY";
            case 1626:
                return "MQIACH_MULTICAST_PROPERTIES";
            case 1627:
                return "MQIACH_NEW_SUBSCRIBER_HISTORY";
            case 1628:
                return "MQIACH_MC_HB_INTERVAL";
            case 1629:
                return "MQIACH_USE_CLIENT_ID";
            case 1630:
                return "MQIACH_MQTT_KEEP_ALIVE";
            case 1631:
                return "MQIACH_IN_DOUBT_IN";
            case 1632:
                return "MQIACH_IN_DOUBT_OUT";
            case 1633:
                return "MQIACH_MSGS_SENT";
            case 1634:
                return "MQIACH_MSGS_RCVD";
            case 1635:
                return "MQIACH_PENDING_OUT";
            case 1636:
                return "MQIACH_AVAILABLE_CIPHERSPECS";
            case 1637:
                return "MQIACH_MATCH";
            case 1638:
                return "MQIACH_USER_SOURCE";
            case 1639:
                return "MQIACH_WARNING";
            case 1640:
                return "MQIACH_DEF_RECONNECT";
            case 1642:
                return "MQIACH_CHANNEL_SUMMARY_ATTRS";
            case 1643:
                return "MQIACH_PROTOCOL";
            case 1644:
                return "MQIACH_AMQP_KEEP_ALIVE";
            case 1645:
                return "MQIACH_SECURITY_PROTOCOL";
            case 1646:
                return "MQIACH_SPL_PROTECTION";
            default:
                return "";
        }
    }

    public static String MQIAMO64_STR(int value) {
        switch (value) {
            case 703:
                return "MQIAMO64_AVG_Q_TIME";
            case 741:
                return "MQIAMO64_Q_TIME_AVG";
            case 742:
                return "MQIAMO64_Q_TIME_MAX";
            case 743:
                return "MQIAMO64_Q_TIME_MIN";
            case 745:
                return "MQIAMO64_BROWSE_BYTES";
            case 746:
                return "MQIAMO64_BYTES";
            case 747:
                return "MQIAMO64_GET_BYTES";
            case 748:
                return "MQIAMO64_PUT_BYTES";
            case 783:
                return "MQIAMO64_TOPIC_PUT_BYTES";
            case 785:
                return "MQIAMO64_PUBLISH_MSG_BYTES";
            case 838:
                return "MQIAMO64_HIGHRES_TIME";
            case 844:
                return "MQIAMO64_QMGR_OP_DURATION";
            case 845:
                return "MQIAMO64_MONITOR_INTERVAL";
            default:
                return "";
        }
    }

    public static String MQIAMO_STR(int value) {
        switch (value) {
            case 0:
                return "MQIAMO_MONITOR_FLAGS_NONE";
            case 1:
                return "MQIAMO_MONITOR_FLAGS_OBJNAME";
            case 2:
                return "MQIAMO_MONITOR_DELTA";
            case 100:
                return "MQIAMO_MONITOR_HUNDREDTHS";
            case 702:
                return "MQIAMO_AVG_BATCH_SIZE";
            case 703:
                return "MQIAMO_AVG_Q_TIME";
            case 704:
                return "MQIAMO_BACKOUTS";
            case 705:
                return "MQIAMO_BROWSES";
            case 706:
                return "MQIAMO_BROWSE_MAX_BYTES";
            case 707:
                return "MQIAMO_BROWSE_MIN_BYTES";
            case 708:
                return "MQIAMO_BROWSES_FAILED";
            case 709:
                return "MQIAMO_CLOSES";
            case 710:
                return "MQIAMO_COMMITS";
            case 711:
                return "MQIAMO_COMMITS_FAILED";
            case 712:
                return "MQIAMO_CONNS";
            case 713:
                return "MQIAMO_CONNS_MAX";
            case 714:
                return "MQIAMO_DISCS";
            case 715:
                return "MQIAMO_DISCS_IMPLICIT";
            case 716:
                return "MQIAMO_DISC_TYPE";
            case 717:
                return "MQIAMO_EXIT_TIME_AVG";
            case 718:
                return "MQIAMO_EXIT_TIME_MAX";
            case 719:
                return "MQIAMO_EXIT_TIME_MIN";
            case 720:
                return "MQIAMO_FULL_BATCHES";
            case 721:
                return "MQIAMO_GENERATED_MSGS";
            case 722:
                return "MQIAMO_GETS";
            case 723:
                return "MQIAMO_GET_MAX_BYTES";
            case 724:
                return "MQIAMO_GET_MIN_BYTES";
            case 725:
                return "MQIAMO_GETS_FAILED";
            case 726:
                return "MQIAMO_INCOMPLETE_BATCHES";
            case 727:
                return "MQIAMO_INQS";
            case 728:
                return "MQIAMO_MSGS";
            case 729:
                return "MQIAMO_NET_TIME_AVG";
            case 730:
                return "MQIAMO_NET_TIME_MAX";
            case 731:
                return "MQIAMO_NET_TIME_MIN";
            case 732:
                return "MQIAMO_OBJECT_COUNT";
            case 733:
                return "MQIAMO_OPENS";
            case 734:
                return "MQIAMO_PUT1S";
            case 735:
                return "MQIAMO_PUTS";
            case 736:
                return "MQIAMO_PUT_MAX_BYTES";
            case 737:
                return "MQIAMO_PUT_MIN_BYTES";
            case 738:
                return "MQIAMO_PUT_RETRIES";
            case 739:
                return "MQIAMO_Q_MAX_DEPTH";
            case 740:
                return "MQIAMO_Q_MIN_DEPTH";
            case 741:
                return "MQIAMO_Q_TIME_AVG";
            case 742:
                return "MQIAMO_Q_TIME_MAX";
            case 743:
                return "MQIAMO_Q_TIME_MIN";
            case 744:
                return "MQIAMO_SETS";
            case 749:
                return "MQIAMO_CONNS_FAILED";
            case 751:
                return "MQIAMO_OPENS_FAILED";
            case 752:
                return "MQIAMO_INQS_FAILED";
            case 753:
                return "MQIAMO_SETS_FAILED";
            case 754:
                return "MQIAMO_PUTS_FAILED";
            case 755:
                return "MQIAMO_PUT1S_FAILED";
            case 757:
                return "MQIAMO_CLOSES_FAILED";
            case 758:
                return "MQIAMO_MSGS_EXPIRED";
            case 759:
                return "MQIAMO_MSGS_NOT_QUEUED";
            case 760:
                return "MQIAMO_MSGS_PURGED";
            case 764:
                return "MQIAMO_SUBS_DUR";
            case 765:
                return "MQIAMO_SUBS_NDUR";
            case 766:
                return "MQIAMO_SUBS_FAILED";
            case 767:
                return "MQIAMO_SUBRQS";
            case 768:
                return "MQIAMO_SUBRQS_FAILED";
            case 769:
                return "MQIAMO_CBS";
            case 770:
                return "MQIAMO_CBS_FAILED";
            case 771:
                return "MQIAMO_CTLS";
            case 772:
                return "MQIAMO_CTLS_FAILED";
            case 773:
                return "MQIAMO_STATS";
            case 774:
                return "MQIAMO_STATS_FAILED";
            case 775:
                return "MQIAMO_SUB_DUR_HIGHWATER";
            case 776:
                return "MQIAMO_SUB_DUR_LOWWATER";
            case 777:
                return "MQIAMO_SUB_NDUR_HIGHWATER";
            case 778:
                return "MQIAMO_SUB_NDUR_LOWWATER";
            case 779:
                return "MQIAMO_TOPIC_PUTS";
            case 780:
                return "MQIAMO_TOPIC_PUTS_FAILED";
            case 781:
                return "MQIAMO_TOPIC_PUT1S";
            case 782:
                return "MQIAMO_TOPIC_PUT1S_FAILED";
            case 784:
                return "MQIAMO_PUBLISH_MSG_COUNT";
            case 786:
                return "MQIAMO_UNSUBS_DUR";
            case 787:
                return "MQIAMO_UNSUBS_NDUR";
            case 788:
                return "MQIAMO_UNSUBS_FAILED";
            case 789:
                return "MQIAMO_INTERVAL";
            case 790:
                return "MQIAMO_MSGS_SENT";
            case 791:
                return "MQIAMO_BYTES_SENT";
            case 792:
                return "MQIAMO_REPAIR_BYTES";
            case 793:
                return "MQIAMO_FEEDBACK_MODE";
            case 794:
                return "MQIAMO_RELIABILITY_TYPE";
            case 795:
                return "MQIAMO_LATE_JOIN_MARK";
            case 796:
                return "MQIAMO_NACKS_RCVD";
            case 797:
                return "MQIAMO_REPAIR_PKTS";
            case 798:
                return "MQIAMO_HISTORY_PKTS";
            case 799:
                return "MQIAMO_PENDING_PKTS";
            case 800:
                return "MQIAMO_PKT_RATE";
            case 801:
                return "MQIAMO_MCAST_XMIT_RATE";
            case 802:
                return "MQIAMO_MCAST_BATCH_TIME";
            case 803:
                return "MQIAMO_MCAST_HEARTBEAT";
            case 804:
                return "MQIAMO_DEST_DATA_PORT";
            case 805:
                return "MQIAMO_DEST_REPAIR_PORT";
            case 806:
                return "MQIAMO_ACKS_RCVD";
            case 807:
                return "MQIAMO_ACTIVE_ACKERS";
            case 808:
                return "MQIAMO_PKTS_SENT";
            case 809:
                return "MQIAMO_TOTAL_REPAIR_PKTS";
            case 810:
                return "MQIAMO_TOTAL_PKTS_SENT";
            case 811:
                return "MQIAMO_TOTAL_MSGS_SENT";
            case 812:
                return "MQIAMO_TOTAL_BYTES_SENT";
            case 813:
                return "MQIAMO_NUM_STREAMS";
            case 814:
                return "MQIAMO_ACK_FEEDBACK";
            case 815:
                return "MQIAMO_NACK_FEEDBACK";
            case 816:
                return "MQIAMO_PKTS_LOST";
            case 817:
                return "MQIAMO_MSGS_RCVD";
            case 818:
                return "MQIAMO_MSG_BYTES_RCVD";
            case 819:
                return "MQIAMO_MSGS_DELIVERED";
            case 820:
                return "MQIAMO_PKTS_PROCESSED";
            case 821:
                return "MQIAMO_PKTS_DELIVERED";
            case 822:
                return "MQIAMO_PKTS_DROPPED";
            case 823:
                return "MQIAMO_PKTS_DUPLICATED";
            case 824:
                return "MQIAMO_NACKS_CREATED";
            case 825:
                return "MQIAMO_NACK_PKTS_SENT";
            case 826:
                return "MQIAMO_REPAIR_PKTS_RQSTD";
            case 827:
                return "MQIAMO_REPAIR_PKTS_RCVD";
            case 828:
                return "MQIAMO_PKTS_REPAIRED";
            case 829:
                return "MQIAMO_TOTAL_MSGS_RCVD";
            case 830:
                return "MQIAMO_TOTAL_MSG_BYTES_RCVD";
            case 831:
                return "MQIAMO_TOTAL_REPAIR_PKTS_RCVD";
            case 832:
                return "MQIAMO_TOTAL_REPAIR_PKTS_RQSTD";
            case 833:
                return "MQIAMO_TOTAL_MSGS_PROCESSED";
            case 834:
                return "MQIAMO_TOTAL_MSGS_SELECTED";
            case 835:
                return "MQIAMO_TOTAL_MSGS_EXPIRED";
            case 836:
                return "MQIAMO_TOTAL_MSGS_DELIVERED";
            case 837:
                return "MQIAMO_TOTAL_MSGS_RETURNED";
            case 839:
                return "MQIAMO_MONITOR_CLASS";
            case 840:
                return "MQIAMO_MONITOR_TYPE";
            case 841:
                return "MQIAMO_MONITOR_ELEMENT";
            case 842:
                return "MQIAMO_MONITOR_DATATYPE";
            case 843:
                return "MQIAMO_MONITOR_FLAGS";
            case 1024:
                return "MQIAMO_MONITOR_KB";
            case 10000:
                return "MQIAMO_MONITOR_PERCENT";
            case 1000000:
                return "MQIAMO_MONITOR_MICROSEC";
            case 1048576:
                return "MQIAMO_MONITOR_MB";
            case 100000000:
                return "MQIAMO_MONITOR_GB";
            default:
                return "";
        }
    }

    public static String MQIASY_STR(int value) {
        switch (value) {
            case -9:
                return "MQIASY_VERSION";
            case -8:
                return "MQIASY_BAG_OPTIONS";
            case -7:
                return "MQIASY_REASON";
            case -6:
                return "MQIASY_COMP_CODE";
            case -5:
                return "MQIASY_CONTROL";
            case -4:
                return "MQIASY_MSG_SEQ_NUMBER";
            case -3:
                return "MQIASY_COMMAND";
            case -2:
                return "MQIASY_TYPE";
            case -1:
                return "MQIASY_CODED_CHAR_SET_ID";
            default:
                return "";
        }
    }

    public static String MQIAV_STR(int value) {
        switch (value) {
            case -2:
                return "MQIAV_UNDEFINED";
            case -1:
                return "MQIAV_NOT_APPLICABLE";
            default:
                return "";
        }
    }

    public static String MQIA_STR(int value) {
        switch (value) {
            case 1:
                return "MQIA_APPL_TYPE";
            case 2:
                return "MQIA_CODED_CHAR_SET_ID";
            case 3:
                return "MQIA_CURRENT_Q_DEPTH";
            case 4:
                return "MQIA_DEF_INPUT_OPEN_OPTION";
            case 5:
                return "MQIA_DEF_PERSISTENCE";
            case 6:
                return "MQIA_DEF_PRIORITY";
            case 7:
                return "MQIA_DEFINITION_TYPE";
            case 8:
                return "MQIA_HARDEN_GET_BACKOUT";
            case 9:
                return "MQIA_INHIBIT_GET";
            case 10:
                return "MQIA_INHIBIT_PUT";
            case 11:
                return "MQIA_MAX_HANDLES";
            case 12:
                return "MQIA_USAGE";
            case 13:
                return "MQIA_MAX_MSG_LENGTH";
            case 14:
                return "MQIA_MAX_PRIORITY";
            case 15:
                return "MQIA_MAX_Q_DEPTH";
            case 16:
                return "MQIA_MSG_DELIVERY_SEQUENCE";
            case 17:
                return "MQIA_OPEN_INPUT_COUNT";
            case 18:
                return "MQIA_OPEN_OUTPUT_COUNT";
            case 19:
                return "MQIA_NAME_COUNT";
            case 20:
                return "MQIA_Q_TYPE";
            case 21:
                return "MQIA_RETENTION_INTERVAL";
            case 22:
                return "MQIA_BACKOUT_THRESHOLD";
            case 23:
                return "MQIA_SHAREABILITY";
            case 24:
                return "MQIA_TRIGGER_CONTROL";
            case 25:
                return "MQIA_TRIGGER_INTERVAL";
            case 26:
                return "MQIA_TRIGGER_MSG_PRIORITY";
            case 27:
                return "MQIA_CPI_LEVEL";
            case 28:
                return "MQIA_TRIGGER_TYPE";
            case 29:
                return "MQIA_TRIGGER_DEPTH";
            case 30:
                return "MQIA_SYNCPOINT";
            case 31:
                return "MQIA_COMMAND_LEVEL";
            case 32:
                return "MQIA_PLATFORM";
            case 33:
                return "MQIA_MAX_UNCOMMITTED_MSGS";
            case 34:
                return "MQIA_DIST_LISTS";
            case 35:
                return "MQIA_TIME_SINCE_RESET";
            case 36:
                return "MQIA_HIGH_Q_DEPTH";
            case 37:
                return "MQIA_MSG_ENQ_COUNT";
            case 38:
                return "MQIA_MSG_DEQ_COUNT";
            case 39:
                return "MQIA_EXPIRY_INTERVAL";
            case 40:
                return "MQIA_Q_DEPTH_HIGH_LIMIT";
            case 41:
                return "MQIA_Q_DEPTH_LOW_LIMIT";
            case 42:
                return "MQIA_Q_DEPTH_MAX_EVENT";
            case 43:
                return "MQIA_Q_DEPTH_HIGH_EVENT";
            case 44:
                return "MQIA_Q_DEPTH_LOW_EVENT";
            case 45:
                return "MQIA_SCOPE";
            case 46:
                return "MQIA_Q_SERVICE_INTERVAL_EVENT";
            case 47:
                return "MQIA_AUTHORITY_EVENT";
            case 48:
                return "MQIA_INHIBIT_EVENT";
            case 49:
                return "MQIA_LOCAL_EVENT";
            case 50:
                return "MQIA_REMOTE_EVENT";
            case 51:
                return "MQIA_CONFIGURATION_EVENT";
            case 52:
                return "MQIA_START_STOP_EVENT";
            case 53:
                return "MQIA_PERFORMANCE_EVENT";
            case 54:
                return "MQIA_Q_SERVICE_INTERVAL";
            case 55:
                return "MQIA_CHANNEL_AUTO_DEF";
            case 56:
                return "MQIA_CHANNEL_AUTO_DEF_EVENT";
            case 57:
                return "MQIA_INDEX_TYPE";
            case 58:
                return "MQIA_CLUSTER_WORKLOAD_LENGTH";
            case 59:
                return "MQIA_CLUSTER_Q_TYPE";
            case 60:
                return "MQIA_ARCHIVE";
            case 61:
                return "MQIA_DEF_BIND";
            case 62:
                return "MQIA_PAGESET_ID";
            case 63:
                return "MQIA_QSG_DISP";
            case 64:
                return "MQIA_INTRA_GROUP_QUEUING";
            case 65:
                return "MQIA_IGQ_PUT_AUTHORITY";
            case 66:
                return "MQIA_AUTH_INFO_TYPE";
            case 68:
                return "MQIA_MSG_MARK_BROWSE_INTERVAL";
            case 69:
                return "MQIA_SSL_TASKS";
            case 70:
                return "MQIA_CF_LEVEL";
            case 71:
                return "MQIA_CF_RECOVER";
            case 72:
                return "MQIA_NAMELIST_TYPE";
            case 73:
                return "MQIA_CHANNEL_EVENT";
            case 74:
                return "MQIA_BRIDGE_EVENT";
            case 75:
                return "MQIA_SSL_EVENT";
            case 76:
                return "MQIA_SSL_RESET_COUNT";
            case 77:
                return "MQIA_SHARED_Q_Q_MGR_NAME";
            case 78:
                return "MQIA_NPM_CLASS";
            case 80:
                return "MQIA_MAX_OPEN_Q";
            case 81:
                return "MQIA_MONITOR_INTERVAL";
            case 82:
                return "MQIA_Q_USERS";
            case 83:
                return "MQIA_MAX_GLOBAL_LOCKS";
            case 84:
                return "MQIA_MAX_LOCAL_LOCKS";
            case 85:
                return "MQIA_LISTENER_PORT_NUMBER";
            case 86:
                return "MQIA_BATCH_INTERFACE_AUTO";
            case 87:
                return "MQIA_CMD_SERVER_AUTO";
            case 88:
                return "MQIA_CMD_SERVER_CONVERT_MSG";
            case 89:
                return "MQIA_CMD_SERVER_DLQ_MSG";
            case 90:
                return "MQIA_MAX_Q_TRIGGERS";
            case 91:
                return "MQIA_TRIGGER_RESTART";
            case 92:
                return "MQIA_SSL_FIPS_REQUIRED";
            case 93:
                return "MQIA_IP_ADDRESS_VERSION";
            case 94:
                return "MQIA_LOGGER_EVENT";
            case 95:
                return "MQIA_CLWL_Q_RANK";
            case 96:
                return "MQIA_CLWL_Q_PRIORITY";
            case 97:
                return "MQIA_CLWL_MRU_CHANNELS";
            case 98:
                return "MQIA_CLWL_USEQ";
            case 99:
                return "MQIA_COMMAND_EVENT";
            case 100:
                return "MQIA_ACTIVE_CHANNELS";
            case 101:
                return "MQIA_CHINIT_ADAPTERS";
            case 102:
                return "MQIA_ADOPTNEWMCA_CHECK";
            case 103:
                return "MQIA_ADOPTNEWMCA_TYPE";
            case 104:
                return "MQIA_ADOPTNEWMCA_INTERVAL";
            case 105:
                return "MQIA_CHINIT_DISPATCHERS";
            case 106:
                return "MQIA_DNS_WLM";
            case 107:
                return "MQIA_LISTENER_TIMER";
            case 108:
                return "MQIA_LU62_CHANNELS";
            case 109:
                return "MQIA_MAX_CHANNELS";
            case 110:
                return "MQIA_OUTBOUND_PORT_MIN";
            case 111:
                return "MQIA_RECEIVE_TIMEOUT";
            case 112:
                return "MQIA_RECEIVE_TIMEOUT_TYPE";
            case 113:
                return "MQIA_RECEIVE_TIMEOUT_MIN";
            case 114:
                return "MQIA_TCP_CHANNELS";
            case 115:
                return "MQIA_TCP_KEEP_ALIVE";
            case 116:
                return "MQIA_TCP_STACK_TYPE";
            case 117:
                return "MQIA_CHINIT_TRACE_AUTO_START";
            case 118:
                return "MQIA_CHINIT_TRACE_TABLE_SIZE";
            case 119:
                return "MQIA_CHINIT_CONTROL";
            case 120:
                return "MQIA_CMD_SERVER_CONTROL";
            case 121:
                return "MQIA_SERVICE_TYPE";
            case 122:
                return "MQIA_MONITORING_CHANNEL";
            case 123:
                return "MQIA_MONITORING_Q";
            case 124:
                return "MQIA_MONITORING_AUTO_CLUSSDR";
            case 127:
                return "MQIA_STATISTICS_MQI";
            case 128:
                return "MQIA_STATISTICS_Q";
            case 129:
                return "MQIA_STATISTICS_CHANNEL";
            case 130:
                return "MQIA_STATISTICS_AUTO_CLUSSDR";
            case 131:
                return "MQIA_STATISTICS_INTERVAL";
            case 133:
                return "MQIA_ACCOUNTING_MQI";
            case 134:
                return "MQIA_ACCOUNTING_Q";
            case 135:
                return "MQIA_ACCOUNTING_INTERVAL";
            case 136:
                return "MQIA_ACCOUNTING_CONN_OVERRIDE";
            case 137:
                return "MQIA_TRACE_ROUTE_RECORDING";
            case 138:
                return "MQIA_ACTIVITY_RECORDING";
            case 139:
                return "MQIA_SERVICE_CONTROL";
            case 140:
                return "MQIA_OUTBOUND_PORT_MAX";
            case 141:
                return "MQIA_SECURITY_CASE";
            case 150:
                return "MQIA_QMOPT_CSMT_ON_ERROR";
            case 151:
                return "MQIA_QMOPT_CONS_INFO_MSGS";
            case 152:
                return "MQIA_QMOPT_CONS_WARNING_MSGS";
            case 153:
                return "MQIA_QMOPT_CONS_ERROR_MSGS";
            case 154:
                return "MQIA_QMOPT_CONS_CRITICAL_MSGS";
            case 155:
                return "MQIA_QMOPT_CONS_COMMS_MSGS";
            case 156:
                return "MQIA_QMOPT_CONS_REORG_MSGS";
            case 157:
                return "MQIA_QMOPT_CONS_SYSTEM_MSGS";
            case 158:
                return "MQIA_QMOPT_LOG_INFO_MSGS";
            case 159:
                return "MQIA_QMOPT_LOG_WARNING_MSGS";
            case 160:
                return "MQIA_QMOPT_LOG_ERROR_MSGS";
            case 161:
                return "MQIA_QMOPT_LOG_CRITICAL_MSGS";
            case 162:
                return "MQIA_QMOPT_LOG_COMMS_MSGS";
            case 163:
                return "MQIA_QMOPT_LOG_REORG_MSGS";
            case 164:
                return "MQIA_QMOPT_LOG_SYSTEM_MSGS";
            case 165:
                return "MQIA_QMOPT_TRACE_MQI_CALLS";
            case 166:
                return "MQIA_QMOPT_TRACE_COMMS";
            case 167:
                return "MQIA_QMOPT_TRACE_REORG";
            case 168:
                return "MQIA_QMOPT_TRACE_CONVERSION";
            case 169:
                return "MQIA_QMOPT_TRACE_SYSTEM";
            case 170:
                return "MQIA_QMOPT_INTERNAL_DUMP";
            case 171:
                return "MQIA_MAX_RECOVERY_TASKS";
            case 172:
                return "MQIA_MAX_CLIENTS";
            case 173:
                return "MQIA_AUTO_REORGANIZATION";
            case 174:
                return "MQIA_AUTO_REORG_INTERVAL";
            case 175:
                return "MQIA_DURABLE_SUB";
            case 176:
                return "MQIA_MULTICAST";
            case 181:
                return "MQIA_INHIBIT_PUB";
            case 182:
                return "MQIA_INHIBIT_SUB";
            case 183:
                return "MQIA_TREE_LIFE_TIME";
            case 184:
                return "MQIA_DEF_PUT_RESPONSE_TYPE";
            case 185:
                return "MQIA_TOPIC_DEF_PERSISTENCE";
            case 186:
                return "MQIA_MASTER_ADMIN";
            case 187:
                return "MQIA_PUBSUB_MODE";
            case 188:
                return "MQIA_DEF_READ_AHEAD";
            case 189:
                return "MQIA_READ_AHEAD";
            case 190:
                return "MQIA_PROPERTY_CONTROL";
            case 192:
                return "MQIA_MAX_PROPERTIES_LENGTH";
            case 193:
                return "MQIA_BASE_TYPE";
            case 195:
                return "MQIA_PM_DELIVERY";
            case 196:
                return "MQIA_NPM_DELIVERY";
            case 199:
                return "MQIA_PROXY_SUB";
            case 203:
                return "MQIA_PUBSUB_NP_MSG";
            case 204:
                return "MQIA_SUB_COUNT";
            case 205:
                return "MQIA_PUBSUB_NP_RESP";
            case 206:
                return "MQIA_PUBSUB_MAXMSG_RETRY_COUNT";
            case 207:
                return "MQIA_PUBSUB_SYNC_PT";
            case 208:
                return "MQIA_TOPIC_TYPE";
            case 215:
                return "MQIA_PUB_COUNT";
            case 216:
                return "MQIA_WILDCARD_OPERATION";
            case 218:
                return "MQIA_SUB_SCOPE";
            case 219:
                return "MQIA_PUB_SCOPE";
            case 221:
                return "MQIA_GROUP_UR";
            case 222:
                return "MQIA_UR_DISP";
            case 223:
                return "MQIA_COMM_INFO_TYPE";
            case 224:
                return "MQIA_CF_OFFLOAD";
            case 225:
                return "MQIA_CF_OFFLOAD_THRESHOLD1";
            case 226:
                return "MQIA_CF_OFFLOAD_THRESHOLD2";
            case 227:
                return "MQIA_CF_OFFLOAD_THRESHOLD3";
            case 228:
                return "MQIA_CF_SMDS_BUFFERS";
            case 229:
                return "MQIA_CF_OFFLDUSE";
            case 230:
                return "MQIA_MAX_RESPONSES";
            case 231:
                return "MQIA_RESPONSE_RESTART_POINT";
            case 232:
                return "MQIA_COMM_EVENT";
            case 233:
                return "MQIA_MCAST_BRIDGE";
            case 234:
                return "MQIA_USE_DEAD_LETTER_Q";
            case 235:
                return "MQIA_TOLERATE_UNPROTECTED";
            case 236:
                return "MQIA_SIGNATURE_ALGORITHM";
            case 237:
                return "MQIA_ENCRYPTION_ALGORITHM";
            case 238:
                return "MQIA_POLICY_VERSION";
            case 239:
                return "MQIA_ACTIVITY_CONN_OVERRIDE";
            case 240:
                return "MQIA_ACTIVITY_TRACE";
            case 242:
                return "MQIA_SUB_CONFIGURATION_EVENT";
            case 243:
                return "MQIA_XR_CAPABILITY";
            case 244:
                return "MQIA_CF_RECAUTO";
            case 245:
                return "MQIA_QMGR_CFCONLOS";
            case 246:
                return "MQIA_CF_CFCONLOS";
            case 247:
                return "MQIA_SUITE_B_STRENGTH";
            case 248:
                return "MQIA_CHLAUTH_RECORDS";
            case 249:
                return "MQIA_PUBSUB_CLUSTER";
            case 250:
                return "MQIA_DEF_CLUSTER_XMIT_Q_TYPE";
            case 251:
                return "MQIA_PROT_POLICY_CAPABILITY";
            case 252:
                return "MQIA_CERT_VAL_POLICY";
            case 253:
                return "MQIA_TOPIC_NODE_COUNT";
            case 254:
                return "MQIA_REVERSE_DNS_LOOKUP";
            case 255:
                return "MQIA_CLUSTER_PUB_ROUTE";
            case 256:
                return "MQIA_CLUSTER_OBJECT_STATE";
            case 257:
                return "MQIA_CHECK_LOCAL_BINDING";
            case 258:
                return "MQIA_CHECK_CLIENT_BINDING";
            case 259:
                return "MQIA_AUTHENTICATION_FAIL_DELAY";
            case 260:
                return "MQIA_ADOPT_CONTEXT";
            case 261:
                return "MQIA_LDAP_SECURE_COMM";
            case 262:
                return "MQIA_DISPLAY_TYPE";
            case 263:
                return "MQIA_LDAP_AUTHORMD";
            case 264:
                return "MQIA_LDAP_NESTGRP";
            case 265:
                return "MQIA_AMQP_CAPABILITY";
            case 266:
                return "MQIA_AUTHENTICATION_METHOD";
            case 267:
                return "MQIA_KEY_REUSE_COUNT";
            case 268:
                return "MQIA_MEDIA_IMAGE_SCHEDULING";
            case 269:
                return "MQIA_MEDIA_IMAGE_INTERVAL";
            case 270:
                return "MQIA_MEDIA_IMAGE_LOG_LENGTH";
            case 271:
                return "MQIA_MEDIA_IMAGE_RECOVER_OBJ";
            case 272:
                return "MQIA_MEDIA_IMAGE_RECOVER_Q";
            case 273:
                return "MQIA_ADVANCED_CAPABILITY";
            case 274:
                return "MQIA_MAX_Q_FILE_SIZE";
            case 2000:
                return "MQIA_USER_LIST";
            default:
                return "";
        }
    }

    public static String MQIDO_STR(int value) {
        switch (value) {
            case 1:
                return "MQIDO_COMMIT";
            case 2:
                return "MQIDO_BACKOUT";
            default:
                return "";
        }
    }

    public static String MQIEPF_STR(int value) {
        switch (value) {
            case 0:
                return "MQIEPF_NONE";
            case 1:
                return "MQIEPF_THREADED_LIBRARY";
            case 2:
                return "MQIEPF_LOCAL_LIBRARY";
            default:
                return "";
        }
    }

    public static String MQIGQPA_STR(int value) {
        switch (value) {
            case 1:
                return "MQIGQPA_DEFAULT";
            case 2:
                return "MQIGQPA_CONTEXT";
            case 3:
                return "MQIGQPA_ONLY_IGQ";
            case 4:
                return "MQIGQPA_ALTERNATE_OR_IGQ";
            default:
                return "";
        }
    }

    public static String MQIGQ_STR(int value) {
        switch (value) {
            case 0:
                return "MQIGQ_DISABLED";
            case 1:
                return "MQIGQ_ENABLED";
            default:
                return "";
        }
    }

    public static String MQIIH_STR(int value) {
        switch (value) {
            case 0:
                return "MQIIH_NONE";
            case 1:
                return "MQIIH_PASS_EXPIRATION";
            case 8:
                return "MQIIH_REPLY_FORMAT_NONE";
            case 16:
                return "MQIIH_IGNORE_PURG";
            case 32:
                return "MQIIH_CM0_REQUEST_RESPONSE";
            default:
                return "";
        }
    }

    public static String MQIMGRCOV_STR(int value) {
        switch (value) {
            case 0:
                return "MQIMGRCOV_NO";
            case 1:
                return "MQIMGRCOV_YES";
            case 2:
                return "MQIMGRCOV_AS_Q_MGR";
            default:
                return "";
        }
    }

    public static String MQIMMREASON_STR(int value) {
        switch (value) {
            case 0:
                return "MQIMMREASON_NONE";
            case 1:
                return "MQIMMREASON_NOT_CLIENT";
            case 2:
                return "MQIMMREASON_NOT_RECONNECTABLE";
            case 3:
                return "MQIMMREASON_MOVING";
            case 4:
                return "MQIMMREASON_APPLNAME_CHANGED";
            default:
                return "";
        }
    }

    public static String MQIMPO_STR(int value) {
        switch (value) {
            case 0:
                return "MQIMPO_NONE";
            case 2:
                return "MQIMPO_CONVERT_TYPE";
            case 4:
                return "MQIMPO_QUERY_LENGTH";
            case 8:
                return "MQIMPO_INQ_NEXT";
            case 16:
                return "MQIMPO_INQ_PROP_UNDER_CURSOR";
            case 32:
                return "MQIMPO_CONVERT_VALUE";
            default:
                return "";
        }
    }

    public static String MQINBD_STR(int value) {
        switch (value) {
            case 0:
                return "MQINBD_Q_MGR";
            case 3:
                return "MQINBD_GROUP";
            default:
                return "";
        }
    }

    public static String MQIND_STR(int value) {
        switch (value) {
            case -2:
                return "MQIND_ALL";
            case -1:
                return "MQIND_NONE";
            default:
                return "";
        }
    }

    public static String MQIPADDR_STR(int value) {
        switch (value) {
            case 0:
                return "MQIPADDR_IPV4";
            case 1:
                return "MQIPADDR_IPV6";
            default:
                return "";
        }
    }

    public static String MQIS_STR(int value) {
        switch (value) {
            case 0:
                return "MQIS_NO";
            case 1:
                return "MQIS_YES";
            default:
                return "";
        }
    }

    public static String MQIT_STR(int value) {
        switch (value) {
            case 0:
                return "MQIT_NONE";
            case 1:
                return "MQIT_MSG_ID";
            case 2:
                return "MQIT_CORREL_ID";
            case 4:
                return "MQIT_MSG_TOKEN";
            case 5:
                return "MQIT_GROUP_ID";
            default:
                return "";
        }
    }

    public static String MQKAI_STR(int value) {
        switch (value) {
            case -1:
                return "MQKAI_AUTO";
            default:
                return "";
        }
    }

    public static String MQKEY_STR(int value) {
        switch (value) {
            case -1:
                return "MQKEY_REUSE_UNLIMITED";
            case 0:
                return "MQKEY_REUSE_DISABLED";
            default:
                return "";
        }
    }

    public static String MQLDAPC_STR(int value) {
        switch (value) {
            case 0:
                return "MQLDAPC_INACTIVE";
            case 1:
                return "MQLDAPC_CONNECTED";
            case 2:
                return "MQLDAPC_ERROR";
            default:
                return "";
        }
    }

    public static String MQLDAP_AUTHORMD_STR(int value) {
        switch (value) {
            case 0:
                return "MQLDAP_AUTHORMD_OS";
            case 1:
                return "MQLDAP_AUTHORMD_SEARCHGRP";
            case 2:
                return "MQLDAP_AUTHORMD_SEARCHUSR";
            case 3:
                return "MQLDAP_AUTHORMD_SRCHGRPSN";
            default:
                return "";
        }
    }

    public static String MQLDAP_NESTGRP_STR(int value) {
        switch (value) {
            case 0:
                return "MQLDAP_NESTGRP_NO";
            case 1:
                return "MQLDAP_NESTGRP_YES";
            default:
                return "";
        }
    }

    public static String MQLR_STR(int value) {
        switch (value) {
            case -2:
                return "MQLR_MAX";
            case -1:
                return "MQLR_AUTO";
            case 1:
                return "MQLR_ONE";
            default:
                return "";
        }
    }

    public static String MQMASTER_STR(int value) {
        switch (value) {
            case 0:
                return "MQMASTER_NO";
            case 1:
                return "MQMASTER_YES";
            default:
                return "";
        }
    }

    public static String MQMATCH_STR(int value) {
        switch (value) {
            case 0:
                return "MQMATCH_GENERIC";
            case 1:
                return "MQMATCH_RUNCHECK";
            case 2:
                return "MQMATCH_EXACT";
            case 3:
                return "MQMATCH_ALL";
            default:
                return "";
        }
    }

    public static String MQMCAS_STR(int value) {
        switch (value) {
            case 0:
                return "MQMCAS_STOPPED";
            case 3:
                return "MQMCAS_RUNNING";
            default:
                return "";
        }
    }

    public static String MQMCAT_STR(int value) {
        switch (value) {
            case 1:
                return "MQMCAT_PROCESS";
            case 2:
                return "MQMCAT_THREAD";
            default:
                return "";
        }
    }

    public static String MQMCB_STR(int value) {
        switch (value) {
            case 0:
                return "MQMCB_DISABLED";
            case 1:
                return "MQMCB_ENABLED";
            default:
                return "";
        }
    }

    public static String MQMCEV_STR(int value) {
        switch (value) {
            case 1:
                return "MQMCEV_PACKET_LOSS";
            case 2:
                return "MQMCEV_HEARTBEAT_TIMEOUT";
            case 3:
                return "MQMCEV_VERSION_CONFLICT";
            case 4:
                return "MQMCEV_RELIABILITY";
            case 5:
                return "MQMCEV_CLOSED_TRANS";
            case 6:
                return "MQMCEV_STREAM_ERROR";
            case 10:
                return "MQMCEV_NEW_SOURCE";
            case 11:
                return "MQMCEV_RECEIVE_QUEUE_TRIMMED";
            case 12:
                return "MQMCEV_PACKET_LOSS_NACK_EXPIRE";
            case 13:
                return "MQMCEV_ACK_RETRIES_EXCEEDED";
            case 14:
                return "MQMCEV_STREAM_SUSPEND_NACK";
            case 15:
                return "MQMCEV_STREAM_RESUME_NACK";
            case 16:
                return "MQMCEV_STREAM_EXPELLED";
            case 20:
                return "MQMCEV_FIRST_MESSAGE";
            case 21:
                return "MQMCEV_LATE_JOIN_FAILURE";
            case 22:
                return "MQMCEV_MESSAGE_LOSS";
            case 23:
                return "MQMCEV_SEND_PACKET_FAILURE";
            case 24:
                return "MQMCEV_REPAIR_DELAY";
            case 25:
                return "MQMCEV_MEMORY_ALERT_ON";
            case 26:
                return "MQMCEV_MEMORY_ALERT_OFF";
            case 27:
                return "MQMCEV_NACK_ALERT_ON";
            case 28:
                return "MQMCEV_NACK_ALERT_OFF";
            case 29:
                return "MQMCEV_REPAIR_ALERT_ON";
            case 30:
                return "MQMCEV_REPAIR_ALERT_OFF";
            case 31:
                return "MQMCEV_RELIABILITY_CHANGED";
            case 80:
                return "MQMCEV_SHM_DEST_UNUSABLE";
            case 81:
                return "MQMCEV_SHM_PORT_UNUSABLE";
            case 110:
                return "MQMCEV_CCT_GETTIME_FAILED";
            case 120:
                return "MQMCEV_DEST_INTERFACE_FAILURE";
            case 121:
                return "MQMCEV_DEST_INTERFACE_FAILOVER";
            case 122:
                return "MQMCEV_PORT_INTERFACE_FAILURE";
            case 123:
                return "MQMCEV_PORT_INTERFACE_FAILOVER";
            default:
                return "";
        }
    }

    public static String MQMCP_STR(int value) {
        switch (value) {
            case -2:
                return "MQMCP_COMPAT";
            case -1:
                return "MQMCP_ALL";
            case 0:
                return "MQMCP_NONE";
            case 1:
                return "MQMCP_USER";
            case 2:
                return "MQMCP_REPLY";
            default:
                return "";
        }
    }

    public static String MQMC_STR(int value) {
        switch (value) {
            case 0:
                return "MQMC_AS_PARENT";
            case 1:
                return "MQMC_ENABLED";
            case 2:
                return "MQMC_DISABLED";
            case 3:
                return "MQMC_ONLY";
            default:
                return "";
        }
    }

    public static String MQMDEF_STR(int value) {
        switch (value) {
            case 0:
                return "MQMDEF_NONE";
            default:
                return "";
        }
    }

    public static String MQMDS_STR(int value) {
        switch (value) {
            case 0:
                return "MQMDS_PRIORITY";
            case 1:
                return "MQMDS_FIFO";
            default:
                return "";
        }
    }

    public static String MQMEDIMGINTVL_STR(int value) {
        switch (value) {
            case 0:
                return "MQMEDIMGINTVL_OFF";
            default:
                return "";
        }
    }

    public static String MQMEDIMGLOGLN_STR(int value) {
        switch (value) {
            case 0:
                return "MQMEDIMGLOGLN_OFF";
            default:
                return "";
        }
    }

    public static String MQMEDIMGSCHED_STR(int value) {
        switch (value) {
            case 0:
                return "MQMEDIMGSCHED_MANUAL";
            case 1:
                return "MQMEDIMGSCHED_AUTO";
            default:
                return "";
        }
    }

    public static String MQMF_STR(int value) {
        switch (value) {
            case -1048576:
                return "MQMF_ACCEPT_UNSUP_MASK";
            case 0:
                return "MQMF_NONE";
            case 1:
                return "MQMF_SEGMENTATION_ALLOWED";
            case 2:
                return "MQMF_SEGMENT";
            case 4:
                return "MQMF_LAST_SEGMENT";
            case 8:
                return "MQMF_MSG_IN_GROUP";
            case 16:
                return "MQMF_LAST_MSG_IN_GROUP";
            case 4095:
                return "MQMF_REJECT_UNSUP_MASK";
            case 1044480:
                return "MQMF_ACCEPT_UNSUP_IF_XMIT_MASK";
            default:
                return "";
        }
    }

    public static String MQMHBO_STR(int value) {
        switch (value) {
            case 0:
                return "MQMHBO_NONE";
            case 1:
                return "MQMHBO_PROPERTIES_IN_MQRFH2";
            case 2:
                return "MQMHBO_DELETE_PROPERTIES";
            default:
                return "";
        }
    }

    public static String MQMLP_ENCRYPTION_STR(int value) {
        switch (value) {
            case 0:
                return "MQMLP_ENCRYPTION_ALG_NONE";
            case 1:
                return "MQMLP_ENCRYPTION_ALG_RC2";
            case 2:
                return "MQMLP_ENCRYPTION_ALG_DES";
            case 3:
                return "MQMLP_ENCRYPTION_ALG_3DES";
            case 4:
                return "MQMLP_ENCRYPTION_ALG_AES128";
            case 5:
                return "MQMLP_ENCRYPTION_ALG_AES256";
            default:
                return "";
        }
    }

    public static String MQMLP_SIGN_STR(int value) {
        switch (value) {
            case 0:
                return "MQMLP_SIGN_ALG_NONE";
            case 1:
                return "MQMLP_SIGN_ALG_MD5";
            case 2:
                return "MQMLP_SIGN_ALG_SHA1";
            case 3:
                return "MQMLP_SIGN_ALG_SHA224";
            case 4:
                return "MQMLP_SIGN_ALG_SHA256";
            case 5:
                return "MQMLP_SIGN_ALG_SHA384";
            case 6:
                return "MQMLP_SIGN_ALG_SHA512";
            default:
                return "";
        }
    }

    public static String MQMLP_TOLERATE_STR(int value) {
        switch (value) {
            case 0:
                return "MQMLP_TOLERATE_UNPROTECTED_NO";
            case 1:
                return "MQMLP_TOLERATE_UNPROTECTED_YES";
            default:
                return "";
        }
    }

    public static String MQMMBI_STR(int value) {
        switch (value) {
            case -1:
                return "MQMMBI_UNLIMITED";
            default:
                return "";
        }
    }

    public static String MQMODE_STR(int value) {
        switch (value) {
            case 0:
                return "MQMODE_FORCE";
            case 1:
                return "MQMODE_QUIESCE";
            case 2:
                return "MQMODE_TERMINATE";
            default:
                return "";
        }
    }

    public static String MQMON_STR(int value) {
        switch (value) {
            case -3:
                return "MQMON_Q_MGR";
            case -1:
                return "MQMON_NONE";
            case 0:
                return "MQMON_OFF";
            case 1:
                return "MQMON_ON";
            case 17:
                return "MQMON_LOW";
            case 33:
                return "MQMON_MEDIUM";
            case 65:
                return "MQMON_HIGH";
            default:
                return "";
        }
    }

    public static String MQMO_STR(int value) {
        switch (value) {
            case 0:
                return "MQMO_NONE";
            case 1:
                return "MQMO_MATCH_MSG_ID";
            case 2:
                return "MQMO_MATCH_CORREL_ID";
            case 4:
                return "MQMO_MATCH_GROUP_ID";
            case 8:
                return "MQMO_MATCH_MSG_SEQ_NUMBER";
            case 16:
                return "MQMO_MATCH_OFFSET";
            case 32:
                return "MQMO_MATCH_MSG_TOKEN";
            default:
                return "";
        }
    }

    public static String MQMT_STR(int value) {
        switch (value) {
            case 1:
                return "MQMT_REQUEST";
            case 2:
                return "MQMT_REPLY";
            case 4:
                return "MQMT_REPORT";
            case 8:
                return "MQMT_DATAGRAM";
            case 112:
                return "MQMT_MQE_FIELDS_FROM_MQE";
            case 113:
                return "MQMT_MQE_FIELDS";
            default:
                return "";
        }
    }

    public static String MQMULC_STR(int value) {
        switch (value) {
            case 0:
                return "MQMULC_STANDARD";
            case 1:
                return "MQMULC_REFINED";
            default:
                return "";
        }
    }

    public static String MQNC_STR(int value) {
        switch (value) {
            case 256:
                return "MQNC_MAX_NAMELIST_NAME_COUNT";
            default:
                return "";
        }
    }

    public static String MQNPMS_STR(int value) {
        switch (value) {
            case 1:
                return "MQNPMS_NORMAL";
            case 2:
                return "MQNPMS_FAST";
            default:
                return "";
        }
    }

    public static String MQNPM_STR(int value) {
        switch (value) {
            case 0:
                return "MQNPM_CLASS_NORMAL";
            case 10:
                return "MQNPM_CLASS_HIGH";
            default:
                return "";
        }
    }

    public static String MQNSH_STR(int value) {
        switch (value) {
            case -1:
                return "MQNSH_ALL";
            case 0:
                return "MQNSH_NONE";
            default:
                return "";
        }
    }

    public static String MQNT_STR(int value) {
        switch (value) {
            case 0:
                return "MQNT_NONE";
            case 1:
                return "MQNT_Q";
            case 2:
                return "MQNT_CLUSTER";
            case 4:
                return "MQNT_AUTH_INFO";
            case 1001:
                return "MQNT_ALL";
            default:
                return "";
        }
    }

    public static String MQOL_STR(int value) {
        switch (value) {
            case -1:
                return "MQOL_UNDEFINED";
            default:
                return "";
        }
    }

    public static String MQOM_STR(int value) {
        switch (value) {
            case 0:
                return "MQOM_NO";
            case 1:
                return "MQOM_YES";
            default:
                return "";
        }
    }

    public static String MQOO_STR(int value) {
        switch (value) {
            case 0:
                return "MQOO_READ_AHEAD_AS_Q_DEF";
            case 1:
                return "MQOO_INPUT_AS_Q_DEF";
            case 2:
                return "MQOO_INPUT_SHARED";
            case 4:
                return "MQOO_INPUT_EXCLUSIVE";
            case 8:
                return "MQOO_BROWSE";
            case 16:
                return "MQOO_OUTPUT";
            case 32:
                return "MQOO_INQUIRE";
            case 64:
                return "MQOO_SET";
            case 128:
                return "MQOO_SAVE_ALL_CONTEXT";
            case 256:
                return "MQOO_PASS_IDENTITY_CONTEXT";
            case 512:
                return "MQOO_PASS_ALL_CONTEXT";
            case 1024:
                return "MQOO_SET_IDENTITY_CONTEXT";
            case 2048:
                return "MQOO_SET_ALL_CONTEXT";
            case 4096:
                return "MQOO_ALTERNATE_USER_AUTHORITY";
            case 8192:
                return "MQOO_FAIL_IF_QUIESCING";
            case 16384:
                return "MQOO_BIND_ON_OPEN";
            case 32768:
                return "MQOO_BIND_NOT_FIXED";
            case 65536:
                return "MQOO_RESOLVE_NAMES";
            case 131072:
                return "MQOO_CO_OP";
            case 262144:
                return "MQOO_RESOLVE_LOCAL_Q";
            case 524288:
                return "MQOO_NO_READ_AHEAD";
            case 1048576:
                return "MQOO_READ_AHEAD";
            case 2097152:
                return "MQOO_NO_MULTICAST";
            case 4194304:
                return "MQOO_BIND_ON_GROUP";
            default:
                return "";
        }
    }

    public static String MQOPER_STR(int value) {
        switch (value) {
            case 0:
                return "MQOPER_UNKNOWN";
            case 1:
                return "MQOPER_BROWSE";
            case 2:
                return "MQOPER_DISCARD";
            case 3:
                return "MQOPER_GET";
            case 4:
                return "MQOPER_PUT";
            case 5:
                return "MQOPER_PUT_REPLY";
            case 6:
                return "MQOPER_PUT_REPORT";
            case 7:
                return "MQOPER_RECEIVE";
            case 8:
                return "MQOPER_SEND";
            case 9:
                return "MQOPER_TRANSFORM";
            case 10:
                return "MQOPER_PUBLISH";
            case 11:
                return "MQOPER_EXCLUDED_PUBLISH";
            case 12:
                return "MQOPER_DISCARDED_PUBLISH";
            default:
                return "";
        }
    }

    public static String MQOPMODE_STR(int value) {
        switch (value) {
            case 0:
                return "MQOPMODE_COMPAT";
            case 1:
                return "MQOPMODE_NEW_FUNCTION";
            default:
                return "";
        }
    }

    public static String MQOP_STR(int value) {
        switch (value) {
            case 1:
                return "MQOP_START";
            case 2:
                return "MQOP_START_WAIT";
            case 4:
                return "MQOP_STOP";
            case 256:
                return "MQOP_REGISTER";
            case 512:
                return "MQOP_DEREGISTER";
            case 65536:
                return "MQOP_SUSPEND";
            case 131072:
                return "MQOP_RESUME";
            default:
                return "";
        }
    }

    public static String MQOT_STR(int value) {
        switch (value) {
            case 0:
                return "MQOT_NONE";
            case 1:
                return "MQOT_Q";
            case 2:
                return "MQOT_NAMELIST";
            case 3:
                return "MQOT_PROCESS";
            case 4:
                return "MQOT_STORAGE_CLASS";
            case 5:
                return "MQOT_Q_MGR";
            case 6:
                return "MQOT_CHANNEL";
            case 7:
                return "MQOT_AUTH_INFO";
            case 8:
                return "MQOT_TOPIC";
            case 9:
                return "MQOT_COMM_INFO";
            case 10:
                return "MQOT_CF_STRUC";
            case 11:
                return "MQOT_LISTENER";
            case 12:
                return "MQOT_SERVICE";
            case 999:
                return "MQOT_RESERVED_1";
            case 1001:
                return "MQOT_ALL";
            case 1002:
                return "MQOT_ALIAS_Q";
            case 1003:
                return "MQOT_MODEL_Q";
            case 1004:
                return "MQOT_LOCAL_Q";
            case 1005:
                return "MQOT_REMOTE_Q";
            case 1007:
                return "MQOT_SENDER_CHANNEL";
            case 1008:
                return "MQOT_SERVER_CHANNEL";
            case 1009:
                return "MQOT_REQUESTER_CHANNEL";
            case 1010:
                return "MQOT_RECEIVER_CHANNEL";
            case 1011:
                return "MQOT_CURRENT_CHANNEL";
            case 1012:
                return "MQOT_SAVED_CHANNEL";
            case 1013:
                return "MQOT_SVRCONN_CHANNEL";
            case 1014:
                return "MQOT_CLNTCONN_CHANNEL";
            case 1015:
                return "MQOT_SHORT_CHANNEL";
            case 1016:
                return "MQOT_CHLAUTH";
            case 1017:
                return "MQOT_REMOTE_Q_MGR_NAME";
            case 1019:
                return "MQOT_PROT_POLICY";
            case 1020:
                return "MQOT_TT_CHANNEL";
            case 1021:
                return "MQOT_AMQP_CHANNEL";
            case 1022:
                return "MQOT_AUTH_REC";
            default:
                return "";
        }
    }

    public static String MQPAGECLAS_STR(int value) {
        switch (value) {
            case 0:
                return "MQPAGECLAS_4KB";
            case 1:
                return "MQPAGECLAS_FIXED4KB";
            default:
                return "";
        }
    }

    public static String MQPA_STR(int value) {
        switch (value) {
            case 1:
                return "MQPA_DEFAULT";
            case 2:
                return "MQPA_CONTEXT";
            case 3:
                return "MQPA_ONLY_MCA";
            case 4:
                return "MQPA_ALTERNATE_OR_MCA";
            default:
                return "";
        }
    }

    public static String MQPD_STR(int value) {
        switch (value) {
            case -1048576:
                return "MQPD_REJECT_UNSUP_MASK";
            case 0:
                return "MQPD_NONE";
            case 1:
                return "MQPD_SUPPORT_OPTIONAL";
            case 1023:
                return "MQPD_ACCEPT_UNSUP_MASK";
            case 1024:
                return "MQPD_SUPPORT_REQUIRED_IF_LOCAL";
            case 1047552:
                return "MQPD_ACCEPT_UNSUP_IF_XMIT_MASK";
            case 1048576:
                return "MQPD_SUPPORT_REQUIRED";
            default:
                return "";
        }
    }

    public static String MQPER_STR(int value) {
        switch (value) {
            case -1:
                return "MQPER_PERSISTENCE_AS_PARENT";
            case 0:
                return "MQPER_NOT_PERSISTENT";
            case 1:
                return "MQPER_PERSISTENT";
            case 2:
                return "MQPER_PERSISTENCE_AS_Q_DEF";
            default:
                return "";
        }
    }

    public static String MQPL_STR(int value) {
        switch (value) {
            case 1:
                return "MQPL_ZOS";
            case 2:
                return "MQPL_OS2";
            case 3:
                return "MQPL_UNIX";
            case 4:
                return "MQPL_OS400";
            case 5:
                return "MQPL_WINDOWS";
            case 11:
                return "MQPL_WINDOWS_NT";
            case 12:
                return "MQPL_VMS";
            case 13:
                return "MQPL_NSK";
            case 15:
                return "MQPL_OPEN_TP1";
            case 18:
                return "MQPL_VM";
            case 23:
                return "MQPL_TPF";
            case 27:
                return "MQPL_VSE";
            case 28:
                return "MQPL_APPLIANCE";
            default:
                return "";
        }
    }

    public static String MQPMO_STR(int value) {
        switch (value) {
            case 0:
                return "MQPMO_NONE";
            case 2:
                return "MQPMO_SYNCPOINT";
            case 4:
                return "MQPMO_NO_SYNCPOINT";
            case 32:
                return "MQPMO_DEFAULT_CONTEXT";
            case 64:
                return "MQPMO_NEW_MSG_ID";
            case 128:
                return "MQPMO_NEW_CORREL_ID";
            case 256:
                return "MQPMO_PASS_IDENTITY_CONTEXT";
            case 512:
                return "MQPMO_PASS_ALL_CONTEXT";
            case 1024:
                return "MQPMO_SET_IDENTITY_CONTEXT";
            case 2048:
                return "MQPMO_SET_ALL_CONTEXT";
            case 4096:
                return "MQPMO_ALTERNATE_USER_AUTHORITY";
            case 8192:
                return "MQPMO_FAIL_IF_QUIESCING";
            case 16384:
                return "MQPMO_NO_CONTEXT";
            case 32768:
                return "MQPMO_LOGICAL_ORDER";
            case 65536:
                return "MQPMO_ASYNC_RESPONSE";
            case 131072:
                return "MQPMO_SYNC_RESPONSE";
            case 262144:
                return "MQPMO_RESOLVE_LOCAL_Q";
            case 524288:
                return "MQPMO_WARN_IF_NO_SUBS_MATCHED";
            case 2097152:
                return "MQPMO_RETAIN";
            case 8388608:
                return "MQPMO_MD_FOR_OUTPUT_ONLY";
            case 67108864:
                return "MQPMO_SCOPE_QMGR";
            case 134217728:
                return "MQPMO_SUPPRESS_REPLYTO";
            case 268435456:
                return "MQPMO_NOT_OWN_SUBS";
            default:
                return "";
        }
    }

    public static String MQPMRF_STR(int value) {
        switch (value) {
            case 0:
                return "MQPMRF_NONE";
            case 1:
                return "MQPMRF_MSG_ID";
            case 2:
                return "MQPMRF_CORREL_ID";
            case 4:
                return "MQPMRF_GROUP_ID";
            case 8:
                return "MQPMRF_FEEDBACK";
            case 16:
                return "MQPMRF_ACCOUNTING_TOKEN";
            default:
                return "";
        }
    }

    public static String MQPO_STR(int value) {
        switch (value) {
            case 0:
                return "MQPO_NO";
            case 1:
                return "MQPO_YES";
            default:
                return "";
        }
    }

    public static String MQPRI_STR(int value) {
        switch (value) {
            case -3:
                return "MQPRI_PRIORITY_AS_PUBLISHED";
            case -2:
                return "MQPRI_PRIORITY_AS_PARENT";
            case -1:
                return "MQPRI_PRIORITY_AS_Q_DEF";
            default:
                return "";
        }
    }

    public static String MQPROP_STR(int value) {
        switch (value) {
            case -1:
                return "MQPROP_UNRESTRICTED_LENGTH";
            case 0:
                return "MQPROP_COMPATIBILITY";
            case 1:
                return "MQPROP_NONE";
            case 2:
                return "MQPROP_ALL";
            case 3:
                return "MQPROP_FORCE_MQRFH2";
            case 4:
                return "MQPROP_V6COMPAT";
            default:
                return "";
        }
    }

    public static String MQPROTO_STR(int value) {
        switch (value) {
            case 1:
                return "MQPROTO_MQTTV3";
            case 2:
                return "MQPROTO_HTTP";
            case 3:
                return "MQPROTO_AMQP";
            case 4:
                return "MQPROTO_MQTTV311";
            default:
                return "";
        }
    }

    public static String MQPRT_STR(int value) {
        switch (value) {
            case 0:
                return "MQPRT_RESPONSE_AS_PARENT";
            case 1:
                return "MQPRT_SYNC_RESPONSE";
            case 2:
                return "MQPRT_ASYNC_RESPONSE";
            default:
                return "";
        }
    }

    public static String MQPSCLUS_STR(int value) {
        switch (value) {
            case 0:
                return "MQPSCLUS_DISABLED";
            case 1:
                return "MQPSCLUS_ENABLED";
            default:
                return "";
        }
    }

    public static String MQPSCT_STR(int value) {
        switch (value) {
            case -1:
                return "MQPSCT_NONE";
            default:
                return "";
        }
    }

    public static String MQPSM_STR(int value) {
        switch (value) {
            case 0:
                return "MQPSM_DISABLED";
            case 1:
                return "MQPSM_COMPAT";
            case 2:
                return "MQPSM_ENABLED";
            default:
                return "";
        }
    }

    public static String MQPSPROP_STR(int value) {
        switch (value) {
            case 0:
                return "MQPSPROP_NONE";
            case 1:
                return "MQPSPROP_COMPAT";
            case 2:
                return "MQPSPROP_RFH2";
            case 3:
                return "MQPSPROP_MSGPROP";
            default:
                return "";
        }
    }

    public static String MQPSST_STR(int value) {
        switch (value) {
            case 0:
                return "MQPSST_ALL";
            case 1:
                return "MQPSST_LOCAL";
            case 2:
                return "MQPSST_PARENT";
            case 3:
                return "MQPSST_CHILD";
            default:
                return "";
        }
    }

    public static String MQPS_STR(int value) {
        switch (value) {
            case 0:
                return "MQPS_STATUS_INACTIVE";
            case 1:
                return "MQPS_STATUS_STARTING";
            case 2:
                return "MQPS_STATUS_STOPPING";
            case 3:
                return "MQPS_STATUS_ACTIVE";
            case 4:
                return "MQPS_STATUS_COMPAT";
            case 5:
                return "MQPS_STATUS_ERROR";
            case 6:
                return "MQPS_STATUS_REFUSED";
            default:
                return "";
        }
    }

    public static String MQPUBO_STR(int value) {
        switch (value) {
            case 0:
                return "MQPUBO_NONE";
            case 1:
                return "MQPUBO_CORREL_ID_AS_IDENTITY";
            case 2:
                return "MQPUBO_RETAIN_PUBLICATION";
            case 4:
                return "MQPUBO_OTHER_SUBSCRIBERS_ONLY";
            case 8:
                return "MQPUBO_NO_REGISTRATION";
            case 16:
                return "MQPUBO_IS_RETAINED_PUBLICATION";
            default:
                return "";
        }
    }

    public static String MQQA_BACKOUT_STR(int value) {
        switch (value) {
            case 0:
                return "MQQA_BACKOUT_NOT_HARDENED";
            case 1:
                return "MQQA_BACKOUT_HARDENED";
            default:
                return "";
        }
    }

    public static String MQQA_GET_STR(int value) {
        switch (value) {
            case 0:
                return "MQQA_GET_ALLOWED";
            case 1:
                return "MQQA_GET_INHIBITED";
            default:
                return "";
        }
    }

    public static String MQQA_PUT_STR(int value) {
        switch (value) {
            case 0:
                return "MQQA_PUT_ALLOWED";
            case 1:
                return "MQQA_PUT_INHIBITED";
            default:
                return "";
        }
    }

    public static String MQQDT_STR(int value) {
        switch (value) {
            case 1:
                return "MQQDT_PREDEFINED";
            case 2:
                return "MQQDT_PERMANENT_DYNAMIC";
            case 3:
                return "MQQDT_TEMPORARY_DYNAMIC";
            case 4:
                return "MQQDT_SHARED_DYNAMIC";
            default:
                return "";
        }
    }

    public static String MQQFS_STR(int value) {
        switch (value) {
            case -1:
                return "MQQFS_DEFAULT";
            default:
                return "";
        }
    }

    public static String MQQF_STR(int value) {
        switch (value) {
            case 1:
                return "MQQF_LOCAL_Q";
            case 64:
                return "MQQF_CLWL_USEQ_ANY";
            case 128:
                return "MQQF_CLWL_USEQ_LOCAL";
            default:
                return "";
        }
    }

    public static String MQQMDT_STR(int value) {
        switch (value) {
            case 1:
                return "MQQMDT_EXPLICIT_CLUSTER_SENDER";
            case 2:
                return "MQQMDT_AUTO_CLUSTER_SENDER";
            case 3:
                return "MQQMDT_CLUSTER_RECEIVER";
            case 4:
                return "MQQMDT_AUTO_EXP_CLUSTER_SENDER";
            default:
                return "";
        }
    }

    public static String MQQMFAC_STR(int value) {
        switch (value) {
            case 1:
                return "MQQMFAC_IMS_BRIDGE";
            case 2:
                return "MQQMFAC_DB2";
            default:
                return "";
        }
    }

    public static String MQQMF_STR(int value) {
        switch (value) {
            case 2:
                return "MQQMF_REPOSITORY_Q_MGR";
            case 8:
                return "MQQMF_CLUSSDR_USER_DEFINED";
            case 16:
                return "MQQMF_CLUSSDR_AUTO_DEFINED";
            case 32:
                return "MQQMF_AVAILABLE";
            default:
                return "";
        }
    }

    public static String MQQMOPT_STR(int value) {
        switch (value) {
            case 0:
                return "MQQMOPT_DISABLED";
            case 1:
                return "MQQMOPT_ENABLED";
            case 2:
                return "MQQMOPT_REPLY";
            default:
                return "";
        }
    }

    public static String MQQMSTA_STR(int value) {
        switch (value) {
            case 1:
                return "MQQMSTA_STARTING";
            case 2:
                return "MQQMSTA_RUNNING";
            case 3:
                return "MQQMSTA_QUIESCING";
            case 4:
                return "MQQMSTA_STANDBY";
            default:
                return "";
        }
    }

    public static String MQQMT_STR(int value) {
        switch (value) {
            case 0:
                return "MQQMT_NORMAL";
            case 1:
                return "MQQMT_REPOSITORY";
            default:
                return "";
        }
    }

    public static String MQQO_STR(int value) {
        switch (value) {
            case 0:
                return "MQQO_NO";
            case 1:
                return "MQQO_YES";
            default:
                return "";
        }
    }

    public static String MQQSGD_STR(int value) {
        switch (value) {
            case -1:
                return "MQQSGD_ALL";
            case 0:
                return "MQQSGD_Q_MGR";
            case 1:
                return "MQQSGD_COPY";
            case 2:
                return "MQQSGD_SHARED";
            case 3:
                return "MQQSGD_GROUP";
            case 4:
                return "MQQSGD_PRIVATE";
            case 6:
                return "MQQSGD_LIVE";
            default:
                return "";
        }
    }

    public static String MQQSGS_STR(int value) {
        switch (value) {
            case 0:
                return "MQQSGS_UNKNOWN";
            case 1:
                return "MQQSGS_CREATED";
            case 2:
                return "MQQSGS_ACTIVE";
            case 3:
                return "MQQSGS_INACTIVE";
            case 4:
                return "MQQSGS_FAILED";
            case 5:
                return "MQQSGS_PENDING";
            default:
                return "";
        }
    }

    public static String MQQSIE_STR(int value) {
        switch (value) {
            case 0:
                return "MQQSIE_NONE";
            case 1:
                return "MQQSIE_HIGH";
            case 2:
                return "MQQSIE_OK";
            default:
                return "";
        }
    }

    public static String MQQSOT_STR(int value) {
        switch (value) {
            case 1:
                return "MQQSOT_ALL";
            case 2:
                return "MQQSOT_INPUT";
            case 3:
                return "MQQSOT_OUTPUT";
            default:
                return "";
        }
    }

    public static String MQQSO_STR(int value) {
        switch (value) {
            case 0:
                return "MQQSO_NO";
            case 1:
                return "MQQSO_YES";
            case 2:
                return "MQQSO_EXCLUSIVE";
            default:
                return "";
        }
    }

    public static String MQQSUM_STR(int value) {
        switch (value) {
            case 0:
                return "MQQSUM_NO";
            case 1:
                return "MQQSUM_YES";
            default:
                return "";
        }
    }

    public static String MQQT_STR(int value) {
        switch (value) {
            case 1:
                return "MQQT_LOCAL";
            case 2:
                return "MQQT_MODEL";
            case 3:
                return "MQQT_ALIAS";
            case 6:
                return "MQQT_REMOTE";
            case 7:
                return "MQQT_CLUSTER";
            case 1001:
                return "MQQT_ALL";
            default:
                return "";
        }
    }

    public static String MQRAR_STR(int value) {
        switch (value) {
            case 0:
                return "MQRAR_NO";
            case 1:
                return "MQRAR_YES";
            default:
                return "";
        }
    }

    public static String MQRCCF_STR(int value) {
        switch (value) {
            case 3001:
                return "MQRCCF_CFH_TYPE_ERROR";
            case 3002:
                return "MQRCCF_CFH_LENGTH_ERROR";
            case 3003:
                return "MQRCCF_CFH_VERSION_ERROR";
            case 3004:
                return "MQRCCF_CFH_MSG_SEQ_NUMBER_ERR";
            case 3005:
                return "MQRCCF_CFH_CONTROL_ERROR";
            case 3006:
                return "MQRCCF_CFH_PARM_COUNT_ERROR";
            case 3007:
                return "MQRCCF_CFH_COMMAND_ERROR";
            case 3008:
                return "MQRCCF_COMMAND_FAILED";
            case 3009:
                return "MQRCCF_CFIN_LENGTH_ERROR";
            case 3010:
                return "MQRCCF_CFST_LENGTH_ERROR";
            case 3011:
                return "MQRCCF_CFST_STRING_LENGTH_ERR";
            case 3012:
                return "MQRCCF_FORCE_VALUE_ERROR";
            case 3013:
                return "MQRCCF_STRUCTURE_TYPE_ERROR";
            case 3014:
                return "MQRCCF_CFIN_PARM_ID_ERROR";
            case 3015:
                return "MQRCCF_CFST_PARM_ID_ERROR";
            case 3016:
                return "MQRCCF_MSG_LENGTH_ERROR";
            case 3017:
                return "MQRCCF_CFIN_DUPLICATE_PARM";
            case 3018:
                return "MQRCCF_CFST_DUPLICATE_PARM";
            case 3019:
                return "MQRCCF_PARM_COUNT_TOO_SMALL";
            case 3020:
                return "MQRCCF_PARM_COUNT_TOO_BIG";
            case 3021:
                return "MQRCCF_Q_ALREADY_IN_CELL";
            case 3022:
                return "MQRCCF_Q_TYPE_ERROR";
            case 3023:
                return "MQRCCF_MD_FORMAT_ERROR";
            case 3024:
                return "MQRCCF_CFSL_LENGTH_ERROR";
            case 3025:
                return "MQRCCF_REPLACE_VALUE_ERROR";
            case 3026:
                return "MQRCCF_CFIL_DUPLICATE_VALUE";
            case 3027:
                return "MQRCCF_CFIL_COUNT_ERROR";
            case 3028:
                return "MQRCCF_CFIL_LENGTH_ERROR";
            case 3029:
                return "MQRCCF_QUIESCE_VALUE_ERROR";
            case 3030:
                return "MQRCCF_MSG_SEQ_NUMBER_ERROR";
            case 3031:
                return "MQRCCF_PING_DATA_COUNT_ERROR";
            case 3032:
                return "MQRCCF_PING_DATA_COMPARE_ERROR";
            case 3033:
                return "MQRCCF_CFSL_PARM_ID_ERROR";
            case 3034:
                return "MQRCCF_CHANNEL_TYPE_ERROR";
            case 3035:
                return "MQRCCF_PARM_SEQUENCE_ERROR";
            case 3036:
                return "MQRCCF_XMIT_PROTOCOL_TYPE_ERR";
            case 3037:
                return "MQRCCF_BATCH_SIZE_ERROR";
            case 3038:
                return "MQRCCF_DISC_INT_ERROR";
            case 3039:
                return "MQRCCF_SHORT_RETRY_ERROR";
            case 3040:
                return "MQRCCF_SHORT_TIMER_ERROR";
            case 3041:
                return "MQRCCF_LONG_RETRY_ERROR";
            case 3042:
                return "MQRCCF_LONG_TIMER_ERROR";
            case 3043:
                return "MQRCCF_SEQ_NUMBER_WRAP_ERROR";
            case 3044:
                return "MQRCCF_MAX_MSG_LENGTH_ERROR";
            case 3045:
                return "MQRCCF_PUT_AUTH_ERROR";
            case 3046:
                return "MQRCCF_PURGE_VALUE_ERROR";
            case 3047:
                return "MQRCCF_CFIL_PARM_ID_ERROR";
            case 3048:
                return "MQRCCF_MSG_TRUNCATED";
            case 3049:
                return "MQRCCF_CCSID_ERROR";
            case 3050:
                return "MQRCCF_ENCODING_ERROR";
            case 3051:
                return "MQRCCF_QUEUES_VALUE_ERROR";
            case 3052:
                return "MQRCCF_DATA_CONV_VALUE_ERROR";
            case 3053:
                return "MQRCCF_INDOUBT_VALUE_ERROR";
            case 3054:
                return "MQRCCF_ESCAPE_TYPE_ERROR";
            case 3055:
                return "MQRCCF_REPOS_VALUE_ERROR";
            case 3062:
                return "MQRCCF_CHANNEL_TABLE_ERROR";
            case 3063:
                return "MQRCCF_MCA_TYPE_ERROR";
            case 3064:
                return "MQRCCF_CHL_INST_TYPE_ERROR";
            case 3065:
                return "MQRCCF_CHL_STATUS_NOT_FOUND";
            case 3066:
                return "MQRCCF_CFSL_DUPLICATE_PARM";
            case 3067:
                return "MQRCCF_CFSL_TOTAL_LENGTH_ERROR";
            case 3068:
                return "MQRCCF_CFSL_COUNT_ERROR";
            case 3069:
                return "MQRCCF_CFSL_STRING_LENGTH_ERR";
            case 3070:
                return "MQRCCF_BROKER_DELETED";
            case 3071:
                return "MQRCCF_STREAM_ERROR";
            case 3072:
                return "MQRCCF_TOPIC_ERROR";
            case 3073:
                return "MQRCCF_NOT_REGISTERED";
            case 3074:
                return "MQRCCF_Q_MGR_NAME_ERROR";
            case 3075:
                return "MQRCCF_INCORRECT_STREAM";
            case 3076:
                return "MQRCCF_Q_NAME_ERROR";
            case 3077:
                return "MQRCCF_NO_RETAINED_MSG";
            case 3078:
                return "MQRCCF_DUPLICATE_IDENTITY";
            case 3079:
                return "MQRCCF_INCORRECT_Q";
            case 3080:
                return "MQRCCF_CORREL_ID_ERROR";
            case 3081:
                return "MQRCCF_NOT_AUTHORIZED";
            case 3082:
                return "MQRCCF_UNKNOWN_STREAM";
            case 3083:
                return "MQRCCF_REG_OPTIONS_ERROR";
            case 3084:
                return "MQRCCF_PUB_OPTIONS_ERROR";
            case 3085:
                return "MQRCCF_UNKNOWN_BROKER";
            case 3086:
                return "MQRCCF_Q_MGR_CCSID_ERROR";
            case 3087:
                return "MQRCCF_DEL_OPTIONS_ERROR";
            case 3088:
                return "MQRCCF_CLUSTER_NAME_CONFLICT";
            case 3089:
                return "MQRCCF_REPOS_NAME_CONFLICT";
            case 3090:
                return "MQRCCF_CLUSTER_Q_USAGE_ERROR";
            case 3091:
                return "MQRCCF_ACTION_VALUE_ERROR";
            case 3092:
                return "MQRCCF_COMMS_LIBRARY_ERROR";
            case 3093:
                return "MQRCCF_NETBIOS_NAME_ERROR";
            case 3094:
                return "MQRCCF_BROKER_COMMAND_FAILED";
            case 3095:
                return "MQRCCF_CFST_CONFLICTING_PARM";
            case 3096:
                return "MQRCCF_PATH_NOT_VALID";
            case 3097:
                return "MQRCCF_PARM_SYNTAX_ERROR";
            case 3098:
                return "MQRCCF_PWD_LENGTH_ERROR";
            case 3150:
                return "MQRCCF_FILTER_ERROR";
            case 3151:
                return "MQRCCF_WRONG_USER";
            case 3152:
                return "MQRCCF_DUPLICATE_SUBSCRIPTION";
            case 3153:
                return "MQRCCF_SUB_NAME_ERROR";
            case 3154:
                return "MQRCCF_SUB_IDENTITY_ERROR";
            case 3155:
                return "MQRCCF_SUBSCRIPTION_IN_USE";
            case 3156:
                return "MQRCCF_SUBSCRIPTION_LOCKED";
            case 3157:
                return "MQRCCF_ALREADY_JOINED";
            case 3160:
                return "MQRCCF_OBJECT_IN_USE";
            case 3161:
                return "MQRCCF_UNKNOWN_FILE_NAME";
            case 3162:
                return "MQRCCF_FILE_NOT_AVAILABLE";
            case 3163:
                return "MQRCCF_DISC_RETRY_ERROR";
            case 3164:
                return "MQRCCF_ALLOC_RETRY_ERROR";
            case 3165:
                return "MQRCCF_ALLOC_SLOW_TIMER_ERROR";
            case 3166:
                return "MQRCCF_ALLOC_FAST_TIMER_ERROR";
            case 3167:
                return "MQRCCF_PORT_NUMBER_ERROR";
            case 3168:
                return "MQRCCF_CHL_SYSTEM_NOT_ACTIVE";
            case 3169:
                return "MQRCCF_ENTITY_NAME_MISSING";
            case 3170:
                return "MQRCCF_PROFILE_NAME_ERROR";
            case 3171:
                return "MQRCCF_AUTH_VALUE_ERROR";
            case 3172:
                return "MQRCCF_AUTH_VALUE_MISSING";
            case 3173:
                return "MQRCCF_OBJECT_TYPE_MISSING";
            case 3174:
                return "MQRCCF_CONNECTION_ID_ERROR";
            case 3175:
                return "MQRCCF_LOG_TYPE_ERROR";
            case 3176:
                return "MQRCCF_PROGRAM_NOT_AVAILABLE";
            case 3177:
                return "MQRCCF_PROGRAM_AUTH_FAILED";
            case 3200:
                return "MQRCCF_NONE_FOUND";
            case 3201:
                return "MQRCCF_SECURITY_SWITCH_OFF";
            case 3202:
                return "MQRCCF_SECURITY_REFRESH_FAILED";
            case 3203:
                return "MQRCCF_PARM_CONFLICT";
            case 3204:
                return "MQRCCF_COMMAND_INHIBITED";
            case 3205:
                return "MQRCCF_OBJECT_BEING_DELETED";
            case 3207:
                return "MQRCCF_STORAGE_CLASS_IN_USE";
            case 3208:
                return "MQRCCF_OBJECT_NAME_RESTRICTED";
            case 3209:
                return "MQRCCF_OBJECT_LIMIT_EXCEEDED";
            case 3210:
                return "MQRCCF_OBJECT_OPEN_FORCE";
            case 3211:
                return "MQRCCF_DISPOSITION_CONFLICT";
            case 3212:
                return "MQRCCF_Q_MGR_NOT_IN_QSG";
            case 3213:
                return "MQRCCF_ATTR_VALUE_FIXED";
            case 3215:
                return "MQRCCF_NAMELIST_ERROR";
            case 3217:
                return "MQRCCF_NO_CHANNEL_INITIATOR";
            case 3218:
                return "MQRCCF_CHANNEL_INITIATOR_ERROR";
            case 3222:
                return "MQRCCF_COMMAND_LEVEL_CONFLICT";
            case 3223:
                return "MQRCCF_Q_ATTR_CONFLICT";
            case 3224:
                return "MQRCCF_EVENTS_DISABLED";
            case 3225:
                return "MQRCCF_COMMAND_SCOPE_ERROR";
            case 3226:
                return "MQRCCF_COMMAND_REPLY_ERROR";
            case 3227:
                return "MQRCCF_FUNCTION_RESTRICTED";
            case 3228:
                return "MQRCCF_PARM_MISSING";
            case 3229:
                return "MQRCCF_PARM_VALUE_ERROR";
            case 3230:
                return "MQRCCF_COMMAND_LENGTH_ERROR";
            case 3231:
                return "MQRCCF_COMMAND_ORIGIN_ERROR";
            case 3232:
                return "MQRCCF_LISTENER_CONFLICT";
            case 3233:
                return "MQRCCF_LISTENER_STARTED";
            case 3234:
                return "MQRCCF_LISTENER_STOPPED";
            case 3235:
                return "MQRCCF_CHANNEL_ERROR";
            case 3236:
                return "MQRCCF_CF_STRUC_ERROR";
            case 3237:
                return "MQRCCF_UNKNOWN_USER_ID";
            case 3238:
                return "MQRCCF_UNEXPECTED_ERROR";
            case 3239:
                return "MQRCCF_NO_XCF_PARTNER";
            case 3240:
                return "MQRCCF_CFGR_PARM_ID_ERROR";
            case 3241:
                return "MQRCCF_CFIF_LENGTH_ERROR";
            case 3242:
                return "MQRCCF_CFIF_OPERATOR_ERROR";
            case 3243:
                return "MQRCCF_CFIF_PARM_ID_ERROR";
            case 3244:
                return "MQRCCF_CFSF_FILTER_VAL_LEN_ERR";
            case 3245:
                return "MQRCCF_CFSF_LENGTH_ERROR";
            case 3246:
                return "MQRCCF_CFSF_OPERATOR_ERROR";
            case 3247:
                return "MQRCCF_CFSF_PARM_ID_ERROR";
            case 3248:
                return "MQRCCF_TOO_MANY_FILTERS";
            case 3249:
                return "MQRCCF_LISTENER_RUNNING";
            case 3250:
                return "MQRCCF_LSTR_STATUS_NOT_FOUND";
            case 3251:
                return "MQRCCF_SERVICE_RUNNING";
            case 3252:
                return "MQRCCF_SERV_STATUS_NOT_FOUND";
            case 3253:
                return "MQRCCF_SERVICE_STOPPED";
            case 3254:
                return "MQRCCF_CFBS_DUPLICATE_PARM";
            case 3255:
                return "MQRCCF_CFBS_LENGTH_ERROR";
            case 3256:
                return "MQRCCF_CFBS_PARM_ID_ERROR";
            case 3257:
                return "MQRCCF_CFBS_STRING_LENGTH_ERR";
            case 3258:
                return "MQRCCF_CFGR_LENGTH_ERROR";
            case 3259:
                return "MQRCCF_CFGR_PARM_COUNT_ERROR";
            case 3260:
                return "MQRCCF_CONN_NOT_STOPPED";
            case 3261:
                return "MQRCCF_SERVICE_REQUEST_PENDING";
            case 3262:
                return "MQRCCF_NO_START_CMD";
            case 3263:
                return "MQRCCF_NO_STOP_CMD";
            case 3264:
                return "MQRCCF_CFBF_LENGTH_ERROR";
            case 3265:
                return "MQRCCF_CFBF_PARM_ID_ERROR";
            case 3266:
                return "MQRCCF_CFBF_OPERATOR_ERROR";
            case 3267:
                return "MQRCCF_CFBF_FILTER_VAL_LEN_ERR";
            case 3268:
                return "MQRCCF_LISTENER_STILL_ACTIVE";
            case 3269:
                return "MQRCCF_DEF_XMIT_Q_CLUS_ERROR";
            case 3300:
                return "MQRCCF_TOPICSTR_ALREADY_EXISTS";
            case 3301:
                return "MQRCCF_SHARING_CONVS_ERROR";
            case 3302:
                return "MQRCCF_SHARING_CONVS_TYPE";
            case 3303:
                return "MQRCCF_SECURITY_CASE_CONFLICT";
            case 3305:
                return "MQRCCF_TOPIC_TYPE_ERROR";
            case 3306:
                return "MQRCCF_MAX_INSTANCES_ERROR";
            case 3307:
                return "MQRCCF_MAX_INSTS_PER_CLNT_ERR";
            case 3308:
                return "MQRCCF_TOPIC_STRING_NOT_FOUND";
            case 3309:
                return "MQRCCF_SUBSCRIPTION_POINT_ERR";
            case 3311:
                return "MQRCCF_SUB_ALREADY_EXISTS";
            case 3312:
                return "MQRCCF_UNKNOWN_OBJECT_NAME";
            case 3313:
                return "MQRCCF_REMOTE_Q_NAME_ERROR";
            case 3314:
                return "MQRCCF_DURABILITY_NOT_ALLOWED";
            case 3315:
                return "MQRCCF_HOBJ_ERROR";
            case 3316:
                return "MQRCCF_DEST_NAME_ERROR";
            case 3317:
                return "MQRCCF_INVALID_DESTINATION";
            case 3318:
                return "MQRCCF_PUBSUB_INHIBITED";
            case 3319:
                return "MQRCCF_GROUPUR_CHECKS_FAILED";
            case 3320:
                return "MQRCCF_COMM_INFO_TYPE_ERROR";
            case 3321:
                return "MQRCCF_USE_CLIENT_ID_ERROR";
            case 3322:
                return "MQRCCF_CLIENT_ID_NOT_FOUND";
            case 3323:
                return "MQRCCF_CLIENT_ID_ERROR";
            case 3324:
                return "MQRCCF_PORT_IN_USE";
            case 3325:
                return "MQRCCF_SSL_ALT_PROVIDER_REQD";
            case 3326:
                return "MQRCCF_CHLAUTH_TYPE_ERROR";
            case 3327:
                return "MQRCCF_CHLAUTH_ACTION_ERROR";
            case 3328:
                return "MQRCCF_POLICY_NOT_FOUND";
            case 3329:
                return "MQRCCF_ENCRYPTION_ALG_ERROR";
            case 3330:
                return "MQRCCF_SIGNATURE_ALG_ERROR";
            case 3331:
                return "MQRCCF_TOLERATION_POL_ERROR";
            case 3332:
                return "MQRCCF_POLICY_VERSION_ERROR";
            case 3333:
                return "MQRCCF_RECIPIENT_DN_MISSING";
            case 3334:
                return "MQRCCF_POLICY_NAME_MISSING";
            case 3335:
                return "MQRCCF_CHLAUTH_USERSRC_ERROR";
            case 3336:
                return "MQRCCF_WRONG_CHLAUTH_TYPE";
            case 3337:
                return "MQRCCF_CHLAUTH_ALREADY_EXISTS";
            case 3338:
                return "MQRCCF_CHLAUTH_NOT_FOUND";
            case 3339:
                return "MQRCCF_WRONG_CHLAUTH_ACTION";
            case 3340:
                return "MQRCCF_WRONG_CHLAUTH_USERSRC";
            case 3341:
                return "MQRCCF_CHLAUTH_WARN_ERROR";
            case 3342:
                return "MQRCCF_WRONG_CHLAUTH_MATCH";
            case 3343:
                return "MQRCCF_IPADDR_RANGE_CONFLICT";
            case 3344:
                return "MQRCCF_CHLAUTH_MAX_EXCEEDED";
            case 3345:
                return "MQRCCF_ADDRESS_ERROR";
            case 3346:
                return "MQRCCF_IPADDR_RANGE_ERROR";
            case 3347:
                return "MQRCCF_PROFILE_NAME_MISSING";
            case 3348:
                return "MQRCCF_CHLAUTH_CLNTUSER_ERROR";
            case 3349:
                return "MQRCCF_CHLAUTH_NAME_ERROR";
            case 3350:
                return "MQRCCF_CHLAUTH_RUNCHECK_ERROR";
            case 3351:
                return "MQRCCF_CF_STRUC_ALREADY_FAILED";
            case 3352:
                return "MQRCCF_CFCONLOS_CHECKS_FAILED";
            case 3353:
                return "MQRCCF_SUITE_B_ERROR";
            case 3354:
                return "MQRCCF_CHANNEL_NOT_STARTED";
            case 3355:
                return "MQRCCF_CUSTOM_ERROR";
            case 3356:
                return "MQRCCF_BACKLOG_OUT_OF_RANGE";
            case 3357:
                return "MQRCCF_CHLAUTH_DISABLED";
            case 3358:
                return "MQRCCF_SMDS_REQUIRES_DSGROUP";
            case 3359:
                return "MQRCCF_PSCLUS_DISABLED_TOPDEF";
            case 3360:
                return "MQRCCF_PSCLUS_TOPIC_EXISTS";
            case 3361:
                return "MQRCCF_SSL_CIPHER_SUITE_ERROR";
            case 3362:
                return "MQRCCF_SOCKET_ERROR";
            case 3363:
                return "MQRCCF_CLUS_XMIT_Q_USAGE_ERROR";
            case 3364:
                return "MQRCCF_CERT_VAL_POLICY_ERROR";
            case 3365:
                return "MQRCCF_INVALID_PROTOCOL";
            case 3366:
                return "MQRCCF_REVDNS_DISABLED";
            case 3367:
                return "MQRCCF_CLROUTE_NOT_ALTERABLE";
            case 3368:
                return "MQRCCF_CLUSTER_TOPIC_CONFLICT";
            case 3369:
                return "MQRCCF_DEFCLXQ_MODEL_Q_ERROR";
            case 3370:
                return "MQRCCF_CHLAUTH_CHKCLI_ERROR";
            case 3371:
                return "MQRCCF_CERT_LABEL_NOT_ALLOWED";
            case 3372:
                return "MQRCCF_Q_MGR_ATTR_CONFLICT";
            case 3373:
                return "MQRCCF_ENTITY_TYPE_MISSING";
            case 3374:
                return "MQRCCF_CLWL_EXIT_NAME_ERROR";
            case 3375:
                return "MQRCCF_SERVICE_NAME_ERROR";
            case 3376:
                return "MQRCCF_REMOTE_CHL_TYPE_ERROR";
            case 3377:
                return "MQRCCF_TOPIC_RESTRICTED";
            case 3378:
                return "MQRCCF_CURRENT_LOG_EXTENT";
            case 3379:
                return "MQRCCF_LOG_EXTENT_NOT_FOUND";
            case 3380:
                return "MQRCCF_LOG_NOT_REDUCED";
            case 3381:
                return "MQRCCF_LOG_EXTENT_ERROR";
            case 3382:
                return "MQRCCF_ACCESS_BLOCKED";
            case 3383:
                return "MQRCCF_PS_REQUIRED_MQUC";
            case 4001:
                return "MQRCCF_OBJECT_ALREADY_EXISTS";
            case 4002:
                return "MQRCCF_OBJECT_WRONG_TYPE";
            case 4003:
                return "MQRCCF_LIKE_OBJECT_WRONG_TYPE";
            case 4004:
                return "MQRCCF_OBJECT_OPEN";
            case 4005:
                return "MQRCCF_ATTR_VALUE_ERROR";
            case 4006:
                return "MQRCCF_UNKNOWN_Q_MGR";
            case 4007:
                return "MQRCCF_Q_WRONG_TYPE";
            case 4008:
                return "MQRCCF_OBJECT_NAME_ERROR";
            case 4009:
                return "MQRCCF_ALLOCATE_FAILED";
            case 4010:
                return "MQRCCF_HOST_NOT_AVAILABLE";
            case 4011:
                return "MQRCCF_CONFIGURATION_ERROR";
            case 4012:
                return "MQRCCF_CONNECTION_REFUSED";
            case 4013:
                return "MQRCCF_ENTRY_ERROR";
            case 4014:
                return "MQRCCF_SEND_FAILED";
            case 4015:
                return "MQRCCF_RECEIVED_DATA_ERROR";
            case 4016:
                return "MQRCCF_RECEIVE_FAILED";
            case 4017:
                return "MQRCCF_CONNECTION_CLOSED";
            case 4018:
                return "MQRCCF_NO_STORAGE";
            case 4019:
                return "MQRCCF_NO_COMMS_MANAGER";
            case 4020:
                return "MQRCCF_LISTENER_NOT_STARTED";
            case 4024:
                return "MQRCCF_BIND_FAILED";
            case 4025:
                return "MQRCCF_CHANNEL_INDOUBT";
            case 4026:
                return "MQRCCF_MQCONN_FAILED";
            case 4027:
                return "MQRCCF_MQOPEN_FAILED";
            case 4028:
                return "MQRCCF_MQGET_FAILED";
            case 4029:
                return "MQRCCF_MQPUT_FAILED";
            case 4030:
                return "MQRCCF_PING_ERROR";
            case 4031:
                return "MQRCCF_CHANNEL_IN_USE";
            case 4032:
                return "MQRCCF_CHANNEL_NOT_FOUND";
            case 4033:
                return "MQRCCF_UNKNOWN_REMOTE_CHANNEL";
            case 4034:
                return "MQRCCF_REMOTE_QM_UNAVAILABLE";
            case 4035:
                return "MQRCCF_REMOTE_QM_TERMINATING";
            case 4036:
                return "MQRCCF_MQINQ_FAILED";
            case 4037:
                return "MQRCCF_NOT_XMIT_Q";
            case 4038:
                return "MQRCCF_CHANNEL_DISABLED";
            case 4039:
                return "MQRCCF_USER_EXIT_NOT_AVAILABLE";
            case 4040:
                return "MQRCCF_COMMIT_FAILED";
            case 4041:
                return "MQRCCF_WRONG_CHANNEL_TYPE";
            case 4042:
                return "MQRCCF_CHANNEL_ALREADY_EXISTS";
            case 4043:
                return "MQRCCF_DATA_TOO_LARGE";
            case 4044:
                return "MQRCCF_CHANNEL_NAME_ERROR";
            case 4045:
                return "MQRCCF_XMIT_Q_NAME_ERROR";
            case 4047:
                return "MQRCCF_MCA_NAME_ERROR";
            case 4048:
                return "MQRCCF_SEND_EXIT_NAME_ERROR";
            case 4049:
                return "MQRCCF_SEC_EXIT_NAME_ERROR";
            case 4050:
                return "MQRCCF_MSG_EXIT_NAME_ERROR";
            case 4051:
                return "MQRCCF_RCV_EXIT_NAME_ERROR";
            case 4052:
                return "MQRCCF_XMIT_Q_NAME_WRONG_TYPE";
            case 4053:
                return "MQRCCF_MCA_NAME_WRONG_TYPE";
            case 4054:
                return "MQRCCF_DISC_INT_WRONG_TYPE";
            case 4055:
                return "MQRCCF_SHORT_RETRY_WRONG_TYPE";
            case 4056:
                return "MQRCCF_SHORT_TIMER_WRONG_TYPE";
            case 4057:
                return "MQRCCF_LONG_RETRY_WRONG_TYPE";
            case 4058:
                return "MQRCCF_LONG_TIMER_WRONG_TYPE";
            case 4059:
                return "MQRCCF_PUT_AUTH_WRONG_TYPE";
            case 4060:
                return "MQRCCF_KEEP_ALIVE_INT_ERROR";
            case 4061:
                return "MQRCCF_MISSING_CONN_NAME";
            case 4062:
                return "MQRCCF_CONN_NAME_ERROR";
            case 4063:
                return "MQRCCF_MQSET_FAILED";
            case 4064:
                return "MQRCCF_CHANNEL_NOT_ACTIVE";
            case 4065:
                return "MQRCCF_TERMINATED_BY_SEC_EXIT";
            case 4067:
                return "MQRCCF_DYNAMIC_Q_SCOPE_ERROR";
            case 4068:
                return "MQRCCF_CELL_DIR_NOT_AVAILABLE";
            case 4069:
                return "MQRCCF_MR_COUNT_ERROR";
            case 4070:
                return "MQRCCF_MR_COUNT_WRONG_TYPE";
            case 4071:
                return "MQRCCF_MR_EXIT_NAME_ERROR";
            case 4072:
                return "MQRCCF_MR_EXIT_NAME_WRONG_TYPE";
            case 4073:
                return "MQRCCF_MR_INTERVAL_ERROR";
            case 4074:
                return "MQRCCF_MR_INTERVAL_WRONG_TYPE";
            case 4075:
                return "MQRCCF_NPM_SPEED_ERROR";
            case 4076:
                return "MQRCCF_NPM_SPEED_WRONG_TYPE";
            case 4077:
                return "MQRCCF_HB_INTERVAL_ERROR";
            case 4078:
                return "MQRCCF_HB_INTERVAL_WRONG_TYPE";
            case 4079:
                return "MQRCCF_CHAD_ERROR";
            case 4080:
                return "MQRCCF_CHAD_WRONG_TYPE";
            case 4081:
                return "MQRCCF_CHAD_EVENT_ERROR";
            case 4082:
                return "MQRCCF_CHAD_EVENT_WRONG_TYPE";
            case 4083:
                return "MQRCCF_CHAD_EXIT_ERROR";
            case 4084:
                return "MQRCCF_CHAD_EXIT_WRONG_TYPE";
            case 4085:
                return "MQRCCF_SUPPRESSED_BY_EXIT";
            case 4086:
                return "MQRCCF_BATCH_INT_ERROR";
            case 4087:
                return "MQRCCF_BATCH_INT_WRONG_TYPE";
            case 4088:
                return "MQRCCF_NET_PRIORITY_ERROR";
            case 4089:
                return "MQRCCF_NET_PRIORITY_WRONG_TYPE";
            case 4090:
                return "MQRCCF_CHANNEL_CLOSED";
            case 4091:
                return "MQRCCF_Q_STATUS_NOT_FOUND";
            case 4092:
                return "MQRCCF_SSL_CIPHER_SPEC_ERROR";
            case 4093:
                return "MQRCCF_SSL_PEER_NAME_ERROR";
            case 4094:
                return "MQRCCF_SSL_CLIENT_AUTH_ERROR";
            case 4095:
                return "MQRCCF_RETAINED_NOT_SUPPORTED";
            case 4096:
                return "MQRCCF_KWD_VALUE_WRONG_TYPE";
            case 4097:
                return "MQRCCF_APPL_STATUS_NOT_FOUND";
            default:
                return "";
        }
    }

    public static String MQRCN_STR(int value) {
        switch (value) {
            case 0:
                return "MQRCN_NO";
            case 1:
                return "MQRCN_YES";
            case 2:
                return "MQRCN_Q_MGR";
            case 3:
                return "MQRCN_DISABLED";
            default:
                return "";
        }
    }

    public static String MQRCVTIME_STR(int value) {
        switch (value) {
            case 0:
                return "MQRCVTIME_MULTIPLY";
            case 1:
                return "MQRCVTIME_ADD";
            case 2:
                return "MQRCVTIME_EQUAL";
            default:
                return "";
        }
    }

    public static String MQRC_STR(int value) {
        switch (value) {
            case 0:
                return "MQRC_NONE";
            case 2001:
                return "MQRC_ALIAS_BASE_Q_TYPE_ERROR";
            case 2002:
                return "MQRC_ALREADY_CONNECTED";
            case 2003:
                return "MQRC_BACKED_OUT";
            case 2004:
                return "MQRC_BUFFER_ERROR";
            case 2005:
                return "MQRC_BUFFER_LENGTH_ERROR";
            case 2006:
                return "MQRC_CHAR_ATTR_LENGTH_ERROR";
            case 2007:
                return "MQRC_CHAR_ATTRS_ERROR";
            case 2008:
                return "MQRC_CHAR_ATTRS_TOO_SHORT";
            case 2009:
                return "MQRC_CONNECTION_BROKEN";
            case 2010:
                return "MQRC_DATA_LENGTH_ERROR";
            case 2011:
                return "MQRC_DYNAMIC_Q_NAME_ERROR";
            case 2012:
                return "MQRC_ENVIRONMENT_ERROR";
            case 2013:
                return "MQRC_EXPIRY_ERROR";
            case 2014:
                return "MQRC_FEEDBACK_ERROR";
            case 2016:
                return "MQRC_GET_INHIBITED";
            case 2017:
                return "MQRC_HANDLE_NOT_AVAILABLE";
            case 2018:
                return "MQRC_HCONN_ERROR";
            case 2019:
                return "MQRC_HOBJ_ERROR";
            case 2020:
                return "MQRC_INHIBIT_VALUE_ERROR";
            case 2021:
                return "MQRC_INT_ATTR_COUNT_ERROR";
            case 2022:
                return "MQRC_INT_ATTR_COUNT_TOO_SMALL";
            case 2023:
                return "MQRC_INT_ATTRS_ARRAY_ERROR";
            case 2024:
                return "MQRC_SYNCPOINT_LIMIT_REACHED";
            case 2025:
                return "MQRC_MAX_CONNS_LIMIT_REACHED";
            case 2026:
                return "MQRC_MD_ERROR";
            case 2027:
                return "MQRC_MISSING_REPLY_TO_Q";
            case 2029:
                return "MQRC_MSG_TYPE_ERROR";
            case 2030:
                return "MQRC_MSG_TOO_BIG_FOR_Q";
            case 2031:
                return "MQRC_MSG_TOO_BIG_FOR_Q_MGR";
            case 2033:
                return "MQRC_NO_MSG_AVAILABLE";
            case 2034:
                return "MQRC_NO_MSG_UNDER_CURSOR";
            case 2035:
                return "MQRC_NOT_AUTHORIZED";
            case 2036:
                return "MQRC_NOT_OPEN_FOR_BROWSE";
            case 2037:
                return "MQRC_NOT_OPEN_FOR_INPUT";
            case 2038:
                return "MQRC_NOT_OPEN_FOR_INQUIRE";
            case 2039:
                return "MQRC_NOT_OPEN_FOR_OUTPUT";
            case 2040:
                return "MQRC_NOT_OPEN_FOR_SET";
            case 2041:
                return "MQRC_OBJECT_CHANGED";
            case 2042:
                return "MQRC_OBJECT_IN_USE";
            case 2043:
                return "MQRC_OBJECT_TYPE_ERROR";
            case 2044:
                return "MQRC_OD_ERROR";
            case 2045:
                return "MQRC_OPTION_NOT_VALID_FOR_TYPE";
            case 2046:
                return "MQRC_OPTIONS_ERROR";
            case 2047:
                return "MQRC_PERSISTENCE_ERROR";
            case 2048:
                return "MQRC_PERSISTENT_NOT_ALLOWED";
            case 2049:
                return "MQRC_PRIORITY_EXCEEDS_MAXIMUM";
            case 2050:
                return "MQRC_PRIORITY_ERROR";
            case 2051:
                return "MQRC_PUT_INHIBITED";
            case 2052:
                return "MQRC_Q_DELETED";
            case 2053:
                return "MQRC_Q_FULL";
            case 2055:
                return "MQRC_Q_NOT_EMPTY";
            case 2056:
                return "MQRC_Q_SPACE_NOT_AVAILABLE";
            case 2057:
                return "MQRC_Q_TYPE_ERROR";
            case 2058:
                return "MQRC_Q_MGR_NAME_ERROR";
            case 2059:
                return "MQRC_Q_MGR_NOT_AVAILABLE";
            case 2061:
                return "MQRC_REPORT_OPTIONS_ERROR";
            case 2062:
                return "MQRC_SECOND_MARK_NOT_ALLOWED";
            case 2063:
                return "MQRC_SECURITY_ERROR";
            case 2065:
                return "MQRC_SELECTOR_COUNT_ERROR";
            case 2066:
                return "MQRC_SELECTOR_LIMIT_EXCEEDED";
            case 2067:
                return "MQRC_SELECTOR_ERROR";
            case 2068:
                return "MQRC_SELECTOR_NOT_FOR_TYPE";
            case 2069:
                return "MQRC_SIGNAL_OUTSTANDING";
            case 2070:
                return "MQRC_SIGNAL_REQUEST_ACCEPTED";
            case 2071:
                return "MQRC_STORAGE_NOT_AVAILABLE";
            case 2072:
                return "MQRC_SYNCPOINT_NOT_AVAILABLE";
            case 2075:
                return "MQRC_TRIGGER_CONTROL_ERROR";
            case 2076:
                return "MQRC_TRIGGER_DEPTH_ERROR";
            case 2077:
                return "MQRC_TRIGGER_MSG_PRIORITY_ERR";
            case 2078:
                return "MQRC_TRIGGER_TYPE_ERROR";
            case 2079:
                return "MQRC_TRUNCATED_MSG_ACCEPTED";
            case 2080:
                return "MQRC_TRUNCATED_MSG_FAILED";
            case 2082:
                return "MQRC_UNKNOWN_ALIAS_BASE_Q";
            case 2085:
                return "MQRC_UNKNOWN_OBJECT_NAME";
            case 2086:
                return "MQRC_UNKNOWN_OBJECT_Q_MGR";
            case 2087:
                return "MQRC_UNKNOWN_REMOTE_Q_MGR";
            case 2090:
                return "MQRC_WAIT_INTERVAL_ERROR";
            case 2091:
                return "MQRC_XMIT_Q_TYPE_ERROR";
            case 2092:
                return "MQRC_XMIT_Q_USAGE_ERROR";
            case 2093:
                return "MQRC_NOT_OPEN_FOR_PASS_ALL";
            case 2094:
                return "MQRC_NOT_OPEN_FOR_PASS_IDENT";
            case 2095:
                return "MQRC_NOT_OPEN_FOR_SET_ALL";
            case 2096:
                return "MQRC_NOT_OPEN_FOR_SET_IDENT";
            case 2097:
                return "MQRC_CONTEXT_HANDLE_ERROR";
            case 2098:
                return "MQRC_CONTEXT_NOT_AVAILABLE";
            case 2099:
                return "MQRC_SIGNAL1_ERROR";
            case 2100:
                return "MQRC_OBJECT_ALREADY_EXISTS";
            case 2101:
                return "MQRC_OBJECT_DAMAGED";
            case 2102:
                return "MQRC_RESOURCE_PROBLEM";
            case 2103:
                return "MQRC_ANOTHER_Q_MGR_CONNECTED";
            case 2104:
                return "MQRC_UNKNOWN_REPORT_OPTION";
            case 2105:
                return "MQRC_STORAGE_CLASS_ERROR";
            case 2106:
                return "MQRC_COD_NOT_VALID_FOR_XCF_Q";
            case 2107:
                return "MQRC_XWAIT_CANCELED";
            case 2108:
                return "MQRC_XWAIT_ERROR";
            case 2109:
                return "MQRC_SUPPRESSED_BY_EXIT";
            case 2110:
                return "MQRC_FORMAT_ERROR";
            case 2111:
                return "MQRC_SOURCE_CCSID_ERROR";
            case 2112:
                return "MQRC_SOURCE_INTEGER_ENC_ERROR";
            case 2113:
                return "MQRC_SOURCE_DECIMAL_ENC_ERROR";
            case 2114:
                return "MQRC_SOURCE_FLOAT_ENC_ERROR";
            case 2115:
                return "MQRC_TARGET_CCSID_ERROR";
            case 2116:
                return "MQRC_TARGET_INTEGER_ENC_ERROR";
            case 2117:
                return "MQRC_TARGET_DECIMAL_ENC_ERROR";
            case 2118:
                return "MQRC_TARGET_FLOAT_ENC_ERROR";
            case 2119:
                return "MQRC_NOT_CONVERTED";
            case 2121:
                return "MQRC_NO_EXTERNAL_PARTICIPANTS";
            case 2122:
                return "MQRC_PARTICIPANT_NOT_AVAILABLE";
            case 2123:
                return "MQRC_OUTCOME_MIXED";
            case 2124:
                return "MQRC_OUTCOME_PENDING";
            case 2125:
                return "MQRC_BRIDGE_STARTED";
            case 2126:
                return "MQRC_BRIDGE_STOPPED";
            case 2127:
                return "MQRC_ADAPTER_STORAGE_SHORTAGE";
            case 2128:
                return "MQRC_UOW_IN_PROGRESS";
            case 2129:
                return "MQRC_ADAPTER_CONN_LOAD_ERROR";
            case 2130:
                return "MQRC_ADAPTER_SERV_LOAD_ERROR";
            case 2131:
                return "MQRC_ADAPTER_DEFS_ERROR";
            case 2132:
                return "MQRC_ADAPTER_DEFS_LOAD_ERROR";
            case 2133:
                return "MQRC_ADAPTER_CONV_LOAD_ERROR";
            case 2134:
                return "MQRC_BO_ERROR";
            case 2135:
                return "MQRC_DH_ERROR";
            case 2136:
                return "MQRC_MULTIPLE_REASONS";
            case 2137:
                return "MQRC_OPEN_FAILED";
            case 2138:
                return "MQRC_ADAPTER_DISC_LOAD_ERROR";
            case 2139:
                return "MQRC_CNO_ERROR";
            case 2140:
                return "MQRC_CICS_WAIT_FAILED";
            case 2141:
                return "MQRC_DLH_ERROR";
            case 2142:
                return "MQRC_HEADER_ERROR";
            case 2143:
                return "MQRC_SOURCE_LENGTH_ERROR";
            case 2144:
                return "MQRC_TARGET_LENGTH_ERROR";
            case 2145:
                return "MQRC_SOURCE_BUFFER_ERROR";
            case 2146:
                return "MQRC_TARGET_BUFFER_ERROR";
            case 2147:
                return "MQRC_INCOMPLETE_TRANSACTION";
            case 2148:
                return "MQRC_IIH_ERROR";
            case 2149:
                return "MQRC_PCF_ERROR";
            case 2150:
                return "MQRC_DBCS_ERROR";
            case 2152:
                return "MQRC_OBJECT_NAME_ERROR";
            case 2153:
                return "MQRC_OBJECT_Q_MGR_NAME_ERROR";
            case 2154:
                return "MQRC_RECS_PRESENT_ERROR";
            case 2155:
                return "MQRC_OBJECT_RECORDS_ERROR";
            case 2156:
                return "MQRC_RESPONSE_RECORDS_ERROR";
            case 2157:
                return "MQRC_ASID_MISMATCH";
            case 2158:
                return "MQRC_PMO_RECORD_FLAGS_ERROR";
            case 2159:
                return "MQRC_PUT_MSG_RECORDS_ERROR";
            case 2160:
                return "MQRC_CONN_ID_IN_USE";
            case 2161:
                return "MQRC_Q_MGR_QUIESCING";
            case 2162:
                return "MQRC_Q_MGR_STOPPING";
            case 2163:
                return "MQRC_DUPLICATE_RECOV_COORD";
            case 2173:
                return "MQRC_PMO_ERROR";
            case 2182:
                return "MQRC_API_EXIT_NOT_FOUND";
            case 2183:
                return "MQRC_API_EXIT_LOAD_ERROR";
            case 2184:
                return "MQRC_REMOTE_Q_NAME_ERROR";
            case 2185:
                return "MQRC_INCONSISTENT_PERSISTENCE";
            case 2186:
                return "MQRC_GMO_ERROR";
            case 2187:
                return "MQRC_CICS_BRIDGE_RESTRICTION";
            case 2188:
                return "MQRC_STOPPED_BY_CLUSTER_EXIT";
            case 2189:
                return "MQRC_CLUSTER_RESOLUTION_ERROR";
            case 2190:
                return "MQRC_CONVERTED_STRING_TOO_BIG";
            case 2191:
                return "MQRC_TMC_ERROR";
            case 2192:
                return "MQRC_STORAGE_MEDIUM_FULL";
            case 2193:
                return "MQRC_PAGESET_ERROR";
            case 2194:
                return "MQRC_NAME_NOT_VALID_FOR_TYPE";
            case 2195:
                return "MQRC_UNEXPECTED_ERROR";
            case 2196:
                return "MQRC_UNKNOWN_XMIT_Q";
            case 2197:
                return "MQRC_UNKNOWN_DEF_XMIT_Q";
            case 2198:
                return "MQRC_DEF_XMIT_Q_TYPE_ERROR";
            case 2199:
                return "MQRC_DEF_XMIT_Q_USAGE_ERROR";
            case 2200:
                return "MQRC_MSG_MARKED_BROWSE_CO_OP";
            case 2201:
                return "MQRC_NAME_IN_USE";
            case 2202:
                return "MQRC_CONNECTION_QUIESCING";
            case 2203:
                return "MQRC_CONNECTION_STOPPING";
            case 2204:
                return "MQRC_ADAPTER_NOT_AVAILABLE";
            case 2206:
                return "MQRC_MSG_ID_ERROR";
            case 2207:
                return "MQRC_CORREL_ID_ERROR";
            case 2208:
                return "MQRC_FILE_SYSTEM_ERROR";
            case 2209:
                return "MQRC_NO_MSG_LOCKED";
            case 2210:
                return "MQRC_SOAP_DOTNET_ERROR";
            case 2211:
                return "MQRC_SOAP_AXIS_ERROR";
            case 2212:
                return "MQRC_SOAP_URL_ERROR";
            case 2216:
                return "MQRC_FILE_NOT_AUDITED";
            case 2217:
                return "MQRC_CONNECTION_NOT_AUTHORIZED";
            case 2218:
                return "MQRC_MSG_TOO_BIG_FOR_CHANNEL";
            case 2219:
                return "MQRC_CALL_IN_PROGRESS";
            case 2220:
                return "MQRC_RMH_ERROR";
            case 2222:
                return "MQRC_Q_MGR_ACTIVE";
            case 2223:
                return "MQRC_Q_MGR_NOT_ACTIVE";
            case 2224:
                return "MQRC_Q_DEPTH_HIGH";
            case 2225:
                return "MQRC_Q_DEPTH_LOW";
            case 2226:
                return "MQRC_Q_SERVICE_INTERVAL_HIGH";
            case 2227:
                return "MQRC_Q_SERVICE_INTERVAL_OK";
            case 2228:
                return "MQRC_RFH_HEADER_FIELD_ERROR";
            case 2229:
                return "MQRC_RAS_PROPERTY_ERROR";
            case 2232:
                return "MQRC_UNIT_OF_WORK_NOT_STARTED";
            case 2233:
                return "MQRC_CHANNEL_AUTO_DEF_OK";
            case 2234:
                return "MQRC_CHANNEL_AUTO_DEF_ERROR";
            case 2235:
                return "MQRC_CFH_ERROR";
            case 2236:
                return "MQRC_CFIL_ERROR";
            case 2237:
                return "MQRC_CFIN_ERROR";
            case 2238:
                return "MQRC_CFSL_ERROR";
            case 2239:
                return "MQRC_CFST_ERROR";
            case 2241:
                return "MQRC_INCOMPLETE_GROUP";
            case 2242:
                return "MQRC_INCOMPLETE_MSG";
            case 2243:
                return "MQRC_INCONSISTENT_CCSIDS";
            case 2244:
                return "MQRC_INCONSISTENT_ENCODINGS";
            case 2245:
                return "MQRC_INCONSISTENT_UOW";
            case 2246:
                return "MQRC_INVALID_MSG_UNDER_CURSOR";
            case 2247:
                return "MQRC_MATCH_OPTIONS_ERROR";
            case 2248:
                return "MQRC_MDE_ERROR";
            case 2249:
                return "MQRC_MSG_FLAGS_ERROR";
            case 2250:
                return "MQRC_MSG_SEQ_NUMBER_ERROR";
            case 2251:
                return "MQRC_OFFSET_ERROR";
            case 2252:
                return "MQRC_ORIGINAL_LENGTH_ERROR";
            case 2253:
                return "MQRC_SEGMENT_LENGTH_ZERO";
            case 2255:
                return "MQRC_UOW_NOT_AVAILABLE";
            case 2256:
                return "MQRC_WRONG_GMO_VERSION";
            case 2257:
                return "MQRC_WRONG_MD_VERSION";
            case 2258:
                return "MQRC_GROUP_ID_ERROR";
            case 2259:
                return "MQRC_INCONSISTENT_BROWSE";
            case 2260:
                return "MQRC_XQH_ERROR";
            case 2261:
                return "MQRC_SRC_ENV_ERROR";
            case 2262:
                return "MQRC_SRC_NAME_ERROR";
            case 2263:
                return "MQRC_DEST_ENV_ERROR";
            case 2264:
                return "MQRC_DEST_NAME_ERROR";
            case 2265:
                return "MQRC_TM_ERROR";
            case 2266:
                return "MQRC_CLUSTER_EXIT_ERROR";
            case 2267:
                return "MQRC_CLUSTER_EXIT_LOAD_ERROR";
            case 2268:
                return "MQRC_CLUSTER_PUT_INHIBITED";
            case 2269:
                return "MQRC_CLUSTER_RESOURCE_ERROR";
            case 2270:
                return "MQRC_NO_DESTINATIONS_AVAILABLE";
            case 2271:
                return "MQRC_CONN_TAG_IN_USE";
            case 2272:
                return "MQRC_PARTIALLY_CONVERTED";
            case 2273:
                return "MQRC_CONNECTION_ERROR";
            case 2274:
                return "MQRC_OPTION_ENVIRONMENT_ERROR";
            case 2277:
                return "MQRC_CD_ERROR";
            case 2278:
                return "MQRC_CLIENT_CONN_ERROR";
            case 2279:
                return "MQRC_CHANNEL_STOPPED_BY_USER";
            case 2280:
                return "MQRC_HCONFIG_ERROR";
            case 2281:
                return "MQRC_FUNCTION_ERROR";
            case 2282:
                return "MQRC_CHANNEL_STARTED";
            case 2283:
                return "MQRC_CHANNEL_STOPPED";
            case 2284:
                return "MQRC_CHANNEL_CONV_ERROR";
            case 2285:
                return "MQRC_SERVICE_NOT_AVAILABLE";
            case 2286:
                return "MQRC_INITIALIZATION_FAILED";
            case 2287:
                return "MQRC_TERMINATION_FAILED";
            case 2288:
                return "MQRC_UNKNOWN_Q_NAME";
            case 2289:
                return "MQRC_SERVICE_ERROR";
            case 2290:
                return "MQRC_Q_ALREADY_EXISTS";
            case 2291:
                return "MQRC_USER_ID_NOT_AVAILABLE";
            case 2292:
                return "MQRC_UNKNOWN_ENTITY";
            case 2293:
                return "MQRC_UNKNOWN_AUTH_ENTITY";
            case 2294:
                return "MQRC_UNKNOWN_REF_OBJECT";
            case 2295:
                return "MQRC_CHANNEL_ACTIVATED";
            case 2296:
                return "MQRC_CHANNEL_NOT_ACTIVATED";
            case 2297:
                return "MQRC_UOW_CANCELED";
            case 2298:
                return "MQRC_FUNCTION_NOT_SUPPORTED";
            case 2299:
                return "MQRC_SELECTOR_TYPE_ERROR";
            case 2300:
                return "MQRC_COMMAND_TYPE_ERROR";
            case 2301:
                return "MQRC_MULTIPLE_INSTANCE_ERROR";
            case 2302:
                return "MQRC_SYSTEM_ITEM_NOT_ALTERABLE";
            case 2303:
                return "MQRC_BAG_CONVERSION_ERROR";
            case 2304:
                return "MQRC_SELECTOR_OUT_OF_RANGE";
            case 2305:
                return "MQRC_SELECTOR_NOT_UNIQUE";
            case 2306:
                return "MQRC_INDEX_NOT_PRESENT";
            case 2307:
                return "MQRC_STRING_ERROR";
            case 2308:
                return "MQRC_ENCODING_NOT_SUPPORTED";
            case 2309:
                return "MQRC_SELECTOR_NOT_PRESENT";
            case 2310:
                return "MQRC_OUT_SELECTOR_ERROR";
            case 2311:
                return "MQRC_STRING_TRUNCATED";
            case 2312:
                return "MQRC_SELECTOR_WRONG_TYPE";
            case 2313:
                return "MQRC_INCONSISTENT_ITEM_TYPE";
            case 2314:
                return "MQRC_INDEX_ERROR";
            case 2315:
                return "MQRC_SYSTEM_BAG_NOT_ALTERABLE";
            case 2316:
                return "MQRC_ITEM_COUNT_ERROR";
            case 2317:
                return "MQRC_FORMAT_NOT_SUPPORTED";
            case 2318:
                return "MQRC_SELECTOR_NOT_SUPPORTED";
            case 2319:
                return "MQRC_ITEM_VALUE_ERROR";
            case 2320:
                return "MQRC_HBAG_ERROR";
            case 2321:
                return "MQRC_PARAMETER_MISSING";
            case 2322:
                return "MQRC_CMD_SERVER_NOT_AVAILABLE";
            case 2323:
                return "MQRC_STRING_LENGTH_ERROR";
            case 2324:
                return "MQRC_INQUIRY_COMMAND_ERROR";
            case 2325:
                return "MQRC_NESTED_BAG_NOT_SUPPORTED";
            case 2326:
                return "MQRC_BAG_WRONG_TYPE";
            case 2327:
                return "MQRC_ITEM_TYPE_ERROR";
            case 2328:
                return "MQRC_SYSTEM_BAG_NOT_DELETABLE";
            case 2329:
                return "MQRC_SYSTEM_ITEM_NOT_DELETABLE";
            case 2330:
                return "MQRC_CODED_CHAR_SET_ID_ERROR";
            case 2331:
                return "MQRC_MSG_TOKEN_ERROR";
            case 2332:
                return "MQRC_MISSING_WIH";
            case 2333:
                return "MQRC_WIH_ERROR";
            case 2334:
                return "MQRC_RFH_ERROR";
            case 2335:
                return "MQRC_RFH_STRING_ERROR";
            case 2336:
                return "MQRC_RFH_COMMAND_ERROR";
            case 2337:
                return "MQRC_RFH_PARM_ERROR";
            case 2338:
                return "MQRC_RFH_DUPLICATE_PARM";
            case 2339:
                return "MQRC_RFH_PARM_MISSING";
            case 2340:
                return "MQRC_CHAR_CONVERSION_ERROR";
            case 2341:
                return "MQRC_UCS2_CONVERSION_ERROR";
            case 2342:
                return "MQRC_DB2_NOT_AVAILABLE";
            case 2343:
                return "MQRC_OBJECT_NOT_UNIQUE";
            case 2344:
                return "MQRC_CONN_TAG_NOT_RELEASED";
            case 2345:
                return "MQRC_CF_NOT_AVAILABLE";
            case 2346:
                return "MQRC_CF_STRUC_IN_USE";
            case 2347:
                return "MQRC_CF_STRUC_LIST_HDR_IN_USE";
            case 2348:
                return "MQRC_CF_STRUC_AUTH_FAILED";
            case 2349:
                return "MQRC_CF_STRUC_ERROR";
            case 2350:
                return "MQRC_CONN_TAG_NOT_USABLE";
            case 2351:
                return "MQRC_GLOBAL_UOW_CONFLICT";
            case 2352:
                return "MQRC_LOCAL_UOW_CONFLICT";
            case 2353:
                return "MQRC_HANDLE_IN_USE_FOR_UOW";
            case 2354:
                return "MQRC_UOW_ENLISTMENT_ERROR";
            case 2355:
                return "MQRC_UOW_MIX_NOT_SUPPORTED";
            case 2356:
                return "MQRC_WXP_ERROR";
            case 2357:
                return "MQRC_CURRENT_RECORD_ERROR";
            case 2358:
                return "MQRC_NEXT_OFFSET_ERROR";
            case 2359:
                return "MQRC_NO_RECORD_AVAILABLE";
            case 2360:
                return "MQRC_OBJECT_LEVEL_INCOMPATIBLE";
            case 2361:
                return "MQRC_NEXT_RECORD_ERROR";
            case 2362:
                return "MQRC_BACKOUT_THRESHOLD_REACHED";
            case 2363:
                return "MQRC_MSG_NOT_MATCHED";
            case 2364:
                return "MQRC_JMS_FORMAT_ERROR";
            case 2365:
                return "MQRC_SEGMENTS_NOT_SUPPORTED";
            case 2366:
                return "MQRC_WRONG_CF_LEVEL";
            case 2367:
                return "MQRC_CONFIG_CREATE_OBJECT";
            case 2368:
                return "MQRC_CONFIG_CHANGE_OBJECT";
            case 2369:
                return "MQRC_CONFIG_DELETE_OBJECT";
            case 2370:
                return "MQRC_CONFIG_REFRESH_OBJECT";
            case 2371:
                return "MQRC_CHANNEL_SSL_ERROR";
            case 2372:
                return "MQRC_PARTICIPANT_NOT_DEFINED";
            case 2373:
                return "MQRC_CF_STRUC_FAILED";
            case 2374:
                return "MQRC_API_EXIT_ERROR";
            case 2375:
                return "MQRC_API_EXIT_INIT_ERROR";
            case 2376:
                return "MQRC_API_EXIT_TERM_ERROR";
            case 2377:
                return "MQRC_EXIT_REASON_ERROR";
            case 2378:
                return "MQRC_RESERVED_VALUE_ERROR";
            case 2379:
                return "MQRC_NO_DATA_AVAILABLE";
            case 2380:
                return "MQRC_SCO_ERROR";
            case 2381:
                return "MQRC_KEY_REPOSITORY_ERROR";
            case 2382:
                return "MQRC_CRYPTO_HARDWARE_ERROR";
            case 2383:
                return "MQRC_AUTH_INFO_REC_COUNT_ERROR";
            case 2384:
                return "MQRC_AUTH_INFO_REC_ERROR";
            case 2385:
                return "MQRC_AIR_ERROR";
            case 2386:
                return "MQRC_AUTH_INFO_TYPE_ERROR";
            case 2387:
                return "MQRC_AUTH_INFO_CONN_NAME_ERROR";
            case 2388:
                return "MQRC_LDAP_USER_NAME_ERROR";
            case 2389:
                return "MQRC_LDAP_USER_NAME_LENGTH_ERR";
            case 2390:
                return "MQRC_LDAP_PASSWORD_ERROR";
            case 2391:
                return "MQRC_SSL_ALREADY_INITIALIZED";
            case 2392:
                return "MQRC_SSL_CONFIG_ERROR";
            case 2393:
                return "MQRC_SSL_INITIALIZATION_ERROR";
            case 2394:
                return "MQRC_Q_INDEX_TYPE_ERROR";
            case 2395:
                return "MQRC_CFBS_ERROR";
            case 2396:
                return "MQRC_SSL_NOT_ALLOWED";
            case 2397:
                return "MQRC_JSSE_ERROR";
            case 2398:
                return "MQRC_SSL_PEER_NAME_MISMATCH";
            case 2399:
                return "MQRC_SSL_PEER_NAME_ERROR";
            case 2400:
                return "MQRC_UNSUPPORTED_CIPHER_SUITE";
            case 2401:
                return "MQRC_SSL_CERTIFICATE_REVOKED";
            case 2402:
                return "MQRC_SSL_CERT_STORE_ERROR";
            case 2406:
                return "MQRC_CLIENT_EXIT_LOAD_ERROR";
            case 2407:
                return "MQRC_CLIENT_EXIT_ERROR";
            case 2408:
                return "MQRC_UOW_COMMITTED";
            case 2409:
                return "MQRC_SSL_KEY_RESET_ERROR";
            case 2410:
                return "MQRC_UNKNOWN_COMPONENT_NAME";
            case 2411:
                return "MQRC_LOGGER_STATUS";
            case 2412:
                return "MQRC_COMMAND_MQSC";
            case 2413:
                return "MQRC_COMMAND_PCF";
            case 2414:
                return "MQRC_CFIF_ERROR";
            case 2415:
                return "MQRC_CFSF_ERROR";
            case 2416:
                return "MQRC_CFGR_ERROR";
            case 2417:
                return "MQRC_MSG_NOT_ALLOWED_IN_GROUP";
            case 2418:
                return "MQRC_FILTER_OPERATOR_ERROR";
            case 2419:
                return "MQRC_NESTED_SELECTOR_ERROR";
            case 2420:
                return "MQRC_EPH_ERROR";
            case 2421:
                return "MQRC_RFH_FORMAT_ERROR";
            case 2422:
                return "MQRC_CFBF_ERROR";
            case 2423:
                return "MQRC_CLIENT_CHANNEL_CONFLICT";
            case 2424:
                return "MQRC_SD_ERROR";
            case 2425:
                return "MQRC_TOPIC_STRING_ERROR";
            case 2426:
                return "MQRC_STS_ERROR";
            case 2428:
                return "MQRC_NO_SUBSCRIPTION";
            case 2429:
                return "MQRC_SUBSCRIPTION_IN_USE";
            case 2430:
                return "MQRC_STAT_TYPE_ERROR";
            case 2431:
                return "MQRC_SUB_USER_DATA_ERROR";
            case 2432:
                return "MQRC_SUB_ALREADY_EXISTS";
            case 2434:
                return "MQRC_IDENTITY_MISMATCH";
            case 2435:
                return "MQRC_ALTER_SUB_ERROR";
            case 2436:
                return "MQRC_DURABILITY_NOT_ALLOWED";
            case 2437:
                return "MQRC_NO_RETAINED_MSG";
            case 2438:
                return "MQRC_SRO_ERROR";
            case 2440:
                return "MQRC_SUB_NAME_ERROR";
            case 2441:
                return "MQRC_OBJECT_STRING_ERROR";
            case 2442:
                return "MQRC_PROPERTY_NAME_ERROR";
            case 2443:
                return "MQRC_SEGMENTATION_NOT_ALLOWED";
            case 2444:
                return "MQRC_CBD_ERROR";
            case 2445:
                return "MQRC_CTLO_ERROR";
            case 2446:
                return "MQRC_NO_CALLBACKS_ACTIVE";
            case 2448:
                return "MQRC_CALLBACK_NOT_REGISTERED";
            case 2457:
                return "MQRC_OPTIONS_CHANGED";
            case 2458:
                return "MQRC_READ_AHEAD_MSGS";
            case 2459:
                return "MQRC_SELECTOR_SYNTAX_ERROR";
            case 2460:
                return "MQRC_HMSG_ERROR";
            case 2461:
                return "MQRC_CMHO_ERROR";
            case 2462:
                return "MQRC_DMHO_ERROR";
            case 2463:
                return "MQRC_SMPO_ERROR";
            case 2464:
                return "MQRC_IMPO_ERROR";
            case 2465:
                return "MQRC_PROPERTY_NAME_TOO_BIG";
            case 2466:
                return "MQRC_PROP_VALUE_NOT_CONVERTED";
            case 2467:
                return "MQRC_PROP_TYPE_NOT_SUPPORTED";
            case 2469:
                return "MQRC_PROPERTY_VALUE_TOO_BIG";
            case 2470:
                return "MQRC_PROP_CONV_NOT_SUPPORTED";
            case 2471:
                return "MQRC_PROPERTY_NOT_AVAILABLE";
            case 2472:
                return "MQRC_PROP_NUMBER_FORMAT_ERROR";
            case 2473:
                return "MQRC_PROPERTY_TYPE_ERROR";
            case 2478:
                return "MQRC_PROPERTIES_TOO_BIG";
            case 2479:
                return "MQRC_PUT_NOT_RETAINED";
            case 2480:
                return "MQRC_ALIAS_TARGTYPE_CHANGED";
            case 2481:
                return "MQRC_DMPO_ERROR";
            case 2482:
                return "MQRC_PD_ERROR";
            case 2483:
                return "MQRC_CALLBACK_TYPE_ERROR";
            case 2484:
                return "MQRC_CBD_OPTIONS_ERROR";
            case 2485:
                return "MQRC_MAX_MSG_LENGTH_ERROR";
            case 2486:
                return "MQRC_CALLBACK_ROUTINE_ERROR";
            case 2487:
                return "MQRC_CALLBACK_LINK_ERROR";
            case 2488:
                return "MQRC_OPERATION_ERROR";
            case 2489:
                return "MQRC_BMHO_ERROR";
            case 2490:
                return "MQRC_UNSUPPORTED_PROPERTY";
            case 2492:
                return "MQRC_PROP_NAME_NOT_CONVERTED";
            case 2494:
                return "MQRC_GET_ENABLED";
            case 2495:
                return "MQRC_MODULE_NOT_FOUND";
            case 2496:
                return "MQRC_MODULE_INVALID";
            case 2497:
                return "MQRC_MODULE_ENTRY_NOT_FOUND";
            case 2498:
                return "MQRC_MIXED_CONTENT_NOT_ALLOWED";
            case 2499:
                return "MQRC_MSG_HANDLE_IN_USE";
            case 2500:
                return "MQRC_HCONN_ASYNC_ACTIVE";
            case 2501:
                return "MQRC_MHBO_ERROR";
            case 2502:
                return "MQRC_PUBLICATION_FAILURE";
            case 2503:
                return "MQRC_SUB_INHIBITED";
            case 2504:
                return "MQRC_SELECTOR_ALWAYS_FALSE";
            case 2507:
                return "MQRC_XEPO_ERROR";
            case 2509:
                return "MQRC_DURABILITY_NOT_ALTERABLE";
            case 2510:
                return "MQRC_TOPIC_NOT_ALTERABLE";
            case 2512:
                return "MQRC_SUBLEVEL_NOT_ALTERABLE";
            case 2513:
                return "MQRC_PROPERTY_NAME_LENGTH_ERR";
            case 2514:
                return "MQRC_DUPLICATE_GROUP_SUB";
            case 2515:
                return "MQRC_GROUPING_NOT_ALTERABLE";
            case 2516:
                return "MQRC_SELECTOR_INVALID_FOR_TYPE";
            case 2517:
                return "MQRC_HOBJ_QUIESCED";
            case 2518:
                return "MQRC_HOBJ_QUIESCED_NO_MSGS";
            case 2519:
                return "MQRC_SELECTION_STRING_ERROR";
            case 2520:
                return "MQRC_RES_OBJECT_STRING_ERROR";
            case 2521:
                return "MQRC_CONNECTION_SUSPENDED";
            case 2522:
                return "MQRC_INVALID_DESTINATION";
            case 2523:
                return "MQRC_INVALID_SUBSCRIPTION";
            case 2524:
                return "MQRC_SELECTOR_NOT_ALTERABLE";
            case 2525:
                return "MQRC_RETAINED_MSG_Q_ERROR";
            case 2526:
                return "MQRC_RETAINED_NOT_DELIVERED";
            case 2527:
                return "MQRC_RFH_RESTRICTED_FORMAT_ERR";
            case 2528:
                return "MQRC_CONNECTION_STOPPED";
            case 2529:
                return "MQRC_ASYNC_UOW_CONFLICT";
            case 2530:
                return "MQRC_ASYNC_XA_CONFLICT";
            case 2531:
                return "MQRC_PUBSUB_INHIBITED";
            case 2532:
                return "MQRC_MSG_HANDLE_COPY_FAILURE";
            case 2533:
                return "MQRC_DEST_CLASS_NOT_ALTERABLE";
            case 2534:
                return "MQRC_OPERATION_NOT_ALLOWED";
            case 2535:
                return "MQRC_ACTION_ERROR";
            case 2537:
                return "MQRC_CHANNEL_NOT_AVAILABLE";
            case 2538:
                return "MQRC_HOST_NOT_AVAILABLE";
            case 2539:
                return "MQRC_CHANNEL_CONFIG_ERROR";
            case 2540:
                return "MQRC_UNKNOWN_CHANNEL_NAME";
            case 2541:
                return "MQRC_LOOPING_PUBLICATION";
            case 2542:
                return "MQRC_ALREADY_JOINED";
            case 2543:
                return "MQRC_STANDBY_Q_MGR";
            case 2544:
                return "MQRC_RECONNECTING";
            case 2545:
                return "MQRC_RECONNECTED";
            case 2546:
                return "MQRC_RECONNECT_QMID_MISMATCH";
            case 2547:
                return "MQRC_RECONNECT_INCOMPATIBLE";
            case 2548:
                return "MQRC_RECONNECT_FAILED";
            case 2549:
                return "MQRC_CALL_INTERRUPTED";
            case 2550:
                return "MQRC_NO_SUBS_MATCHED";
            case 2551:
                return "MQRC_SELECTION_NOT_AVAILABLE";
            case 2552:
                return "MQRC_CHANNEL_SSL_WARNING";
            case 2553:
                return "MQRC_OCSP_URL_ERROR";
            case 2554:
                return "MQRC_CONTENT_ERROR";
            case 2555:
                return "MQRC_RECONNECT_Q_MGR_REQD";
            case 2556:
                return "MQRC_RECONNECT_TIMED_OUT";
            case 2557:
                return "MQRC_PUBLISH_EXIT_ERROR";
            case 2558:
                return "MQRC_COMMINFO_ERROR";
            case 2559:
                return "MQRC_DEF_SYNCPOINT_INHIBITED";
            case 2560:
                return "MQRC_MULTICAST_ONLY";
            case 2561:
                return "MQRC_DATA_SET_NOT_AVAILABLE";
            case 2562:
                return "MQRC_GROUPING_NOT_ALLOWED";
            case 2563:
                return "MQRC_GROUP_ADDRESS_ERROR";
            case 2564:
                return "MQRC_MULTICAST_CONFIG_ERROR";
            case 2565:
                return "MQRC_MULTICAST_INTERFACE_ERROR";
            case 2566:
                return "MQRC_MULTICAST_SEND_ERROR";
            case 2567:
                return "MQRC_MULTICAST_INTERNAL_ERROR";
            case 2568:
                return "MQRC_CONNECTION_NOT_AVAILABLE";
            case 2569:
                return "MQRC_SYNCPOINT_NOT_ALLOWED";
            case 2570:
                return "MQRC_SSL_ALT_PROVIDER_REQUIRED";
            case 2571:
                return "MQRC_MCAST_PUB_STATUS";
            case 2572:
                return "MQRC_MCAST_SUB_STATUS";
            case 2573:
                return "MQRC_PRECONN_EXIT_LOAD_ERROR";
            case 2574:
                return "MQRC_PRECONN_EXIT_NOT_FOUND";
            case 2575:
                return "MQRC_PRECONN_EXIT_ERROR";
            case 2576:
                return "MQRC_CD_ARRAY_ERROR";
            case 2577:
                return "MQRC_CHANNEL_BLOCKED";
            case 2578:
                return "MQRC_CHANNEL_BLOCKED_WARNING";
            case 2579:
                return "MQRC_SUBSCRIPTION_CREATE";
            case 2580:
                return "MQRC_SUBSCRIPTION_DELETE";
            case 2581:
                return "MQRC_SUBSCRIPTION_CHANGE";
            case 2582:
                return "MQRC_SUBSCRIPTION_REFRESH";
            case 2583:
                return "MQRC_INSTALLATION_MISMATCH";
            case 2584:
                return "MQRC_NOT_PRIVILEGED";
            case 2586:
                return "MQRC_PROPERTIES_DISABLED";
            case 2587:
                return "MQRC_HMSG_NOT_AVAILABLE";
            case 2588:
                return "MQRC_EXIT_PROPS_NOT_SUPPORTED";
            case 2589:
                return "MQRC_INSTALLATION_MISSING";
            case 2590:
                return "MQRC_FASTPATH_NOT_AVAILABLE";
            case 2591:
                return "MQRC_CIPHER_SPEC_NOT_SUITE_B";
            case 2592:
                return "MQRC_SUITE_B_ERROR";
            case 2593:
                return "MQRC_CERT_VAL_POLICY_ERROR";
            case 2594:
                return "MQRC_PASSWORD_PROTECTION_ERROR";
            case 2595:
                return "MQRC_CSP_ERROR";
            case 2596:
                return "MQRC_CERT_LABEL_NOT_ALLOWED";
            case 2598:
                return "MQRC_ADMIN_TOPIC_STRING_ERROR";
            case 2599:
                return "MQRC_AMQP_NOT_AVAILABLE";
            case 2600:
                return "MQRC_CCDT_URL_ERROR";
            case 2601:
                return "MQRC_Q_MGR_RECONNECT_REQUESTED";
            case 6100:
                return "MQRC_REOPEN_EXCL_INPUT_ERROR";
            case 6101:
                return "MQRC_REOPEN_INQUIRE_ERROR";
            case 6102:
                return "MQRC_REOPEN_SAVED_CONTEXT_ERR";
            case 6103:
                return "MQRC_REOPEN_TEMPORARY_Q_ERROR";
            case 6104:
                return "MQRC_ATTRIBUTE_LOCKED";
            case 6105:
                return "MQRC_CURSOR_NOT_VALID";
            case 6106:
                return "MQRC_ENCODING_ERROR";
            case 6107:
                return "MQRC_STRUC_ID_ERROR";
            case 6108:
                return "MQRC_NULL_POINTER";
            case 6109:
                return "MQRC_NO_CONNECTION_REFERENCE";
            case 6110:
                return "MQRC_NO_BUFFER";
            case 6111:
                return "MQRC_BINARY_DATA_LENGTH_ERROR";
            case 6112:
                return "MQRC_BUFFER_NOT_AUTOMATIC";
            case 6113:
                return "MQRC_INSUFFICIENT_BUFFER";
            case 6114:
                return "MQRC_INSUFFICIENT_DATA";
            case 6115:
                return "MQRC_DATA_TRUNCATED";
            case 6116:
                return "MQRC_ZERO_LENGTH";
            case 6117:
                return "MQRC_NEGATIVE_LENGTH";
            case 6118:
                return "MQRC_NEGATIVE_OFFSET";
            case 6119:
                return "MQRC_INCONSISTENT_FORMAT";
            case 6120:
                return "MQRC_INCONSISTENT_OBJECT_STATE";
            case 6121:
                return "MQRC_CONTEXT_OBJECT_NOT_VALID";
            case 6122:
                return "MQRC_CONTEXT_OPEN_ERROR";
            case 6124:
                return "MQRC_NOT_CONNECTED";
            case 6125:
                return "MQRC_NOT_OPEN";
            case 6126:
                return "MQRC_DISTRIBUTION_LIST_EMPTY";
            case 6127:
                return "MQRC_INCONSISTENT_OPEN_OPTIONS";
            case 6128:
                return "MQRC_WRONG_VERSION";
            case 6129:
                return "MQRC_REFERENCE_ERROR";
            case 6130:
                return "MQRC_XR_NOT_AVAILABLE";
            case 29440:
                return "MQRC_SUB_JOIN_NOT_ALTERABLE";
            default:
                return "";
        }
    }

    public static String MQRDNS_STR(int value) {
        switch (value) {
            case 0:
                return "MQRDNS_ENABLED";
            case 1:
                return "MQRDNS_DISABLED";
            default:
                return "";
        }
    }

    public static String MQRD_STR(int value) {
        switch (value) {
            case -1:
                return "MQRD_NO_RECONNECT";
            case 0:
                return "MQRD_NO_DELAY";
            default:
                return "";
        }
    }

    public static String MQREADA_STR(int value) {
        switch (value) {
            case 0:
                return "MQREADA_NO";
            case 1:
                return "MQREADA_YES";
            case 2:
                return "MQREADA_DISABLED";
            case 3:
                return "MQREADA_INHIBITED";
            case 4:
                return "MQREADA_BACKLOG";
            default:
                return "";
        }
    }

    public static String MQRECAUTO_STR(int value) {
        switch (value) {
            case 0:
                return "MQRECAUTO_NO";
            case 1:
                return "MQRECAUTO_YES";
            default:
                return "";
        }
    }

    public static String MQRECORDING_STR(int value) {
        switch (value) {
            case 0:
                return "MQRECORDING_DISABLED";
            case 1:
                return "MQRECORDING_Q";
            case 2:
                return "MQRECORDING_MSG";
            default:
                return "";
        }
    }

    public static String MQREGO_STR(int value) {
        switch (value) {
            case 0:
                return "MQREGO_NONE";
            case 1:
                return "MQREGO_CORREL_ID_AS_IDENTITY";
            case 2:
                return "MQREGO_ANONYMOUS";
            case 4:
                return "MQREGO_LOCAL";
            case 8:
                return "MQREGO_DIRECT_REQUESTS";
            case 16:
                return "MQREGO_NEW_PUBLICATIONS_ONLY";
            case 32:
                return "MQREGO_PUBLISH_ON_REQUEST_ONLY";
            case 64:
                return "MQREGO_DEREGISTER_ALL";
            case 128:
                return "MQREGO_INCLUDE_STREAM_NAME";
            case 256:
                return "MQREGO_INFORM_IF_RETAINED";
            case 512:
                return "MQREGO_DUPLICATES_OK";
            case 1024:
                return "MQREGO_NON_PERSISTENT";
            case 2048:
                return "MQREGO_PERSISTENT";
            case 4096:
                return "MQREGO_PERSISTENT_AS_PUBLISH";
            case 8192:
                return "MQREGO_PERSISTENT_AS_Q";
            case 16384:
                return "MQREGO_ADD_NAME";
            case 32768:
                return "MQREGO_NO_ALTERATION";
            case 65536:
                return "MQREGO_FULL_RESPONSE";
            case 131072:
                return "MQREGO_JOIN_SHARED";
            case 262144:
                return "MQREGO_JOIN_EXCLUSIVE";
            case 524288:
                return "MQREGO_LEAVE_ONLY";
            case 1048576:
                return "MQREGO_VARIABLE_USER_ID";
            case 2097152:
                return "MQREGO_LOCKED";
            default:
                return "";
        }
    }

    public static String MQREORG_STR(int value) {
        switch (value) {
            case 0:
                return "MQREORG_DISABLED";
            case 1:
                return "MQREORG_ENABLED";
            default:
                return "";
        }
    }

    public static String MQRFH_STR(int value) {
        switch (value) {
            case -65536:
                return "MQRFH_FLAGS_RESTRICTED_MASK";
            case 0:
                return "MQRFH_NONE";
            default:
                return "";
        }
    }

    public static String MQRL_STR(int value) {
        switch (value) {
            case -1:
                return "MQRL_UNDEFINED";
            default:
                return "";
        }
    }

    public static String MQROUTE_STR(int value) {
        switch (value) {
            case -65536:
                return "MQROUTE_DELIVER_REJ_UNSUP_MASK";
            case 0:
                return "MQROUTE_UNLIMITED_ACTIVITIES";
            case 2:
                return "MQROUTE_DETAIL_LOW";
            case 8:
                return "MQROUTE_DETAIL_MEDIUM";
            case 32:
                return "MQROUTE_DETAIL_HIGH";
            case 256:
                return "MQROUTE_FORWARD_ALL";
            case 512:
                return "MQROUTE_FORWARD_IF_SUPPORTED";
            case 4096:
                return "MQROUTE_DELIVER_YES";
            case 8192:
                return "MQROUTE_DELIVER_NO";
            case 65539:
                return "MQROUTE_ACCUMULATE_NONE";
            case 65540:
                return "MQROUTE_ACCUMULATE_IN_MSG";
            case 65541:
                return "MQROUTE_ACCUMULATE_AND_REPLY";
            default:
                return "";
        }
    }

    public static String MQRO_STR(int value) {
        switch (value) {
            case -270532353:
                return "MQRO_ACCEPT_UNSUP_MASK";
            case 0:
                return "MQRO_NONE";
            case 1:
                return "MQRO_PAN";
            case 2:
                return "MQRO_NAN";
            case 4:
                return "MQRO_ACTIVITY";
            case 64:
                return "MQRO_PASS_CORREL_ID";
            case 128:
                return "MQRO_PASS_MSG_ID";
            case 256:
                return "MQRO_COA";
            case 768:
                return "MQRO_COA_WITH_DATA";
            case 1792:
                return "MQRO_COA_WITH_FULL_DATA";
            case 2048:
                return "MQRO_COD";
            case 6144:
                return "MQRO_COD_WITH_DATA";
            case 14336:
                return "MQRO_COD_WITH_FULL_DATA";
            case 16384:
                return "MQRO_PASS_DISCARD_AND_EXPIRY";
            case 261888:
                return "MQRO_ACCEPT_UNSUP_IF_XMIT_MASK";
            case 2097152:
                return "MQRO_EXPIRATION";
            case 6291456:
                return "MQRO_EXPIRATION_WITH_DATA";
            case 14680064:
                return "MQRO_EXPIRATION_WITH_FULL_DATA";
            case 16777216:
                return "MQRO_EXCEPTION";
            case 50331648:
                return "MQRO_EXCEPTION_WITH_DATA";
            case 117440512:
                return "MQRO_EXCEPTION_WITH_FULL_DATA";
            case 134217728:
                return "MQRO_DISCARD_MSG";
            case 270270464:
                return "MQRO_REJECT_UNSUP_MASK";
            default:
                return "";
        }
    }

    public static String MQRP_STR(int value) {
        switch (value) {
            case 0:
                return "MQRP_NO";
            case 1:
                return "MQRP_YES";
            default:
                return "";
        }
    }

    public static String MQRQ_STR(int value) {
        switch (value) {
            case 1:
                return "MQRQ_CONN_NOT_AUTHORIZED";
            case 2:
                return "MQRQ_OPEN_NOT_AUTHORIZED";
            case 3:
                return "MQRQ_CLOSE_NOT_AUTHORIZED";
            case 4:
                return "MQRQ_CMD_NOT_AUTHORIZED";
            case 5:
                return "MQRQ_Q_MGR_STOPPING";
            case 6:
                return "MQRQ_Q_MGR_QUIESCING";
            case 7:
                return "MQRQ_CHANNEL_STOPPED_OK";
            case 8:
                return "MQRQ_CHANNEL_STOPPED_ERROR";
            case 9:
                return "MQRQ_CHANNEL_STOPPED_RETRY";
            case 10:
                return "MQRQ_CHANNEL_STOPPED_DISABLED";
            case 11:
                return "MQRQ_BRIDGE_STOPPED_OK";
            case 12:
                return "MQRQ_BRIDGE_STOPPED_ERROR";
            case 13:
                return "MQRQ_SSL_HANDSHAKE_ERROR";
            case 14:
                return "MQRQ_SSL_CIPHER_SPEC_ERROR";
            case 15:
                return "MQRQ_SSL_CLIENT_AUTH_ERROR";
            case 16:
                return "MQRQ_SSL_PEER_NAME_ERROR";
            case 17:
                return "MQRQ_SUB_NOT_AUTHORIZED";
            case 18:
                return "MQRQ_SUB_DEST_NOT_AUTHORIZED";
            case 19:
                return "MQRQ_SSL_UNKNOWN_REVOCATION";
            case 20:
                return "MQRQ_SYS_CONN_NOT_AUTHORIZED";
            case 21:
                return "MQRQ_CHANNEL_BLOCKED_ADDRESS";
            case 22:
                return "MQRQ_CHANNEL_BLOCKED_USERID";
            case 23:
                return "MQRQ_CHANNEL_BLOCKED_NOACCESS";
            case 24:
                return "MQRQ_MAX_ACTIVE_CHANNELS";
            case 25:
                return "MQRQ_MAX_CHANNELS";
            case 26:
                return "MQRQ_SVRCONN_INST_LIMIT";
            case 27:
                return "MQRQ_CLIENT_INST_LIMIT";
            case 28:
                return "MQRQ_CAF_NOT_INSTALLED";
            case 29:
                return "MQRQ_CSP_NOT_AUTHORIZED";
            case 30:
                return "MQRQ_FAILOVER_PERMITTED";
            case 31:
                return "MQRQ_FAILOVER_NOT_PERMITTED";
            case 32:
                return "MQRQ_STANDBY_ACTIVATED";
            default:
                return "";
        }
    }

    public static String MQRT_STR(int value) {
        switch (value) {
            case 1:
                return "MQRT_CONFIGURATION";
            case 2:
                return "MQRT_EXPIRY";
            case 3:
                return "MQRT_NSPROC";
            case 4:
                return "MQRT_PROXYSUB";
            case 5:
                return "MQRT_SUB_CONFIGURATION";
            default:
                return "";
        }
    }

    public static String MQRU_STR(int value) {
        switch (value) {
            case 1:
                return "MQRU_PUBLISH_ON_REQUEST";
            case 2:
                return "MQRU_PUBLISH_ALL";
            default:
                return "";
        }
    }

    public static String MQSCA_STR(int value) {
        switch (value) {
            case 0:
                return "MQSCA_REQUIRED";
            case 1:
                return "MQSCA_OPTIONAL";
            case 2:
                return "MQSCA_NEVER_REQUIRED";
            default:
                return "";
        }
    }

    public static String MQSCOPE_STR(int value) {
        switch (value) {
            case 0:
                return "MQSCOPE_ALL";
            case 1:
                return "MQSCOPE_AS_PARENT";
            case 4:
                return "MQSCOPE_QMGR";
            default:
                return "";
        }
    }

    public static String MQSCO_STR(int value) {
        switch (value) {
            case 1:
                return "MQSCO_Q_MGR";
            case 2:
                return "MQSCO_CELL";
            default:
                return "";
        }
    }

    public static String MQSCYC_STR(int value) {
        switch (value) {
            case 0:
                return "MQSCYC_UPPER";
            case 1:
                return "MQSCYC_MIXED";
            default:
                return "";
        }
    }

    public static String MQSECCOMM_STR(int value) {
        switch (value) {
            case 0:
                return "MQSECCOMM_NO";
            case 1:
                return "MQSECCOMM_YES";
            case 2:
                return "MQSECCOMM_ANON";
            default:
                return "";
        }
    }

    public static String MQSECITEM_STR(int value) {
        switch (value) {
            case 0:
                return "MQSECITEM_ALL";
            case 1:
                return "MQSECITEM_MQADMIN";
            case 2:
                return "MQSECITEM_MQNLIST";
            case 3:
                return "MQSECITEM_MQPROC";
            case 4:
                return "MQSECITEM_MQQUEUE";
            case 5:
                return "MQSECITEM_MQCONN";
            case 6:
                return "MQSECITEM_MQCMDS";
            case 7:
                return "MQSECITEM_MXADMIN";
            case 8:
                return "MQSECITEM_MXNLIST";
            case 9:
                return "MQSECITEM_MXPROC";
            case 10:
                return "MQSECITEM_MXQUEUE";
            case 11:
                return "MQSECITEM_MXTOPIC";
            default:
                return "";
        }
    }

    public static String MQSECPROT_STR(int value) {
        switch (value) {
            case 0:
                return "MQSECPROT_NONE";
            case 1:
                return "MQSECPROT_SSLV30";
            case 2:
                return "MQSECPROT_TLSV10";
            case 4:
                return "MQSECPROT_TLSV12";
            case 8:
                return "MQSECPROT_TLSV13";
            default:
                return "";
        }
    }

    public static String MQSECSW_STR(int value) {
        switch (value) {
            case 1:
                return "MQSECSW_PROCESS";
            case 2:
                return "MQSECSW_NAMELIST";
            case 3:
                return "MQSECSW_Q";
            case 4:
                return "MQSECSW_TOPIC";
            case 6:
                return "MQSECSW_CONTEXT";
            case 7:
                return "MQSECSW_ALTERNATE_USER";
            case 8:
                return "MQSECSW_COMMAND";
            case 9:
                return "MQSECSW_CONNECTION";
            case 10:
                return "MQSECSW_SUBSYSTEM";
            case 11:
                return "MQSECSW_COMMAND_RESOURCES";
            case 15:
                return "MQSECSW_Q_MGR";
            case 16:
                return "MQSECSW_QSG";
            case 21:
                return "MQSECSW_OFF_FOUND";
            case 22:
                return "MQSECSW_ON_FOUND";
            case 23:
                return "MQSECSW_OFF_NOT_FOUND";
            case 24:
                return "MQSECSW_ON_NOT_FOUND";
            case 25:
                return "MQSECSW_OFF_ERROR";
            case 26:
                return "MQSECSW_ON_OVERRIDDEN";
            default:
                return "";
        }
    }

    public static String MQSECTYPE_STR(int value) {
        switch (value) {
            case 1:
                return "MQSECTYPE_AUTHSERV";
            case 2:
                return "MQSECTYPE_SSL";
            case 3:
                return "MQSECTYPE_CLASSES";
            case 4:
                return "MQSECTYPE_CONNAUTH";
            default:
                return "";
        }
    }

    public static String MQSELTYPE_STR(int value) {
        switch (value) {
            case 0:
                return "MQSELTYPE_NONE";
            case 1:
                return "MQSELTYPE_STANDARD";
            case 2:
                return "MQSELTYPE_EXTENDED";
            default:
                return "";
        }
    }

    public static String MQSEL_ALL_STR(int value) {
        switch (value) {
            case -30003:
                return "MQSEL_ALL_SYSTEM_SELECTORS";
            case -30002:
                return "MQSEL_ALL_USER_SELECTORS";
            case -30001:
                return "MQSEL_ALL_SELECTORS";
            default:
                return "";
        }
    }

    public static String MQSEL_ANY_STR(int value) {
        switch (value) {
            case -30003:
                return "MQSEL_ANY_SYSTEM_SELECTOR";
            case -30002:
                return "MQSEL_ANY_USER_SELECTOR";
            case -30001:
                return "MQSEL_ANY_SELECTOR";
            default:
                return "";
        }
    }

    public static String MQSMPO_STR(int value) {
        switch (value) {
            case 0:
                return "MQSMPO_NONE";
            case 1:
                return "MQSMPO_SET_PROP_UNDER_CURSOR";
            case 2:
                return "MQSMPO_SET_PROP_AFTER_CURSOR";
            case 4:
                return "MQSMPO_APPEND_PROPERTY";
            case 8:
                return "MQSMPO_SET_PROP_BEFORE_CURSOR";
            default:
                return "";
        }
    }

    public static String MQSO_STR(int value) {
        switch (value) {
            case 0:
                return "MQSO_NONE";
            case 1:
                return "MQSO_ALTER";
            case 2:
                return "MQSO_CREATE";
            case 4:
                return "MQSO_RESUME";
            case 8:
                return "MQSO_DURABLE";
            case 16:
                return "MQSO_GROUP_SUB";
            case 32:
                return "MQSO_MANAGED";
            case 64:
                return "MQSO_SET_IDENTITY_CONTEXT";
            case 128:
                return "MQSO_NO_MULTICAST";
            case 256:
                return "MQSO_FIXED_USERID";
            case 512:
                return "MQSO_ANY_USERID";
            case 2048:
                return "MQSO_PUBLICATIONS_ON_REQUEST";
            case 4096:
                return "MQSO_NEW_PUBLICATIONS_ONLY";
            case 8192:
                return "MQSO_FAIL_IF_QUIESCING";
            case 262144:
                return "MQSO_ALTERNATE_USER_AUTHORITY";
            case 1048576:
                return "MQSO_WILDCARD_CHAR";
            case 2097152:
                return "MQSO_WILDCARD_TOPIC";
            case 4194304:
                return "MQSO_SET_CORREL_ID";
            case 67108864:
                return "MQSO_SCOPE_QMGR";
            case 134217728:
                return "MQSO_NO_READ_AHEAD";
            case 268435456:
                return "MQSO_READ_AHEAD";
            default:
                return "";
        }
    }

    public static String MQSPL_STR(int value) {
        switch (value) {
            case 0:
                return "MQSPL_PASSTHRU";
            case 1:
                return "MQSPL_REMOVE";
            case 2:
                return "MQSPL_AS_POLICY";
            default:
                return "";
        }
    }

    public static String MQSP_STR(int value) {
        switch (value) {
            case 0:
                return "MQSP_NOT_AVAILABLE";
            case 1:
                return "MQSP_AVAILABLE";
            default:
                return "";
        }
    }

    public static String MQSQQM_STR(int value) {
        switch (value) {
            case 0:
                return "MQSQQM_USE";
            case 1:
                return "MQSQQM_IGNORE";
            default:
                return "";
        }
    }

    public static String MQSRO_STR(int value) {
        switch (value) {
            case 0:
                return "MQSRO_NONE";
            case 8192:
                return "MQSRO_FAIL_IF_QUIESCING";
            default:
                return "";
        }
    }

    public static String MQSR_STR(int value) {
        switch (value) {
            case 1:
                return "MQSR_ACTION_PUBLICATION";
            default:
                return "";
        }
    }

    public static String MQSSL_STR(int value) {
        switch (value) {
            case 0:
                return "MQSSL_FIPS_NO";
            case 1:
                return "MQSSL_FIPS_YES";
            default:
                return "";
        }
    }

    public static String MQSTAT_STR(int value) {
        switch (value) {
            case 0:
                return "MQSTAT_TYPE_ASYNC_ERROR";
            case 1:
                return "MQSTAT_TYPE_RECONNECTION";
            case 2:
                return "MQSTAT_TYPE_RECONNECTION_ERROR";
            default:
                return "";
        }
    }

    public static String MQSTDBY_STR(int value) {
        switch (value) {
            case 0:
                return "MQSTDBY_NOT_PERMITTED";
            case 1:
                return "MQSTDBY_PERMITTED";
            default:
                return "";
        }
    }

    public static String MQSUBTYPE_STR(int value) {
        switch (value) {
            case -2:
                return "MQSUBTYPE_USER";
            case -1:
                return "MQSUBTYPE_ALL";
            case 1:
                return "MQSUBTYPE_API";
            case 2:
                return "MQSUBTYPE_ADMIN";
            case 3:
                return "MQSUBTYPE_PROXY";
            default:
                return "";
        }
    }

    public static String MQSUB_STR(int value) {
        switch (value) {
            case -1:
                return "MQSUB_DURABLE_ALL";
            case 0:
                return "MQSUB_DURABLE_AS_PARENT";
            case 1:
                return "MQSUB_DURABLE_ALLOWED";
            case 2:
                return "MQSUB_DURABLE_INHIBITED";
            default:
                return "";
        }
    }

    public static String MQSUS_STR(int value) {
        switch (value) {
            case 0:
                return "MQSUS_NO";
            case 1:
                return "MQSUS_YES";
            default:
                return "";
        }
    }

    public static String MQSVC_CONTROL_STR(int value) {
        switch (value) {
            case 0:
                return "MQSVC_CONTROL_Q_MGR";
            case 1:
                return "MQSVC_CONTROL_Q_MGR_START";
            case 2:
                return "MQSVC_CONTROL_MANUAL";
            default:
                return "";
        }
    }

    public static String MQSVC_STATUS_STR(int value) {
        switch (value) {
            case 0:
                return "MQSVC_STATUS_STOPPED";
            case 1:
                return "MQSVC_STATUS_STARTING";
            case 2:
                return "MQSVC_STATUS_RUNNING";
            case 3:
                return "MQSVC_STATUS_STOPPING";
            case 4:
                return "MQSVC_STATUS_RETRYING";
            default:
                return "";
        }
    }

    public static String MQSVC_TYPE_STR(int value) {
        switch (value) {
            case 0:
                return "MQSVC_TYPE_COMMAND";
            case 1:
                return "MQSVC_TYPE_SERVER";
            default:
                return "";
        }
    }

    public static String MQSYNCPOINT_STR(int value) {
        switch (value) {
            case 0:
                return "MQSYNCPOINT_YES";
            case 1:
                return "MQSYNCPOINT_IFPER";
            default:
                return "";
        }
    }

    public static String MQSYSOBJ_STR(int value) {
        switch (value) {
            case 0:
                return "MQSYSOBJ_YES";
            case 1:
                return "MQSYSOBJ_NO";
            default:
                return "";
        }
    }

    public static String MQSYSP_STR(int value) {
        switch (value) {
            case 0:
                return "MQSYSP_NO";
            case 1:
                return "MQSYSP_YES";
            case 2:
                return "MQSYSP_EXTENDED";
            case 10:
                return "MQSYSP_TYPE_INITIAL";
            case 11:
                return "MQSYSP_TYPE_SET";
            case 12:
                return "MQSYSP_TYPE_LOG_COPY";
            case 13:
                return "MQSYSP_TYPE_LOG_STATUS";
            case 14:
                return "MQSYSP_TYPE_ARCHIVE_TAPE";
            case 20:
                return "MQSYSP_ALLOC_BLK";
            case 21:
                return "MQSYSP_ALLOC_TRK";
            case 22:
                return "MQSYSP_ALLOC_CYL";
            case 30:
                return "MQSYSP_STATUS_BUSY";
            case 31:
                return "MQSYSP_STATUS_PREMOUNT";
            case 32:
                return "MQSYSP_STATUS_AVAILABLE";
            case 33:
                return "MQSYSP_STATUS_UNKNOWN";
            case 34:
                return "MQSYSP_STATUS_ALLOC_ARCHIVE";
            case 35:
                return "MQSYSP_STATUS_COPYING_BSDS";
            case 36:
                return "MQSYSP_STATUS_COPYING_LOG";
            default:
                return "";
        }
    }

    public static String MQS_AVAIL_STR(int value) {
        switch (value) {
            case 0:
                return "MQS_AVAIL_NORMAL";
            case 1:
                return "MQS_AVAIL_ERROR";
            case 2:
                return "MQS_AVAIL_STOPPED";
            default:
                return "";
        }
    }

    public static String MQS_EXPANDST_STR(int value) {
        switch (value) {
            case 0:
                return "MQS_EXPANDST_NORMAL";
            case 1:
                return "MQS_EXPANDST_FAILED";
            case 2:
                return "MQS_EXPANDST_MAXIMUM";
            default:
                return "";
        }
    }

    public static String MQS_OPENMODE_STR(int value) {
        switch (value) {
            case 0:
                return "MQS_OPENMODE_NONE";
            case 1:
                return "MQS_OPENMODE_READONLY";
            case 2:
                return "MQS_OPENMODE_UPDATE";
            case 3:
                return "MQS_OPENMODE_RECOVERY";
            default:
                return "";
        }
    }

    public static String MQS_STATUS_STR(int value) {
        switch (value) {
            case 0:
                return "MQS_STATUS_CLOSED";
            case 1:
                return "MQS_STATUS_CLOSING";
            case 2:
                return "MQS_STATUS_OPENING";
            case 3:
                return "MQS_STATUS_OPEN";
            case 4:
                return "MQS_STATUS_NOTENABLED";
            case 5:
                return "MQS_STATUS_ALLOCFAIL";
            case 6:
                return "MQS_STATUS_OPENFAIL";
            case 7:
                return "MQS_STATUS_STGFAIL";
            case 8:
                return "MQS_STATUS_DATAFAIL";
            default:
                return "";
        }
    }

    public static String MQTA_STR(int value) {
        switch (value) {
            case 1:
                return "MQTA_BLOCK";
            case 2:
                return "MQTA_PASSTHRU";
            default:
                return "";
        }
    }

    public static String MQTA_PROXY_STR(int value) {
        switch (value) {
            case 1:
                return "MQTA_PROXY_SUB_FORCE";
            case 2:
                return "MQTA_PROXY_SUB_FIRSTUSE";
            default:
                return "";
        }
    }

    public static String MQTA_PUB_STR(int value) {
        switch (value) {
            case 0:
                return "MQTA_PUB_AS_PARENT";
            case 1:
                return "MQTA_PUB_INHIBITED";
            case 2:
                return "MQTA_PUB_ALLOWED";
            default:
                return "";
        }
    }

    public static String MQTA_SUB_STR(int value) {
        switch (value) {
            case 0:
                return "MQTA_SUB_AS_PARENT";
            case 1:
                return "MQTA_SUB_INHIBITED";
            case 2:
                return "MQTA_SUB_ALLOWED";
            default:
                return "";
        }
    }

    public static String MQTCPKEEP_STR(int value) {
        switch (value) {
            case 0:
                return "MQTCPKEEP_NO";
            case 1:
                return "MQTCPKEEP_YES";
            default:
                return "";
        }
    }

    public static String MQTCPSTACK_STR(int value) {
        switch (value) {
            case 0:
                return "MQTCPSTACK_SINGLE";
            case 1:
                return "MQTCPSTACK_MULTIPLE";
            default:
                return "";
        }
    }

    public static String MQTC_STR(int value) {
        switch (value) {
            case 0:
                return "MQTC_OFF";
            case 1:
                return "MQTC_ON";
            default:
                return "";
        }
    }

    public static String MQTIME_STR(int value) {
        switch (value) {
            case 0:
                return "MQTIME_UNIT_MINS";
            case 1:
                return "MQTIME_UNIT_SECS";
            default:
                return "";
        }
    }

    public static String MQTOPT_STR(int value) {
        switch (value) {
            case 0:
                return "MQTOPT_LOCAL";
            case 1:
                return "MQTOPT_CLUSTER";
            case 2:
                return "MQTOPT_ALL";
            default:
                return "";
        }
    }

    public static String MQTRAXSTR_STR(int value) {
        switch (value) {
            case 0:
                return "MQTRAXSTR_NO";
            case 1:
                return "MQTRAXSTR_YES";
            default:
                return "";
        }
    }

    public static String MQTRIGGER_STR(int value) {
        switch (value) {
            case 0:
                return "MQTRIGGER_RESTART_NO";
            case 1:
                return "MQTRIGGER_RESTART_YES";
            default:
                return "";
        }
    }

    public static String MQTSCOPE_STR(int value) {
        switch (value) {
            case 1:
                return "MQTSCOPE_QMGR";
            case 2:
                return "MQTSCOPE_ALL";
            default:
                return "";
        }
    }

    public static String MQTT_STR(int value) {
        switch (value) {
            case 0:
                return "MQTT_NONE";
            case 1:
                return "MQTT_FIRST";
            case 2:
                return "MQTT_EVERY";
            case 3:
                return "MQTT_DEPTH";
            default:
                return "";
        }
    }

    public static String MQTYPE_STR(int value) {
        switch (value) {
            case 0:
                return "MQTYPE_AS_SET";
            case 2:
                return "MQTYPE_NULL";
            case 4:
                return "MQTYPE_BOOLEAN";
            case 8:
                return "MQTYPE_BYTE_STRING";
            case 16:
                return "MQTYPE_INT8";
            case 32:
                return "MQTYPE_INT16";
            case 64:
                return "MQTYPE_INT32";
            case 128:
                return "MQTYPE_INT64";
            case 256:
                return "MQTYPE_FLOAT32";
            case 512:
                return "MQTYPE_FLOAT64";
            case 1024:
                return "MQTYPE_STRING";
            default:
                return "";
        }
    }

    public static String MQUCI_STR(int value) {
        switch (value) {
            case 0:
                return "MQUCI_NO";
            case 1:
                return "MQUCI_YES";
            default:
                return "";
        }
    }

    public static String MQUIDSUPP_STR(int value) {
        switch (value) {
            case 0:
                return "MQUIDSUPP_NO";
            case 1:
                return "MQUIDSUPP_YES";
            default:
                return "";
        }
    }

    public static String MQUNDELIVERED_STR(int value) {
        switch (value) {
            case 0:
                return "MQUNDELIVERED_NORMAL";
            case 1:
                return "MQUNDELIVERED_SAFE";
            case 2:
                return "MQUNDELIVERED_DISCARD";
            case 3:
                return "MQUNDELIVERED_KEEP";
            default:
                return "";
        }
    }

    public static String MQUOWST_STR(int value) {
        switch (value) {
            case 0:
                return "MQUOWST_NONE";
            case 1:
                return "MQUOWST_ACTIVE";
            case 2:
                return "MQUOWST_PREPARED";
            case 3:
                return "MQUOWST_UNRESOLVED";
            default:
                return "";
        }
    }

    public static String MQUOWT_STR(int value) {
        switch (value) {
            case 0:
                return "MQUOWT_Q_MGR";
            case 1:
                return "MQUOWT_CICS";
            case 2:
                return "MQUOWT_RRS";
            case 3:
                return "MQUOWT_IMS";
            case 4:
                return "MQUOWT_XA";
            default:
                return "";
        }
    }

    public static String MQUSAGE_DS_STR(int value) {
        switch (value) {
            case 10:
                return "MQUSAGE_DS_OLDEST_ACTIVE_UOW";
            case 11:
                return "MQUSAGE_DS_OLDEST_PS_RECOVERY";
            case 12:
                return "MQUSAGE_DS_OLDEST_CF_RECOVERY";
            default:
                return "";
        }
    }

    public static String MQUSAGE_EXPAND_STR(int value) {
        switch (value) {
            case 1:
                return "MQUSAGE_EXPAND_USER";
            case 2:
                return "MQUSAGE_EXPAND_SYSTEM";
            case 3:
                return "MQUSAGE_EXPAND_NONE";
            default:
                return "";
        }
    }

    public static String MQUSAGE_PS_STR(int value) {
        switch (value) {
            case 0:
                return "MQUSAGE_PS_AVAILABLE";
            case 1:
                return "MQUSAGE_PS_DEFINED";
            case 2:
                return "MQUSAGE_PS_OFFLINE";
            case 3:
                return "MQUSAGE_PS_NOT_DEFINED";
            case 4:
                return "MQUSAGE_PS_SUSPENDED";
            default:
                return "";
        }
    }

    public static String MQUSAGE_SMDS_STR(int value) {
        switch (value) {
            case 0:
                return "MQUSAGE_SMDS_AVAILABLE";
            case 1:
                return "MQUSAGE_SMDS_NO_DATA";
            default:
                return "";
        }
    }

    public static String MQUSEDLQ_STR(int value) {
        switch (value) {
            case 0:
                return "MQUSEDLQ_AS_PARENT";
            case 1:
                return "MQUSEDLQ_NO";
            case 2:
                return "MQUSEDLQ_YES";
            default:
                return "";
        }
    }

    public static String MQUSRC_STR(int value) {
        switch (value) {
            case 0:
                return "MQUSRC_MAP";
            case 1:
                return "MQUSRC_NOACCESS";
            case 2:
                return "MQUSRC_CHANNEL";
            default:
                return "";
        }
    }

    public static String MQUS_STR(int value) {
        switch (value) {
            case 0:
                return "MQUS_NORMAL";
            case 1:
                return "MQUS_TRANSMISSION";
            default:
                return "";
        }
    }

    public static String MQVL_STR(int value) {
        switch (value) {
            case -1:
                return "MQVL_NULL_TERMINATED";
            case 0:
                return "MQVL_EMPTY_STRING";
            default:
                return "";
        }
    }

    public static String MQVS_STR(int value) {
        switch (value) {
            case -1:
                return "MQVS_NULL_TERMINATED";
            default:
                return "";
        }
    }

    public static String MQVU_STR(int value) {
        switch (value) {
            case 1:
                return "MQVU_FIXED_USER";
            case 2:
                return "MQVU_ANY_USER";
            default:
                return "";
        }
    }

    public static String MQWARN_STR(int value) {
        switch (value) {
            case 0:
                return "MQWARN_NO";
            case 1:
                return "MQWARN_YES";
            default:
                return "";
        }
    }

    public static String MQWIH_STR(int value) {
        switch (value) {
            case 0:
                return "MQWIH_NONE";
            default:
                return "";
        }
    }

    public static String MQWI_STR(int value) {
        switch (value) {
            case -1:
                return "MQWI_UNLIMITED";
            default:
                return "";
        }
    }

    public static String MQWS_STR(int value) {
        switch (value) {
            case 0:
                return "MQWS_DEFAULT";
            case 1:
                return "MQWS_CHAR";
            case 2:
                return "MQWS_TOPIC";
            default:
                return "";
        }
    }

    public static String MQWXP_STR(int value) {
        switch (value) {
            case 2:
                return "MQWXP_PUT_BY_CLUSTER_CHL";
            default:
                return "";
        }
    }

    public static String MQXACT_STR(int value) {
        switch (value) {
            case 1:
                return "MQXACT_EXTERNAL";
            case 2:
                return "MQXACT_INTERNAL";
            default:
                return "";
        }
    }

    public static String MQXCC_STR(int value) {
        switch (value) {
            case -8:
                return "MQXCC_FAILED";
            case -7:
                return "MQXCC_REQUEST_ACK";
            case -6:
                return "MQXCC_CLOSE_CHANNEL";
            case -5:
                return "MQXCC_SUPPRESS_EXIT";
            case -4:
                return "MQXCC_SEND_SEC_MSG";
            case -3:
                return "MQXCC_SEND_AND_REQUEST_SEC_MSG";
            case -2:
                return "MQXCC_SKIP_FUNCTION";
            case -1:
                return "MQXCC_SUPPRESS_FUNCTION";
            case 0:
                return "MQXCC_OK";
            default:
                return "";
        }
    }

    public static String MQXC_STR(int value) {
        switch (value) {
            case 1:
                return "MQXC_MQOPEN";
            case 2:
                return "MQXC_MQCLOSE";
            case 3:
                return "MQXC_MQGET";
            case 4:
                return "MQXC_MQPUT";
            case 5:
                return "MQXC_MQPUT1";
            case 6:
                return "MQXC_MQINQ";
            case 8:
                return "MQXC_MQSET";
            case 9:
                return "MQXC_MQBACK";
            case 10:
                return "MQXC_MQCMIT";
            case 42:
                return "MQXC_MQSUB";
            case 43:
                return "MQXC_MQSUBRQ";
            case 44:
                return "MQXC_MQCB";
            case 45:
                return "MQXC_MQCTL";
            case 46:
                return "MQXC_MQSTAT";
            case 48:
                return "MQXC_CALLBACK";
            default:
                return "";
        }
    }

    public static String MQXDR_STR(int value) {
        switch (value) {
            case 0:
                return "MQXDR_OK";
            case 1:
                return "MQXDR_CONVERSION_FAILED";
            default:
                return "";
        }
    }

    public static String MQXEPO_STR(int value) {
        switch (value) {
            case 0:
                return "MQXEPO_NONE";
            default:
                return "";
        }
    }

    public static String MQXE_STR(int value) {
        switch (value) {
            case 0:
                return "MQXE_OTHER";
            case 1:
                return "MQXE_MCA";
            case 2:
                return "MQXE_MCA_SVRCONN";
            case 3:
                return "MQXE_COMMAND_SERVER";
            case 4:
                return "MQXE_MQSC";
            case 5:
                return "MQXE_MCA_CLNTCONN";
            default:
                return "";
        }
    }

    public static String MQXF_STR(int value) {
        switch (value) {
            case 1:
                return "MQXF_INIT";
            case 2:
                return "MQXF_TERM";
            case 3:
                return "MQXF_CONN";
            case 4:
                return "MQXF_CONNX";
            case 5:
                return "MQXF_DISC";
            case 6:
                return "MQXF_OPEN";
            case 7:
                return "MQXF_CLOSE";
            case 8:
                return "MQXF_PUT1";
            case 9:
                return "MQXF_PUT";
            case 10:
                return "MQXF_GET";
            case 11:
                return "MQXF_DATA_CONV_ON_GET";
            case 12:
                return "MQXF_INQ";
            case 13:
                return "MQXF_SET";
            case 14:
                return "MQXF_BEGIN";
            case 15:
                return "MQXF_CMIT";
            case 16:
                return "MQXF_BACK";
            case 18:
                return "MQXF_STAT";
            case 19:
                return "MQXF_CB";
            case 20:
                return "MQXF_CTL";
            case 21:
                return "MQXF_CALLBACK";
            case 22:
                return "MQXF_SUB";
            case 23:
                return "MQXF_SUBRQ";
            case 24:
                return "MQXF_XACLOSE";
            case 25:
                return "MQXF_XACOMMIT";
            case 26:
                return "MQXF_XACOMPLETE";
            case 27:
                return "MQXF_XAEND";
            case 28:
                return "MQXF_XAFORGET";
            case 29:
                return "MQXF_XAOPEN";
            case 30:
                return "MQXF_XAPREPARE";
            case 31:
                return "MQXF_XARECOVER";
            case 32:
                return "MQXF_XAROLLBACK";
            case 33:
                return "MQXF_XASTART";
            case 34:
                return "MQXF_AXREG";
            case 35:
                return "MQXF_AXUNREG";
            default:
                return "";
        }
    }

    public static String MQXPT_STR(int value) {
        switch (value) {
            case -1:
                return "MQXPT_ALL";
            case 0:
                return "MQXPT_LOCAL";
            case 1:
                return "MQXPT_LU62";
            case 2:
                return "MQXPT_TCP";
            case 3:
                return "MQXPT_NETBIOS";
            case 4:
                return "MQXPT_SPX";
            case 5:
                return "MQXPT_DECNET";
            case 6:
                return "MQXPT_UDP";
            default:
                return "";
        }
    }

    public static String MQXR2_STR(int value) {
        switch (value) {
            case 0:
                return "MQXR2_DEFAULT_CONTINUATION";
            case 1:
                return "MQXR2_PUT_WITH_DEF_USERID";
            case 2:
                return "MQXR2_PUT_WITH_MSG_USERID";
            case 4:
                return "MQXR2_USE_EXIT_BUFFER";
            case 8:
                return "MQXR2_CONTINUE_CHAIN";
            case 16:
                return "MQXR2_SUPPRESS_CHAIN";
            case 32:
                return "MQXR2_DYNAMIC_CACHE";
            default:
                return "";
        }
    }

    public static String MQXR_STR(int value) {
        switch (value) {
            case 1:
                return "MQXR_BEFORE";
            case 2:
                return "MQXR_AFTER";
            case 3:
                return "MQXR_CONNECTION";
            case 4:
                return "MQXR_BEFORE_CONVERT";
            case 11:
                return "MQXR_INIT";
            case 12:
                return "MQXR_TERM";
            case 13:
                return "MQXR_MSG";
            case 14:
                return "MQXR_XMIT";
            case 15:
                return "MQXR_SEC_MSG";
            case 16:
                return "MQXR_INIT_SEC";
            case 17:
                return "MQXR_RETRY";
            case 18:
                return "MQXR_AUTO_CLUSSDR";
            case 19:
                return "MQXR_AUTO_RECEIVER";
            case 20:
                return "MQXR_CLWL_OPEN";
            case 21:
                return "MQXR_CLWL_PUT";
            case 22:
                return "MQXR_CLWL_MOVE";
            case 23:
                return "MQXR_CLWL_REPOS";
            case 24:
                return "MQXR_CLWL_REPOS_MOVE";
            case 25:
                return "MQXR_END_BATCH";
            case 26:
                return "MQXR_ACK_RECEIVED";
            case 27:
                return "MQXR_AUTO_SVRCONN";
            case 28:
                return "MQXR_AUTO_CLUSRCVR";
            case 29:
                return "MQXR_SEC_PARMS";
            case 30:
                return "MQXR_PUBLICATION";
            case 31:
                return "MQXR_PRECONNECT";
            default:
                return "";
        }
    }

    public static String MQXT_STR(int value) {
        switch (value) {
            case 1:
                return "MQXT_API_CROSSING_EXIT";
            case 2:
                return "MQXT_API_EXIT";
            case 11:
                return "MQXT_CHANNEL_SEC_EXIT";
            case 12:
                return "MQXT_CHANNEL_MSG_EXIT";
            case 13:
                return "MQXT_CHANNEL_SEND_EXIT";
            case 14:
                return "MQXT_CHANNEL_RCV_EXIT";
            case 15:
                return "MQXT_CHANNEL_MSG_RETRY_EXIT";
            case 16:
                return "MQXT_CHANNEL_AUTO_DEF_EXIT";
            case 20:
                return "MQXT_CLUSTER_WORKLOAD_EXIT";
            case 21:
                return "MQXT_PUBSUB_ROUTING_EXIT";
            case 22:
                return "MQXT_PUBLISH_EXIT";
            case 23:
                return "MQXT_PRECONNECT_EXIT";
            default:
                return "";
        }
    }

    public static String MQZAET_STR(int value) {
        switch (value) {
            case 0:
                return "MQZAET_NONE";
            case 1:
                return "MQZAET_PRINCIPAL";
            case 2:
                return "MQZAET_GROUP";
            case 3:
                return "MQZAET_UNKNOWN";
            default:
                return "";
        }
    }

    public static String MQZAO_STR(int value) {
        switch (value) {
            case 0:
                return "MQZAO_NONE";
            case 1:
                return "MQZAO_CONNECT";
            case 2:
                return "MQZAO_BROWSE";
            case 4:
                return "MQZAO_INPUT";
            case 8:
                return "MQZAO_OUTPUT";
            case 16:
                return "MQZAO_INQUIRE";
            case 32:
                return "MQZAO_SET";
            case 64:
                return "MQZAO_PASS_IDENTITY_CONTEXT";
            case 128:
                return "MQZAO_PASS_ALL_CONTEXT";
            case 256:
                return "MQZAO_SET_IDENTITY_CONTEXT";
            case 512:
                return "MQZAO_SET_ALL_CONTEXT";
            case 1024:
                return "MQZAO_ALTERNATE_USER_AUTHORITY";
            case 2048:
                return "MQZAO_PUBLISH";
            case 4096:
                return "MQZAO_SUBSCRIBE";
            case 8192:
                return "MQZAO_RESUME";
            case 16383:
                return "MQZAO_ALL_MQI";
            case 65536:
                return "MQZAO_CREATE";
            case 131072:
                return "MQZAO_DELETE";
            case 262144:
                return "MQZAO_DISPLAY";
            case 524288:
                return "MQZAO_CHANGE";
            case 1048576:
                return "MQZAO_CLEAR";
            case 2097152:
                return "MQZAO_CONTROL";
            case 4194304:
                return "MQZAO_CONTROL_EXTENDED";
            case 8388608:
                return "MQZAO_AUTHORIZE";
            case 16646144:
                return "MQZAO_ALL_ADMIN";
            case 16777216:
                return "MQZAO_REMOVE";
            case 33554432:
                return "MQZAO_SYSTEM";
            case 50216959:
                return "MQZAO_ALL";
            case 67108864:
                return "MQZAO_CREATE_ONLY";
            default:
                return "";
        }
    }

    public static String MQZAT_STR(int value) {
        switch (value) {
            case 0:
                return "MQZAT_INITIAL_CONTEXT";
            case 1:
                return "MQZAT_CHANGE_CONTEXT";
            default:
                return "";
        }
    }

    public static String MQZCI_STR(int value) {
        switch (value) {
            case 0:
                return "MQZCI_CONTINUE";
            case 1:
                return "MQZCI_STOP";
            default:
                return "";
        }
    }

    public static String MQZIO_STR(int value) {
        switch (value) {
            case 0:
                return "MQZIO_PRIMARY";
            case 1:
                return "MQZIO_SECONDARY";
            default:
                return "";
        }
    }

    public static String MQZSE_STR(int value) {
        switch (value) {
            case 0:
                return "MQZSE_CONTINUE";
            case 1:
                return "MQZSE_START";
            default:
                return "";
        }
    }

    public static String MQZSL_STR(int value) {
        switch (value) {
            case 0:
                return "MQZSL_NOT_RETURNED";
            case 1:
                return "MQZSL_RETURNED";
            default:
                return "";
        }
    }

    public static String MQZTO_STR(int value) {
        switch (value) {
            case 0:
                return "MQZTO_PRIMARY";
            case 1:
                return "MQZTO_SECONDARY";
            default:
                return "";
        }
    }

    public static String MQ_CERT_STR(int value) {
        switch (value) {
            case 0:
                return "MQ_CERT_VAL_POLICY_ANY";
            case 1:
                return "MQ_CERT_VAL_POLICY_RFC5280";
            default:
                return "";
        }
    }

    public static String MQ_MQTT_STR(int value) {
        switch (value) {
            case 65536:
                return "MQ_MQTT_MAX_KEEP_ALIVE";
            default:
                return "";
        }
    }

    public static String MQ_SUITE_STR(int value) {
        switch (value) {
            case 0:
                return "MQ_SUITE_B_NOT_AVAILABLE";
            case 1:
                return "MQ_SUITE_B_NONE";
            case 2:
                return "MQ_SUITE_B_128_BIT";
            case 4:
                return "MQ_SUITE_B_192_BIT";
            default:
                return "";
        }
    }
}
