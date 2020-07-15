package com.lingcloud.controller;

import com.lingcloud.service.RedisService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<10; i++){
      list.add(i);
    }

    int[] source = {1,2,3,4,5,6,7,8,9,10};

    int[] list2 = new int[10];
    System.arraycopy(source, 0, list2, 0, source.length);

    System.out.println(Arrays.toString(list2));

  }

  public static void print(Object e){
    System.out.println(e);
  }


}
