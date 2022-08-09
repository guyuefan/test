package com.uniubi.visitor.common.esign.factory.seals;


import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.QryAuthSealResponse;
import lombok.Data;


/**
 * @description  查询企业授权印章
 * @author  bixing
 */

@Data
public class QueryAuthSealByOrgId extends Request<QryAuthSealResponse> {
    private String orgId;
    private boolean downloadFlag;
    private Integer offset;
    private Integer size;


    //禁止构造无参对象
    private QueryAuthSealByOrgId(){};

    //构造方法传入必填参数
    public QueryAuthSealByOrgId(String orgId) {
        this.orgId = orgId;
    }


    @Override
    public void build() {
        super.setUrl("/v1/organizations/"+orgId+"/granted/seals");
        super.setRequestType(RequestType.GET);
    }
}
