package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.CreatePersonByThirdPartyUserIdData;

public class CreatePersonByThirdPartyUserIdResponse extends Response{
    private CreatePersonByThirdPartyUserIdData data;
    public CreatePersonByThirdPartyUserIdData getData() {
        return data;
    }
    public void setData(CreatePersonByThirdPartyUserIdData data) {
        this.data = data;
    }
}