package com.uniubi.visitor.common.esign.factory.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.DeleteOrganizationsByThirdIdResponse;

/**
 * @description  注销机构账号（按照第三方机构ID注销）
 * @author  bixing
 */
public class DeleteOrganizationsByThirdId extends Request<DeleteOrganizationsByThirdIdResponse> {
    @JSONField(serialize = false)
    private String thirdPartyUserId;

    //禁止构造无参对象
    private DeleteOrganizationsByThirdId() {}

    public DeleteOrganizationsByThirdId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    public String getThirdPartyUserId() {
        return thirdPartyUserId;
    }

    public void setThirdPartyUserId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    @Override
    public void build() {
        super.setUrl("/v1/organizations/deleteByThirdId?thirdPartyUserId="+thirdPartyUserId);
        super.setRequestType(RequestType.DELETE);
    }
}
