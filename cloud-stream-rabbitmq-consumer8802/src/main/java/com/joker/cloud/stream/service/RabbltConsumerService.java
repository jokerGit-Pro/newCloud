package com.joker.cloud.stream.service;

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
@EnableBinding(Sink.class)
public class RabbltConsumerService {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void reveive(Message<String> message){
        String payload = message.getPayload();
        System.out.println("接收到的消息"+payload+"\t  端口为"+port);
    }
}
