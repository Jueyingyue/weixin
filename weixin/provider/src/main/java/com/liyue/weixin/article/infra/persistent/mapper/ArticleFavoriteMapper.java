package com.liyue.weixin.article.infra.persistent.mapper;

import com.liyue.weixin.article.domain.entity.ArticleFavoriteDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleFavoriteMapper {
    Long insert(ArticleFavoriteDO favorite);
    int deleteByUserAndArticle(String userId, Long articleId);
    int countByArticleId(Long articleId);
    List<ArticleFavoriteDO> selectByArticleId(Long articleId);
    ArticleFavoriteDO selectByUserAndArticle(String userId, Long articleId);
}
