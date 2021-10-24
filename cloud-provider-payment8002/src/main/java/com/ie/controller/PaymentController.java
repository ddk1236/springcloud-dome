package com.ie.controller;

import com.ie.common.Result;
import com.ie.entity.PaymentEntity;
import com.ie.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
