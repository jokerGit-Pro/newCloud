package com.joker.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author:Tom-joker
 * @Date:2020/10/30
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp2 extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(EurekaApp2.class);
  }

}
