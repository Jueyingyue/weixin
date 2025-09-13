package com.liyue.weixin.online.userInfo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.liyue.weixin.article.domain.entity.ArticleDO;
import com.liyue.weixin.article.service.ArticleAppService;
import com.liyue.weixin.httpRequest.application.WeixinInterfaceAppService;
import com.liyue.weixin.httpRequest.domain.entity.WxLoginResponse;
import com.liyue.weixin.innerHomePage.application.service.HomePageAppService;
import com.liyue.weixin.innerHomePage.domain.entity.MenuInfoDO;
import com.liyue.weixin.innerHomePage.domain.entity.ResultConfigDO;
import com.liyue.weixin.innerHomePage.domain.repo.HomePageRepository;
import com.liyue.weixin.online.userInfo.dto.UserInfoReqDTO;
import com.liyue.weixin.online.userInfo.dto.UserInfoRspDTO;
import com.liyue.weixin.online.userInfo.service.UserInfoRpcAppService;
import com.liyue.weixin.testRecordDetail.application.service.TestRecordDetailAppService;
import com.liyue.weixin.testRecordDetail.domain.entity.TestRecordDetailDO;
import com.liyue.weixin.testRecordDetail.domain.vo.TestRecordPageVO;
import com.liyue.weixin.userInfo.application.service.UserInfoAppService;
import com.liyue.weixin.userInfo.domain.entity.UserInfoDO;
import com.liyue.weixin.utils.IPutils;
import com.liyue.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 用户信息 RPC 服务实现类
 */
@RestController
@RequestMapping("/user")
public class UserInfoRpcAppServiceImpl implements UserInfoRpcAppService {

    @Autowired
    private UserInfoAppService userInfoAppService;
    @Autowired
    private WeixinInterfaceAppService weixinInterfaceAppService;
    @Autowired
    private TestRecordDetailAppService testRecordDetailAppService;
    @Autowired
    private HomePageAppService homePageAppService;
    @Autowired
    private HomePageRepository homePageRepository;
    @Autowired
    private ArticleAppService articleAppService;

    @Override
    public UserInfoDO selectByOpenid(String openid) {
        return null;
    }

