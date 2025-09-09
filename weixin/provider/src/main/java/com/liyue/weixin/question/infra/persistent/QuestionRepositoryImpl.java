package com.liyue.weixin.question.infra.persistent;

import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.question.domain.repo.QuestionRepository;
import com.liyue.weixin.question.infra.persistent.mapper.QuestionMapper;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAndAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    @Autowired
    private  QuestionMapper questionMapper;

    @Override
    public void save(QuestionDO question) {
        questionMapper.insert(question);
    }

    @Override
    public void update(QuestionDO question) {
        questionMapper.update(question);
    }

    @Override
    public void deleteById(String id) {
        questionMapper.deleteById(id);
    }

    @Override
    public QuestionDO findById(String id) {
        return questionMapper.selectById(id);
    }

    @Override
    public List<QuestionDO> findAll() {
        return questionMapper.selectAll();
    }

    @Override
    public List<QuestionAndAnswer> selectByUserId(QuestionAndAnswer questionAnswer) {
        return questionMapper.selectByUserId(questionAnswer);
    }

    @Override
    public int selectByUserIdCount(QuestionAndAnswer questionAnswer) {
        return questionMapper.selectByUserIdCount(questionAnswer);
    }
}
