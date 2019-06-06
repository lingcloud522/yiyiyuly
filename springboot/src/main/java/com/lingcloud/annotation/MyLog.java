package com.lingcloud.annotation;

import java.lang.annotation.*;

/**
 * Created by wushiyuan on 2018/5/5 0005.
 * 创建自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyLog {

  String requestUrl();

}
