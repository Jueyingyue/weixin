package com.liyue.weixin.innerHomePage.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class HomePageDO {

    private List<MenuInfoDO> test = new ArrayList<>();
    private List<MenuInfoDO> categories = new ArrayList<>();
    private List<MenuInfoDO> plays = new ArrayList<>();

    public List<MenuInfoDO> getTest() {
        return test;
    }

    public void setTest(List<MenuInfoDO> test) {
        this.test = test;
    }

    public List<MenuInfoDO> getCategories() {
        return categories;
    }

    public void setCategories(List<MenuInfoDO> categories) {
        this.categories = categories;
    }

    public List<MenuInfoDO> getPlays() {
        return plays;
    }

    public void setPlays(List<MenuInfoDO> plays) {
        this.plays = plays;
    }
}
