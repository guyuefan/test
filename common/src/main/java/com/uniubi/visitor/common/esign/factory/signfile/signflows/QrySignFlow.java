package com.uniubi.visitor.common.esign.factory.signfile.signflows;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.QrySignFlowResponse;

/**
 * @description  签署流程查询
 * @author  bixing
 */
public class QrySignFlow extends Request<QrySignFlowResponse> {
    @JSONField(serialize = false)
    private String flowId;

    private QrySignFlow(){};

    public QrySignFlow(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    @Override
    public void build() {
        super.setUrl("/v1/signflows/"+flowId);
        super.setRequestType(RequestType.GET);
    }
}
