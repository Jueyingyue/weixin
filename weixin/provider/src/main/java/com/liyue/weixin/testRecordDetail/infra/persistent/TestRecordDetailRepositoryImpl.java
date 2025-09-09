package com.liyue.weixin.testRecordDetail.infra.persistent;

import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.repo.TestRecordDetailRepository;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.testRecordDetail.infra.persistent.mapper.TestRecordDetailMapper;
import com.liyue.weixin.utils.PageHelperUtil;
import com.liyue.weixin.utils.PageResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试记录明细仓储实现类
 */
@Repository
public class TestRecordDetailRepositoryImpl extends PageHelperUtil implements TestRecordDetailRepository {

    @Resource
    private TestRecordDetailMapper testRecordDetailMapper;


    @Override
    public List<TestRecordDetailDO> getDetailByOpenid(String openid) {
        return testRecordDetailMapper.getDetailByOpenid(openid);
    }

    @Override
    public PageResult<TestRecordPageVO> queryTestRecordPage(String openid, int pageNum, int pageSize) {
        int total=testRecordDetailMapper.selectTestRecordPageCount(openid);
        int offset=(pageNum-1)*pageSize;
        List<TestRecordPageVO> records= testRecordDetailMapper.queryTestRecordPage(offset,pageSize,openid);

        return queryTestRecordPageWithResult(pageNum,pageSize, records,total);
    }

    @Override
    public List<TestRecordDetailDO> getDetailByOpenidAndBizTypeCode(TestRecordDetailDO testRecordDetailDO) {
        return testRecordDetailMapper.getDetailByOpenidAndBizTypeCode(testRecordDetailDO);
    }

    @Override
    public int save(TestRecordDetailDO detail) {
        return testRecordDetailMapper.insert(detail);
    }

    @Override
    public int update(TestRecordDetailDO detail) {
        return testRecordDetailMapper.update(detail);
    }

    @Override
    public int deleteById(Integer id) {
        return testRecordDetailMapper.deleteById(id);
    }

    @Override
    public TestRecordDetailDO getById(Long id) {
        return testRecordDetailMapper.selectById(id);
    }
}
