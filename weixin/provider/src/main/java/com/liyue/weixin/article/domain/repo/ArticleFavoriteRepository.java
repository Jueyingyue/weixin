package com.liyue.weixin.article.domain.repo;

import com.liyue.weixin.article.domain.entity.ArticleFavoriteDO;

public interface ArticleFavoriteRepository {
    Long save(ArticleFavoriteDO favorite);
    void delete(String userId, Long articleId);
    int countByArticleId(Long articleId);
    ArticleFavoriteDO findByUserAndArticle(String userId, Long articleId);
}
