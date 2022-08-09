package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.QryPersonData;

public class QryPersonByThirdIdResponse extends Response {
    private QryPersonData data;

    public QryPersonData getData() {
        return data;
    }

    public void setData(QryPersonData data) {
        this.data = data;
    }
}
