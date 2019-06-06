package com.lingcloud.common;

import lombok.Data;


/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@Data
public class ResponseResult<T> {

  private RetCode retCode = RetCode.OK;

  private T data;

  public ResponseResult(){
    super();
  }

  public ResponseResult(T data){
    this.data = data;
  }

  public ResponseResult(T data,RetCode retCode){
    this(data);
    this.retCode = retCode;
  }

}
