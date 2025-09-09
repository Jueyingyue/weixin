package com.liyue.weixin.innerHomePage.domain.entity;

import java.io.Serializable;
import java.util.List;

public class QuestionsDO implements Serializable {
    private String  bizTypeCode;
    private String bizType;
    private String questionNo;
    private String  questionText;
    private List<OptionsDO> optionsDOList;

    public List<OptionsDO> getOptionsDOList() {
        return optionsDOList;
    }

    public void setOptionsDOList(List<OptionsDO> optionsDOList) {
        this.optionsDOList = optionsDOList;
    }

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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
