package com.ie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ddk
 * @date 2021/10/25
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String testConsul(){
        return "springCloud with consul:" +serverPort +"\t"+ UUID.randomUUID().toString();
    }
}
