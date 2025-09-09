package com.liyue.weixin.question.domain.entity;

import java.util.List;

public class QuestionRspDO extends QuestionDO{
    private String asker_nick;
    private String askTypeDesc;

    public QuestionRspDO(Integer total, Integer pageNum, Integer pageSize, List records) {
        super(total, pageNum, pageSize, records);
    }

    public String getAsker_nick() {
        return asker_nick;
    }

    public void setAsker_nick(String asker_nick) {
        this.asker_nick = asker_nick;
    }

    public String getAskTypeDesc() {
        return askTypeDesc;
    }

    public void setAskTypeDesc(String askTypeDesc) {
        this.askTypeDesc = askTypeDesc;
    }
}
