package com.liyue.weixin.online.question.dto;

import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.utils.PageResult;

import java.time.LocalDateTime;

public class QuestionRspDTO {
    private String id;               // 问题ID
    private String asker_nick;
    private LocalDateTime ask_time;
    private String bizType;
    private String bizTypeCode;
    private String askUserId;            // 问题标题
    private String question;          // 问题内容
    private PageResult<QuestionAnswer> answerList;

    // Getter 和 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsker_nick() {
        return asker_nick;
    }

    public void setAsker_nick(String asker_nick) {
        this.asker_nick = asker_nick;
    }

    public LocalDateTime getAsk_time() {
        return ask_time;
    }

    public void setAsk_time(LocalDateTime ask_time) {
        this.ask_time = ask_time;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeCode() {
        return bizTypeCode;
    }

    public void setBizTypeCode(String bizTypeCode) {
        this.bizTypeCode = bizTypeCode;
    }

    public String getAskUserId() {
        return askUserId;
    }

    public void setAskUserId(String askUserId) {
        this.askUserId = askUserId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public PageResult<QuestionAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(PageResult<QuestionAnswer> answerList) {
        this.answerList = answerList;
    }
}
