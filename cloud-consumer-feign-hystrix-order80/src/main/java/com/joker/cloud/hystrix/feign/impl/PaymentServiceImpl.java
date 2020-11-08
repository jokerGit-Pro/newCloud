package com.joker.cloud.hystrix.feign.impl;

import com.joker.cloud.hystrix.feign.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author:Tom-joker
 * @Date:2020/11/7
 * @version:1.0
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentOk(Integer id) {
        return "调用支付服务的ok方法失败，执行通配服务降级";
    }

    @Override
    public String paymenyTimeout(Integer id) {
        return "调用支付服务的timeout方法失败，执行通配服务降级";
    }
}
