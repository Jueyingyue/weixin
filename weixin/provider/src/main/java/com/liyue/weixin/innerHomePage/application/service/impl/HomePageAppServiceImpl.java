package com.liyue.weixin.innerHomePage.application.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyue.weixin.innerHomePage.application.service.HomePageAppService;
import com.liyue.weixin.innerHomePage.domain.entity.*;
import com.liyue.weixin.innerHomePage.domain.service.HomePageDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageAppServiceImpl implements HomePageAppService {
    @Autowired
    private HomePageDomainService homePageDomainService;

    public HomePageDO getHomePage() {
        return homePageDomainService.getHomePage();
    }

    @Override
    public List<MenuInfoDO> test() {
        return homePageDomainService.test();
    }

    @Override
    public List<QuestionsDO> getQuestions(String bizTypeCode, String bizType) {
        return homePageDomainService.getQuestions(bizTypeCode,bizType);
    }

    @Override
    public ResultConfigDO testResult(String bizTypeCode, String bizType,int score,String openid,String operate) {
        return homePageDomainService.testResult( bizTypeCode, bizType,score,openid,operate);
    }

    @Override
    public int update(ResultConfigVO resultConfigDO, String content, int modelIndex) throws Exception {
        return homePageDomainService.update(resultConfigDO,content,modelIndex);
    }

}
