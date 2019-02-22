package com.smile.yx.demo1.stream;

import javafx.scene.control.Skin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @description: 消息消费者
 * @author: qing.wang.o
 * @create: 2019-02-22 14:25
 **/
@EnableBinding(Sink.class)
@Slf4j
public class SinkReceiver {


    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        log.info("receive message:{}", payload);
    }
}
