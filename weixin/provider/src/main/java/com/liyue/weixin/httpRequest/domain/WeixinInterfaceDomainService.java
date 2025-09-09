package com.liyue.weixin.httpRequest.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyue.weixin.httpRequest.domain.entity.MessageResponse;
import com.liyue.weixin.httpRequest.domain.entity.WxLoginResponse;

public interface WeixinInterfaceDomainService {
    WxLoginResponse getWxSession(String jsCode);

    MessageResponse getMessage(String content,int index) throws Exception;

}
