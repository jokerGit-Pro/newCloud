package com.joker.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:Tom-joker
 * @Date:2020/11/7
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixApp {

  public static void main(String[] args) {
    SpringApplication.run(PaymentHystrixApp.class);
  }
}
