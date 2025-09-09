package com.liyue.weixin.article.domain.service.impl;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import com.liyue.weixin.article.domain.repo.ArticleTagRepository;
import com.liyue.weixin.article.domain.service.ArticleTagDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagDomainServiceImpl implements ArticleTagDomainService {

    @Autowired
    private ArticleTagRepository articleTagRepository;

    @Override
    public void createTag(ArticleTagDO articleTagDO) {
        articleTagRepository.save(articleTagDO);
    }

    @Override
    public void deleteTag(Long id) {
        articleTagRepository.delete(id);
    }

    @Override
    public ArticleTagDO getTagById(Long id) {
        return articleTagRepository.findById(id);
    }

    @Override
    public ArticleTagDO getTagByName(String name) {
        return articleTagRepository.findByName(name);
    }

    @Override
    public List<ArticleTagDO> selectAll() {
        return articleTagRepository.selectAll();
    }

    @Override
    public int insertArticleTag(ArticleTagDO articleTagDO) {
        return articleTagRepository.insertArticleTag(articleTagDO);
    }
}
