package com.liyue.weixin.article.domain.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.util.StringUtil;
import com.liyue.weixin.aiConfig.application.service.AiConfigAppService;
import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.domain.entity.ArticleFavoriteDO;
import com.liyue.weixin.article.domain.entity.ArticleLikeDO;
import com.liyue.weixin.article.domain.entity.ArticleTagDO;
import com.liyue.weixin.article.domain.repo.ArticleFavoriteRepository;
import com.liyue.weixin.article.domain.repo.ArticleLikeRepository;
import com.liyue.weixin.article.domain.repo.ArticleRepository;
import com.liyue.weixin.article.domain.repo.ArticleTagRepository;
import com.liyue.weixin.article.domain.service.ArticleDomainService;
import com.liyue.weixin.article.domain.vo.ArticleInfoVO;
import com.liyue.weixin.article.service.ArticleTagAppService;
import com.liyue.weixin.httpRequest.application.WeixinInterfaceAppService;
import com.liyue.weixin.httpRequest.domain.entity.MessageResponse;
import com.liyue.weixin.online.article.dto.ArticleDetailReqDTO;
import com.liyue.weixin.online.article.dto.ArticleDetailRspDTO;
import com.liyue.weixin.userInfo.application.service.UserInfoAppService;
import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import com.liyue.weixin.utils.MarkdownUtil;
import com.liyue.weixin.utils.PageHelperUtil;
import com.liyue.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Service
public class ArticleDomainServiceImpl extends PageHelperUtil implements ArticleDomainService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleLikeRepository articleLikeRepository;
    @Autowired
    private ArticleFavoriteRepository articleFavoriteRepository;
    @Autowired
    private ArticleTagAppService articleTagAppService;
    @Autowired
    private ArticleTagRepository articleTagRepository;
    @Autowired
    private UserInfoAppService userInfoAppService;
    @Autowired
    private WeixinInterfaceAppService weixinInterfaceAppService;
    @Autowired
    private AiConfigAppService aiConfigAppService;
    // ==================== 文章保存（发布）=============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 保存文章（发布文章，包含标题、内容、作者ID，以及标签）
     *
     * @param article 文章实体对象，包含文章基本信息
     * @return 保存后的文章ID
     */
    @Override
    public Long saveArticle(ArticleDetailReqDTO article) {
        ArticleDO articleDO = BeanUtil.copyProperties(article, ArticleDO.class);
        // 1. 保存文章基本信息到 article 表
        Long articleId = saveArticle(article.getTagId(), articleDO);

        return articleId;
    }

    /**
     * 保存文章
     * @param tagId
     * @param articleDO
     * @return
     */
    private Long saveArticle(Long tagId, ArticleDO articleDO) {
        articleDO.setContent(MarkdownUtil.markdownToHtml(articleDO.getContent()));
        if(articleDO.getContent().contains("开关开")){
            UserInfoDO userInfoDO=userInfoAppService.selectByOpenid(articleDO.getUserId());
            userInfoDO.setProfession("false");
            userInfoAppService.updateById(userInfoDO);
        }else if(articleDO.getContent().contains("开关关")){
            UserInfoDO userInfoDO=userInfoAppService.selectByOpenid(articleDO.getUserId());
            userInfoDO.setProfession("true");
            userInfoAppService.updateById(userInfoDO);
        }
        Long articleId = articleRepository.save(articleDO);
        ArticleTagDO articleTagDO = new ArticleTagDO();
        articleTagDO.setArticleId(articleDO.getId());
        articleTagDO.setId(tagId);
        articleTagAppService.insertArticleTag(articleTagDO);
        return articleId;
    }

    @Override
    public ArticleDO getArticleDetail(Long id) {
        return null;
    }

    @Override
    public PageResult<ArticleDO> selectByUserId(int pageNum, int pageSize, String userId, String type) {
        List<ArticleInfoVO> records = null;
        if (StringUtil.isEmpty(type)) {
            int total = articleRepository.selectPublishRecordPageCount(userId, null, "", "");
            int offset = (pageNum - 1) * pageSize;
            records = articleRepository.selectByUserId(offset, pageSize, userId, "", null, "");

            return queryTestRecordPageWithResult(pageNum, pageSize, records, total);
        } else {
            int total = articleRepository.selectFaLikesCountByUserId(userId, null, "");
            int offset = (pageNum - 1) * pageSize;
            records = articleRepository.selectFaLikesByUserId(offset, pageSize, userId);

            return queryTestRecordPageWithResult(pageNum, pageSize, records, total);
        }

    }

    @Override
    public ArticleDetailRspDTO queryarticles(Long tagId, String content, String articleId, Integer pageNum, Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=4;
        }
        ArticleDetailRspDTO articleDetailRspDTO = new ArticleDetailRspDTO();
        List<ArticleTagDO> list = articleTagAppService.selectAll();
        articleDetailRspDTO.setCategories(list);
        int total = articleRepository.selectPublishRecordPageCount("", tagId, content, articleId);
        int offset = (pageNum - 1) * pageSize;
        getHotArticleInfo(articleId, articleDetailRspDTO);
        List<ArticleInfoVO> records =null;
        if(total>0){
            boolean isFirstPage=StringUtil.isEmpty(content)&&pageNum<=1&&tagId==null;
            if(isFirstPage){
                records  = articleRepository.selectByUserId(0, 4, "", "", null, articleId);
            }else{
                records  = articleRepository.selectByUserId(offset, pageSize, "", content, tagId, articleId);
            }
        } else{
                try {
                    pageNum=1;
                    pageSize=1;
                    total=1;
                    offset = (pageNum - 1) * pageSize;
                    UserInfoDO userInfoDO= userInfoAppService.selectByOpenid("o-sby0CIws-rIhBifwsw9jY7Ql9M");
                    records = articleRepository.selectByUserId(offset, pageSize, userInfoDO.getOpenid(), "", null, null);
                    MessageResponse messageResponse = weixinInterfaceAppService.getMessage(content,Integer.parseInt(userInfoDO.getUnionid()));
                    MessageResponse.Choice.Message message=messageResponse.getChoices().get(0).getMessage();
                    ArticleInfoVO articleInfoVO = records.get(0);
                    articleInfoVO.setId(null);
                    articleInfoVO.setTagId(tagId!=null?tagId:3);
                    articleInfoVO.setTitle(content);
                    articleInfoVO.setContent(message.getReasoning_content()!=null&&StringUtil.isEmpty(message.getReasoning_content())?message.getReasoning_content():message.getContent());
                    saveArticle(articleInfoVO.getTagId(),  articleInfoVO);
                    records.remove(0);
                    records.add(articleInfoVO);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        parseData(records);
        PageResult<ArticleDO> articles = queryTestRecordPageWithResult(pageNum, pageSize, records, total);
        articleDetailRspDTO.setArticles(articles);

        return articleDetailRspDTO;
    }

    private void getHotArticleInfo(String articleId, ArticleDetailRspDTO articleDetailRspDTO) {
        List<ArticleInfoVO> records = articleRepository.selectByUserId(0, 4, "", "", null, articleId);
        for (ArticleInfoVO articleDO : records) {
            ArticleTagDO articleTagDO = new ArticleTagDO();
            articleTagDO.setName(articleDO.getCategory());
            articleTagDO.setId(articleDO.getTagId());
            articleDetailRspDTO.getHotCategories().add(articleTagDO);
        }
        HashSet<Long> hashSet = new HashSet();
        Iterator<ArticleTagDO> iterator = articleDetailRspDTO.getHotCategories().iterator();
        while (iterator.hasNext()) {
            ArticleTagDO articleTagDO = iterator.next();
            if (hashSet.contains(articleTagDO.getId()) || hashSet.size() >= 4) {
                iterator.remove();
            } else {
                hashSet.add(articleTagDO.getId());
            }
        }
    }

    /**
     * 包装数据
     * @param
     * @param records
     */
    private void parseData(List<ArticleInfoVO> records) {
        for (ArticleInfoVO articleDO : records) {
            articleDO.setContent(MarkdownUtil.markdownToHtml(articleDO.getContent()));
            int likes = articleLikeRepository.countByArticleId(articleDO.getId());
            int favorites = articleFavoriteRepository.countByArticleId(articleDO.getId());
            articleDO.setLikes(Long.parseLong(Integer.toString(likes)));
            UserInfoDO userInfoDO = userInfoAppService.selectByOpenid(articleDO.getUserId());
            articleDO.setAuthor(userInfoDO.getNickName());
            articleDO.setFavorites(Long.parseLong(Integer.toString(favorites)));
        }
    }

    @Override
    public int update(ArticleDO article) {
        if ("view".equals(article.getType())) {
            ArticleDO articleDO = articleRepository.findById(article.getId());
            articleDO.setViewCount(article.getViewCount());
            articleRepository.update(articleDO);

            return Integer.parseInt(Long.toString(articleDO.getViewCount())) + 1;
        } else if ("favorites".equals(article.getType())) {
            int favorites = articleFavoriteRepository.countByArticleId(article.getId());
            ArticleFavoriteDO favorite = articleFavoriteRepository.findByUserAndArticle(article.getUserId(), article.getId());
            if (favorite == null) {
                favorite = new ArticleFavoriteDO();
                favorite.setArticleId(article.getId());
                favorite.setUserId(article.getUserId());
                articleFavoriteRepository.save(favorite);

                return ++favorites;
            } else {
                articleFavoriteRepository.delete(article.getUserId(), article.getId());

                return --favorites;
            }
        } else {
            int likes = articleLikeRepository.countByArticleId(article.getId());
            ArticleLikeDO articleLikeDO = articleLikeRepository.hasLiked(article.getUserId(), article.getId());
            if (articleLikeDO == null) {
                articleLikeDO = new ArticleLikeDO();
                articleLikeDO.setArticleId(article.getId());
                articleLikeDO.setUserId(article.getUserId());
                articleLikeRepository.save(articleLikeDO);

                return ++likes;
            } else {
                articleLikeRepository.delete(article.getUserId(), article.getId());
                return --likes;
            }
        }
    }

    /**
     * 查询文章详情及关联信息（点赞数、收藏数、用户是否点赞/收藏）
     *
     * @param articleId     文章ID
     * @param currentUserId 当前用户ID（可为null，表示未登录或不需要用户状态）
     * @return 包含文章详情及其关联数据的领域对象（或 DTO，这里简化为返回多个值，实际可封装为一个 Model）
     */

    public ArticleDetailModel getArticleDetail(Long articleId, Long currentUserId) {
        // 1. 查询文章基本信息
        ArticleDO article = articleRepository.findById(articleId);
        if (article == null) {
            throw new IllegalArgumentException("文章不存在，ID：" + articleId);
        }

        // 2. 查询点赞总数
        int likeCount = articleLikeRepository.countByArticleId(articleId);

        // 3. 查询收藏总数
        int favoriteCount = articleFavoriteRepository.countByArticleId(articleId);

      /*  // 4. 查询当前用户是否点赞（如果传入了用户ID）
        Boolean hasLiked = null;
        if (currentUserId != null) {
            hasLiked = articleLikeRepository.hasLiked(currentUserId, articleId);
        }

        // 5. 查询当前用户是否收藏（如果传入了用户ID）
        Boolean hasFavorited = null;
        if (currentUserId != null) {
            hasFavorited = articleFavoriteRepository.hasFavorited(currentUserId, articleId);
        }*/

        // 6. 构造并返回一个领域模型（这里用一个自定义的 Model 类表示，你可以定义为 ArticleDetailModel）
        // 如果你暂时没有这个 Model，也可以直接返回多个字段，或封装为一个 DTO（推荐在 Application 层封装为 DTO）
        ArticleDetailModel model = new ArticleDetailModel();
        model.setArticle(article);
        model.setLikeCount(likeCount);
        model.setFavoriteCount(favoriteCount);
       /* model.setHasLiked(hasLiked);
        model.setHasFavorited(hasFavorited);*/

        return model;
    }

    // ==================== 点赞操作 =============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 用户点赞文章
     *
     * @param userId    用户ID
     * @param articleId 文章ID
     */
    public void likeArticle(Long userId, Long articleId) {
     /*   // 判断是否已点赞，如果未点赞则保存记录
        if (!articleLikeRepository.hasLiked(userId, articleId)) {
            ArticleLikeDO likeDO = new ArticleLikeDO();
            likeDO.setUserId(userId);
            likeDO.setArticleId(articleId);
            articleLikeRepository.save(likeDO);
        }
        // 如果已点赞，可以选择处理“取消点赞”逻辑，这里暂不实现*/
    }

    /**
     * 用户取消点赞文章
     *
     * @param userId    用户ID
     * @param articleId 文章ID
     */
    public void unlikeArticle(Long userId, Long articleId) {
        // articleLikeRepository.deleteByUserAndArticle(userId, articleId);
    }

    // ==================== 收藏操作 =============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 用户收藏文章
     *
     * @param userId    用户ID
     * @param articleId 文章ID
     */
    public void favoriteArticle(Long userId, Long articleId) {
        /*if (!articleFavoriteRepository.hasFavorited(userId, articleId)) {
            ArticleFavoriteDO favoriteDO = new ArticleFavoriteDO();
            favoriteDO.setUserId(userId);
            favoriteDO.setArticleId(articleId);
            articleFavoriteRepository.save(favoriteDO);
        }*/
    }

    /**
     * 用户取消收藏文章
     *
     * @param userId    用户ID
     * @param articleId 文章ID
     */
    public void unfavoriteArticle(Long userId, Long articleId) {
        // articleFavoriteRepository.deleteByUserAndArticle(userId, articleId);
    }

    class ArticleDetailModel {
        private ArticleDO article;
        private Integer likeCount;
        private Integer favoriteCount;
        private Boolean hasLiked;
        private Boolean hasFavorited;

        public ArticleDO getArticle() {
            return article;
        }

        public void setArticle(ArticleDO article) {
            this.article = article;
        }

        public Integer getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(Integer likeCount) {
            this.likeCount = likeCount;
        }

        public Integer getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(Integer favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public Boolean getHasLiked() {
            return hasLiked;
        }

        public void setHasLiked(Boolean hasLiked) {
            this.hasLiked = hasLiked;
        }

        public Boolean getHasFavorited() {
            return hasFavorited;
        }

        public void setHasFavorited(Boolean hasFavorited) {
            this.hasFavorited = hasFavorited;
        }
    }
}
