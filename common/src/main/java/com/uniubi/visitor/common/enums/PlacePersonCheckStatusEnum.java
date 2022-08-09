package com.uniubi.visitor.common.enums;

import lombok.Getter;

/**
 * @author yangling
 */
@Getter
public enum PlacePersonCheckStatusEnum {

    UNCHECK(10, "未审核"),

    PASS(20, "审核通过"),

    REJECT(30, "审核拒绝");

    private Integer status;

    private String desc;


    PlacePersonCheckStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

}
