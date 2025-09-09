package com.liyue.weixin.innerHomePage.infra.persistent.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.liyue.weixin.innerHomePage.domain.entity.MenuInfoDO;
import com.liyue.weixin.innerHomePage.domain.entity.OptionsDO;
import com.liyue.weixin.innerHomePage.domain.entity.QuestionsDO;
import com.liyue.weixin.innerHomePage.domain.entity.ResultConfigDO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageMapper extends BaseMapper {

    List<MenuInfoDO> getHomePage();

    List<QuestionsDO> getQuestions(String bizTypeCode,String bizType );

    List<OptionsDO> getOptions(String bizTypeCode,String bizType,String questionNo);

    @Select("SELECT * FROM menu_info")
    @Results({
            @Result(column = "biz_type_code", property = "bizTypeCode"),
            @Result(column = "biz_type", property = "bizType"),
            @Result(column = "biz_type_cn_desc", property = "bizTypeCnDesc"),
            @Result(column = "index_type", property = "indexType"),
    })
    List<MenuInfoDO> test();

    ResultConfigDO testResult(String bizTypeCode, String bizType,int score);

    int update(ResultConfigDO resultConfigDO);
}
