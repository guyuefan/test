package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum SceneTypeEnum {
    PROXY(1, "代理商"),

    SCENE(2, "信息不全"),;

    private Integer code;

    private String desc;

    SceneTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
