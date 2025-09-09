package com.liyue.weixin.article.domain.repo;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.domain.vo.ArticleInfoVO;

import java.util.List;

public interface ArticleRepository {
    Long save(ArticleDO article);
    ArticleDO findById(Long id);
    int update(ArticleDO article);
    List<ArticleInfoVO> selectByUserId(int offset, int pageSize, String userId, String content, Long tagId,String articleId);
    int selectPublishRecordPageCount(String userId,Long tagId, String content,String articleId);
    List<ArticleInfoVO> selectFaLikesByUserId(int offset, int pageSize, String userId);
    int selectFaLikesCountByUserId(String userId,Long tagId, String content);
}
