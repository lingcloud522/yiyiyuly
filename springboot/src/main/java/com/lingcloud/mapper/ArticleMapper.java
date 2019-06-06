package com.lingcloud.mapper;

import com.lingcloud.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
public interface ArticleMapper {

  Integer selectArticleId();

  int updateArticleById(Long id);

  int selectCount();

  List<Article> selectAllArticle(@Param("offset") int page, @Param("pageSize") int pageSize);

}
