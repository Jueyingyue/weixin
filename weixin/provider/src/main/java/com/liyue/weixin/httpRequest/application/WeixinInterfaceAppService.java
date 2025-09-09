package com.liyue.weixin.httpRequest.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyue.weixin.httpRequest.domain.entity.MessageResponse;
import com.liyue.weixin.httpRequest.domain.entity.WxLoginResponse;

public interface WeixinInterfaceAppService {

    WxLoginResponse getWxSession(String jsCode);

    MessageResponse getMessage(String content,int index) throws Exception;



}
