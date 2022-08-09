package com.uniubi.visitor.common.enums;

import java.util.Arrays;

/**
 * 人员类型
 *
 * @author zhaoyanbo
 */
public enum VisitorTypeEnum {

    VISITOR(10, "访客"),

    EMPLOYEE(20, "员工");


    private Integer code;

    private String desc;

    VisitorTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    public static VisitorTypeEnum codeOf(Integer code) {
        return Arrays.stream(VisitorTypeEnum.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(VisitorTypeEnum.VISITOR);
    }
}
