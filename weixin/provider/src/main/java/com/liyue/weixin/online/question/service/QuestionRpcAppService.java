package com.liyue.weixin.online.question.service;


import com.liyue.weixin.online.question.dto.QuestionCreateReqDTO;
import com.liyue.weixin.online.question.dto.QuestionReqDTO;
import com.liyue.weixin.online.question.dto.QuestionRspDTO;
import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.question.domain.entity.QuestionRspDO;

import java.util.List;

public interface QuestionRpcAppService {
    List<QuestionRspDO> createQuestion(QuestionCreateReqDTO dto) throws Exception;
    void updateQuestion(QuestionRspDTO dto);
    void deleteQuestion(String id);
    QuestionDO getQuestionById(String id);
    QuestionRspDO getQuestion(QuestionReqDTO reqDTO);
}
