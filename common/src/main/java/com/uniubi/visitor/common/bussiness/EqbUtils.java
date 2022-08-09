package com.uniubi.visitor.common.bussiness;

import com.uniubi.visitor.common.esign.factory.account.CreateOrganizationsByThirdPartyUserId;
import com.uniubi.visitor.common.esign.factory.account.CreatePersonByThirdPartyUserId;
import com.uniubi.visitor.common.esign.factory.account.QryOrganizationsByThirdId;
import com.uniubi.visitor.common.esign.factory.account.QryPersonByThirdId;
import com.uniubi.visitor.common.esign.factory.base.EqbAccount;
import com.uniubi.visitor.common.esign.factory.response.CreateOrganizationsByThirdPartyUserIdResponse;
import com.uniubi.visitor.common.esign.factory.response.CreatePersonByThirdPartyUserIdResponse;
import com.uniubi.visitor.common.esign.factory.response.QryOrganizationsByThirdIdResponse;
import com.uniubi.visitor.common.esign.factory.response.QryPersonByThirdIdResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

/**
 * @author zqp
 */
@Slf4j
public class EqbUtils implements Serializable {

    /**
     * e签宝个人账号
     * 1：先查询是否存在对应的个人账号
     * 2：不存在则需要创建
     * @param signAccountDto
     */
    public static String createPerson(SignAccountDTO signAccountDto){
        try {
            //用idCardNo查询是否在e签宝已经有账号，如果有，直接返回
            QryPersonByThirdId qryPersonByThirdId = EqbAccount.qryPersonByThirdId(signAccountDto.getIdCardNo());
            QryPersonByThirdIdResponse qryPersonByThirdIdResponse = qryPersonByThirdId.execute();
            if (!ObjectUtils.isEmpty(qryPersonByThirdIdResponse.getData())) {
                return qryPersonByThirdIdResponse.getData().getAccountId();
                //在e签宝没有账号时，创建账号
            } else {
                CreatePersonByThirdPartyUserId thirdPartyUserId = EqbAccount.createPersonByThirdPartyUserId(signAccountDto.getIdCardNo(), signAccountDto.getPersonName(), "CRED_PSN_CH_IDCARD", signAccountDto.getIdCardNo());
                thirdPartyUserId.setMobile(signAccountDto.getPhone());
                CreatePersonByThirdPartyUserIdResponse thirdPartyUserIdResponse = thirdPartyUserId.execute();
                return thirdPartyUserIdResponse.getData().getAccountId();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("创建e签宝个人账号时报错,idCardNo：" + signAccountDto.getCreditCode());
            return "";
        }
    }

    /**
     * e签宝企业账号
     * 1：先查询对应的企业是否在e鉴宝存在，存在直接返回
     * 2：若不存在则需要在e鉴宝创建信息：1：创建主体；2创建企业
     * @param signAccountDto
     */
    public static String createEnterprise(SignAccountDTO signAccountDto,String personEAccountId){
        try {
            //查询机构账号是否已经存在，如果存在直接返回
            QryOrganizationsByThirdId organizationsByThirdId = EqbAccount.qryOrganizationsByThirdId(signAccountDto.getCreditCode());
            QryOrganizationsByThirdIdResponse organizationsByThirdIdResponse = organizationsByThirdId.execute();
            if (!ObjectUtils.isEmpty(organizationsByThirdIdResponse.getData())) {
                return organizationsByThirdIdResponse.getData().getOrgId();
            } else {
                //不存在时，创建机构账号
                CreateOrganizationsByThirdPartyUserId thirdPartyUserId = EqbAccount.createOrganizationsByThirdPartyUserId(signAccountDto.getCreditCode(), personEAccountId, signAccountDto.getOrgName(), "CRED_ORG_USCC", signAccountDto.getCreditCode());
                CreateOrganizationsByThirdPartyUserIdResponse thirdPartyUserIdResponse = thirdPartyUserId.execute();
                String orgId = thirdPartyUserIdResponse.getData().getOrgId();
                return orgId;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("创建e签宝企业账号时报错,creditCode：" + signAccountDto.getCreditCode());
            return "";
        }
    }

}
