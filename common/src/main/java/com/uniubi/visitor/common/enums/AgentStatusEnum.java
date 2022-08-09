package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum AgentStatusEnum {
    CHECK_SUCCESS(1, "代理商审核通过"),
    CHECK_FAIL(0, "代理商审核不通过"),
    CHECK_WAIT(2, "待审核");

    private Integer code;
    private String message;

    AgentStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
