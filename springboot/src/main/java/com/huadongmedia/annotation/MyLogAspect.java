package com.huadongmedia.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by wushiyuan on 2018/5/5 0005.
 */
@Aspect
@Component
public class MyLogAspect {

  @Pointcut(value = "@annotation(com.huadongmedia.annotation.MyLog)")
  private void pointcut(){

  }

  @Around(value = "pointcut() && @annotation(myLog)")
  public Object around(ProceedingJoinPoint point,MyLog myLog){
    System.out.println("++++++++++执行了around方法++++++++++");
    String requestUrl = myLog.requestUrl();
    //拦截的类名
    Class clazz = point.getTarget().getClass();
    //拦截的方法
    Method method = ((MethodSignature)point.getSignature()).getMethod();
    System.out.println("执行了类："+clazz+",执行了方法："+method+",自定义请求地址"+requestUrl);
    try{
      return point.proceed();
    }catch(Throwable throwable){
      throwable.printStackTrace();
      return throwable.getMessage();
    }
  }

  @AfterReturning(value = "pointcut() && @annotation(myLog)",returning = "result")
  public Object afterReturning(JoinPoint joinPoint,MyLog myLog,Object result){
    System.out.println("++++执行了afterReturning方法++++");
    System.out.println("执行结果：" + result);
    return result;
  }

  @AfterThrowing(value = "pointcut() && @annotation(myLog)",throwing = "ex")
  public void afterThrowing(JoinPoint joinPoint,MyLog myLog,Exception ex){
    System.out.println("++++执行了afterThrowing方法++++");
    System.out.println("请求：" + myLog.requestUrl() + " 出现异常");
  }
}
