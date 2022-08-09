package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.UpdateOrganizationsData;

public class UpdateOrganizationsByThirdIdResponse extends Response {
    private UpdateOrganizationsData data;

    public UpdateOrganizationsData getData() {
        return data;
    }

    public void setData(UpdateOrganizationsData data) {
        this.data = data;
    }
}
