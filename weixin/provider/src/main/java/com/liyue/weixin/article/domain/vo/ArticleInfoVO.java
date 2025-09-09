package com.liyue.weixin.article.domain.vo;

import com.liyue.weixin.article.domain.entity.ArticleDO;

public class ArticleInfoVO extends ArticleDO {
    private String category;
    private Long tagId;

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
