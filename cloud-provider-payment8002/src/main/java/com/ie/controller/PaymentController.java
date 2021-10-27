package com.ie.controller;

import com.ie.common.Result;
import com.ie.entity.PaymentEntity;
import com.ie.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ddk
 * @date 2021/10/22
 */
@RestController
@Slf4j
@RequestMapping("payment")
@Api(value = "payment", tags = "payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPaymentList")
    @ApiOperation(value = "查询")
    public Result<List<PaymentEntity>> getPaymentList() {
        return Result.back(serverPort,paymentService.getPaymentList());
    }

    @PostMapping("/addPayment")
    @ApiOperation(value = "添加")
    public Result getPaymentList(@RequestBody PaymentEntity payment) {
        return Result.back(serverPort,paymentService.addPayment(payment));
    }

    @GetMapping("/findPaymentById/{id}")
    @ApiOperation(value = "根据Id查询")
    public Result<PaymentEntity> findPaymentById(@PathVariable Long id) {
        return Result.back(serverPort,paymentService.findPaymentById(id));
    }

    @GetMapping("/payment/discovery")
    public Result<Map<String, Object>> getDiscovery(){
        Map<String, Object> map = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        services.forEach(e ->{
            log.info("----------service:"+e);
        });
        map.put("services",services);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(e->{
            log.info("----------instance:"+e);
        });
        map.put("instances",instances);
        return Result.back(map);
    }

    @GetMapping("/lb")
    public String getPayment(){
        return serverPort;
    }
}
