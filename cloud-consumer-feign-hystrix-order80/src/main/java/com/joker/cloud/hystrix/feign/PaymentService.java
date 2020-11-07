package com.joker.cloud.hystrix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author:Tom-joker
 * @Date:2020/11/7
 * @version:1.0
 */
@Component
@FeignClient("CLOUD-PROVIDER-HYSTRIX-PAYMENT8001")
public interface PaymentService {

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymenyTimeout(@PathVariable("id") Integer id);
}
