package com.liyue.weixin.testRecordDetail.domain.service;

import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.utils.PageResult;

import java.util.List;

/**
 * 测试记录明细领域服务接口（处理测试记录相关的业务逻辑）
 */
public interface TestRecordDetailDomainService {

    /**
     * 分页查询用户的测试记录及关联的测试结果
     */
    PageResult<TestRecordPageVO> queryTestRecordPage(String openid, int pageNum,
                                                     int pageSize);

    List<TestRecordDetailDO> getDetailByOpenid(String openid);

    List<TestRecordDetailDO> getDetailByOpenidAndBizTypeCode(TestRecordDetailDO testRecordDetailDO);


    int saveDetail(TestRecordDetailDO detail);

    int updateDetail(TestRecordDetailDO detail,String type,String title);

    int deleteDetailById(Integer id);

    TestRecordDetailDO getById(Long id);


}
