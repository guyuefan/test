package com.uniubi.visitor.common.esign.factory.fileTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.uniubi.visitor.common.esign.comm.FileHelper;
import com.uniubi.visitor.common.esign.comm.HttpHelper;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.exception.DefineException;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.UploadFileResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @description  文件流上传
 * @author  bixing
 */
public class UploadFile extends Request {
    private String filePath;
    private String contentType;
    private String url;
    public UploadFile(String url,String filePath, String contentType) {
        this.url=url;
        this.filePath=filePath;
        this.contentType=contentType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 上传文件
     * @return
     * @throws DefineException
     * @throws IOException
     */
    public UploadFileResponse excute() throws DefineException {
        byte[] bytes = FileHelper.getBytes(filePath);
        String fileContentMd5 = FileHelper.getContentMD5(filePath);
        Map map = HttpHelper.doUploadHttp(RequestType.PUT, url, bytes, fileContentMd5, contentType);
        String resCtx = (String)map.get("resCtx");//响应体
        int status = (int) map.get("status");//响应状态码
        UploadFileResponse uploadFileResponse=new UploadFileResponse();
        try {
            uploadFileResponse = JSON.parseObject(resCtx, UploadFileResponse.class);
            uploadFileResponse.setStatus(status);
            uploadFileResponse.setBody(resCtx);
        }catch (JSONException e){
            uploadFileResponse.setBody(resCtx);
        }
        return uploadFileResponse;
    }

    @Override
    public void build() {
    }
}