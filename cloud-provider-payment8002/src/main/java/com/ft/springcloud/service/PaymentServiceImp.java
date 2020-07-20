package com.ft.springcloud.service;

import com.ft.springcloud.dao.PaymentDao;
import com.ft.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/7/15 0:20
 */
@Service
public class PaymentServiceImp implements IPaymentService{
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
