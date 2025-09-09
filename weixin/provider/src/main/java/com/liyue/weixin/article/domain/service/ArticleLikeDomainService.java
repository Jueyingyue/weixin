package com.liyue.weixin.article.domain.service;


import com.liyue.weixin.article.domain.entity.ArticleLikeDO;

public interface ArticleLikeDomainService {

    /**
     * 用户点赞某篇文章
     * @param userId 用户ID
     * @param articleId 文章ID
     */
    void likeArticle(Long userId, Long articleId);

    /**
     * 用户取消点赞某篇文章
     * @param userId 用户ID
     * @param articleId 文章ID
     */
    void unlikeArticle(String userId, Long articleId);

    /**
     * 查询某用户是否点过赞某文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 如果点过赞，返回点赞记录；否则返回 null
     */
    ArticleLikeDO hasLiked(String userId, Long articleId);
}
