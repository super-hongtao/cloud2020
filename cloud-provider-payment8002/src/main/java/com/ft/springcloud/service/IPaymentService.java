package com.ft.springcloud.service;

import com.ft.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/15 0:19
 */
public interface IPaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
