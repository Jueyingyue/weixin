package com.liyue.weixin.online.question.dto;

import java.time.LocalDateTime;

public class AnswerCreateReqDTO {
    private String questionId;       // 关联的问题ID
    private String content;          // 回答内容
    private LocalDateTime createTime; // 创建时间（可选，可由服务端生成）

    // Getter 和 Setter
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
