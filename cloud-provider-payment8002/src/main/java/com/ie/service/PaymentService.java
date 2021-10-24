package com.ie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ie.entity.PaymentEntity;

import java.util.List;

/**
 * @author ddk
 * @date 2021/10/22
 */
public interface PaymentService extends IService<PaymentEntity> {


    List<PaymentEntity> getPaymentList();

    Boolean addPayment(PaymentEntity payment);

    PaymentEntity findPaymentById(Long id);
}
