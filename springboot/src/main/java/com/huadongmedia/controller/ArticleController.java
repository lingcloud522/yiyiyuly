package com.huadongmedia.controller;

import com.huadongmedia.common.PagingResponse;
import com.huadongmedia.common.ResponseResult;
import com.huadongmedia.entity.Article;
import com.huadongmedia.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @RequestMapping(value = "/list",method = RequestMethod.POST)
  public ResponseResult<PagingResponse<Article>> getArticle(@RequestParam int page,@RequestParam int pageSize){
    ResponseResult<PagingResponse<Article>> responseResult = new ResponseResult<>();
    PagingResponse<Article> pagingResponse = new PagingResponse<>();
    if(page<1){
      page = 1;
    }
    if(pageSize<1){
      pageSize = 10;
    }
    int totalCount = articleService.count();
    pagingResponse.setPage(page);
    pagingResponse.setPageSize(pageSize);
    pagingResponse.setTotalCount(totalCount);
    pagingResponse.setDataList(articleService.getArticle(page,pageSize));
    responseResult.setData(pagingResponse);
    return responseResult;
  }

}
