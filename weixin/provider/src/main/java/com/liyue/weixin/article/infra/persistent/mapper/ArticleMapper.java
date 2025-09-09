package com.liyue.weixin.article.infra.persistent.mapper;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.domain.vo.ArticleInfoVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper{
    Long insert(ArticleDO article);
    ArticleDO selectById(Long id);
    List<ArticleInfoVO> selectByUserId(int offset, int pageSize, String userId, String content, Long tagId,String articleId);
    int selectPublishRecordPageCount(String userId,Long tagId, String content,String articleId);
    int update(ArticleDO article);
    List<ArticleInfoVO> selectFaLikesByUserId(int offset, int pageSize, String userId);
    int selectFaLikesCountByUserId(String userId,Long tagId, String content);
}
