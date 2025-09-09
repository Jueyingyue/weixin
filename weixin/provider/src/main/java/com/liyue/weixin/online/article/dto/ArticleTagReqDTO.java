package com.liyue.weixin.online.article.dto;

import java.util.ArrayList;
import java.util.List;

public class ArticleTagReqDTO {
    private Long id;
    private String name;
    private List<String> allTags=new ArrayList<>();
    private List<Long> tagIndex=new ArrayList<>();

    public List<Long> getTagIndex() {
        return tagIndex;
    }

    public void setTagIndex(List<Long> tagIndex) {
        this.tagIndex = tagIndex;
    }

    public List<String> getAllTags() {
        return allTags;
    }

    public void setAllTags(List<String> allTags) {
        this.allTags = allTags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
