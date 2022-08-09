package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.DownDocumentsData;

public class DownDocumentsResponse extends Response {

    private DownDocumentsData data;

    public DownDocumentsData getData() {
        return data;
    }

    public void setData(DownDocumentsData data) {
        this.data = data;
    }
}
