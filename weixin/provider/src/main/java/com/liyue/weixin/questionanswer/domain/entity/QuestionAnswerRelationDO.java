package com.liyue.weixin.questionanswer.domain.entity;

import java.io.Serializable;

public class QuestionAnswerRelationDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;            // 自增主键，关联记录唯一标识
    private String questionId;     // 问题ID，对应问题表中的 _id
    private int answerId;       // 回答ID，对应回答表中的 _id

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
