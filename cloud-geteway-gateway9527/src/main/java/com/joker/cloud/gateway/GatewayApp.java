package com.joker.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:Tom-joker
 * @Date:2020/11/8
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApp {
  public static void main(String[] args) {
    SpringApplication.run(GatewayApp.class);
  }
}
