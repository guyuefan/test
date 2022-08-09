package com.uniubi.visitor.common.enums;

import lombok.Getter;

/**
 * @description:
 * @author: yangling
 * @time: 2021/8/26 8:01 下午
 */
@Getter
public enum HealthStatusEnum {

    GREEN("00", "绿码"),

    YELLOW("01", "黄码"),

    RED("10", "红码");

    private String status;

    private String value;


    HealthStatusEnum(String status, String value) {
        this.status = status;
        this.value = value;
    }

    public static String getValue(String code) {
        for (HealthStatusEnum statusEnum : HealthStatusEnum.values()) {
            if (statusEnum.getStatus().equals(code)) {
                return statusEnum.getValue();
            }
        }
        return null;
    }
}
