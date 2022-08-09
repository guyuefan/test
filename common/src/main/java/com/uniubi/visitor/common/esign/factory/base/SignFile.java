package com.uniubi.visitor.common.esign.factory.base;

import com.uniubi.visitor.common.esign.bean.Docs;
import com.uniubi.visitor.common.esign.bean.FlowInfo;
import com.uniubi.visitor.common.esign.bean.Signers;
import com.uniubi.visitor.common.esign.factory.fileTemplate.QryFileStatus;
import com.uniubi.visitor.common.esign.factory.other.SearchWordsPosition;
import com.uniubi.visitor.common.esign.factory.signfile.CreateFlowOneStep;
import com.uniubi.visitor.common.esign.factory.signfile.documents.DownDocuments;
import com.uniubi.visitor.common.esign.factory.signfile.signflows.QrySignFlow;

/**
 *
 * @description  签署服务功能类
 * @author  bixing
 */
public class SignFile {

    /**
     * 一步发起签署
     * @param docs
     * @param flowInfo
     * @param signers
     * @return
     */
    public static CreateFlowOneStep createFlowOneStep(Docs docs, FlowInfo flowInfo, Signers signers){
        return new CreateFlowOneStep(docs, flowInfo, signers);
    }


    /**
     * 签署流程查询
     * @param flowId 流程id
     * @return
     */
    public static QrySignFlow qrySignFlow(String flowId){
        return new QrySignFlow(flowId);
    }


    /**
     * 流程文档下载
     * @param flowId 流程id
     * @return
     */
    public static DownDocuments downDocuments(String flowId){
        return new DownDocuments(flowId);
    }

    /**
     * 搜索关键字坐标
     * @param fileId 文档id
     * @param keywords 关键字列表，逗号分割
     * @return
     */
    public static SearchWordsPosition searchWordsPosition(String fileId, String keywords){
        return new SearchWordsPosition(fileId, keywords);
    }


    /**
     * 查询文件状态
     * @param fileId
     * @return
     */
    public static QryFileStatus qryFileStatus(String fileId){
        return new QryFileStatus(fileId);
    }
}
