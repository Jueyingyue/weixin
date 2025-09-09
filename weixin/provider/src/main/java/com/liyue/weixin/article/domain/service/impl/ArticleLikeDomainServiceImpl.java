package com.liyue.weixin.article.domain.service.impl;

import com.liyue.weixin.article.domain.entity.ArticleLikeDO;
import com.liyue.weixin.article.domain.repo.ArticleLikeRepository;
import com.liyue.weixin.article.domain.service.ArticleLikeDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleLikeDomainServiceImpl implements ArticleLikeDomainService {

    @Autowired
    private  ArticleLikeRepository articleLikeRepository;


    @Override
    public void likeArticle(Long userId, Long articleId) {

    }

    /**
     * 用户取消点赞文章
     * @param userId 用户ID
     * @param articleId 文章ID
     */
    @Override
    public void unlikeArticle(String userId, Long articleId) {
        articleLikeRepository.delete(userId, articleId);
    }

    /**
     * 查询某用户是否点过赞某文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 如果点过赞，返回 ArticleLikeDO；否则返回 null
     */
    @Override
    public ArticleLikeDO hasLiked(String userId, Long articleId) {
        return articleLikeRepository.hasLiked(userId, articleId);
    }
}