    @Override
    @PostMapping(value = "/login")
    public UserInfoRspDTO login(@RequestBody UserInfoReqDTO userInfoReqDTO) {
        String openid=userInfoReqDTO.getOpenid();
        UserInfoDO userInfoDO=userInfoAppService.selectByOpenid(openid);
        if(userInfoDO==null){
            WxLoginResponse wxLoginResponse=weixinInterfaceAppService.getWxSession(userInfoReqDTO.getLoginCode());
            openid=wxLoginResponse.getOpenid();
            userInfoDO=userInfoAppService.selectByOpenid(openid);
        }
        UserInfoRspDTO userInfoRspDTO=new UserInfoRspDTO();
        if(userInfoDO!=null){
            BeanUtil.copyProperties(userInfoReqDTO, userInfoDO, CopyOptions.create().setIgnoreNullValue(true));
            userInfoAppService.updateById(userInfoDO);
            BeanUtil.copyProperties(userInfoDO, userInfoRspDTO, CopyOptions.create().setIgnoreNullValue(true));
            UserInfoDO userInfo=userInfoAppService.selectByOpenid("o-sby0CIws-rIhBifwsw9jY7Ql9M");
            if((userInfo!=null&&"false".equals(userInfo.getProfession()))||"o-sby0CIws-rIhBifwsw9jY7Ql9M".equals(openid)){
                userInfoRspDTO.setProfession("false");
            }
            TestRecordDetailDO testRecordDetailDO=new TestRecordDetailDO();
            testRecordDetailDO.setBizTypeCode(userInfoDO.getBizTypeCode());
            testRecordDetailDO.setBizType(userInfoDO.getIndexType());
            testRecordDetailDO.setUserId(userInfoDO.getOpenid());
            List<TestRecordDetailDO> testRecordDetailDOList= testRecordDetailAppService.getDetailByOpenidAndBizTypeCode(testRecordDetailDO);
            if(!CollectionUtils.isEmpty(testRecordDetailDOList)){
                userInfoRspDTO.setTestRecordDetailDO(testRecordDetailDOList.get(0));
                ResultConfigDO resultConfigDO;
                boolean getFlag=false;
                for (TestRecordDetailDO testRecordDetailDO1:testRecordDetailDOList){
                     resultConfigDO= homePageAppService.testResult( testRecordDetailDO1.getBizTypeCode(),  testRecordDetailDO1.getBizType(),
                             testRecordDetailDO1.getScore(),testRecordDetailDO1.getUserId(),"");
                     if(resultConfigDO!=null&&!getFlag){
                         getFlag=true;
                         userInfoRspDTO.setPersonalityType(resultConfigDO.getResultType(),resultConfigDO.getResultDesc(),testRecordDetailDO1.getId());
                     }
                    List<MenuInfoDO> menuInfoDOList = homePageRepository.getHomePage();
                    userInfoRspDTO.setTestData(testRecordDetailDO1,menuInfoDOList,resultConfigDO);
                }
            }
            PageResult<ArticleDO> pageResult=articleAppService.selectByUserId(1,2,userInfoDO.getOpenid(),"");
            if(!CollectionUtils.isEmpty(pageResult.getRecords())){
                userInfoRspDTO.setArticleList(pageResult.getRecords());
            }
            PageResult<ArticleDO> pageResult1=articleAppService.selectByUserId(1,2,userInfoDO.getOpenid(),"likes");
            if(!CollectionUtils.isEmpty(pageResult1.getRecords())){
                userInfoRspDTO.setFavoriteData(pageResult1.getRecords());
            }
        }else{
            userInfoDO=new UserInfoDO();
            BeanUtil.copyProperties(userInfoReqDTO, userInfoDO, CopyOptions.create().setIgnoreNullValue(true));
            userInfoDO.setOpenid(openid);
            userInfoAppService.insert(userInfoDO);

            BeanUtil.copyProperties(userInfoDO, userInfoRspDTO, CopyOptions.create().setIgnoreNullValue(true));
        }

        return userInfoRspDTO;
    }

    @Override
    @PostMapping(value = "/upload-avatar")
    public String updateById(@RequestParam("avatarUrl") MultipartFile file,
                          @RequestParam("userId") String userId,@RequestParam("interfaceUrl") String interfaceUrl,@RequestParam("savePath") String savePath) {
        if(StringUtils.isEmpty(userId)){
             return new UserInfoDO().getAvatarUrl();
        }else{
            UserInfoDO userInfo=userInfoAppService.selectByOpenid(userId);
            // 5. 保存文件到服务器本地
            try {
                // 3. 创建上传目录（如果不存在）
                File uploadDir = new File(savePath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                Path uploadPath = Paths.get(savePath).toAbsolutePath();
                if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);

                Path filePath = uploadPath.resolve(userId);
                file.transferTo(filePath);
                interfaceUrl= interfaceUrl+"uploads/" + userId;
                userInfo.setAvatarUrl(interfaceUrl);
                userInfoAppService.updateById(userInfo);

               return  interfaceUrl;
            } catch (IOException e) {
                e.printStackTrace();

                return new UserInfoDO().getAvatarUrl();
            }
        }

    }

    @Override
    public UserInfoDO selectById(Long id) {
        return null;
    }

    @Override
    public List<UserInfoDO> selectAll() {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    @RequestMapping(value = "/queryTestRecordPage")
    public PageResult<TestRecordPageVO> queryTestRecordPage(String openid, Integer pageNum, Integer pageSize) {
        PageResult<TestRecordPageVO> pageVOPageResult= testRecordDetailAppService.queryTestRecordPage(openid,pageNum,pageSize);

        return pageVOPageResult;
    }

    @RequestMapping(value = "/queryarticles")
    public PageResult<TestRecordPageVO> queryarticles(Long tagId ,String content, Integer pageNum, Integer pageSize) {
        PageResult<TestRecordPageVO> pageVOPageResult= testRecordDetailAppService.queryTestRecordPage(content,pageNum,pageSize);

        return pageVOPageResult;
    }
}
