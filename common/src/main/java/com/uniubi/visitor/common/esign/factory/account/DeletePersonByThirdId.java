package com.uniubi.visitor.common.esign.factory.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.DeletePersonByThirdIdResponse;


/**
 * @description  注销个人账户（按照第三方用户ID注销）
 * @author  bixing
 */
public class DeletePersonByThirdId extends Request<DeletePersonByThirdIdResponse> {
    @JSONField(serialize = false)
    private String thirdPartyUserId;

    //禁止构造无参对象
    private DeletePersonByThirdId() {
    }

    public DeletePersonByThirdId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    public String getThirdPartyUserId() {
        return thirdPartyUserId;
    }

    public void setThirdPartyUserId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    @Override
    public void build() {
        super.setUrl("/v1/accounts/deleteByThirdId?thirdPartyUserId="+thirdPartyUserId);
        super.setRequestType(RequestType.DELETE);
    }
}
