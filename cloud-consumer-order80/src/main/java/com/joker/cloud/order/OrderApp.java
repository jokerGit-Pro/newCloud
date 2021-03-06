package com.joker.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:Tom-joker
 * @Date:2020/10/27
 * @version:1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderApp {
  public static void main(String[] args) {
    SpringApplication.run(OrderApp.class);
  }
}
