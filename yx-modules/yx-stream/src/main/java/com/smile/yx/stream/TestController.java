package com.smile.yx.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-03-07 16:38
 **/
@RestController
@Slf4j
public class TestController {


    @Autowired
    private ExampleBinder exampleBinder;

    @GetMapping("/test")
    public String test() {
        exampleBinder.output().send(MessageBuilder.withPayload("测试一下").build());
        return "ok";
    }

    @RequestMapping("/trace-2")
    public String trace2() {
        log.info("trace-2");
        return "ok";
    }

}
