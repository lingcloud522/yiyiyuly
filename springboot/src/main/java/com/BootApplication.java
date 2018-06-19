package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 * springboot 启动类  注解@SpringBootApplication
 */
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.huadongmedia.mapper")
/*@Import({DynamicDataSourceRegister.class})*/
public class BootApplication {
  public static void main(String[] args) {
    SpringApplication.run(BootApplication.class, args);
  }
}
