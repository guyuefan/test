package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.QrySignFlowData;

public class QrySignFlowResponse extends Response {
    private QrySignFlowData data;

    public QrySignFlowData getData() {
        return data;
    }

    public void setData(QrySignFlowData data) {
        this.data = data;
    }
}
