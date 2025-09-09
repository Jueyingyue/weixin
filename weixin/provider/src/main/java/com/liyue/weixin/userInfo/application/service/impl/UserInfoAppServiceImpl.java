package com.liyue.weixin.userInfo.application.service.impl;

import com.liyue.weixin.userInfo.application.service.UserInfoAppService;
import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import com.liyue.weixin.userInfo.domain.service.UserInfoDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoAppServiceImpl implements UserInfoAppService {

    @Autowired
    private UserInfoDomainService userInfoDomainService;

    @Override
    public UserInfoDO selectByOpenid(String openid) {
        return userInfoDomainService.selectByOpenid(openid);
    }

    @Override
    public int insert(UserInfoDO userInfo) {
        return userInfoDomainService.insert(userInfo);
    }

    @Override
    public int updateById(UserInfoDO userInfo) {
        return userInfoDomainService.updateById(userInfo);
    }

    @Override
    public UserInfoDO selectById(Long id) {
        return userInfoDomainService.selectById(id);
    }

    @Override
    public List<UserInfoDO> selectAll() {
        return userInfoDomainService.selectAll();
    }

    @Override
    public int deleteById(Integer id) {
        return userInfoDomainService.deleteById(id);
    }
}
