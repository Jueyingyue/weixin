package com.liyue.weixin.article.domain.service;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;

import java.util.List;

public interface ArticleTagDomainService {
    void createTag(ArticleTagDO articleTagDO);
    void deleteTag(Long id);
    ArticleTagDO getTagById(Long id);
    ArticleTagDO getTagByName(String name);
    List<ArticleTagDO> selectAll();
    int insertArticleTag(ArticleTagDO articleTagDO);
}
