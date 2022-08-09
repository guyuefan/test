package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum SmsCodeEnum {

    HEALTH_CODE("健康码"),

    JOURNEY_CODE("行程卡");

    private String name;

    SmsCodeEnum(String name) {
        this.name = name;
    }


}
