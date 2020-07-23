package com.ft.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/24 0:53
 */
public interface LoadBalancer {

    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
