package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.UpdatePersonAccountData;

public class UpdatePersonAccountByThirdIdResponse extends Response {
    private UpdatePersonAccountData data;

    public UpdatePersonAccountData getData() {
        return data;
    }

    public void setData(UpdatePersonAccountData data) {
        this.data = data;
    }
}
