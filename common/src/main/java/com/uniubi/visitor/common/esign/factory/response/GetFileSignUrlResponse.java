package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.GetFileSignUrlData;

public class GetFileSignUrlResponse extends Response {
    private GetFileSignUrlData data;

    public GetFileSignUrlData getData() {
        return data;
    }

    public void setData(GetFileSignUrlData data) {
        this.data = data;
    }
}
