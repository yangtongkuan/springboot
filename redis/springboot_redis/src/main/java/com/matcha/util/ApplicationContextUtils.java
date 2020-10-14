package com.matcha.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/14 22:54
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */

/**
 * 获取spring bean的工厂
 */
@Configuration
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //提供在工厂中获取对象的方法 //RedisTemplate  redisTemplate
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

}
