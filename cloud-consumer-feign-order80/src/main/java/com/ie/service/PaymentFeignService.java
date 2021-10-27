package com.ie.service;

import com.ie.common.Result;
import com.ie.entity.PaymentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/findPaymentById/{id}")
    Result<PaymentEntity> findPaymentById(@PathVariable Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeOut();


}
