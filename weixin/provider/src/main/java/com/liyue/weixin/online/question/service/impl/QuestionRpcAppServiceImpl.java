package com.liyue.weixin.online.question.service.impl;


import com.liyue.weixin.online.question.dto.QuestionCreateReqDTO;
import com.liyue.weixin.online.question.dto.QuestionReqDTO;
import com.liyue.weixin.online.question.dto.QuestionRspDTO;
import com.liyue.weixin.online.question.service.QuestionRpcAppService;
import com.liyue.weixin.question.application.service.QuestionAppService;
import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.question.domain.entity.QuestionRspDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionRpcAppServiceImpl implements QuestionRpcAppService {

    @Autowired
    private QuestionAppService questionAppService;

    public QuestionRpcAppServiceImpl(QuestionAppService questionAppService) {
        this.questionAppService = questionAppService;
    }

    @Override
    @PostMapping(value = "/createQuestion")
    public List<QuestionRspDO> createQuestion(@RequestBody QuestionCreateReqDTO dto) throws Exception {
        List<QuestionRspDO> questionRspDOList=new ArrayList<>();
        questionRspDOList.add(questionAppService.createQuestion(dto));

        return questionRspDOList;
    }

    @Override
    public void updateQuestion(QuestionRspDTO dto) {
        // TODO: 将 QuestionRspDTO 转为 QuestionDO
        questionAppService.updateQuestion(null);
    }

    @Override
    public void deleteQuestion(String id) {
        questionAppService.deleteQuestion(id);
    }

    @Override
    @PostMapping(value = "/getQuestionById")
    public QuestionDO getQuestionById(String id) {
        // TODO: 调用 questionAppService.getQuestionById(id)，获取 DO 并转为 DTO
        return questionAppService.getQuestionById(id);
    }

    @PostMapping(value = "/getQuestion")
    public QuestionRspDO getQuestion(@RequestBody QuestionReqDTO reqDTO) {
        QuestionRspDO questionRspDO= questionAppService.getQuestionRsp(reqDTO);

        return questionRspDO;
    }


}
