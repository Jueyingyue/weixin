package com.liyue.weixin.userInfo.domain.service.impl;

import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import com.liyue.weixin.userInfo.domain.repo.UserInfoRepository;
import com.liyue.weixin.userInfo.domain.service.UserInfoDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoDomainServiceImpl implements UserInfoDomainService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDO selectByOpenid(String openid) {
        return userInfoRepository.selectByOpenid(openid);
    }

    @Override
    public int insert(UserInfoDO userInfo) {
        return userInfoRepository.insert(userInfo);
    }

    @Override
    public int updateById(UserInfoDO userInfo) {
        return userInfoRepository.updateById(userInfo);
    }

    @Override
    public UserInfoDO selectById(Long id) {
        return userInfoRepository.selectById(id);
    }

    @Override
    public List<UserInfoDO> selectAll() {
        return userInfoRepository.selectAll();
    }

    @Override
    public int deleteById(Integer id) {
        return userInfoRepository.deleteById(id);
    }
}
