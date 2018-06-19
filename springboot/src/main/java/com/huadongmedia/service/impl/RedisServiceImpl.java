package com.huadongmedia.service.impl;

import com.huadongmedia.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@Service
public class RedisServiceImpl implements RedisService{

  @Autowired
  private RedisTemplate redisTemplate;

  /**
   * 写入缓存
   * @param key
   * @param value
   * @return
   */
  @Override
  public boolean set(final String key,Object value){

    boolean result = false;
    try{
      ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
      valueOperations.set(key,value);
      result = true;
    }catch (Exception e){
      e.printStackTrace();
    }
    return result;
  }

  /**
   * 写入缓存设置时效时间
   * @param key
   * @param value
   * @return
   */
  @Override
  public boolean set(final String key,Object value,Long expireTime){
    boolean result = false;
    try{
      ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
      valueOperations.set(key,value);
      result = redisTemplate.expire(key,expireTime,TimeUnit.SECONDS);
    }catch (Exception e){
      e.printStackTrace();
    }
    return result;
  }

  /**
   * 批量删除对应的value
   * @param keys
   */
  @Override
  public void remove(final String... keys){
    for(String key : keys){
      remove(key);
    }
  }

  /**
   * 批量删除key
   * @param pattern
   */
  @Override
  public void removePattern(final String pattern){
    Set<Serializable> keys = redisTemplate.keys(pattern);
    if(keys.size() > 0){
      redisTemplate.delete(keys);
    }
  }

  /**
   * 判断缓存中是否有对应的value
   * @param key
   * @return
   */
  @Override
  public boolean exists(final String key) {
    return redisTemplate.hasKey(key);
  }

  /**
   * 删除对应的value
   * @param key
   */
  @Override
  public void remove(final String key){
    if(exists(key)){
      redisTemplate.delete(key);
    }
  }

  /**
   * 读取缓存
   * @param key
   * @return
   */
  @Override
  public Object get(final String key){
    Object result = null;
    ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
    result = valueOperations.get(key);
    return result;
  }

  /**
   * 哈希 添加
   * @param key
   * @param hashKey
   * @param value
   */
  @Override
  public void hmSet(String key,Object hashKey,Object value){
    HashOperations<String,Object,Object> valueOperations = redisTemplate.opsForHash();
    valueOperations.put(key,hashKey,value);
  }

  /**
   * 哈希获取数据
   * @param key
   * @param hashKey
   * @return
   */
  @Override
  public Object hmGet(String key,String hashKey){
    HashOperations<String,Object,Object> valueOperations = redisTemplate.opsForHash();
    return valueOperations.get(key,hashKey);
  }

  /**
   * 列表添加
   * @param key
   * @param value
   */
  @Override
  public void addList(String key,Object value){
    ListOperations<String,Object> listOperations = redisTemplate.opsForList();
    listOperations.rightPush(key, value);
  }

  /**
   * 列表获取
   * @param k
   * @param l
   * @param l1
   * @return
   */
  @Override
  public List<Object> lRange(String k, long l, long l1){
    ListOperations<String, Object> list = redisTemplate.opsForList();
    return list.range(k,l,l1);
  }

  /**
   * 集合添加
   * @param key
   * @param value
   */
  @Override
  public void add(String key,Object value){
    SetOperations<String, Object> set = redisTemplate.opsForSet();
    set.add(key,value);
  }

  /**
   * 集合获取
   * @param key
   * @return
   */
  @Override
  public Set<Object> setMembers(String key){
    SetOperations<String, Object> set = redisTemplate.opsForSet();
    return set.members(key);
  }

  /**
   * 有序集合添加
   * @param key
   * @param value
   * @param scoure
   */
  @Override
  public void zAdd(String key,Object value,double scoure){
    ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
    zset.add(key,value,scoure);
  }

  /**
   * 有序集合获取
   * @param key
   * @param scoure
   * @param scoure1
   * @return
   */
  @Override
  public Set<Object> rangeByScore(String key,double scoure,double scoure1){
    ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
    return zset.rangeByScore(key, scoure, scoure1);
  }
}
