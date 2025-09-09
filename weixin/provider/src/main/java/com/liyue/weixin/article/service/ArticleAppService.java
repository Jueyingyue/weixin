package com.liyue.weixin.article.service;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.online.article.dto.ArticleDetailReqDTO;
import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.utils.PageResult;

public interface ArticleAppService {
    int update(ArticleDO article);
    Long saveArticle(ArticleDetailReqDTO article);
    ArticleDO getArticleDetail(Long id);
    int getLikeCount(Long articleId);
    int getFavoriteCount(Long articleId);
    boolean hasLiked(String userId, Long articleId);
    boolean hasFavorited(String userId, Long articleId);
    PageResult<ArticleDO> selectByUserId(int pageNum, int pageSize, String userId,String type);
    ArticleDetailRspDTO queryarticles(Long tagId , String content,String articleId, Integer pageNum, Integer pageSize);
}
