package com.uniubi.visitor.common.esign.factory.response.data;


public class QryFileStatusData {

    /**
     * 文件状态
     *
     * 0-文件未上传；
     *
     * 1-文件上传中 ；
     *
     * 2-文件上传已完成,；
     *
     * 3-文件上传失败 ；
     *
     * 4-文件等待转pdf ；
     *
     * 5-文件已转换pdf ；
     *
     * 6-加水印中；
     *
     * 7-加水印完毕；
     *
     * 8-文件转换中；
     *
     * 9-文件转换失败
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
