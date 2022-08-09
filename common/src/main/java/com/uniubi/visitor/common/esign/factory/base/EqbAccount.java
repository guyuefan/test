package com.uniubi.visitor.common.esign.factory.base;

import com.uniubi.visitor.common.esign.factory.account.*;

/**
 * 账号相关功能类
 * @description  账号功能类
 * @author  bixing
 */
public class EqbAccount {

    /**
     * 个人账户创建
     * @param thirdPartyUserId 用户唯一标识
     */
    public static CreatePersonByThirdPartyUserId createPersonByThirdPartyUserId(String thirdPartyUserId, String name, String idType, String idNumber) {
        return new CreatePersonByThirdPartyUserId(thirdPartyUserId,name,idType,idNumber);
    }

    /**
     * 个人账户修改(按照账号ID修改)
     * @param accountId 账号Id
     */
    public static UpdatePersonAccountByAccountId updatePersonAccountByAccountId(String accountId){
        return new UpdatePersonAccountByAccountId(accountId);
    }

    /**
     *个人账户修改(按照第三方用户ID修改)
     * @param thirdPartyUserId 第三方平台的用户唯一标识
     * @return
     */
    public static UpdatePersonAccountByThirdId updatePersonAccountByThirdId(String thirdPartyUserId){
        return new UpdatePersonAccountByThirdId(thirdPartyUserId);
    }

    /**
     * 查询个人账户（按照账户ID查询）
     * @param accountId 账号Id
     * @return
     */
    public static QryPersonByAccountId qryPersonByaccountId(String accountId){
        return new QryPersonByAccountId(accountId);
    }

    /**
     * 查询个人账户（按照第三方用户ID查询）
     * @param thirdPartyUserId 第三方平台的用户id
     * @return
     */
    public static QryPersonByThirdId qryPersonByThirdId(String thirdPartyUserId){
        return new QryPersonByThirdId(thirdPartyUserId);
    }

    /**
     * 注销个人账户（按照账号ID注销）
     * @param accountId 个人账号id
     * @return
     */
    public static DeletePersonByAccountId deletePersonByAccountId(String accountId){
        return new DeletePersonByAccountId(accountId);
    }

    /**
     * 注销个人账户（按照第三方用户ID注销）
     * @param thirdPartyUserId 第三方平台的用户id
     * @return
     */
    public static DeletePersonByThirdId deletePersonByThirdId(String thirdPartyUserId){
        return new DeletePersonByThirdId(thirdPartyUserId);
    }

    /**
     * 机构账号创建
     * @param thirdPartyUserId 机构唯一标识
     * @param creator 创建人个人账号id
     * @param name 机构名称
     * @param idType 证件类型
     * @param idNumber 证件号
     * @return
     */
    public static CreateOrganizationsByThirdPartyUserId createOrganizationsByThirdPartyUserId(String thirdPartyUserId, String creator, String name, String idType, String idNumber){
        return new CreateOrganizationsByThirdPartyUserId(thirdPartyUserId,creator,name,idType,idNumber);
    }

    /**
     * 机构账号修改（按照账号ID修改）
     * @param orgId 机构账号id
     * @return
     */
    public static UpdateOrganizationsByOrgId updateOrganizationsByOrgId(String orgId){
        return new UpdateOrganizationsByOrgId(orgId);
    }

    /**
     * 机构账号修改（按照账号ID修改）
     * @param thirdPartyUserId 机构账号id
     * @return
     */
    public static UpdateOrganizationsByThirdId updateOrganizationsByThirdId(String thirdPartyUserId){
        return new UpdateOrganizationsByThirdId(thirdPartyUserId);
    }

    /**
     * 查询机构账号（按照账号ID查询）
     * @param orgId 机构账号id
     * @return
     */
    public static QryOrganizationsByOrgId qryOrganizationsByOrgId(String orgId){
        return new QryOrganizationsByOrgId(orgId);
    }

    /**
     *  查询机构账号（按照第三方机构ID查询）
     * @param thirdPartyUserId 第三方平台机构id
     * @return
     */
    public static QryOrganizationsByThirdId qryOrganizationsByThirdId(String thirdPartyUserId){
        return new QryOrganizationsByThirdId(thirdPartyUserId);
    }

    /**
     * 注销机构账号（按照账号ID注销）
     * @param orgId 机构账号id
     * @return
     */
    public static DeleteOrganizationsByOrgId deleteOrganizationsByOrgId(String orgId){
        return new DeleteOrganizationsByOrgId(orgId);
    }

    /**
     * 注销机构账号（按照第三方机构ID注销）
     * @param thirdPartyUserId 第三方平台的机构id
     * @return
     */
    public static DeleteOrganizationsByThirdId deleteOrganizationsByThirdId(String thirdPartyUserId){
        return new DeleteOrganizationsByThirdId(thirdPartyUserId);
    }



}
