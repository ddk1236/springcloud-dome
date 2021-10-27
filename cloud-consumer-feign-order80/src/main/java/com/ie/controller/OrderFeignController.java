package com.ie.controller;

import com.ie.common.Result;
import com.ie.entity.PaymentEntity;
import com.ie.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ddk
 * @date 2021/10/27
 */
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/findPaymentById/{id}")
    public Result<PaymentEntity> findPaymentById(@PathVariable Long id){
        return paymentFeignService.findPaymentById(id);
    }
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
