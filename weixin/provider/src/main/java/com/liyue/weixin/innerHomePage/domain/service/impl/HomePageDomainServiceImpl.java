package com.liyue.weixin.innerHomePage.domain.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.util.StringUtil;
import com.liyue.weixin.httpRequest.application.WeixinInterfaceAppService;
import com.liyue.weixin.httpRequest.domain.entity.MessageResponse;
import com.liyue.weixin.innerHomePage.domain.entity.*;
import com.liyue.weixin.innerHomePage.domain.repo.HomePageRepository;
import com.liyue.weixin.innerHomePage.domain.service.HomePageDomainService;
import com.liyue.weixin.testRecordDetail.application.service.TestRecordDetailAppService;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.utils.MarkdownUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class HomePageDomainServiceImpl implements HomePageDomainService {

    @Autowired
    private HomePageRepository homePageRepository;
    @Autowired
    private TestRecordDetailAppService testRecordDetailAppService;
    @Autowired
    private WeixinInterfaceAppService weixinInterfaceAppService;

    @Override
    public HomePageDO getHomePage() {
        HomePageDO homePageDO = new HomePageDO();
        List<MenuInfoDO> menuInfoDOList = homePageRepository.getHomePage();
        for (int i = 0; i < menuInfoDOList.size(); i++) {
            if (menuInfoDOList.get(i) != null) {
                String index = menuInfoDOList.get(i).getBizType();
                switch (index) {
                    case "1":
                        homePageDO.getTest().add(menuInfoDOList.get(i));
                        break;
                    case "2":
                        homePageDO.getPlays().add(menuInfoDOList.get(i));
                        break;
                    case "3":
                        homePageDO.getCategories().add(menuInfoDOList.get(i));
                        break;
                    default:
                        break;
                }
            }

        }
        return homePageDO;
    }

    @Override
    public List<MenuInfoDO> test() {
        return homePageRepository.test();
    }

    @Override
    public List<QuestionsDO> getQuestions(String bizTypeCode, String bizType) {
        List<QuestionsDO> questionsDOList= homePageRepository.getQuestions(bizTypeCode,bizType);
        for (QuestionsDO questionsDO:questionsDOList){
            if(questionsDO!=null){
                List<OptionsDO> optionsDOList=homePageRepository.getOptions(questionsDO.getBizTypeCode(),questionsDO.getBizType(),questionsDO.getQuestionNo());
                questionsDO.setOptionsDOList(optionsDOList);
            }
        }
        return questionsDOList;
    }

    @Override
    public ResultConfigDO testResult(String bizTypeCode, String bizType,int score,String openid,String operate) {
        ResultConfigDO resultConfigDO= homePageRepository.testResult( bizTypeCode,  bizType,score);
        if("test".equals(operate)){
            saveTestRecordDetail( bizTypeCode,bizType,openid,score);
        }
        if(resultConfigDO!=null&&!StringUtil.isEmpty(resultConfigDO.getContent())){
            resultConfigDO.setContent(MarkdownUtil.markdownToHtml(resultConfigDO.getContent()));
        }
        if(resultConfigDO!=null&&!StringUtil.isEmpty(resultConfigDO.getReasoningContent())){
            resultConfigDO.setReasoningContent(MarkdownUtil.markdownToHtml(resultConfigDO.getReasoningContent()));
        }

        return resultConfigDO;
    }

    @Override
    public int update(ResultConfigVO resultConfigDO,String content,int modelIndex) throws Exception {
        if(StringUtils.isBlank(content)){
             content=resultConfigDO.getResultType()+"的详细解读报告";
        }
        if(StringUtils.isBlank(resultConfigDO.getContent())){
            MessageResponse messageResponse=weixinInterfaceAppService.getMessage(content,modelIndex);
            if(messageResponse!=null&&!CollectionUtils.isEmpty(messageResponse.getChoices())){
                resultConfigDO.setContent(MarkdownUtil.markdownToHtml(messageResponse.getChoices().get(0).getMessage().getContent()));
                resultConfigDO.setReasoningContent(MarkdownUtil.markdownToHtml(messageResponse.getChoices().get(0).getMessage().getReasoning_content()));
                return homePageRepository.update(resultConfigDO);
            }
        }
        return 0;
    }

    public void saveTestRecordDetail(String bizTypeCode, String bizType,String openid,int score){
        TestRecordDetailDO testRecordDetailDO=new TestRecordDetailDO();
        testRecordDetailDO.setBizType(bizType);
        testRecordDetailDO.setBizTypeCode(bizTypeCode);
        testRecordDetailDO.setScore(score);
        testRecordDetailDO.setUserId(openid);

        testRecordDetailAppService.createDetail(testRecordDetailDO);
    }

}
