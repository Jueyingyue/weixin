package com.liyue.weixin.online.userInfo.service;


import com.liyue.weixin.online.userInfo.dto.UserInfoReqDTO;
import com.liyue.weixin.online.userInfo.dto.UserInfoRspDTO;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import com.liyue.weixin.utils.PageResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户信息 RPC 服务接口
 */
public interface UserInfoRpcAppService {

    /**
     * 根据 openid 查询用户信息
     */
    UserInfoDO selectByOpenid(String openid);

    /**
     * 插入用户信息
     */
    UserInfoRspDTO login(UserInfoReqDTO userInfoReqDTO);

    String updateById(@RequestParam("avatar") MultipartFile file,
                          @RequestParam("userId") String userId,@RequestParam("interfaceUrl") String interfaceUrl,@RequestParam("savePath") String savePath);

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

    /**
     * 分页查询用户的测试记录及关联的测试结果
     */
    PageResult<TestRecordPageVO> queryTestRecordPage(String openid, Integer pageNum,
                                                     Integer pageSize);
}
