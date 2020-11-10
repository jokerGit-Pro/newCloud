package com.joker.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:Tom-joker
 * @Date:2020/11/10
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerApp {
  public static void main(String[] args) {
    SpringApplication.run(StreamConsumerApp.class);
  }
}
