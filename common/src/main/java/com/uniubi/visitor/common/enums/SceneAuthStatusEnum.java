package com.uniubi.visitor.common.enums;

import java.util.Arrays;

/**
 * @author zqp
 */
public enum SceneAuthStatusEnum {

    /**
     * 审核中
     */
    APPROVING(10, "审核中"),
    /**
     * 已拒绝
     */
    REFUSE(20, "已拒绝"),
    /**
     * 申请通过
     */
    SUCCESS(30, "申请通过");

    private final Integer code;
    private final String type;

    SceneAuthStatusEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public static SceneAuthStatusEnum typeOf(Integer code) {
        return Arrays.stream(SceneAuthStatusEnum.values()).filter(e -> e.getCode() == (code)).findFirst().orElse(null);
    }
}
