package com.liyue.weixin.testRecordDetail.application.service;

import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.utils.PageResult;

import java.util.List;

/**
 * 测试记录明细应用服务接口（对外协调服务）
 */
public interface TestRecordDetailAppService {

    /**
     * 分页查询用户的测试记录及关联的测试结果
     */
    PageResult<TestRecordPageVO> queryTestRecordPage(String openid, int pageNum,
                                                     int pageSize);

    List<TestRecordDetailDO> getDetailByOpenid(String openid);

    List<TestRecordDetailDO> getDetailByOpenidAndBizTypeCode(TestRecordDetailDO testRecordDetailDO);


    int createDetail(TestRecordDetailDO detail);

    int updateDetail(TestRecordDetailDO detail,String type,String title);

    int deleteDetailById(Integer id);

    TestRecordDetailDO getById(Long id);

}
