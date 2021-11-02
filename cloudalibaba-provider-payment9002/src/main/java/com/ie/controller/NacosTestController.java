package com.ie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ddk
 * @date 2021/11/2 1:40 下午
 */

@RestController
@RequestMapping("/nacos")
public class NacosTestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/{id}")
    public String paymentTest(@PathVariable("id")Integer id){
        return serverPort + "-" + id;
    }
}
