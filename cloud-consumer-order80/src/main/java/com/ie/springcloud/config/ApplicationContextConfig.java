package com.ie.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ddk
 * @date 2021/10/23
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
//    /**
//     * 覆盖掉ribbon默认的轮询负载均衡策略
//     * @return
//     */
//    @Bean
//    public IRule iRule(){
//        //return new RandomRule();//采用随机负载均衡策略
//        return new RetryRule();
//    }
}
