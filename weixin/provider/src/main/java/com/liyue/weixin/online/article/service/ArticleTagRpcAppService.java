package com.liyue.weixin.online.article.service;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import com.liyue.weixin.online.article.dto.ArticleTagReqDTO;

public interface ArticleTagRpcAppService {
    void create(ArticleTagDO articleTagDO);
    void delete(Long id);
    ArticleTagDO getById(Long id);
    ArticleTagDO getByName(String name);
    ArticleTagReqDTO selectAll();
}
