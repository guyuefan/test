package com.uniubi.visitor.common.enums;

/**
 * 证件类型枚举
 *
 * @author zhaoyanbo
 * @date 2021/08/22
 */
public enum CardTypeEnum {


    ID(1, "身份证"),

    PASSPORT(2, "护照"),

    MILITARY_ID(3, "军官证"),

    SOLDIER_ID(4, "士兵证"),

    OTHER(9, "其他");


    private Integer code;

    private String desc;

    CardTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
