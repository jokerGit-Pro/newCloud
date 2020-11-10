package com.joker.cloud.stream.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @Author:Tom-joker
 * @Date:2020/11/10
 * @version:1.0
 */
@Slf4j
@EnableBinding(Sink.class)
public class RabbitConsumerService {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message){
        String payload = message.getPayload();
        log.info("接收到的消息:"+payload+"/t 端口："+port);
    }
}
