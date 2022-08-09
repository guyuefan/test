package com.uniubi.visitor.common.esign.factory.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.UpdateOrganizationsByThirdIdResponse;

/**
 * @description  机构账号修改（按照第三方机构ID修改）
 * @author  bixing
 */
public class UpdateOrganizationsByThirdId extends Request<UpdateOrganizationsByThirdIdResponse> {
    @JSONField(serialize = false)
    private String thirdPartyUserId;
    private String name;
    private String idType;
    private String idNumber;
    private String orgLegalIdNumber;
    private String orgLegalName;

    //禁止构造无参对象
    private UpdateOrganizationsByThirdId() {}

    public UpdateOrganizationsByThirdId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    public String getThirdPartyUserId() {
        return thirdPartyUserId;
    }

    public void setThirdPartyUserId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getOrgLegalIdNumber() {
        return orgLegalIdNumber;
    }

    public void setOrgLegalIdNumber(String orgLegalIdNumber) {
        this.orgLegalIdNumber = orgLegalIdNumber;
    }

    public String getOrgLegalName() {
        return orgLegalName;
    }

    public void setOrgLegalName(String orgLegalName) {
        this.orgLegalName = orgLegalName;
    }

    @Override
    public void build() {
        super.setUrl("/v1/organizations/updateByThirdId?thirdPartyUserId="+thirdPartyUserId);
        super.setRequestType(RequestType.POST);
    }
}