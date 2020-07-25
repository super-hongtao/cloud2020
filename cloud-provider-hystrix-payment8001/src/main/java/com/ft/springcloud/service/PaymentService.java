package com.ft.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/25 23:57
 */
@Service
public class PaymentService {

    /**
     * 正常访问的时候
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：  "+Thread.currentThread().getName() + "  paymentInfo_OK,id:  "+id+"\t"+"O(n_n)O  哈哈！！";
    }

    /**
     * 延时n秒后访问
     * @param id
     * @return
     */
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName() + "  paymentInfo_Timeout,id:  "+id+"\t"+"O(n_n)O  哈哈！！" + "耗时" + timeNumber + "秒";
    }
}
