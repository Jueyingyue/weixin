package com.liyue.weixin.httpRequest.domain.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liyue.weixin.aiConfig.application.service.AiConfigAppService;
import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import com.liyue.weixin.httpRequest.domain.WeixinInterfaceDomainService;
import com.liyue.weixin.httpRequest.domain.entity.MessageResponse;
import com.liyue.weixin.httpRequest.domain.entity.WxLoginResponse;
import com.liyue.weixin.httpRequest.utils.Constants;
import com.liyue.weixin.httpRequest.utils.HttpUtil;
import com.liyue.weixin.httpRequest.utils.WxApiUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeixinInterfaceDomainServiceImpl implements WeixinInterfaceDomainService {
    @Autowired
    private AiConfigAppService aiConfigAppService;

    @Override
    public WxLoginResponse getWxSession(String jsCode) {
        Map<String, String> headers = new HashMap<>();
        headers.put("appid", Constants.APP_ID);
        headers.put("secret", Constants.SECRET);
        headers.put("grant_type", "authorization_code");
        headers.put("js_code", jsCode);
        // 2. 发送 GET 请求
        String jsonResponse = "";
        try {
            jsonResponse = HttpUtil.doGet(WxApiUrls.JS_CODE_2_SESSION + "?appid=" + Constants.APP_ID + "&secret=" + Constants.SECRET + "&js_code=" +
                    jsCode + "&grant_type=authorization_code", null);
        } catch (Exception e) {
            // 请求失败
            WxLoginResponse errorResponse = new WxLoginResponse();
            errorResponse.setErrcode(-1);
            errorResponse.setErrmsg("网络请求失败: " + e.getMessage());
            return errorResponse;
        }

        WxLoginResponse response = JSONObject.parseObject(jsonResponse, WxLoginResponse.class);
        // 4. 判断是否成功（errcode == 0 表示成功）
        if (response.isSuccess()) {
            return response;
        } else {
            // 返回微信接口返回的错误信息
            return response;
        }
    }

    @Override
    public MessageResponse getMessage(String content, int index) throws Exception {
        AiConfigDO aiConfigDO = aiConfigAppService.getById(index);
        ObjectMapper objectMapper = new ObjectMapper();
        // 将 JSON 字符串转为 Map<String, Object>
        Map<String, String> headers = objectMapper.readValue(aiConfigDO.getAiHeadersJson(), Map.class);
        headers.put("Authorization", "Bearer " + aiConfigDO.getAiToken());

        Map<String, Object> jsonBody = objectMapper.readValue(aiConfigDO.getAiJsonBodyJson(), Map.class);
        jsonBody.put("model",aiConfigDO.getAiModel());
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) jsonBody.get("messages");
        mapList.get(0).put("content", content);
        // 2. 发送 GET 请求
        String jsonResponse = "";
        try {
            jsonResponse = HttpUtil.doPostJson(aiConfigDO.getAiUrl(), JSONObject.toJSONString(jsonBody), headers);
        } catch (Exception e) {
            List<AiConfigDO> configDOList=aiConfigAppService.listAll();
            for (AiConfigDO aiConfigDO1 :configDOList) {
                if(aiConfigDO1.getId()==87){
                   break;
                }
                if(aiConfigDO1!=null){
                    return getMessage( content, aiConfigDO1.getId());
                }
            }
            // 请求失败
            MessageResponse errorResponse = new MessageResponse();
            errorResponse.setErrcode(-1);
            errorResponse.setErrmsg("网络请求失败: " + e.getMessage());
            return errorResponse;
        }

        MessageResponse response = JSONObject.parseObject(jsonResponse, MessageResponse.class);
        // 4. 判断是否成功（errcode == 0 表示成功）
        if (response.isSuccess()) {
            return response;
        } else {
            // 返回微信接口返回的错误信息
            return response;
        }

    }

}
