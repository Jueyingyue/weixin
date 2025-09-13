package com.liyue.weixin.userInfo.domain.entity;

import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息表持久化对象（对应 user_profile 表）
 */
public class UserInfoDO implements Serializable {
    private Long id;
    private String openid;         // 微信小程序用户唯一标识
    private String unionid="80";        // 微信开放平台unionid
    private String nickName;       // 用户昵称
    private String avatarUrl;      // 用户头像URL
    private Integer gender;        // 性别：0-未知，1-男，2-女
    private String country;        // 国家
    private String province;       // 省份
    private String city;           // 城市
    private String language;       // 语言
    private LocalDateTime lastLoginTime;   // 最后登录时间
    private String profession;     // 职业
    private String bizTypeCode="MBTI";    // 业务类型代码
    private String indexType="3";      // 1-第一板块 2-第二版块 3-第三版块
    private String detailId;       // 详细报告ID
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 此处应包含所有字段的 getter 和 setter（省略，实际开发需补全）


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if(StringUtil.isEmpty(nickName)){
            return "微信用户".concat(String.valueOf(id));
        }
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        if(StringUtils.isBlank(avatarUrl)){
            return "http://www.ceshixinli.xin:8081/uploads/FK.png";
        }
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
