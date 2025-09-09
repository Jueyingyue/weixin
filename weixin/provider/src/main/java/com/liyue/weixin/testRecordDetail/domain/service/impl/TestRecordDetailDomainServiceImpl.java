package com.liyue.weixin.testRecordDetail.domain.service.impl;

import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.repo.TestRecordDetailRepository;
import com.liyue.weixin.testRecordDetail.domain.service.TestRecordDetailDomainService;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试记录明细领域服务实现类
 */
@Service
public class TestRecordDetailDomainServiceImpl implements TestRecordDetailDomainService {

    @Resource
    private TestRecordDetailRepository testRecordDetailRepository;

    @Override
    public PageResult<TestRecordPageVO> queryTestRecordPage(String openid, int pageNum,
                                                            int pageSize) {
        return testRecordDetailRepository.queryTestRecordPage(openid,pageNum,pageSize);
    }

    @Override
    public List<TestRecordDetailDO> getDetailByOpenid(String openid) {
        return testRecordDetailRepository.getDetailByOpenid(openid);
    }

    @Override
    public List<TestRecordDetailDO> getDetailByOpenidAndBizTypeCode(TestRecordDetailDO testRecordDetailDO) {
        return testRecordDetailRepository.getDetailByOpenidAndBizTypeCode( testRecordDetailDO);
    }

    @Override
    public int saveDetail(TestRecordDetailDO detail) {
        return testRecordDetailRepository.save(detail);
    }

    @Override
    public int updateDetail(TestRecordDetailDO detail,String type,String title) {
        return testRecordDetailRepository.update(detail);
    }

    @Override
    public int deleteDetailById(Integer id) {
        return testRecordDetailRepository.deleteById(id);
    }

    @Override
    public TestRecordDetailDO getById(Long id) {
        return testRecordDetailRepository.getById(id);
    }
}
