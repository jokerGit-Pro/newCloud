package com.joker.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:Tom-joker
 * @Date:2020/11/7
 * @version:1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderhystrixApp {

  public static void main(String[] args) {
    SpringApplication.run(OrderhystrixApp.class);
  }
}
