package com.liyue.weixin.article.service;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;

import java.util.List;

public interface ArticleTagAppService {
    void addTag(ArticleTagDO articleTagDO);
    void removeTag(Long id);
    ArticleTagDO queryTagById(Long id);
    ArticleTagDO queryTagByName(String name);
    List<ArticleTagDO> selectAll();
    int insertArticleTag(ArticleTagDO articleTagDO);
}
