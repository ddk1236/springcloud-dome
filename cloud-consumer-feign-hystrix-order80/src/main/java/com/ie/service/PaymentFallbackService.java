package com.ie.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @auther zzyy
 * @create 2020-02-20 18:22
 */
//@Component
@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }

}
