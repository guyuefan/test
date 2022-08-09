package com.uniubi.visitor.common.bussiness;

import com.uniubi.visitor.common.esign.comm.FileBean;
import com.uniubi.visitor.common.esign.enums.HeaderConstant;
import com.uniubi.visitor.common.esign.factory.base.FileTemplate;
import com.uniubi.visitor.common.esign.factory.fileTemplate.GetFileUploadUrl;
import com.uniubi.visitor.common.esign.factory.fileTemplate.UploadFile;
import com.uniubi.visitor.common.esign.factory.response.GetFileUploadUrlResponse;
import com.uniubi.visitor.common.esign.factory.response.UploadFileResponse;

import java.io.Serializable;

/**
 * @author zqp
 */
public class UploadFileUtils implements Serializable {

        /**
         * 第一步 将合同传到e鉴宝平台
         * @param localAddress
         */
        public static String uploadFileToEqb(String localAddress) throws Exception {
        //文件地址
        //FileTemplate是文件模板功能类，所有文件模板相关的接口由FileTemplate发起
            //用于本地获取文件大小，名称等信息
            FileBean fileBean = new FileBean(localAddress);
            GetFileUploadUrl fileUploadUrl = FileTemplate.getFileUploadUrl(fileBean.getFileContentMD5(),
                    HeaderConstant.CONTENTTYPE_PDF.VALUE(),
                    false,
                    fileBean.getFileName(),
                    fileBean.getFileSize());
            GetFileUploadUrlResponse fileUploadUrlResp = fileUploadUrl.execute();
            //文件id保存好，后续使用
            String fileId = fileUploadUrlResp.getData().getFileId();
            //上传url保存好，后续使用
            String uploadUrl = fileUploadUrlResp.getData().getUploadUrl();

            //文件流上传文件
            UploadFile uploadFile = FileTemplate.uploadFile(uploadUrl, localAddress, HeaderConstant.CONTENTTYPE_PDF.VALUE());
            UploadFileResponse uploadFileResp = uploadFile.excute();
            return fileId;
    }


}
