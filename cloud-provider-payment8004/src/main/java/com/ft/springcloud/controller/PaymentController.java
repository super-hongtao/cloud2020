package com.ft.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/22 0:18
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zkp")
    public String paymentzk(){
        return "springcloud with zookeeper:"+serverPort+"/t"+ UUID.randomUUID().toString();
    }
}
