package com.liyue.weixin.question.application.service;

import com.liyue.weixin.online.question.dto.QuestionReqDTO;
import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.question.domain.entity.QuestionRspDO;


public interface QuestionAppService {
    QuestionRspDO createQuestion(QuestionDO question) throws Exception;
    void updateQuestion(QuestionDO question);
    void deleteQuestion(String id);
    QuestionDO getQuestionById(String id);
    QuestionRspDO getQuestionRsp(QuestionReqDTO reqDTO);
}
