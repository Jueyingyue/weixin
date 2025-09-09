package com.liyue.weixin.online.question.dto;

import com.liyue.weixin.question.domain.entity.QuestionDO;

import java.util.List;

public class QuestionCreateReqDTO extends QuestionDO {

    public QuestionCreateReqDTO(Integer total, Integer pageNum, Integer pageSize, List records) {
        super(total, pageNum, pageSize, records);
    }
}
