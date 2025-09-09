package com.liyue.weixin.online.article.dto;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import com.liyue.weixin.utils.PageResult;

import java.util.ArrayList;
import java.util.List;

public class ArticleDetailRspDTO {

    //全部分类
    List<ArticleTagDO> categories=new ArrayList<>();
    //热门分类
    List<ArticleTagDO> hotCategories=new ArrayList<>();
    //文章列表
    PageResult<ArticleDO> articles;

    public List<ArticleTagDO> getCategories() {
        return categories;
    }

    public void setCategories(List<ArticleTagDO> categories) {
        this.categories = categories;
    }

    public List<ArticleTagDO> getHotCategories() {
        return hotCategories;
    }

    public void setHotCategories(List<ArticleTagDO> hotCategories) {
        this.hotCategories = hotCategories;
    }

    public PageResult<ArticleDO> getArticles() {
        return articles;
    }

    public void setArticles(PageResult<ArticleDO> articles) {
        this.articles = articles;
    }
}
