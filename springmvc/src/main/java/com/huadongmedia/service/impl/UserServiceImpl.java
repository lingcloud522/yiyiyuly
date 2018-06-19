package com.huadongmedia.service.impl;

import com.huadongmedia.entity.User;
import com.huadongmedia.mapper.UserMapper;
import com.huadongmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wushiyuan on 2018/5/4 0004.
 */
@Service
public class UserServiceImpl implements UserService{

  @Autowired
  UserMapper userMapper;

  @Override
  public User getUserById(Long id) {
    return userMapper.selectById(id);
  }
}
