package com.uniubi.visitor.common.esign.factory.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.QryOrganizationsByThirdIdResponse;

/**
 * @description  按照第三方账号查询机构账号
 * @author  bixing
 */
public class QryOrganizationsByThirdId extends Request<QryOrganizationsByThirdIdResponse> {
    @JSONField(serialize = false)
    private String thirdPartyUserId;

    //禁止构造无参对象
    public QryOrganizationsByThirdId() {}

    public QryOrganizationsByThirdId(String thirdPartyUserId) {
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
        super.setUrl("/v1/organizations/getByThirdId?thirdPartyUserId="+thirdPartyUserId);
        super.setRequestType(RequestType.GET);
    }
}
