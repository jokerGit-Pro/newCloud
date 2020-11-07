package com.joker.cloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author:Tom-joker
 * @Date:2020/11/7
 * @version:1.0
 */
@Service
public class PaymentService {

    public String payment_Ok(){
        return "当前·线程："+Thread.currentThread().getName()+" 执行OK";
    }

    /**
     *  execution.isolation.thread.timeoutInMilliseconds 3000：规定了该业务方法的执行时间，超时就会执行降级方法
     *  如果在3000毫秒内执行方法时遇到异常，直接就会执行降级方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "payment_TimeOout_Handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payment_TimeOout(){
        try{
            //int age=10/0;
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "当前 线程："+Thread.currentThread().getName()+" 执行超时";
    }

    public String payment_TimeOout_Handler(){
        return "当前 线程："+Thread.currentThread().getName()+" 由于超时，执行了降级方法";
    }
}
