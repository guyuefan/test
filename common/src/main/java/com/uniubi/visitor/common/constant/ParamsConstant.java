package com.uniubi.visitor.common.constant;


import java.util.regex.Pattern;

/**
 * @author zqp
 */
public class ParamsConstant {

    public static final Integer ONE = 1;

    public static final String LOGIN_ERROR_CODE = "loginError";

    public static final String LAST_NAME_AUTH_SCENE = "90812111";

    public static final String ECO_HEALTH_TOKEN = "uniubi_visitor_token";

    public static final String UNDEFINED = "undefined";

    public static final String AUTH = "/auth";


    private static final String VALIDATE_PHONE = "^((13[0-9])|(15[^4,\\D])|(16[6])|(18[0-9])|(19[1,8,9])|(14[1,4,5,6,7,8,9])|(17[0,1,3,5-8]))\\d{8}$";


    public static Pattern PHONE_PATTERN = Pattern.compile(VALIDATE_PHONE);
}
