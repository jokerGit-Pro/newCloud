package com.joker.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:Tom-joker
 * @Date:2020/10/26
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PayApplication {
  public static void main(String[] args) {
    SpringApplication.run(PayApplication.class);
  }
}
