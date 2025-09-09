package com.liyue.weixin.online.article.service.impl;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import com.liyue.weixin.article.service.ArticleTagAppService;
import com.liyue.weixin.online.article.dto.ArticleTagReqDTO;
import com.liyue.weixin.online.article.service.ArticleTagRpcAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articleTag")
public class ArticleTagRpcAppServiceImpl implements ArticleTagRpcAppService {

    @Autowired
    private ArticleTagAppService articleTagAppService;

    public ArticleTagRpcAppServiceImpl(ArticleTagAppService articleTagAppService) {
        this.articleTagAppService = articleTagAppService;
    }

    @Override
    public void create(ArticleTagDO articleTagDO) {
        articleTagAppService.addTag(articleTagDO);
    }

    @Override
    public void delete(Long id) {
        articleTagAppService.removeTag(id);
    }

    @Override
    public ArticleTagDO getById(Long id) {
        return articleTagAppService.queryTagById(id);
    }

    @Override
    public ArticleTagDO getByName(String name) {
        return articleTagAppService.queryTagByName(name);
    }

    @Override
    @PostMapping(value = "/selectAll")
    public ArticleTagReqDTO selectAll() {
        ArticleTagReqDTO articleTagReqDTO=new ArticleTagReqDTO();
        List<ArticleTagDO> list= articleTagAppService.selectAll();
        articleTagReqDTO.setAllTags(list.stream().map(ArticleTagDO::getName).collect(Collectors.toList()));
        articleTagReqDTO.setTagIndex(list.stream().map(ArticleTagDO::getId).collect(Collectors.toList()));

        return articleTagReqDTO;
    }

}
