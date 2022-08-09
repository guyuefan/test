package com.uniubi.visitor.common.esign.factory.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.QryPersonByAccountIdResponse;

/**
 * @description  查询个人账户（按照账户ID查询）
 * @author  bixing
 */
public class QryPersonByAccountId extends Request<QryPersonByAccountIdResponse> {
    @JSONField(serialize = false)
    private String accountId;

    //禁止构造无参对象
    private QryPersonByAccountId(){};

    public QryPersonByAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public void build() {
        super.setUrl("/v1/accounts/"+accountId);
        super.setRequestType(RequestType.GET);
    }
}
