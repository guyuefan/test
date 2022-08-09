package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.QryFileStatusData;

public class QryFileStatusResponse extends Response {
    private QryFileStatusData data;

    public QryFileStatusData getData() {
        return data;
    }

    public void setData(QryFileStatusData data) {
        this.data = data;
    }
}
