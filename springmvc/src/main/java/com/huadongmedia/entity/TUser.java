package com.huadongmedia.entity;

import java.util.List;

/**
 * Created by wushiyuan on 2018/5/7 0007.
 */

public class TUser {
  private Integer id;
  private String username;
  private String password;
  private List<Role> roleList;

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
