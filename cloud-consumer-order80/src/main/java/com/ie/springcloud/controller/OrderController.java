package com.ie.springcloud.controller;

import com.ie.common.Result;
import com.ie.entity.PaymentEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ddk
 * @date 2021/10/23
 */
@RestController
@Log4j2
public class OrderController {

    public static final String payment_uri = "https://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/addPayment")
    public Result<PaymentEntity> add(PaymentEntity payment) {
        return restTemplate.postForObject(payment_uri + "/payment/addPayment", payment, Result.class);
    }

    @GetMapping("/consumer/payment/findPaymentById/{id}")
    public Result<PaymentEntity> getPaymentById(@PathVariable Long id) {
        return restTemplate.getForObject(payment_uri + "/payment/findPaymentById/" + id, Result.class);
    }

    @GetMapping("/consumer/payment/getPaymentEntityById/{id}")
    public ResponseEntity<Result> getPaymentEntityById(@PathVariable Long id) {
        ResponseEntity<Result> forEntity = restTemplate.getForEntity(payment_uri + "/payment/findPaymentById/" + id, Result.class);
        log.info("ResponseEntity<Result>:{}",forEntity);
        return forEntity;
    }
}
