package com.liyue.weixin.userInfo.infra.persistent.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户信息表 Mapper 接口
 */
@Component
public interface UserInfoMapper extends BaseMapper {

    /**
     * 根据 openid 查询用户信息
     */
    UserInfoDO selectByOpenid(String openid);

    /**
     * 插入用户信息
     */
    int insert(UserInfoDO userInfo);

    /**
     * 更新用户信息
     */
    int updateById(UserInfoDO userInfo);

    /**
     * 根据 id 查询用户信息
     */
    UserInfoDO selectById(Long id);

    /**
     * 查询所有用户（一般用于管理端，慎用）
     */
    List<UserInfoDO> selectAll();

    /**
     * 根据 id 删除用户（软删可加字段 is_deleted）
     */
    int deleteById(Integer id);
}
