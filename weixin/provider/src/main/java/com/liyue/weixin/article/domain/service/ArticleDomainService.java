package com.liyue.weixin.article.domain.service;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.online.article.dto.ArticleDetailReqDTO;
import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.utils.PageResult;

public interface ArticleDomainService {
    Long saveArticle(ArticleDetailReqDTO article);
    ArticleDO getArticleDetail(Long id);
    PageResult<ArticleDO> selectByUserId(int pageNum, int pageSize, String userId,String type);
    ArticleDetailRspDTO queryarticles(Long tagId , String content,String articleId, Integer pageNum, Integer pageSize);
    int update(ArticleDO article);
}
