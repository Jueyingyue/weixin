package com.weixin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @version 1.0.0
 * @Date: 2023/4/26 20:27
 * @Copyright (C) liyue10
 * @Description: Eureka 注册中心服务端启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterApp {
    public static void main(String[] args) {
        SpringApplication.run(RegisterApp.class, args);
    }
}