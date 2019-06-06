package com.lingcloud.service.impl;

import com.lingcloud.dao.EsBeanRepository;
import com.lingcloud.entity.User;
import com.lingcloud.service.EsService;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by wushiyuan on 2018/5/11 0011.
 */
@Service
@EnableElasticsearchRepositories
public class EsServiceImpl implements EsService {

  @Resource
  private EsBeanRepository esBeanRepository;

  @Override
  public String queryInfoById(String id) {
    System.out.println("id:" + id);
//        EsBean eb = (EsBean)esBeanRepository.findOne(id);
    User user = new User();
    user.setId("1314");
    user.setUserName("wushiyuan");
    user.setAddTime(new Date());
    user.setNickName("wu");
    user.setRealName("wushiyuan");
    user.setState(1);
    user.setPassword("12311");
    esBeanRepository.save(user);
    String value = "1";
    System.out.println("value:"+value);
    return value;
  }
}
