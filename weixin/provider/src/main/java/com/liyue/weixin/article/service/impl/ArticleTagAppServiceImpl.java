package com.liyue.weixin.article.service.impl;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import com.liyue.weixin.article.domain.service.ArticleTagDomainService;
import com.liyue.weixin.article.service.ArticleTagAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagAppServiceImpl implements ArticleTagAppService {

    @Autowired
    private ArticleTagDomainService articleTagDomainService;

    @Override
    public void addTag(ArticleTagDO articleTagDO) {
        articleTagDomainService.createTag(articleTagDO);
    }

    @Override
    public void removeTag(Long id) {
        articleTagDomainService.deleteTag(id);
    }

    @Override
    public ArticleTagDO queryTagById(Long id) {
        return articleTagDomainService.getTagById(id);
    }

    @Override
    public ArticleTagDO queryTagByName(String name) {
        return articleTagDomainService.getTagByName(name);
    }

    @Override
    public List<ArticleTagDO> selectAll() {
        return articleTagDomainService.selectAll();
    }

    @Override
    public int insertArticleTag(ArticleTagDO articleTagDO) {
        return articleTagDomainService.insertArticleTag(articleTagDO);
    }
}
