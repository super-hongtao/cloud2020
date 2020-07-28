package com.ft.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/29 0:10
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain6001.class,args);
    }
}
