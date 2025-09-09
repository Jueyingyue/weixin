package com.liyue.weixin.innerHomePage.domain.repo;

import com.liyue.weixin.innerHomePage.domain.entity.MenuInfoDO;
import com.liyue.weixin.innerHomePage.domain.entity.OptionsDO;
import com.liyue.weixin.innerHomePage.domain.entity.QuestionsDO;
import com.liyue.weixin.innerHomePage.domain.entity.ResultConfigDO;

import java.util.List;


public interface HomePageRepository {
    List<MenuInfoDO> getHomePage();

    List<QuestionsDO> getQuestions(String bizTypeCode,String bizType );

    List<OptionsDO> getOptions(String bizTypeCode,String bizType ,String questionNo);

    List<MenuInfoDO> test();

    ResultConfigDO testResult(String bizTypeCode, String bizType,int score);

    int update(ResultConfigDO resultConfigDO);


}
