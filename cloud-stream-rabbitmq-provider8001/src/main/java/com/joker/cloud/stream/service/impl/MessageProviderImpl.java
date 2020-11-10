package com.joker.cloud.stream.service.impl;

import com.joker.cloud.stream.service.RabbitMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author:Tom-joker
 * @Date:2020/11/9
 * @version:1.0
 */
@Service
@EnableBinding(Source.class)
@Transactional(rollbackFor = Exception.class)
public class MessageProviderImpl implements RabbitMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial:"+serial);
        return serial;
    }
}
