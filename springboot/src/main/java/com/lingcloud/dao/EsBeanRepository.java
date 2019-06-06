package com.lingcloud.dao;

import com.lingcloud.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by wushiyuan on 2018/5/11 0011.
 */
public interface EsBeanRepository extends ElasticsearchRepository<User,String> {

}
