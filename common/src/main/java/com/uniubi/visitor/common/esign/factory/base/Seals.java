package com.uniubi.visitor.common.esign.factory.base;


import com.uniubi.visitor.common.esign.factory.seals.QueryAuthSealByOrgId;

/**
 *
 * @description  印章服务功能类
 * @author  bixing
 */
public class Seals {

    /**
     * 查询机构授权印章
     * @param
     */
    public static QueryAuthSealByOrgId queryAuthSealByOrgId(String orgId) {
        return new QueryAuthSealByOrgId(orgId);
    }

}