package com.liyue.weixin.online.article.service.impl;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.service.ArticleAppService;
import com.liyue.weixin.online.article.dto.ArticleDetailReqDTO;
import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.online.article.service.ArticleRpcAppService;
import com.liyue.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleRpcAppServiceImpl implements ArticleRpcAppService {
    @Autowired
    private  ArticleAppService articleAppService;


    @Override
    @PostMapping(value = "/saveArticle")
    public Long saveArticle(@RequestBody ArticleDetailReqDTO articleDetailReqDTO) {
        return articleAppService.saveArticle(articleDetailReqDTO);
    }

    @PostMapping(value = "/insertfavorites")
    public Long insertfavorites(@RequestBody ArticleDetailReqDTO articleDetailReqDTO) {
        return articleAppService.saveArticle(articleDetailReqDTO);
    }

    @Override
    public ArticleDO getArticleDetail(Long id) {
        return articleAppService.getArticleDetail(id);
    }

    @Override
    public int getLikeCount(Long articleId) {
        return articleAppService.getLikeCount(articleId);
    }

    @Override
    public int getFavoriteCount(Long articleId) {
        return articleAppService.getFavoriteCount(articleId);
    }

    @Override
    public boolean hasLiked(String userId, Long articleId) {
        return articleAppService.hasLiked(userId, articleId);
    }

    @Override
    public boolean hasFavorited(String userId, Long articleId) {
        return articleAppService.hasFavorited(userId, articleId);
    }

    @Override
    @PostMapping(value = "/getArticleUserId")
    public PageResult<ArticleDO> selectByUserId(int pageNum, int pageSize, String userId,String type) {
        PageResult<ArticleDO> pageResult= articleAppService.selectByUserId(pageNum,pageSize,userId,type);

        return pageResult;
    }

    @Override
    @PostMapping(value = "/queryarticles")
    public ArticleDetailRspDTO queryarticles(Long tagId, String content, String articleId,Integer pageNum, Integer pageSize) {
        ArticleDetailRspDTO articleDetailRspDTO= articleAppService.queryarticles(tagId,content,articleId,pageNum,pageSize);

        return articleDetailRspDTO;
    }

    @Override
    @PostMapping(value = "/update")
    public int update(@RequestBody ArticleDO article) {
        return articleAppService.update(article);
    }

}
