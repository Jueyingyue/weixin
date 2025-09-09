package com.liyue.weixin.article.service.impl;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.domain.service.ArticleDomainService;
import com.liyue.weixin.article.domain.service.ArticleFavoriteDomainService;
import com.liyue.weixin.article.domain.service.ArticleLikeDomainService;
import com.liyue.weixin.article.service.ArticleAppService;
import com.liyue.weixin.online.article.dto.ArticleDetailReqDTO;
import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleAppServiceImpl implements ArticleAppService {
    @Autowired
    private  ArticleDomainService articleDomainService;
    @Autowired
    private  ArticleLikeDomainService articleLikeDomainService;
    @Autowired
    private  ArticleFavoriteDomainService articleFavoriteDomainService;


    @Override
    public int update(ArticleDO article) {
        return articleDomainService.update(article);
    }

    @Override
    public Long saveArticle(ArticleDetailReqDTO article) {
        return articleDomainService.saveArticle(article);
    }

    @Override
    public ArticleDO getArticleDetail(Long id) {
        return articleDomainService.getArticleDetail(id);
    }

    @Override
    public int getLikeCount(Long articleId) {
       return 0;
    }

    @Override
    public int getFavoriteCount(Long articleId) {
        return articleFavoriteDomainService.getFavoriteCount(articleId);
    }

    @Override
    public boolean hasLiked(String userId, Long articleId) {
        return true;
    }

    @Override
    public boolean hasFavorited(String userId, Long articleId) {
        return articleFavoriteDomainService.hasFavorited(userId, articleId);
    }

    @Override
    public PageResult<ArticleDO> selectByUserId(int pageNum, int pageSize, String userId,String type) {
        return articleDomainService.selectByUserId(pageNum,pageSize,userId,type);
    }

    @Override
    public ArticleDetailRspDTO queryarticles(Long tagId, String content, String articleId,Integer pageNum, Integer pageSize) {
        return articleDomainService.queryarticles(tagId,content,articleId,pageNum,pageSize);
    }
}
