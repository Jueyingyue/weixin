package com.liyue.weixin.article.infra.persistent.mapper;

import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleTagMapper {

    void insert(ArticleTagDO articleTagDO);

    void deleteById(@Param("id") Long id);

    void update(ArticleTagDO articleTagDO);

    ArticleTagDO selectById(@Param("id") Long id);

    List<ArticleTagDO> selectAll();

    ArticleTagDO selectByName(@Param("name") String name);

    int insertArticleTag(ArticleTagDO articleTagDO);

    List<ArticleTagDO> findByArticleId(Long articleId);
}
