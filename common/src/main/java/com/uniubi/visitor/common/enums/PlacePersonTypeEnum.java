package com.uniubi.visitor.common.enums;

/**
 * 场所角色类型
 *
 * @author zhaoyanbo
 * @date 2021/08/26
 */
public enum PlacePersonTypeEnum {


    ADMIN(1, "管理员"),

    EMPLOYEE(2, "员工"),

    OWNER(3, "创建人");


    private Integer code;

    private String desc;

    PlacePersonTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
