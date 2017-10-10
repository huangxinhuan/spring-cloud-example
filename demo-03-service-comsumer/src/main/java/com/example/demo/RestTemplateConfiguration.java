package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate load(){
        RestTemplate template = new RestTemplate();
        return template;
    }

    @Bean(name = "computing-service")
    public String computingService(){
        return "COMPUTING-SERVICE-PRODUCER";
    }
}
