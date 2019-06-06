package com.lingcloud.schedule;

import com.lingcloud.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 * 定时任务
 */
@Component
@PropertySource("classpath:job.properties")
public class AutoAuditSchedule {

  @Value("${job.autoStart}")
  private String autoStart;

  @Autowired
  private ArticleMapper articleMapper;

  @Scheduled(cron = "${job.cron}")
  public Boolean autoAudit(){
    Boolean result = false;
    System.out.println("111111"+autoStart);
    if("true".equals(autoStart)){
      Integer articleId = articleMapper.selectArticleId();
      try{
        result = articleMapper.updateArticleById(Long.parseLong(articleId.toString())) > 0;
      }catch (NullPointerException e){
        e.printStackTrace();
      }
    }
    return result;
  }

  @Scheduled(cron = "${job.cron}")
  public Boolean autoAudit2(){
    Boolean result = false;
    System.out.println("22222"+autoStart);
    if("true".equals(autoStart)){
      Integer articleId = articleMapper.selectArticleId();
      try{
        result = articleMapper.updateArticleById(Long.parseLong(articleId.toString())) > 0;
      }catch (NullPointerException e){
        e.printStackTrace();
      }
    }
    return result;
  }
}
