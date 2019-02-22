package com.smile.yx.demo1;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-02-19 13:51
 **/
@RestController
@AllArgsConstructor
public class Demo1Controller {
    private final RestTemplate restTemplate;


    @RequestMapping("hello")
    public String hello() throws InterruptedException {
        Thread.sleep(5000L);
        return "hello my is demo1";
    }

    @RequestMapping("demo2")
    public String demo2() {
        return restTemplate.getForEntity("http://YX-DEMO2/hello", String.class).getBody();
    }

}
