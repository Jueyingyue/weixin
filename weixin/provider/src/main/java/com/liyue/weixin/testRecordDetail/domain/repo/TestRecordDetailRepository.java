package com.liyue.weixin.testRecordDetail.domain.repo;

import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.utils.PageResult;

import java.util.List;

/**
 * 测试记录明细仓储接口（领域层抽象）
 */
public interface TestRecordDetailRepository {

    List<TestRecordDetailDO> getDetailByOpenid(String openid);

    /**
     * 分页查询用户的测试记录及关联的测试结果
     */
    PageResult<TestRecordPageVO> queryTestRecordPage(String openid, int pageNum,
                                                     int pageSize);

    List<TestRecordDetailDO> getDetailByOpenidAndBizTypeCode(TestRecordDetailDO testRecordDetailDO);


    int save(TestRecordDetailDO detail);

    int update(TestRecordDetailDO detail);

    int deleteById(Integer id);

    TestRecordDetailDO getById(Long id);

}
