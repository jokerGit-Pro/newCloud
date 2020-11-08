package com.joker.cloud.hystrix.controller;

import com.joker.cloud.hystrix.feign.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "globalFallbackMethod")
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
    /*@HystrixCommand(fallbackMethod = "orderTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand //服务降级
    public String orderTimeout(@PathVariable("id") Integer id){
        //int age=10/0;
        String timeout = paymentService.paymenyTimeout(id);
        log.info("****调用payment的timeout方法,调用结果："+timeout);
        return timeout;
    }

    public String orderTimeoutHandler(@PathVariable("id") Integer id){

        log.info("****调用降级方法,端口：80");
        return "执行降级方法 orderTimeoutHandler，端口80";
    }

    public String globalFallbackMethod(){
        return "global全局降级方法,服务异常，请稍后再试";
    }
}
