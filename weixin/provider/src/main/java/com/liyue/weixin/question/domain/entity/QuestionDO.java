package com.liyue.weixin.question.domain.entity;

import com.liyue.weixin.utils.PageResult;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionDO extends PageResult {
    private String id;
    private String question;
    private String askUserId;
    private String askTypeId;
    private LocalDateTime askTime=LocalDateTime.now();

    public QuestionDO(Integer total, Integer pageNum, Integer pageSize, List records) {
        super(total, pageNum, pageSize, records);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAskUserId() {
        return askUserId;
    }

    public void setAskUserId(String askUserId) {
        this.askUserId = askUserId;
    }

    public String getAskTypeId() {
        return askTypeId;
    }

    public void setAskTypeId(String askTypeId) {
        this.askTypeId = askTypeId;
    }

    public LocalDateTime getAskTime() {
        return askTime;
    }

    public void setAskTime(LocalDateTime askTime) {
        this.askTime = askTime;
    }
}
