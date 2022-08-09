package com.uniubi.visitor.common.enums;

import lombok.Getter;

/**
 * @description:
 * @author: yangling
 * @time: 2021/8/26 8:01 下午
 */
@Getter
public enum ItineraryStatusEnum {

    GREEN("00", "green"),

    YELLOW("01", "yellow"),

    RED("10", "red"),

    ORANGE("11", "orange");


    private String status;

    private String code;

    ItineraryStatusEnum(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public static String getStatus(String code) {
        for (ItineraryStatusEnum itineraryStatusEnum : values()) {
            if (itineraryStatusEnum.getCode().equals(code)) {
                return itineraryStatusEnum.getStatus();
            }
        }
        return null;
    }
}
