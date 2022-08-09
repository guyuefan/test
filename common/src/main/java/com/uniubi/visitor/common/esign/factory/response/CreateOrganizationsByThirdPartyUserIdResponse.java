package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.CreateOrganizationsByThirdPartyUserIdData;

public class CreateOrganizationsByThirdPartyUserIdResponse extends Response {
    private CreateOrganizationsByThirdPartyUserIdData data;

    public CreateOrganizationsByThirdPartyUserIdData getData() {
        return data;
    }

    public void setData(CreateOrganizationsByThirdPartyUserIdData data) {
        this.data = data;
    }
}
