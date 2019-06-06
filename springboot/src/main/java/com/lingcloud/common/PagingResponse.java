package com.lingcloud.common;

import lombok.Data;

import java.util.List;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@Data
public class PagingResponse<T> {

  private int page;
  private int pageSize;
  private int totalCount;
  private List<T> dataList;

}
