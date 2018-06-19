package com.huadongmedia.controller;

import com.huadongmedia.entity.User;
import com.huadongmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wushiyuan on 2018/5/4 0004.
 */
@RestController
public class LoginController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login",method = RequestMethod.GET)
  public String login(){
    User user = userService.getUserById(59L);
    System.out.println(user.getRealName());
    return "hello world!";
  }

}
