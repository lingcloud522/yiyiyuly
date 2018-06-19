package com.huadongmedia.entity;

import java.util.List;

/**
 * Created by wushiyuan on 2018/5/7 0007.
 */
public class Role {
  private Integer id;
  private String rolename;
  private List<Permission> permissionList;//一个角色对应多个权限
  private List<User> userList;//一个角色对应多个用户
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

  public List<Permission> getPermissionList() {
    return permissionList;
  }

  public void setPermissionList(List<Permission> permissionList) {
    this.permissionList = permissionList;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }
}
