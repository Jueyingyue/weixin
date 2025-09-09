package com.liyue.weixin.innerHomePage.domain.entity;

import java.io.Serializable;

public class MenuInfoDO implements Serializable {
    private String bizTypeCode;
    private String bizType;
    private String bizTypeCnDesc;
    private String indexType;

    public String getBizTypeCode() {
        return bizTypeCode;
    }

    public void setBizTypeCode(String bizTypeCode) {
        this.bizTypeCode = bizTypeCode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeCnDesc() {
        return bizTypeCnDesc;
    }

    public void setBizTypeCnDesc(String bizTypeCnDesc) {
        this.bizTypeCnDesc = bizTypeCnDesc;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }
}

