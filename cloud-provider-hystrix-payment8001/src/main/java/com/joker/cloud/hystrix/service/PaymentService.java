package com.joker.cloud.hystrix.service;

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

    public String payment_TimeOout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "当前 线程："+Thread.currentThread().getName()+" 执行超时";
    }
}
