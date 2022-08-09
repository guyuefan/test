package com.uniubi.visitor.common.enums;

/**
 * 签约类型
 * @author zhaoyanbo
 * @date 2021/08/18
 */
public enum SignTypeEnum {


    ENTERPRISE(1, "企业"),

    PERSON(2, "个人");


    private Integer code;

    private String desc;

    SignTypeEnum(Integer code, String desc) {
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
