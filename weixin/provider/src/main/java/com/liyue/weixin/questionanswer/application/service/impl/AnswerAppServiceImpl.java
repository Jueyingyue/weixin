package com.liyue.weixin.questionanswer.application.service.impl;

import com.liyue.weixin.online.question.dto.AnswerRspDTO;
import com.liyue.weixin.questionanswer.application.service.AnswerAppService;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;
import com.liyue.weixin.questionanswer.domain.service.AnswerDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerAppServiceImpl implements AnswerAppService {

    @Autowired
    private AnswerDomainService answerDomainService;

    @Override
    public AnswerRspDTO saveAnswer(QuestionAnswer questionAnswer) {
        answerDomainService.saveAnswer(questionAnswer);

        return convertToRsp(questionAnswer);
    }

    @Override
    public AnswerRspDTO getAnswerById(Integer id) {
        QuestionAnswer questionAnswer = answerDomainService.getAnswerById(id);
        return convertToRsp(questionAnswer);
    }

    @Override
    public QuestionAnswerRelationDO insertQuestionAndRel(QuestionAnswerRelationDO questionAnswerRelationDO) {
         answerDomainService.insertQuestionAndRel(questionAnswerRelationDO);

         return questionAnswerRelationDO;
    }

    private AnswerRspDTO convertToRsp(QuestionAnswer questionAnswer) {
        AnswerRspDTO rsp = new AnswerRspDTO();
        rsp.setAnswerid(questionAnswer.getAnswerid());
        rsp.setAnswerUserId(questionAnswer.getAnswerUserId());
        rsp.setAnswer(questionAnswer.getAnswer());
        rsp.setAnswerTime(questionAnswer.getAnswerTime());
        return rsp;
    }

}
