package com.ft.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/25 18:27
 */
@SpringBootApplication
@EnableFeignClients   //开启feign
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
