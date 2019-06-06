package com.lingcloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by wushiyuan on 2018/5/11 0011.
 */
@Document(indexName = "index_1",type = "admin_user",shards = 5, replicas = 1, refreshInterval = "-1")
@Data
public class User {
  @Id
  private String id;
  @Field
  private String userName;
  @Field
  private String realName;
  @Field
  private String nickName;
  @Field
  private String password;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Field
  private Date addTime;
  @Field
  private Integer state;
}
