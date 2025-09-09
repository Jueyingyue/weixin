package com.liyue.weixin.article.infra.persistent;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.domain.repo.ArticleRepository;
import com.liyue.weixin.article.domain.vo.ArticleInfoVO;
import com.liyue.weixin.article.infra.persistent.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Long save(ArticleDO article) {
        articleMapper.insert(article);
        return article.getId(); // 假设插入成功并返回自增ID
    }

    @Override
    public ArticleDO findById(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public int update(ArticleDO article) {
        return  articleMapper.update(article);
    }


    @Override
    public List<ArticleInfoVO> selectByUserId(int offset, int pageSize, String userId, String content, Long tagId,String articleId) {
        return articleMapper.selectByUserId( offset,  pageSize,  userId,content,tagId,articleId);
    }

    @Override
    public int selectPublishRecordPageCount(String userId,Long tagId, String content,String articleId) {
        return    articleMapper.selectPublishRecordPageCount( userId,tagId,content, articleId);

    }

    @Override
    public List<ArticleInfoVO> selectFaLikesByUserId(int offset, int pageSize, String userId) {
        return articleMapper.selectFaLikesByUserId( offset,  pageSize,  userId);
    }

    @Override
    public int selectFaLikesCountByUserId(String userId, Long tagId, String content) {
        return    articleMapper.selectFaLikesCountByUserId( userId,tagId,content);
    }
}
