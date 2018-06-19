package com.huadongmedia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by wushiyuan on 2018/5/10 0010.
 * 解决redis乱码问题
 */
@Configuration
public class RedisConfig {

  @Autowired
  private RedisTemplate redisTemplate;

  @Bean
  public RedisTemplate redisTemplateInit(){
    //设置序列化key的实例化对象
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    //设置序列化value的实例化对象
    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    return redisTemplate;
  }

}
