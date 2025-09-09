package com.liyue.weixin.article.infra.persistent.mapper;

import com.liyue.weixin.article.domain.entity.ArticleLikeDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ArticleLikeMapper {

    // 插入点赞记录
    void insertLike(ArticleLikeDO likeDO);

    // 删除点赞记录
    void deleteLike(@Param("userId") String userId, @Param("articleId") Long articleId);

    // 查询某文章的点赞总数
    int countByArticleId(@Param("articleId") Long articleId);

    // 查询某用户是否点过赞某文章
    ArticleLikeDO hasLiked(@Param("userId") String userId, @Param("articleId") Long articleId);
}
