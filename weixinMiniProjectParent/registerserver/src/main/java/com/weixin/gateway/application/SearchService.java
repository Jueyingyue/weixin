package com.weixin.gateway.application;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class SearchService {

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/gateway")
    public String customer() {
        //1. 通过eurekaClient获取到SEARCH服务的信息
        InstanceInfo info = eurekaClient.getNextServerFromEureka("service-provider", false);
        //2. 获取到访问的地址
        String url = info.getHomePageUrl();
        System.out.println(url);

        //3. 通过restTemplate访问
        String result = restTemplate.getForObject(url + "/test", String.class);

        //4. 返回
        return result;
    }

}
