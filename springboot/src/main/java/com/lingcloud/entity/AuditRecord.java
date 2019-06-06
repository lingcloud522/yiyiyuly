package com.lingcloud.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
@Data
public class AuditRecord {

  private Long id;
  private Long articleId;
  private String trialUsername;
  private String retrialUsername;
  private String trialState;
  private String retrialState;
  private Date createTime;
  private Date lastModifyTime;
  private String articleTitle;
  private Date trialTime;
  private String articleChannel;
  private Long trialUserId;
  private Long retrialUserId;

}
