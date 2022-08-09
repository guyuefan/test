package com.uniubi.visitor.common.enums;

import lombok.Getter;

/**
 * 健康码平台类型枚举
 */
@Getter
public enum HealthCodePlatformCodeEnum {


    /**
     * 国康码
     */
    COUNTRY_CODE(1, "国康码"),

    /**
     * 苏康码
     */
    SUZHOU_CODE(2, "苏康码"),

    /**
     * 安康码
     */
    AN_HUI_CODE(3, "安康码"),

    /**
     * 四川健康码
     */
    SI_CHUAN_CODE(4, "四川健康码"),


    ;

    /**
     * 健康码厂商类型
     */
    private Integer qrCodeFirmCode;

    /**
     * 健康码厂商描述
     */
    private String desc;

    HealthCodePlatformCodeEnum(Integer qrCodeFirmCode, String desc) {
        this.qrCodeFirmCode = qrCodeFirmCode;
        this.desc = desc;
    }

    public static HealthCodePlatformCodeEnum getHealthCodePlatform(Integer qrCodeFirmCode) {
        for (HealthCodePlatformCodeEnum healthCodePlatformCodeEnum : values()) {
            if (healthCodePlatformCodeEnum.getQrCodeFirmCode().equals(qrCodeFirmCode)) {
                return healthCodePlatformCodeEnum;
            }
        }
        return null;
    }
}
