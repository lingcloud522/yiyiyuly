package com.huadongmedia.service.impl;

import com.huadongmedia.entity.Article;
import com.huadongmedia.mapper.ArticleMapper;
import com.huadongmedia.service.ArticleService;
import com.huadongmedia.util.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  ArticleMapper articleMapper;

  @Override
  public Integer selectArticleId() {
    return articleMapper.selectArticleId();
  }

  @Override
  public int count() {
    return articleMapper.selectCount();
  }

  @Override
  @TargetDataSource("ds1")
  public List<Article> getArticle(int page, int pageSize) {
    return articleMapper.selectAllArticle((page-1)*pageSize,pageSize);
  }

}
