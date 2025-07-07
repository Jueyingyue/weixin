package com.weixin.provider.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestAppService {
    @RequestMapping("getName")
    public String getName() {
        return "SpringCloud!";
    }
}
