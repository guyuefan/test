package com.uniubi.visitor.common.esign.enums;
/**
 * @description  头部信息常量
 * @author  bixing
 */
public enum HeaderConstant {
    ACCEPT("*/*"),
    DATE(""),
    HEADERS( ""),
    CONTENTTYPE_JSON("application/json; charset=UTF-8"),
    CONTENTTYPE_PDF("application/pdf"),
    CONTENTTYPE_STREAM("application/octet-stream"),
    AUTHMODE("Signature");

    private String value;
    private HeaderConstant(String value) {
        this.value=value;
    }

    public String VALUE(){
        return this.value;
    }
}
