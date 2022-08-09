package com.uniubi.visitor.common.constant;

/**
 * @author RoyWang
 * @version 1.0
 * @date 2021/8/11 18:24
 */
public class HealthCodeConstant {

    /**
     * 健康码对接上报协议的类型
     */
    public static Integer CUSTOM_MESSAGE_TYPE = 80;

    /**
     * 超时
     */
    public static final Integer HTTP_TIME_OUT = 5000;


    /**
     * 国康码
     */
    public static class Country {

        /**
         * 国康码接口的响应参数
         */
        public static final Integer SUCCESS_CODE = 200;

        /**
         * 全国码请求地址
         */
        public static final String URL = "http://health.uniktarget.com:9882";

        /**
         * 登录URL
         */
        public static final String LOGIN_URL = "/api/login";

        /**
         * 二维码校验接口 URL
         */
        public static final String QCRVERIFY_URL = "/api/qcrverifyv3";

        /**
         * 身份证校验接口(v2) URL
         */
        public static final String IDVERIFYV2_URL = "/api/idverifyv2";
    }

    /**
     * 苏康码
     */
    public static class Sukang {

        /**
         * 苏康码请求地址
         */
        public static final String URL = "http://edu.uniktarget.com:9890";


        /**
         * 苏康码身份证接口
         */
        public static final String IDVERIFYV_URL = "/api/qcrverify";


    }


    /**
     * 四川健康码
     */
    public static class SiChuan {

        /**
         * 国康码接口的响应参数
         */
        public static final Integer SUCCESS_CODE = 200;

        /**
         * 请求地址
         */
        public static final String URL = "https://test2.yelisheng.com";

        /**
         * 设备激活接口
         */
        public static final String ACTIVE_DEVICE = "/prod-api/api/equipment/eptactive";

        /**
         * 健康码扫码接口
         */
        public static final String QCRVERIFY_URL = "/docking/api/equipment/code";

        /**
         * 通过身份认证信息
         * 获取健康码状态
         */
        public static final String IDVERIFYV_URL = "/docking/api/equipment/certificate";


    }

}
