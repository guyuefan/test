package com.uniubi.visitor.common.esign.factory.response.other;

import lombok.Data;

@Data
public class AuthSeal {
    private String alias;
    private int height;
    private int width;
    private String sealId;
    private String url;
    private Long effectiveTime;
    private Long expireTime;
    private String organiztionName;
    private String idNumber;
    private String idType;
    private String sealBizType;

}
