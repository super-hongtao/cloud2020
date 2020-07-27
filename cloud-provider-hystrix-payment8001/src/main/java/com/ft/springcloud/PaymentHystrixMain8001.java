package com.ft.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/25 23:55
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //服务回路
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
