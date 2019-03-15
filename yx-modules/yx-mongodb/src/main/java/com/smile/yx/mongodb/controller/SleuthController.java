package com.smile.yx.mongodb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

/**
 * @description: 测试
 * @author: qing.wang.o
 * @create: 2019-03-08 16:26
 **/
@RestController
@Slf4j
public class SleuthController {


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/trace-1")
    public String trace1() {
        log.info("trace-1");
        return restTemplate.getForEntity("http://yx-stream/trace-2", String.class).getBody();
    }


}
