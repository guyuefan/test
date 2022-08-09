package com.uniubi.visitor.common.esign.comm;

import com.uniubi.visitor.common.esign.enums.HeaderConstant;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.exception.DefineException;
import com.uniubi.visitor.common.esign.factory.Factory;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bixing
 * @description Http 请求 辅助类
 */
@Slf4j
public class HttpHelper<T> {


    /**
     * 不允许外部创建实例
     */
    private HttpHelper() {

    }

    // ------------------------------公有方法start--------------------------------------------

    /**
     * @param reqType  请求方式
     * @param url      请求路径
     * @param paramStr 请求参数
     * @return
     * @description 发送常规HTTP 请求
     */
    public static Map doCommHttp(RequestType reqType, String url, String paramStr) throws DefineException {
        //对body体做md5摘要
        String contentMD5 = Encryption.doContentMD5(paramStr);
        //get和delete方式请求不能携带body体
        if ("GET".equals(reqType.name()) || "DELETE".equals(reqType.name())) {
            paramStr = null;
        }
        //传入生成的bodyMd5,加上其他请求头部信息拼接成字符串
        String message = Encryption.appendSignDataString(reqType.name(), HeaderConstant.ACCEPT.VALUE(), contentMD5, HeaderConstant.CONTENTTYPE_JSON.VALUE(), HeaderConstant.DATE.VALUE(), HeaderConstant.HEADERS.VALUE(), url);

        //整体做sha256签名
        String reqSignature = Encryption.doSignatureBase64(message, Factory.getProject_scert());


        return HttpCfgHelper.sendHttp(reqType, url, buildCommHeader(contentMD5, reqSignature), paramStr);
    }

    /**
     * @param reqType        请求方式
     * @param url            请求路径
     * @param param          请求参数
     * @param fileContentMd5 文件fileContentMd5
     * @param contentType    文件MIME类型
     * @return
     * @description 发送文件流上传 HTTP 请求
     */
    public static Map doUploadHttp(RequestType reqType, String url, byte[] param, String fileContentMd5,
                                   String contentType) throws DefineException {
        return HttpCfgHelper.sendHttp(reqType, url, buildUploadHeader(fileContentMd5, contentType), param);
    }

    // ------------------------------公有方法end----------------------------------------------

    // ------------------------------私有方法start--------------------------------------------

    /**
     * @param contentMD5
     * @description 创建常规请求头
     */
    private static Map<String, String> buildCommHeader(String contentMD5, String reqSignature) {

        Map<String, String> header = new HashMap<>();
        header.put("X-Tsign-Open-App-Id", Factory.getProject_id());
        header.put("X-Tsign-Open-Ca-Timestamp", Encryption.timeStamp());
        header.put("Accept", HeaderConstant.ACCEPT.VALUE());
        header.put("X-Tsign-Open-Ca-Signature", reqSignature);
        header.put("Content-MD5", contentMD5);
        header.put("Content-Type", HeaderConstant.CONTENTTYPE_JSON.VALUE());
        header.put("X-Tsign-Open-Auth-Mode", HeaderConstant.AUTHMODE.VALUE());
        return header;
    }

    /**
     * @param fileContentMd5
     * @param contentType
     * @description 创建文件流上传 请求头
     */
    private static Map<String, String> buildUploadHeader(String fileContentMd5, String contentType) {
        Map<String, String> header = new HashMap<>();
        header.put("Content-MD5", fileContentMd5);
        header.put("Content-Type", contentType);
        return header;
    }

    // ------------------------------私有方法end----------------------------------------------
}
