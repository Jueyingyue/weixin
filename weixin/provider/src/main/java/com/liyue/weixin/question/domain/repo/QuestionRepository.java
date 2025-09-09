package com.liyue.weixin.question.domain.repo;

import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAndAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;

import java.util.List;

public interface QuestionRepository {
    void save(QuestionDO question);
    void update(QuestionDO question);
    void deleteById(String id);
    QuestionDO findById(String id);
    List<QuestionDO> findAll();
    List<QuestionAndAnswer> selectByUserId(QuestionAndAnswer questionAnswer);
    int selectByUserIdCount(QuestionAndAnswer questionAnswer);
}
