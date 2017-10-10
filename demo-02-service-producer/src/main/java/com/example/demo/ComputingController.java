package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;

@RestController
public class ComputingController {

    private ComputingService<Double> computingService;

    @Value("${server.port}")
    private String port;


    private String host;

    public ComputingController(){
        try {
            host = Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            host = "localhost";
        }
    }

    private static final Logger log = LoggerFactory.getLogger(ComputingController.class);
    @Autowired
    public void setComputingService(ComputingService<Double> computingService){
        this.computingService = computingService;
    }


    @RequestMapping(path = "/info")
    public String info(){
        return "I'm Computing Service Producer!";
    }

    @RequestMapping(path = "/add/{a:[0-9\\.]+}/{b:[0-9\\.]+}")
    public Double add(@PathVariable("a") Double a, @PathVariable("b") Double b){
        log.info("add {} {} from {}:{}",a,b,host,port);
        return computingService.add(a,b);
    }

    @RequestMapping(path = "/minus/{a:[0-9\\.]+}/{b:[0-9\\.]+}")
    public Double minus(@PathVariable("a") Double a, @PathVariable("b") Double b){
        log.info("minus {} {} from {}:{}",a,b,host,port);
        return computingService.minus(a,b);
    }

    @RequestMapping(path = "/times/{a:[\\d\\.]+}/{b:[\\d\\.]+}")
    public Double times(@PathVariable("a") Double a, @PathVariable("b") Double b){
        log.info("times {} {} from {}:{}",a,b,host,port);
        return computingService.times(a,b);
    }

    @RequestMapping(path = "/divide/{a:[\\d\\.]+}/{b:[\\d\\.]+}")
    public Double divide(@PathVariable("a") Double a, @PathVariable("b") Double b){
        log.info("divide {} {} from {}:{}",a,b,host,port);
        return computingService.divide(a,b);
    }
}
