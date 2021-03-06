package com.ft.springcloud.controller;

import com.ft.springcloud.entity.CommonResult;
import com.ft.springcloud.entity.Payment;
import com.ft.springcloud.service.IPaymentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/715 0:19
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private IPaymentService ipaymentService;

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = ipaymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功: ",result);
        }else{
            return new CommonResult(444,"插入数据失败: ",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = ipaymentService.getPaymentById(id);
        log.info("*****插入结果："+payment+"\t"+"哈哈哈");
        if(payment != null){
            return new CommonResult(200,"查询成功: ",payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }

}
