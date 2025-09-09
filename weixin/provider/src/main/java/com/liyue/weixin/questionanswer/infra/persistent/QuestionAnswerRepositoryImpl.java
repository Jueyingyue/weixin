package com.liyue.weixin.questionanswer.infra.persistent;

import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;
import com.liyue.weixin.questionanswer.domain.repo.QuestionAnswerRepository;
import com.liyue.weixin.questionanswer.infra.persistent.mapper.QuestionAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * QuestionAnswer 仓储实现类（调用 MyBatis Mapper）
 */
@Repository
public class QuestionAnswerRepositoryImpl implements QuestionAnswerRepository {

    @Autowired
    private QuestionAnswerMapper questionAnswerMapper;


    @Override
    public int saveAnswer(QuestionAnswer answerDO) {
        return questionAnswerMapper.insert(answerDO);
    }

    @Override
    public int insertQuestionAndRel(QuestionAnswerRelationDO questionAnswerRelationDO) {
        return questionAnswerMapper.insertQuestionAndRel(questionAnswerRelationDO);
    }

    @Override
    public QuestionAnswer getAnswerById(Integer id) {
        return questionAnswerMapper.selectById(id);
    }
}
