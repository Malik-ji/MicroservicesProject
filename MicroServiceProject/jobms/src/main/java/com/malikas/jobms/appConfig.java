package com.malikas.jobms;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class appConfig {

    public RestTemplate restTemplate;
@LoadBalanced
    @Bean
    public RestTemplate   restTemplate()
    {
        return  new RestTemplate();
    }
}
