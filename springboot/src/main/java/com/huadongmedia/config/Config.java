package com.huadongmedia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wushiyuan on 2018/5/11 0011.
 */
@Configuration
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {
  @Override
  public void configureDefaultServletHandling(
          DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
}
