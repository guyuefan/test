package com.uniubi.visitor.common.enums;

/**
 *
 *  签约状态
 * @author zhaoyanbo
 * @date 2021/08/19
 */
public enum  SignStatusEnum {



    INIT(1, "未签约"),

    SIGNED(2, "已签约");


    private Integer code;

    private String desc;

    SignStatusEnum(Integer code, String desc){
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
