package com.ie.controller;

import com.ie.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ddk
 * @date 2021/11/1 4:04 下午
 */

@RestController
@RequestMapping("/stream")
public class SendMessageController {

    @Autowired
    private IMessageProvider provider;

    @GetMapping("/send")
    public String sendMessage(){
        return provider.send();
    }
}
