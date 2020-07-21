package com.ft.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/22 0:15
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于使用consul和zookeeper作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
