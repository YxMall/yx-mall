package com.smile.yx.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableBinding(value = {YxMonitorApplicationTests.SinkSender.class})
public class YxMonitorApplicationTests {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() {
        sinkSender.output().send(MessageBuilder.withPayload("发送消息").build());
    }


    public interface SinkSender {

        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();
    }

}
