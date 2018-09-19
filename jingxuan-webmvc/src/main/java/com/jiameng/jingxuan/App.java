package com.jiameng.jingxuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jiameng.jingxuan.config.WebMVCResourceProperties;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableConfigurationProperties(WebMVCResourceProperties.class)
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
