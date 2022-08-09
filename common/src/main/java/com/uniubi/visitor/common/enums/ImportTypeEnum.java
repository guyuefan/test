package com.uniubi.visitor.common.enums;

import java.util.Arrays;

/**
 * @author zqp
 */
public enum ImportTypeEnum {

    /**
     * 人员
     */
    PERSON(10, "人员"),
    /**
     * 部门
     */
    DEPT(20, "部门");

    private final Integer code;
    private final String type;

    ImportTypeEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public static ImportTypeEnum typeOf(Integer code) {
        return Arrays.stream(ImportTypeEnum.values()).filter(e -> e.getCode() == (code)).findFirst().orElse(null);
    }
}
