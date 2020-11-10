package com.joker.cloud.stream.controller;

import com.joker.cloud.stream.service.RabbitMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author:Tom-joker
 * @Date:2020/11/9
 * @version:1.0
 */
@RestController
public class MessageController {

    @Resource
    private RabbitMessageProvider rabbitMessageProvider;

    @GetMapping("sendmq")
    public String sendMessage(){
        String send = rabbitMessageProvider.send();
        return send;
    }
}
