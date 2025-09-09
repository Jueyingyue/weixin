package com.liyue.weixin.question.domain.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.util.StringUtil;
import com.liyue.weixin.httpRequest.application.WeixinInterfaceAppService;
import com.liyue.weixin.httpRequest.domain.entity.MessageResponse;
import com.liyue.weixin.online.question.dto.QuestionReqDTO;
import com.liyue.weixin.question.domain.entity.QuestionDO;
import com.liyue.weixin.question.domain.entity.QuestionRspDO;
import com.liyue.weixin.question.domain.repo.QuestionRepository;
import com.liyue.weixin.question.domain.service.QuestionDomainService;
import com.liyue.weixin.questionanswer.application.service.AnswerAppService;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAndAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswer;
import com.liyue.weixin.questionanswer.domain.entity.QuestionAnswerRelationDO;
import com.liyue.weixin.userInfo.application.service.UserInfoAppService;
import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import com.liyue.weixin.utils.MarkdownUtil;
import com.liyue.weixin.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class QuestionDomainServiceImpl extends PageHelperUtil implements QuestionDomainService {

    @Autowired
    private  QuestionRepository questionRepository;
    @Autowired
    private WeixinInterfaceAppService weixinInterfaceAppService;
    @Autowired
    private UserInfoAppService userInfoAppService;
    @Autowired
    private AnswerAppService answerAppService;

    public QuestionDomainServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionRspDO createQuestion(QuestionDO question) throws Exception {
        questionRepository.save(question);
        UserInfoDO userInfoDO= userInfoAppService.selectByOpenid(question.getAskUserId());
        MessageResponse messageResponse = weixinInterfaceAppService.getMessage(question.getQuestion(),Integer.parseInt(userInfoDO.getUnionid()));
        MessageResponse.Choice.Message message=messageResponse.getChoices().get(0).getMessage();
        QuestionAnswer questionAnswer=new QuestionAnswer();
        String answer=message.getReasoning_content()!=null&& StringUtil.isEmpty(message.getReasoning_content())?message.getReasoning_content():message.getContent();
        questionAnswer.setAnswer(MarkdownUtil.markdownToHtml(answer));
        answerAppService.saveAnswer(questionAnswer);
        QuestionAnswerRelationDO questionAnswerRelationDO=new QuestionAnswerRelationDO();
        questionAnswerRelationDO.setAnswerId(questionAnswer.getAnswerid());
        questionAnswerRelationDO.setQuestionId(question.getId());
        answerAppService.insertQuestionAndRel(questionAnswerRelationDO);

        List<QuestionAnswer> answerList=new ArrayList<>();
        answerList.add(questionAnswer);
        QuestionRspDO questionRspDO=new QuestionRspDO(1,1,1,answerList);

        BeanUtil.copyProperties(question,questionRspDO ,CopyOptions.create().setIgnoreNullValue(true));

        return questionRspDO;
    }

    @Override
    public void updateQuestion(QuestionDO question) {
        questionRepository.update(question);
    }

    @Override
    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionDO getQuestionById(String id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<QuestionDO> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public QuestionRspDO getQuestionRsp(QuestionReqDTO reqDTO) {
        QuestionAndAnswer questionAnswer=new QuestionAndAnswer();
        questionAnswer.setAskTypeId(reqDTO.getBizType().concat("@").concat(reqDTO.getBizTypeCode()));
        questionAnswer.setAskUserId(reqDTO.getUserId());
        questionAnswer.setPageNum(reqDTO.getPageNum());
        questionAnswer.setPageSize(reqDTO.getPageSize());
        int offset = (reqDTO.getPageNum() - 1) * reqDTO.getPageSize();
        questionAnswer.setOffset(offset);
        int total=questionRepository.selectByUserIdCount(questionAnswer);
        List<QuestionAndAnswer> records= questionRepository.selectByUserId(questionAnswer);
        HashSet hashSet=new HashSet();
        QuestionRspDO questionRspDO=new QuestionRspDO(1,reqDTO.getPageNum(),reqDTO.getPageSize(),new ArrayList<QuestionAnswer>());
        questionRspDO.setTotal(total);
       for (QuestionAndAnswer questionDO:records){
           if(!hashSet.contains(questionDO.getId())){
               BeanUtil.copyProperties(questionDO,questionRspDO ,CopyOptions.create().setIgnoreNullValue(true));
               QuestionAnswer answer=BeanUtil.copyProperties(questionDO,QuestionAnswer.class);
               answer.setAnswer(MarkdownUtil.markdownToHtml(answer.getAnswer()));
               hashSet.add(questionDO.getId());
               questionRspDO.getRecords().add(answer);
           }
       }

        return questionRspDO;
    }
}
