package com.liyue.weixin.testRecordDetail.domain.entity;

import java.time.LocalDateTime;

/**
 * 测试记录明细表（test_record_detail）对应的实体类（DO）
 */
public class TestRecordDetailDO {

    private Long id;                    // 明细ID，主键
    private String userId;                // 测试用户ID
    private String bizType;                // 测试模块，如：情绪测试、人格测试
    private String bizTypeCode;            // 测试问题类型代码，如：anxiety、depression
    private Integer score;                 // 测试得分
    private LocalDateTime createdAt=LocalDateTime.now() ;       // 创建时间
    private LocalDateTime updatedAt=LocalDateTime.now();       // 更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeCode() {
        return bizTypeCode;
    }

    public void setBizTypeCode(String bizTypeCode) {
        this.bizTypeCode = bizTypeCode;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
