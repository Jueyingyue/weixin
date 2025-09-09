package com.liyue.weixin.httpRequest.application.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyue.weixin.httpRequest.application.WeixinInterfaceAppService;
import com.liyue.weixin.httpRequest.domain.WeixinInterfaceDomainService;
import com.liyue.weixin.httpRequest.domain.entity.MessageResponse;
import com.liyue.weixin.httpRequest.domain.entity.WxLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeixinInterfaceAppServiceImpl implements WeixinInterfaceAppService {

    @Autowired
    private WeixinInterfaceDomainService weixinInterfaceDomainService;


    @Override
    public WxLoginResponse getWxSession( String jsCode) {
        return weixinInterfaceDomainService.getWxSession(jsCode);
    }

    @Override
    public MessageResponse getMessage(String content,int index) throws Exception {
        return weixinInterfaceDomainService.getMessage(content,index);
    }
}
