package com.liyue.weixin.questionanswer.domain.repo;

import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;

import java.util.List;

/**
 * 问题回答仓储接口（领域层数据访问抽象）
 */
public interface QuestionAnswerRepository {
    int saveAnswer(QuestionAnswer answerDO);
    int insertQuestionAndRel(QuestionAnswerRelationDO questionAnswerRelationDO);
    QuestionAnswer getAnswerById(Integer id);
}
