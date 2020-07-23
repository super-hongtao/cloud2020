package com.ft.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/24 0:53
 */
@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        //自写自旋锁
        do {
            current =this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;

        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("接口第"+next+"次访问分配");
        return next;
    }

    @Override
    public ServiceInstance instances (List<ServiceInstance> serviceInstances){
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
