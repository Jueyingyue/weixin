package com.liyue.weixin.userInfo.infra.persistent;

import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import com.liyue.weixin.userInfo.domain.repo.UserInfoRepository;
import com.liyue.weixin.userInfo.infra.persistent.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoDO selectByOpenid(String openid) {
        return userInfoMapper.selectByOpenid(openid);
    }

    @Override
    public int insert(UserInfoDO userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int updateById(UserInfoDO userInfo) {
        return userInfoMapper.updateById(userInfo);
    }

    @Override
    public UserInfoDO selectById(Long id) {
        return userInfoMapper.selectById(id);
    }

    @Override
    public List<UserInfoDO> selectAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public int deleteById(Integer id) {
        return userInfoMapper.deleteById(id);
    }
}
