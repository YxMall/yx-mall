package com.smile.yx.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-03-05 14:48
 **/
@RestController
@RefreshScope
public class TestController {

    @Value("${test.msg}")
    private String msg;

    @Autowired
    private Environment environment;

    @GetMapping("testYml")
    public String testYml() {
        return msg;
    }

    @GetMapping("testEnvironment")
    public String testEnvironment() {
        return environment.getProperty("test.msg");
    }
}
