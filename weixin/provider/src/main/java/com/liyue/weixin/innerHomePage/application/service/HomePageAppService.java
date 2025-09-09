package com.liyue.weixin.innerHomePage.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyue.weixin.innerHomePage.domain.entity.*;

import java.util.List;

public interface HomePageAppService {

    HomePageDO getHomePage();

    List<MenuInfoDO> test();

    List<QuestionsDO> getQuestions(String bizTypeCode, String bizType );

    ResultConfigDO testResult(String bizTypeCode, String bizType,int score,String openid,String operate);

    int update(ResultConfigVO resultConfigDO, String content, int modelIndex) throws Exception;



}
