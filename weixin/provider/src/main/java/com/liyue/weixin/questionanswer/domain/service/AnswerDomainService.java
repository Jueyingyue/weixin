package com.liyue.weixin.questionanswer.domain.service;

import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;

public interface AnswerDomainService {
    int saveAnswer(QuestionAnswer answerDO);
    QuestionAnswer getAnswerById(Integer id);
    int insertQuestionAndRel(QuestionAnswerRelationDO questionAnswerRelationDO);

}
