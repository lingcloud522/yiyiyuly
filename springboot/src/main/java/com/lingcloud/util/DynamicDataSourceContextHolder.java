package com.lingcloud.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushiyuan on 2018/5/5 0005.
 * 动态数据源上下文
 */
public class DynamicDataSourceContextHolder {

  /*
   * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
   * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
   */
  private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

  /*
   * 管理所有的数据源id;
   * 主要是为了判断数据源是否存在;
   */
  public static List<String> datasourceIds = new ArrayList<>();

  public static void setDataSourceType(String dataSourceType){
    contextHolder.set(dataSourceType);
  }

  public static String getDataSourceType(){
    return contextHolder.get();
  }

  public static void clearDataSourceType(){
    contextHolder.remove();
  }

  public static boolean contain(String dataSourceId){
    return datasourceIds.contains(dataSourceId);
  }


}
