package com.huadongmedia.controller;

import com.huadongmedia.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

  @Autowired
  RedisService redisService;

  @RequestMapping(value = "/set",method = RequestMethod.POST)
  public void set(){
    redisService.set("name","wushiyuan");
  }
  @RequestMapping(value = "/get",method = RequestMethod.POST)
  public Object get(){
    return redisService.get("25");
  }
  @RequestMapping(value = "/setTimeEffect",method = RequestMethod.POST)
  public void setTimeEffect(){
    redisService.set("25","wushiyuan",15L);
  }

}
