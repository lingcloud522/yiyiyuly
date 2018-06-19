package com.huadongmedia.controller;

import com.huadongmedia.annotation.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
@Api("hello")
@RestController
@EnableAutoConfiguration
@RequestMapping("/hello")
public class HelloController {

  @ApiOperation("获取问候语！")
  @RequestMapping(value = "/getGreetings",method = RequestMethod.GET)
  public String hello(){
    return "hello world";
  }

  @MyLog(requestUrl = "/index")
  @RequestMapping(value = "/index" ,method = RequestMethod.GET)
  public String index(){
    return "index";
  }

}
