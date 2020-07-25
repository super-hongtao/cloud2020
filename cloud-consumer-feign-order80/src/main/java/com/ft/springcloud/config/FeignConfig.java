package com.ft.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/25 18:30
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){

        //feign自身详细日志
        return Logger.Level.FULL;
    }

}
