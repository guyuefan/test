package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.GetFileUploadUrlData;

public class GetFileUploadUrlResponse extends Response {
    private GetFileUploadUrlData data;

    public GetFileUploadUrlData getData() {
        return data;
    }

    public void setData(GetFileUploadUrlData data) {
        this.data = data;
    }
}
