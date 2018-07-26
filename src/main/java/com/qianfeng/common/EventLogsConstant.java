package com.qianfeng.common;

/**
 * @Auther: lyd
 * @Date: 2018/7/26 09:25
 * @Description:定义采集的数据中的相对应的key
 */
public class EventLogsConstant {

    /**
     * 定义事件枚举
     */
    public static enum EventEnum{
        LAUNCH(1,"lanuch event","e_l"),
        PAGEVIEW(2,"page view event","e_pv"),
        CHARGEREQUEST(3,"charge request event","e_crt"),
        CHARGESUCCESS(4,"charge success","e_cs"),
        CHARGEREFUND(5,"charge refund","e_cr"),
        EVENT(6,"event","e_e")
        ;

        public  final int id;
        public final  String name;
        public final String alias; //别名

        EventEnum(int id, String name, String alias) {
            this.id = id;
            this.name = name;
            this.alias = alias;
        }

        /**
         * 根据别名获取事件枚举
         * @param alias
         * @return
         */
        public static EventEnum valueOfAlias(String alias){
            //for循环
            for (EventEnum event:values()){
                if(alias.equals(event.alias)){
                    return event;
                }
            }
            return null;
        }
    }


    /**
     * 和日志相关
     */
    private static final String HABSE_TABLE_NAME = "logs";

    private static final String HBASE_COLUMN_FAMILY = "info";

    private static final String EVENT_COLUMN_NAME_VERSION = "ver";

    private static final String EVENT_COLUMN_NAME_SERVER_TIME = "s_time";

    private static final String EVENT_COLUMN_NAME_EVENT_NAME = "en";

    private static final String EVENT_COLUMN_NAME_UUID = "u_ud";

    private static final String EVENT_COLUMN_NAME_MEMBER_ID = "u_mid";

    private static final String EVENT_COLUMN_NAME_SESSION_ID = "u_sd";

    private static final String EVENT_COLUMN_NAME_CLIENT_TIME = "c_time";

    private static final String EVENT_COLUMN_NAME_LANGUAGE = "l";

    private static final String EVENT_COLUMN_NAME_USERAGENT = "b_iev";

    private static final String EVENT_COLUMN_NAME_RESOLUTION = "b_rst";

    private static final String EVENT_COLUMN_NAME_CURRENT_URL = "p_url";

    private static final String EVENT_COLUMN_NAME_PREFFER_URL = "p_ref";

    private static final String EVENT_COLUMN_NAME_TITLE = "tt";

    private static final String EVENT_COLUMN_NAME_PLATFORM = "pl";

    private static final String EVENT_COLUMN_NAME_IP = "ip";

    private static final String COLUMN_SEPARTOR = "\\^A";


    /**
     * 和订单相关
     */
    private static final String EVENT_COLUMN_NAME_ORDER_ID = "oid";

    private static final String EVENT_COLUMN_NAME_ORDER_NAME = "on";

    private static final String EVENT_COLUMN_NAME_CURRENCY_AMOUTN = "cua";

    private static final String EVENT_COLUMN_NAME_CURRENCY_TYPE = "cut";

    private static final String EVENT_COLUMN_NAME_PAYMENT_TYPE = "pt";


    /**
     * 事件相关
     */
    private static final String EVENT_COLUMN_NAME_EVENT_CATEGORY = "ca";

    private static final String EVENT_COLUMN_NAME_EVENT_ACTION = "ac";

    private static final String EVENT_COLUMN_NAME_EVENT_KV = "kv_";

    private static final String EVENT_COLUMN_NAME_EVENT_DURATION = "du";

    /**
     * 浏览器相关
     */

    private static final String EVENT_COLUMN_NAME_BROWSER_NAME = "browserName";

    private static final String EVENT_COLUMN_NAME_BROWSER_VERSION = "browserVersion";

    private static final String EVENT_COLUMN_NAME_OS_NAME = "osName";

    private static final String EVENT_COLUMN_NAME_OS_VERSION = "osVersion";

    /**
     * 地域相关
     */

    private static final String EVENT_COLUMN_NAME_COUNTRY = "country";

    private static final String EVENT_COLUMN_NAME_PROVINCE = "province";

    private static final String EVENT_COLUMN_NAME_CITY = "city";

}
