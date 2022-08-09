package com.uniubi.visitor.common.enums;

import lombok.Getter;

/**
 * @description:
 * @author: yangling
 * @time: 2021/8/24 4:43 下午
 */
@Getter
public enum RegisterStatusEnum {

    UNREGISTER(0, "未登记"),

    REGISTERED(1, "已登记");

    private Integer code;

    private String desc;

    RegisterStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
