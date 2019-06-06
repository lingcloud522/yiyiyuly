package com.lingcloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@Data
public class Article {
  //文章ID
  private Long id;

  //文章标题
  private String title;

  //文章摘要描述
  private String summary;

  //所属频道
  private String channel;

  //来源URL
  private String sourceUrl;

  //来源名称
  private String sourceName;

  //来源类型
  private String sourceType;

  //直接来源
  private String directSourceName;

  //来源发布时间
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date sourceReleaseTime;

  //封面类型
  private String coverType;

  //文章封面
  private String cover;

  //文章内容
  private String content;

  //产品质量
  private Integer articleQuality;

  //文章时效性
  private String timeEffect;

  //文章属性
  private String articleAttribute;

  //地区属性
  private String areaAttribute;

  //文章浏览数
  private Integer viewNum;

  //文章评论数
  private Integer commentNum;

  //文章发布状态
  private String releaseState;

  //文章发布时间
  private Date releaseTime;

  //是否送金币(0不送，1送)
  private Integer rewardOpen;

  //免责声明(0免责，1不免)
  private Integer reliefOpen;

  //是否展开全文(0不展开，1展开)
  private Integer spreadOpen;

  //相关推荐(0关闭，1打开)
  private Integer recommendOpen;

  //广告开关(0关闭，1打开)
  private Integer advertOpen;

  //分享开关(0关闭，1打开)
  private Integer shareOpen;

  //评论状态
  private String commentState;

  //定向推送
  private String directionalPush;

  //权重
  private Integer weight;

  //创建人ID
  private Integer createUserId;

  //修改人ID
  private Integer lastModifiedUserId;

  //创建时间
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  //修改时间
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date lastModifiedTime;

  //文章初审状态
  private String trialState;

  //文章复审状态
  private String retrialState;

  //初审人ID
  private Integer trialUserId;

  //初审人姓名
  private String trialUser;

  //复审人ID
  private Integer retrialUserId;

  //复审人姓名
  private String retrialUser;

  private String releaseUser;
  private Integer releaseUserId;


}
