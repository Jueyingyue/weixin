package com.liyue.weixin.innerHomePage.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyue.weixin.innerHomePage.domain.entity.*;

import java.util.List;

public interface HomePageDomainService {
    HomePageDO getHomePage();

    List<MenuInfoDO> test();

    List<QuestionsDO> getQuestions(String bizTypeCode, String bizType );

    ResultConfigDO testResult(String bizTypeCode, String bizType,int score,String openid,String operate);

    int update(ResultConfigVO resultConfigDO, String content, int modelIndex) throws Exception;


}
