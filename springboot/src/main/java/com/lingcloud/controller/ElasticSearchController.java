package com.lingcloud.controller;

import com.lingcloud.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wushiyuan on 2018/5/11 0011.
 */
@RestController
@RequestMapping("/es")
public class ElasticSearchController {

  @Autowired
  EsService esService;
  //增加
  @RequestMapping(value = "/add",method = RequestMethod.POST)
  public String add(){
    String result = esService.queryInfoById("1314");
    return result;
  }

/*  //删除
  @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
  public String delete(){
    esBeanRepository.delete("1");
    return "success";
  }

  //局部更新
  @RequestMapping(value = "/update",method = RequestMethod.POST)
  public String update(){
    User user= esBeanRepository.queryUserById(1);
    user.setNickName("yuly");
    esBeanRepository.save(user);
    System.err.println("update a obj");
    return "success";
  }

  //查询
  @RequestMapping(value = "/query",method = RequestMethod.GET)
  public User query(){
    User accountInfo= esBeanRepository.queryUserById(1);
    System.err.println(new Gson().toJson(accountInfo));
    return accountInfo;
  }*/

}
