package com.liyue.weixin.testRecordDetail.infra.persistent.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 测试记录明细表 Mapper 接口（对应 test_record_detail 表）
 */
@Mapper
public interface TestRecordDetailMapper extends BaseMapper<TestRecordDetailDO> {

    /**
     * 根据 ID 查询测试记录明细
     */
    List<TestRecordDetailDO> getDetailByOpenid(String openid);

    List<TestRecordDetailDO> getDetailByOpenidAndBizTypeCode(TestRecordDetailDO testRecordDetailDO);

    /**
     * 分页查询用户的测试记录及关联的测试结果
     */
    List<TestRecordPageVO> queryTestRecordPage(int offset, int pageSize, String openid);

    int selectTestRecordPageCount(String openid);

    /**
     * 更新测试记录明细
     */
    int update(TestRecordDetailDO detail);

    /**
     * 根据 ID 删除测试记录明细
     */
    int deleteById(Integer id);
}
