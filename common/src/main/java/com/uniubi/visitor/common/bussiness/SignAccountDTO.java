package com.uniubi.visitor.common.bussiness;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zqp
 */
@Data
public class SignAccountDTO implements Serializable {
    /**
     * 身份证
     */
    private String idCardNo;
    /**
     * 人名
     */
    private String personName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 信用代码
     */
    private String creditCode;
    /**
     * 组织名称
     */
    private String orgName;
}
