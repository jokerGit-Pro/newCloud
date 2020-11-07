package com.joker.cloud.hystrix.controller;

import com.joker.cloud.hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:Tom-joker @Date:2020/11/7
 *
 * @version:1.0
 */
@RestController
@Slf4j
public class PaymentController {

  @Resource private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("payment/hystrix/ok/{id}")
  public String paymentOk(@PathVariable("id") Integer id) {
    String msg = paymentService.payment_Ok();
    log.info("****************** 调用成功 result: " + msg);
    return msg;
  }

  @GetMapping("payment/hystrix/timeout/{id}")
  public String paymenyTimeout(@PathVariable("id") Integer id) {
    String msg = paymentService.payment_TimeOout();
    log.info("******************调用超时  result: " + msg);
    return msg;
  }
}
