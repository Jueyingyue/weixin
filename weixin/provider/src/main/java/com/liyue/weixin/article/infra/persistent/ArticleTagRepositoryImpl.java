package com.liyue.weixin.article.infra.persistent;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import com.liyue.weixin.article.domain.repo.ArticleTagRepository;
import com.liyue.weixin.article.infra.persistent.mapper.ArticleTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleTagRepositoryImpl implements ArticleTagRepository {

    @Autowired
    private  ArticleTagMapper articleTagMapper;

    @Override
    public void save(ArticleTagDO articleTagDO) {
        articleTagMapper.insert(articleTagDO);
    }

    @Override
    public void delete(Long id) {
        articleTagMapper.deleteById(id);
    }

    @Override
    public void update(ArticleTagDO articleTagDO) {
        articleTagMapper.update(articleTagDO);
    }

    @Override
    public ArticleTagDO findById(Long id) {
        return articleTagMapper.selectById(id);
    }

    @Override
    public ArticleTagDO findByName(String name) {
        return articleTagMapper.selectByName(name);
    }

    @Override
    public List<ArticleTagDO> selectAll() {
        return articleTagMapper.selectAll();
    }

    @Override
    public int insertArticleTag(ArticleTagDO articleTagDO) {
        return articleTagMapper.insertArticleTag(articleTagDO);
    }

    @Override
    public List<ArticleTagDO> findByArticleId(Long articleId) {
        return articleTagMapper.findByArticleId(articleId);
    }
}
