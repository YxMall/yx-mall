package com.smile.yx.demo2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.smile.yx.demo2.feign.Demo1Client;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-02-19 13:51
 **/
@RestController
@AllArgsConstructor
public class Demo2Controller {

    private final Demo1Client demo1Client;

    @RequestMapping("hello")
    public String hello() {
        return "hello my is demo2";
    }


    @RequestMapping("demo1Hello")
    @HystrixCommand(fallbackMethod = "fallback")
    public String demo1Hello() {
        String s = demo1Client.demo1Hello();
        return s;
    }

    public String fallback() {
        return "方法被降级处理";
    }
}
