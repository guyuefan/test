package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    FIRST_LOGIN(1, "第一次登陆"),

    NOT_FULL_INFORMATION(2, "信息不全"),

    ALL_CLEAR_SCAN(3, "信息完全"),


    PROXY(4, "代理商"),

    ALL_CLEAR_HOME(5, "PC"),

    PLACE_HOME(6, "非代理商，场所注册页面"),

    PLACE_PERSON_REGISTER(10, "场所员工登记页面"),

    PLACE_MANAGER(11, "场所管理员小程序管理页面"),

    DO_NOTHING(7, "什么都不干");


    private Integer type;

    private String desc;

    StatusEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
