package com.huadongmedia.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wushiyuan on 2018/4/26 0026.
 */
@Data
public class RetCode implements Serializable{

  private int code;
  private String message;

  public RetCode(int code,String message){
    this.code = code;
    this.message = message;
  }

  public static final RetCode OK = new RetCode(200,"OK");
  public static final RetCode FAILURE = new RetCode(-1001,"操作失败");

}
