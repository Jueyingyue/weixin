package com.weixin.consumer.application;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class SearchService {

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer")
    @ResponseBody
    public String customer() {
        //1. 通过eurekaClient获取到SEARCH服务的信息
        InstanceInfo info = eurekaClient.getNextServerFromEureka("service-provider", false);
        //2. 获取到访问的地址
        String url =info.getHomePageUrl();
        System.out.println("服务提供者访问地址"+url);

        //3. 通过restTemplate访问
        String result = restTemplate.getForObject(url+"test/getName", String.class);

        //4. 返回
        return result;
    }

}
