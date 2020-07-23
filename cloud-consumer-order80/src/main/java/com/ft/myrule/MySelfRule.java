package com.ft.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/24 0:34
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return  new RandomRule();  //设置为随机轮询方式
    }
}
