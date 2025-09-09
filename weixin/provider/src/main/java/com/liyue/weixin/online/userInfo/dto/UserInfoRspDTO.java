package com.liyue.weixin.online.userInfo.dto;

import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.innerHomePage.domain.entity.MenuInfoDO;
import com.liyue.weixin.innerHomePage.domain.entity.ResultConfigDO;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserInfoRspDTO {
    private String openid;                 // 微信小程序用户唯一标识
    private String unionid;                // 微信开放平台unionid
    private String nickName;               // 用户昵称
    private String avatarUrl;              // 用户头像URL
    private Integer gender;                // 性别：0-未知，1-男，2-女
    private String country;                // 国家
    private String province;               // 省份
    private String city;                   // 城市
    private String language;               // 语言
    private LocalDateTime lastLoginTime;   // 最后登录时间
    private String profession;                // 职业
    private String bizTypeCode;                // 业务类型代码
    private String indexType;              // 1-第一板块 2-第二版块 3-第三版块
    private String detailId;             // 详细报告ID
    private String loginCode;
    private PersonalityType personalityType=new PersonalityType();
    private List<TestData> testData=new ArrayList<>();
    private TestRecordDetailDO testRecordDetailDO=new TestRecordDetailDO();
    private List<Article> articleList=new ArrayList<>();
    private List<Article> favoriteData=new ArrayList<>();

    public List<Article> getFavoriteData() {
        return favoriteData;
    }

    public void setFavoriteData(List<ArticleDO> articleDOList) {
        for (ArticleDO articleDO:articleDOList){
            UserInfoRspDTO.Article article=new UserInfoRspDTO.Article();
            favoriteData.add(article);
            article.setDate(articleDO.getCreatedAt().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            article.setId(articleDO.getId());
            article.setTitle(articleDO.getTitle());
            article.setViews(articleDO.getViewCount());
        }
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleDO> articleDOList) {
        for (ArticleDO articleDO:articleDOList){
            UserInfoRspDTO.Article article=new UserInfoRspDTO.Article();
            articleList.add(article);
            article.setDate(articleDO.getCreatedAt().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            article.setId(articleDO.getId());
            article.setTitle(articleDO.getTitle());
            article.setViews(articleDO.getViewCount());
        }
    }



    public TestRecordDetailDO getTestRecordDetailDO() {
        return testRecordDetailDO;
    }

    public void setTestRecordDetailDO(TestRecordDetailDO testRecordDetailDO) {
        this.testRecordDetailDO = testRecordDetailDO;
    }

    class Article{
        private Long id;
        private String date;
        private String title;
        private Long views;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getViews() {
            return views;
        }

        public void setViews(Long views) {
            this.views = views;
        }
    }

    class PersonalityType {
        private Long id;
        private String  type;//'INFJ'
        private String  title;//'提倡者型人格',
        private String  description;//'富有创造力且洞察力强的人格类型',

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    class TestData {
        private long id;
        private String title;
        private String date;
        private String score;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getBizTypeCode() {
        return bizTypeCode;
    }

    public void setBizTypeCode(String bizTypeCode) {
        this.bizTypeCode = bizTypeCode;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public PersonalityType getPersonalityType() {
        return personalityType;
    }

    public void setPersonalityType(String resultType,String resultDesc,Long id) {
        String title="" ;
        if(resultDesc.indexOf("（")>0&&resultDesc.indexOf("属于")>0){
             title=resultDesc.substring(resultDesc.indexOf("属于")+2,resultDesc.indexOf("（"));
        }
        personalityType.setTitle(title);
        personalityType.setType(resultType);
        personalityType.setDescription(resultDesc);
        personalityType.setId(id);
    }

    public List<TestData> getTestData() {
        return testData;
    }

    public void setTestData(TestRecordDetailDO testRecordDetailDO, List<MenuInfoDO> menuInfoDOList, ResultConfigDO resultConfigDO) {
            UserInfoRspDTO.TestData testData1=new UserInfoRspDTO.TestData();
            testData.add(testData1);
            testData1.setDate(testRecordDetailDO.getCreatedAt().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            if(resultConfigDO!=null){
                testData1.setScore(resultConfigDO.getResultDesc());
            }
            testData1.setId(testRecordDetailDO.getId());
            for (MenuInfoDO menuInfoDO:menuInfoDOList){
                if(menuInfoDO.getBizTypeCode().equals(testRecordDetailDO.getBizTypeCode())&&menuInfoDO.getBizType().equals(testRecordDetailDO.getBizType())){
                    testData1.setTitle(menuInfoDO.getBizTypeCnDesc());
                    break;
                }
            }
        }
}
