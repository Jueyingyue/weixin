package com.liyue.weixin.article.domain.repo;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;

import java.util.List;

public interface ArticleTagRepository {
    void save(ArticleTagDO articleTagDO);
    void delete(Long id);
    void update(ArticleTagDO articleTagDO);
    ArticleTagDO findById(Long id);
    ArticleTagDO findByName(String name);
    List<ArticleTagDO> selectAll();
    int insertArticleTag(ArticleTagDO articleTagDO);
    List<ArticleTagDO> findByArticleId(Long articleId);
}
