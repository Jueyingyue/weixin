package com.liyue.weixin.online.homePage.application.service;


import com.liyue.weixin.innerHomePage.domain.entity.HomePageDO;
import com.liyue.weixin.innerHomePage.domain.entity.QuestionsDO;
import com.liyue.weixin.innerHomePage.domain.entity.ResultConfigDO;

import java.util.List;

public interface MyHomePageRpcService {

    HomePageDO getHomePage();

    List<QuestionsDO> getQuestions(String bizTypeCode, String bizType );

    ResultConfigDO testResult(String bizTypeCode, String bizType,int score,String openid);



}
