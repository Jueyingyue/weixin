package com.liyue.weixin.article.infra.persistent;

import com.liyue.weixin.article.domain.entity.ArticleLikeDO;
import com.liyue.weixin.article.domain.repo.ArticleLikeRepository;
import com.liyue.weixin.article.infra.persistent.mapper.ArticleLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleLikeRepositoryImpl implements ArticleLikeRepository {

    @Autowired
    private ArticleLikeMapper articleLikeMapper;

    /**
     * 保存点赞记录（用户点赞某篇文章）
     * @param likeDO 点赞实体，包含 userId, articleId, createdAt
     */
    @Override
    public void save(ArticleLikeDO likeDO) {
        articleLikeMapper.insertLike(likeDO);
    }

    /**
     * 删除点赞记录（取消点赞）
     * @param userId 用户ID
     * @param articleId 文章ID
     */
    @Override
    public void delete(String userId, Long articleId) {
        articleLikeMapper.deleteLike(userId, articleId);
    }

    /**
     * 查询某篇文章的点赞总数
     * @param articleId 文章ID
     * @return 点赞总数（整数）
     */
    @Override
    public int countByArticleId(Long articleId) {
        return articleLikeMapper.countByArticleId(articleId);
    }

    /**
     * 判断某用户是否点过赞某文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 如果点过赞，返回对应的 ArticleLikeDO；否则可能返回 null
     */
    @Override
    public ArticleLikeDO hasLiked(String userId, Long articleId) {
        return articleLikeMapper.hasLiked(userId, articleId);
    }
}
