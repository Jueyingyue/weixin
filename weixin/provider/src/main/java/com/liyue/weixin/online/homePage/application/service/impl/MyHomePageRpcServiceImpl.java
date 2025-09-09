package com.liyue.weixin.online.homePage.application.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyue.weixin.innerHomePage.application.service.HomePageAppService;
import com.liyue.weixin.innerHomePage.domain.entity.*;
import com.liyue.weixin.online.homePage.application.service.MyHomePageRpcService;
import com.liyue.weixin.testRecordDetail.application.service.TestRecordDetailAppService;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.userInfo.application.service.UserInfoAppService;
import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/homePage")
@RestController
public class MyHomePageRpcServiceImpl implements MyHomePageRpcService {

    @Autowired
    private HomePageAppService homePageAppService;
    @Autowired
    private TestRecordDetailAppService testRecordDetailAppService;
    @Autowired
    private UserInfoAppService userInfoAppService;

    @Override
    @RequestMapping(value = "/getHomePage")
    public HomePageDO getHomePage() {
        long startime=System.currentTimeMillis();
        HomePageDO homePageDO= homePageAppService.getHomePage();
        System.out.println("耗时："+(System.currentTimeMillis()-startime));
        return homePageDO;
    }

    @Override
    @RequestMapping(value = "/getQuestions")
    public List<QuestionsDO> getQuestions(String bizTypeCode, String bizType) {
        return homePageAppService.getQuestions(bizTypeCode,bizType);
    }

    @Override
    @RequestMapping(value = "/testResult")
    public ResultConfigDO testResult(String bizTypeCode, String bizType,int score,String openid) {
        ResultConfigDO resultConfigDO= homePageAppService.testResult( bizTypeCode,  bizType,score,openid,"test");

        return resultConfigDO;
    }

    @RequestMapping(value = "/test")
    public List<MenuInfoDO> test() {
        return homePageAppService.test();
    }


    @RequestMapping(value = "/getTestRecordDetailDO")
    public ResultConfigVO getTestRecordDetailDO(String content, Long id) throws Exception {
        TestRecordDetailDO testRecordDetailDO=testRecordDetailAppService.getById(id);
        UserInfoDO userInfoDO=userInfoAppService.selectByOpenid(testRecordDetailDO.getUserId());
        ResultConfigDO resultConfigDO= homePageAppService.testResult( testRecordDetailDO.getBizTypeCode(),  testRecordDetailDO.getBizType(),testRecordDetailDO.getScore(),testRecordDetailDO.getUserId(),"");
        ResultConfigVO resultConfigVO= BeanUtil.copyProperties(resultConfigDO, ResultConfigVO.class);
        resultConfigVO.setScore(testRecordDetailDO.getScore());
        homePageAppService.update(resultConfigVO, content, Integer.parseInt(userInfoDO.getUnionid()));

        return resultConfigVO;
    }
}
