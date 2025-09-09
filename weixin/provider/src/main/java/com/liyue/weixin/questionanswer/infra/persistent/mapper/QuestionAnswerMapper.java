package com.liyue.weixin.questionanswer.infra.persistent.mapper;

import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * QuestionAnswer 表的 MyBatis Mapper 接口
 */
@Repository
public interface QuestionAnswerMapper {
    int insert(QuestionAnswer record);
    int insertQuestionAndRel(QuestionAnswerRelationDO questionAnswerRelationDO);
    QuestionAnswer selectById(Integer id);
}
