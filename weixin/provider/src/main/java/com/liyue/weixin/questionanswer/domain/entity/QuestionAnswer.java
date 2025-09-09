package com.liyue.weixin.questionanswer.domain.entity;

import com.github.pagehelper.util.StringUtil;

import java.time.LocalDateTime;

public class QuestionAnswer{
    private Integer answerid;
    private String answerUserId;
    private String answer;
    private LocalDateTime answerTime=LocalDateTime.now();
    private String answerer_type;
    private Integer pageNum=1;    // 当前页码
    private Integer pageSize=1;   // 每页条数
    private Integer offset;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAnswerer_type() {
        return StringUtil.isEmpty(answerUserId)?"ai":"userid";
    }

    public void setAnswerer_type(String answerer_type) {
        this.answerer_type = answerer_type;
    }

    public Integer getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
    }

    public String getAnswerUserId() { return answerUserId; }
    public void setAnswerUserId(String answerUserId) { this.answerUserId = answerUserId; }
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
    public LocalDateTime getAnswerTime() { return answerTime; }
    public void setAnswerTime(LocalDateTime answerTime) { this.answerTime = answerTime; }
}
