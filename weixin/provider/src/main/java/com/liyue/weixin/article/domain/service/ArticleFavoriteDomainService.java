package com.liyue.weixin.article.domain.service;

public interface ArticleFavoriteDomainService {
    void favoriteArticle(Long userId, Long articleId);
    void unfavoriteArticle(String userId, Long articleId);
    int getFavoriteCount(Long articleId);
    boolean hasFavorited(String userId, Long articleId);
}
