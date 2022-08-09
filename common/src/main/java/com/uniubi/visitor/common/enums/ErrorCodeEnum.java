package com.uniubi.visitor.common.enums;

import org.springframework.util.StringUtils;

/**
 * 错误码范围：22001-23000
 *
 */
public enum ErrorCodeEnum {

    /**
     * 【错误码范围】：22001-23000
     */
    // token无效
    TOKEN_INVALID("22001", "token invalid"),

    // 不支持该健康码厂商
    NOT_SUPPORT_QRCODEFIRM_CODE("22002", "不支持该健康码厂商"),

    // 健康码厂商调用失败,未获取有效信息
    INVOKE_HEALTHCODE_PLATFORM_FAIL("22006", "健康码厂商调用失败,未获取有效信息"),

    // 健康码厂商调用失败,国康码无效
    COUNTRY_QRCODE_ILLEGAL("22007", "无效国康码"),

    // 未获取健康码的状态
    NOT_GET_HEALTH_CODE_STATUS("22009", "未获取到健康码的状态，请稍后重试"),

    // 身份证或健康码不能同时为空
    ID_NUMBER_QRCODE_NULL("22010", "身份证或健康码不能同时为空"),


    // 国康码接口返回失败统一提示, 注意只使用错误码，不使用msg具体内容
    COUNTRY_HEALTH_CODE_RESPONSE("22011", "国康码接口返回失败统一提示"),

    ;

    private String code;
    private String msg;

    private ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCodeEnum getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (ErrorCodeEnum item : values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
