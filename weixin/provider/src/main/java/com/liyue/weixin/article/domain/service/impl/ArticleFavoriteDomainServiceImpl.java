package com.liyue.weixin.article.domain.service.impl;

import com.liyue.weixin.article.domain.entity.ArticleFavoriteDO;
import com.liyue.weixin.article.domain.repo.ArticleFavoriteRepository;
import com.liyue.weixin.article.domain.service.ArticleFavoriteDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleFavoriteDomainServiceImpl implements ArticleFavoriteDomainService {

    @Autowired
    private  ArticleFavoriteRepository articleFavoriteRepository;


    @Override
    public void favoriteArticle(Long userId, Long articleId) {

    }

    /**
     * 用户取消收藏文章
     * @param userId 用户ID
     * @param articleId 文章ID
     */
    @Override
    public void unfavoriteArticle(String userId, Long articleId) {
        articleFavoriteRepository.delete(userId, articleId);
    }

    /**
     * 获取某篇文章的收藏总数
     * @param articleId 文章ID
     * @return 收藏数量
     */
    @Override
    public int getFavoriteCount(Long articleId) {
        return articleFavoriteRepository.countByArticleId(articleId);
    }

    /**
     * 判断某用户是否收藏过某文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return true=已收藏，false=未收藏
     */
    @Override
    public boolean hasFavorited(String userId, Long articleId) {
        ArticleFavoriteDO favorite = articleFavoriteRepository.findByUserAndArticle(userId, articleId);
        return favorite != null;
    }
}
