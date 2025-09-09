package com.liyue.weixin.testRecordDetail.application.service.impl;

import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.testRecordDetail.application.service.TestRecordDetailAppService;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.service.TestRecordDetailDomainService;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试记录明细应用服务实现类
 */
@Service
public class TestRecordDetailAppServiceImpl implements TestRecordDetailAppService {

    @Resource
    private TestRecordDetailDomainService testRecordDetailDomainService;

    @Override
    public PageResult<TestRecordPageVO> queryTestRecordPage(String openid, int pageNum,
                                                            int pageSize) {
        return testRecordDetailDomainService.queryTestRecordPage(openid,pageNum,pageSize);
    }

    @Override
    public List<TestRecordDetailDO> getDetailByOpenid(String openid) {
        return testRecordDetailDomainService.getDetailByOpenid(openid);
    }

    @Override
    public List<TestRecordDetailDO> getDetailByOpenidAndBizTypeCode(TestRecordDetailDO testRecordDetailDO) {
        return testRecordDetailDomainService.getDetailByOpenidAndBizTypeCode(testRecordDetailDO);
    }

    @Override
    public int createDetail(TestRecordDetailDO detail) {
        return testRecordDetailDomainService.saveDetail(detail);
    }

    @Override
    public int updateDetail(TestRecordDetailDO detail,String type,String title) {
        return testRecordDetailDomainService.updateDetail(detail,type,title);
    }

    @Override
    public int deleteDetailById(Integer id) {
        return testRecordDetailDomainService.deleteDetailById(id);
    }

    @Override
    public TestRecordDetailDO getById(Long id) {
        return testRecordDetailDomainService.getById(id);
    }
}
