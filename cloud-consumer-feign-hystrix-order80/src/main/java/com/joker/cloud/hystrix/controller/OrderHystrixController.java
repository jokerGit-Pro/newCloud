package com.joker.cloud.hystrix.controller;

import com.joker.cloud.hystrix.feign.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:Tom-joker
 * @Date:2020/11/7
 * @version:1.0
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("consumer/order/ok/{id}")
    public String orderOk(@PathVariable("id") Integer id){
        String ok = paymentService.paymentOk(id);
        log.info("****调用payment的ok方法,调用结果："+ok);
        return ok;
    }

    @GetMapping("consumer/order/timeout/{id}")
    public String orderTimeout(@PathVariable("id") Integer id){
        String timeout = paymentService.paymenyTimeout(id);
        log.info("****调用payment的timeout方法,调用结果："+timeout);
        return timeout;
    }
}
