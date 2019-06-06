package com.lingcloud.util;

import java.lang.annotation.*;

/**
 * Created by wushiyuan on 2018/5/5 0005.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

  String value();

}
