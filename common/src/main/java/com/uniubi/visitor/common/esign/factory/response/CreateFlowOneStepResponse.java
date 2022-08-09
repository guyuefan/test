package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.data.CreateFlowOneStepData;

public class CreateFlowOneStepResponse extends Response {
    private CreateFlowOneStepData data;

    public CreateFlowOneStepData getData() {
        return data;
    }

    public void setData(CreateFlowOneStepData data) {
        this.data = data;
    }
}
