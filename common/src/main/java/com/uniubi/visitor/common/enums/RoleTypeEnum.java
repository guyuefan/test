package com.uniubi.visitor.common.enums;

/**
 * 角色类型(目前先维护2个：代理商和代理商官员，对应的code需要和数据库主键对应上)
 * @author zqp
 */
public enum RoleTypeEnum {
    /**
     *
     */
    AGENT(1, "代理商"),

    SCENE_ADMIN(2, "场所管理员");


    private Integer code;

    private String desc;

    RoleTypeEnum(Integer code, String desc) {
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
