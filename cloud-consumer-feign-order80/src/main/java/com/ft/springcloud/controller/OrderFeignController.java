package com.ft.springcloud.controller;

import com.ft.springcloud.entity.CommonResult;
import com.ft.springcloud.entity.Payment;
import com.ft.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/25 18:35
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){

        //OpenFeign底层ribbon，客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }


}
