package com.liyue.weixin.questionanswer.domain.entity;

import java.time.LocalDateTime;

public class QuestionAndAnswer  extends QuestionAnswer{
    private String id;
    private String question;
    private String askUserId;
    private String askTypeId;
    private LocalDateTime askTime=LocalDateTime.now();

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
