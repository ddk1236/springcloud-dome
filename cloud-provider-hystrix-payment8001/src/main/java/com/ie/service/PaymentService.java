package com.ie.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ddk
 * @date 2021/10/27
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeout(Integer id){
//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeout,id:" + id;
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "系统繁忙，请稍后再试,id:" + id;
    }
}
