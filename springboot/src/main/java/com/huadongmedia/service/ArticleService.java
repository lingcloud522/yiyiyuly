package com.huadongmedia.service;

import com.huadongmedia.entity.Article;

import java.util.List;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
public interface ArticleService {

  Integer selectArticleId();

  int count();

  List<Article> getArticle(int page,int pageSize);

}
