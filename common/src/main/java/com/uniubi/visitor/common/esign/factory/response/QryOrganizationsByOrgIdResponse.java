package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.QryOrganizationsData;

public class QryOrganizationsByOrgIdResponse extends Response {
    private QryOrganizationsData data;

    public QryOrganizationsData getData() {
        return data;
    }

    public void setData(QryOrganizationsData data) {
        this.data = data;
    }
}
