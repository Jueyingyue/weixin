package com.liyue.weixin.testRecordDetail.domain.vo;

import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;


public class TestRecordPageVO extends TestRecordDetailDO {
    private String resultDesc;          // 测试结果描述

    private String resultType;          // 测试结果类型

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
