package com.ft.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池:    " + Thread.currentThread().getName() + serverPort + "系统繁忙或运行报错，请稍后再试，id：" + id + "\t" + "o(╥﹏╥)o";
    }

}
