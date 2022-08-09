package com.uniubi.visitor.common.enums;

/**
 * @author zhaoyanbo
 * @date 2021/09/16
 */
public enum ImportDataRecordStatus {


    INIT(10, "初始化"),

    SUCCESS(20, "执行成功");


    private Integer code;

    private String desc;

    ImportDataRecordStatus(Integer code, String desc) {
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
