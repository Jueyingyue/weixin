package com.liyue.weixin.question.domain.service;

import com.liyue.weixin.online.question.dto.QuestionReqDTO;
import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.question.domain.entity.QuestionRspDO;

import java.util.List;

public interface QuestionDomainService {
    QuestionRspDO createQuestion(QuestionDO question) throws Exception;
    void updateQuestion(QuestionDO question);
    void deleteQuestion(String id);
    QuestionDO getQuestionById(String id);
    List<QuestionDO> getAllQuestions();
    QuestionRspDO getQuestionRsp(QuestionReqDTO reqDTO);

}
