package com.liyue.weixin.question.infra.persistent.mapper;

import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAndAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionMapper {
    int insert(QuestionDO question);
    int update(QuestionDO question);
    int deleteById(String id);
    QuestionDO selectById(String id);
    List<QuestionDO> selectAll();
    List<QuestionAndAnswer> selectByUserId(QuestionAndAnswer questionAnswer);
    int selectByUserIdCount(QuestionAndAnswer questionAnswer);
}
