package com.smile.yx.stream;

import javafx.scene.control.Skin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-03-06 13:47
 **/
@EnableBinding(Sink.class)
@Slf4j
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(String payload) {
        log.info("payload:{}", payload);
    }

}
