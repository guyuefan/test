package com.uniubi.visitor.common.esign.bean;
/**
 * @description  抄送人人列表
 * @author  bixing
 */
public class Copier {
    private String copierAccountId;
    private Integer copierIdentityAccountType;
    private String copierIdentityAccountId;

    public String getCopierAccountId() {
        return copierAccountId;
    }

    public Copier setCopierAccountId(String copierAccountId) {
        this.copierAccountId = copierAccountId;
        return this;
    }

    public Integer getCopierIdentityAccountType() {
        return copierIdentityAccountType;
    }

    public Copier setCopierIdentityAccountType(Integer copierIdentityAccountType) {
        this.copierIdentityAccountType = copierIdentityAccountType;
        return this;
    }

    public String getCopierIdentityAccountId() {
        return copierIdentityAccountId;
    }

    public Copier setCopierIdentityAccountId(String copierIdentityAccountId) {
        this.copierIdentityAccountId = copierIdentityAccountId;
        return this;
    }
}
