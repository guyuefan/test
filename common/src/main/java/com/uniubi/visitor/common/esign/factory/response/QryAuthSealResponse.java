package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.QryAuthSealData;

public class QryAuthSealResponse extends Response{

    private QryAuthSealData data;

    public QryAuthSealData getData() {
        return data;
    }

    public void setData(QryAuthSealData data) {
        this.data = data;
    }
}
