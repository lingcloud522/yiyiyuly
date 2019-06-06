package com.lingcloud.service;

import java.util.List;
import java.util.Set;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
public interface RedisService {
  boolean set(final String key,Object value);
  boolean set(final String key,Object value,Long expireTime);
  void remove(final String... keys);
  void removePattern(final String pattern);
  boolean exists(final String key);
  void remove(final String key);
  Object get(final String key);
  void hmSet(String key,Object hashKey,Object value);
  Object hmGet(String key,String hashKey);
  void addList(String key,Object value);
  List<Object> lRange(String k, long l, long l1);
  void add(String key,Object value);
  Set<Object> setMembers(String key);
  void zAdd(String key,Object value,double scoure);
  Set<Object> rangeByScore(String key,double scoure,double scoure1);
}
