package com.liyue.weixin.questionanswer.application.service;


import com.liyue.weixin.online.question.dto.AnswerRspDTO;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;

public interface AnswerAppService {
    AnswerRspDTO saveAnswer(QuestionAnswer req);
    AnswerRspDTO getAnswerById(Integer id);
    QuestionAnswerRelationDO insertQuestionAndRel(QuestionAnswerRelationDO questionAnswerRelationDO);
}
