package com.liyue.weixin.aiConfig.domain.entity;


import java.io.Serializable;

/**
 * AI配置表对应的数据对象（DO）
 */

public class AiConfigDO implements Serializable {
    private Integer id;
    private String aiName;
    private String aiToken;
    private String aiModel;
    private String aiUrl;
    private String aiHeadersJson;
    private String aiJsonBodyJson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAiName() {
        return aiName;
    }

    public void setAiName(String aiName) {
        this.aiName = aiName;
    }

    public String getAiToken() {
        return aiToken;
    }

    public void setAiToken(String aiToken) {
        this.aiToken = aiToken;
    }

    public String getAiModel() {
        return aiModel;
    }

    public void setAiModel(String aiModel) {
        this.aiModel = aiModel;
    }

    public String getAiUrl() {
        return aiUrl;
    }

    public void setAiUrl(String aiUrl) {
        this.aiUrl = aiUrl;
    }

    public String getAiHeadersJson() {
        return aiHeadersJson;
    }

    public void setAiHeadersJson(String aiHeadersJson) {
        this.aiHeadersJson = aiHeadersJson;
    }

    public String getAiJsonBodyJson() {
        return aiJsonBodyJson;
    }

    public void setAiJsonBodyJson(String aiJsonBodyJson) {
        this.aiJsonBodyJson = aiJsonBodyJson;
    }
}
