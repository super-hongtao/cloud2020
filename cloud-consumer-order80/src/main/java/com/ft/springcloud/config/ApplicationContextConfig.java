package com.ft.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/16 22:35
 */
@Configuration
public class ApplicationContextConfig {
    //这里相当于applicationContext.xml<bean id="" class="">
    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}

