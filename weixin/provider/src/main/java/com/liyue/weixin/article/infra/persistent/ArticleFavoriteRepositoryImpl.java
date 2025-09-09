package com.liyue.weixin.article.infra.persistent;

import com.liyue.weixin.article.domain.entity.ArticleFavoriteDO;
import com.liyue.weixin.article.domain.repo.ArticleFavoriteRepository;
import com.liyue.weixin.article.infra.persistent.mapper.ArticleFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFavoriteRepositoryImpl implements ArticleFavoriteRepository {

    @Autowired
    private ArticleFavoriteMapper articleFavoriteMapper;

    /**
     * 保存收藏记录
     * @param favorite 收藏DO对象
     * @return 收藏记录ID
     */
    @Override
    public Long save(ArticleFavoriteDO favorite) {
        articleFavoriteMapper.insert(favorite);
        // 假设插入成功并返回自增ID，实际应根据你的数据库主键生成策略调整
        // 这里简单返回 null 或者可以修改 Mapper 返回自增ID
        // ⚠️ 注意：如果你的 Mapper insert 方法不返回 ID，你需要调整此处的逻辑
        return favorite.getId(); // 或者从数据库获取，比如使用 selectKey
    }

    /**
     * 删除收藏记录（根据用户ID和文章ID）
     * @param userId 用户ID
     * @param articleId 文章ID
     */
    @Override
    public void delete(String userId, Long articleId) {
        articleFavoriteMapper.deleteByUserAndArticle(userId, articleId);
    }

    /**
     * 统计某篇文章的收藏总数
     * @param articleId 文章ID
     * @return 收藏数量
     */
    @Override
    public int countByArticleId(Long articleId) {
        return articleFavoriteMapper.countByArticleId(articleId);
    }

    /**
     * 查询某用户是否收藏了某篇文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 收藏DO对象，如果不存在则返回 null
     */
    @Override
    public ArticleFavoriteDO findByUserAndArticle(String userId, Long articleId) {
        return articleFavoriteMapper.selectByUserAndArticle(userId, articleId);
    }
}
