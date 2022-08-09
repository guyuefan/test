package com.uniubi.visitor.common.esign.factory.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.DeleteOrganizationsByOrgIdResponse;

/**
 * @description  注销机构账号（按照账号ID注销）
 * @author  bixing
 */
public class DeleteOrganizationsByOrgId extends Request<DeleteOrganizationsByOrgIdResponse> {
    @JSONField(serialize = false)
    private String orgId;

    //禁止构造无参对象
    private DeleteOrganizationsByOrgId() {}

    public DeleteOrganizationsByOrgId(String orgId) {
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
        super.setRequestType(RequestType.DELETE);
    }
}
