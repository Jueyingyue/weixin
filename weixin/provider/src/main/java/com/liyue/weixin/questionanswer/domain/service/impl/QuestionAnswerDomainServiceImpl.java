package com.liyue.weixin.questionanswer.domain.service.impl;

import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;
import com.liyue.weixin.questionanswer.domain.repo.QuestionAnswerRepository;
import com.liyue.weixin.questionanswer.domain.service.AnswerDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 问题回答领域服务实现类
 */
@Service
public class QuestionAnswerDomainServiceImpl implements AnswerDomainService {

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    @Override
    public int saveAnswer(QuestionAnswer questionAnswer) {
        return questionAnswerRepository.saveAnswer(questionAnswer);
    }

    @Override
    public QuestionAnswer getAnswerById(Integer id) {
        return questionAnswerRepository.getAnswerById(id);
    }

    @Override
    public int insertQuestionAndRel(QuestionAnswerRelationDO questionAnswerRelationDO) {
        return questionAnswerRepository.insertQuestionAndRel(questionAnswerRelationDO);
    }

}
