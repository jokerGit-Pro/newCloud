package com.joker.cloud.order.controller;

import com.joker.cloud.entity.Payment;
import com.joker.cloud.entity.ResultCommon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author:Tom-joker
 * @Date:2020/10/27
 * @version:1.0
 */
@Slf4j
@RestController
@RequestMapping("consumer")
@Api(tags = "订单接口")
public class OrderController {

    public static final String PAYMENT_URL="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/create")
    @ApiOperation("远程调用添加操作")
    public ResultCommon create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,ResultCommon.class);
    }

    @GetMapping("payment/get/{id}")
    @ApiOperation("远程调用查找操作")
    public ResultCommon<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,ResultCommon.class);
    }
}
