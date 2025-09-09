package com.liyue.weixin.article.domain.repo;


import com.liyue.weixin.article.domain.entity.ArticleLikeDO;

public interface ArticleLikeRepository {

    // 保存点赞记录
    void save(ArticleLikeDO likeDO);

    // 删除点赞记录（根据用户ID和文章ID）
    void delete(String userId, Long articleId);

    // 查询某文章的点赞总数
    int countByArticleId(Long articleId);

    // 判断某用户是否点过赞某文章（返回 ArticleLikeDO，可用于判断是否存在）
    ArticleLikeDO hasLiked(String userId, Long articleId);
}
