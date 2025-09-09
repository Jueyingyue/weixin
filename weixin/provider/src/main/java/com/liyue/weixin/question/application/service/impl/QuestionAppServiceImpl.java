package com.liyue.weixin.question.application.service.impl;

import com.liyue.weixin.online.question.dto.QuestionReqDTO;
import com.liyue.weixin.question.application.service.QuestionAppService;
import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.question.domain.entity.QuestionRspDO;
import com.liyue.weixin.question.domain.service.QuestionDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAppServiceImpl implements QuestionAppService {

    @Autowired
    private QuestionDomainService questionDomainService;

    @Override
    public QuestionRspDO createQuestion(QuestionDO question) throws Exception {
       return questionDomainService.createQuestion(question);
    }

    @Override
    public void updateQuestion(QuestionDO question) {
        questionDomainService.updateQuestion(question);
    }

    @Override
    public void deleteQuestion(String id) {
        questionDomainService.deleteQuestion(id);
    }

    @Override
    public QuestionDO getQuestionById(String id) {
        return questionDomainService.getQuestionById(id);
    }

    @Override
    public QuestionRspDO getQuestionRsp(QuestionReqDTO reqDTO) {
        return questionDomainService.getQuestionRsp(reqDTO);
    }
}
