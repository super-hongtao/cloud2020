package com.ft.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/25 23:57
 */
@Service
public class PaymentService {

    @Value("{$server.Port}")
    private String serverPort;
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id："+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * @HystrixCommand报异常后如何处理：
     * 一旦调用服务方法失败并抛出了错误信息后，
     * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_Timeout(Integer id){
        //运行异常
        //int age = 10 / 0;
        //延时异常
        int timeNumber = 5;
        try{
            //暂停毫秒
            TimeUnit.SECONDS.sleep(timeNumber);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName() + "  paymentInfo_Timeout,id:  "+id+"\t"+"O(n_n)O  哈哈！！" + "耗时" + timeNumber + "秒";
    }
    //指定降级方法
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池:    " + Thread.currentThread().getName() + serverPort + "系统繁忙或运行报错，请稍后再试，id：" + id + "\t" + "o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("******id 不能为负数");
        }

        //下方同理UUID.randomUUID();
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍后再试，o(╥﹏╥)o  id："+id;
    }
}
