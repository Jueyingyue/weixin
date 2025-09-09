package com.liyue.weixin.innerHomePage.domain.entity;

import java.io.Serializable;

public class OptionsDO implements Serializable {
    private String bizTypeCode;
    private String bizType;
    private String questionNo;
    private String optionLabel;
    private String optionText;
    private String optionScore;

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

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getOptionLabel() {
        return optionLabel;
    }

    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public String getOptionScore() {
        return optionScore;
    }

    public void setOptionScore(String optionScore) {
        this.optionScore = optionScore;
    }
}
