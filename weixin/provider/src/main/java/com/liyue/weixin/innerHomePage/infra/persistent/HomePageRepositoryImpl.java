package com.liyue.weixin.innerHomePage.infra.persistent;

import com.liyue.weixin.innerHomePage.domain.entity.MenuInfoDO;
import com.liyue.weixin.innerHomePage.domain.entity.OptionsDO;
import com.liyue.weixin.innerHomePage.domain.entity.QuestionsDO;
import com.liyue.weixin.innerHomePage.domain.entity.ResultConfigDO;
import com.liyue.weixin.innerHomePage.domain.repo.HomePageRepository;
import com.liyue.weixin.innerHomePage.infra.persistent.mapper.HomePageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageRepositoryImpl implements HomePageRepository {

    @Autowired
    private HomePageMapper homePageMapper;

    @Override
    public List<MenuInfoDO> getHomePage() {
        return homePageMapper.getHomePage();
    }

    @Override
    public List<QuestionsDO> getQuestions(String bizTypeCode,String bizType ) {
        return homePageMapper.getQuestions( bizTypeCode, bizType );
    }

    @Override
    public List<OptionsDO> getOptions(String bizTypeCode,String bizType,String questionNo) {
        return homePageMapper.getOptions(bizTypeCode,bizType,questionNo);
    }

    public List<MenuInfoDO> test() {
        return homePageMapper.test();
    }

    @Override
    public ResultConfigDO testResult(String bizTypeCode, String bizType,int score) {
        return homePageMapper.testResult( bizTypeCode,  bizType,score);
    }

    @Override
    public int update(ResultConfigDO resultConfigDO) {
        return homePageMapper.update(resultConfigDO);
    }
}
