package com.uniubi.visitor.common.esign.factory.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.QryOrganizationsByOrgIdResponse;

/**
 * @description  查询机构账号（按照账号ID查询）
 * @author  bixing
 */
public class QryOrganizationsByOrgId extends Request<QryOrganizationsByOrgIdResponse> {
    @JSONField(serialize = false)
    private String orgId;

    //禁止构造无参对象
    private QryOrganizationsByOrgId() {}

    public QryOrganizationsByOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public void build() {
        super.setUrl("/v1/organizations/"+orgId);
        super.setRequestType(RequestType.GET);
    }
}
