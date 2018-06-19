package com.huadongmedia.dao;

import com.huadongmedia.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by wushiyuan on 2018/5/11 0011.
 */
public interface EsBeanRepository extends ElasticsearchRepository<User,String> {

}
