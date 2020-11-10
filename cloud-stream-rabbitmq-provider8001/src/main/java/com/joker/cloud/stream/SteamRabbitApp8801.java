package com.joker.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:Tom-joker
 * @Date:2020/11/9
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class SteamRabbitApp8801  {
  public static void main(String[] args) {
    SpringApplication.run(SteamRabbitApp8801.class);
  }
}
