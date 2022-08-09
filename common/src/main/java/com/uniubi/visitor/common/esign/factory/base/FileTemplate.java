package com.uniubi.visitor.common.esign.factory.base;


import com.uniubi.visitor.common.esign.factory.fileTemplate.GetFileUploadUrl;
import com.uniubi.visitor.common.esign.factory.fileTemplate.UploadFile;

/**
 *
 * @description  文件模板功能类
 * @author bixing
 */
public class FileTemplate {

    /**
     * 通过上传方式创建文件
     * @param contentMd5 文件md5值,demo提供了FileTransformation.getFileContentMD5(filePath)获取
     * @param contentType 目标文件的MIME类型，支持：
     *
     * （1）application/octet-stream
     *
     * （2）application/pdf
     * @param convert2Pdf 是否转换成pdf文档
     * @param fileName 文件名称
     * @param fileSize 文件大小，单位byte
     * @return
     */
    public static GetFileUploadUrl getFileUploadUrl(String contentMd5, String contentType, boolean convert2Pdf, String fileName, Integer fileSize){
        return new GetFileUploadUrl(contentMd5, contentType, convert2Pdf, fileName, fileSize);
    }

    /**
     * 上传文件(包括模板文件)
     *      * @param filePath 本地文件地址
     *      * @param contentType 目标文件的MIME类型需要与通过上传方式创建文件接口入参的contentType保持一致
     * @return
     */
    public static UploadFile uploadFile(String url, String filePath, String contentType){
        return new UploadFile(url, filePath, contentType);
    }



}