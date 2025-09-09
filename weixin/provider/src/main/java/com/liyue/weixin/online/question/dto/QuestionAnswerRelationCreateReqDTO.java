package com.liyue.weixin.online.question.dto;

public class QuestionAnswerRelationCreateReqDTO {
    private String questionId;       // 问题ID
    private String answerId;         // 回答ID

    // Getter 和 Setter
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }
}
