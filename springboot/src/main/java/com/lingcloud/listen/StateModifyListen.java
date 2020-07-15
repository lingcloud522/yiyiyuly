package com.lingcloud.listen;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wushiyuan
 * @version 1.0
 * @className StateModifyListen
 * @description
 * @date 2019-06-26 19:09
 **/
@Component
public class StateModifyListen implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("监听器。。。");
    }


}
