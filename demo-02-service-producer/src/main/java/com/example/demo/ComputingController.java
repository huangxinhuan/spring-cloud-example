package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputingController {

    private ComputingService<Double> computingService;


    @Autowired
    public void setComputingService(ComputingService<Double> computingService){
        this.computingService = computingService;
    }


    @RequestMapping(path = "/")
    public String home(){
        return "I'm Computing Service!";
    }

    @RequestMapping(path = "/add/{a:[0-9]+}/{b:[0-9]+}")
    public Double add(@PathVariable("a") Double a, @PathVariable("b") Double b){
        return computingService.add(a,b);
    }

    @RequestMapping(path = "/minus/{a:[0-9]+}/{b:[0-9]+}")
    public Double minus(@PathVariable("a") Double a, @PathVariable("b") Double b){
        return computingService.minus(a,b);
    }

    @RequestMapping(path = "/times/{a:[0-9]+}/{b:[0-9]+}")
    public Double times(@PathVariable("a") Double a, @PathVariable("b") Double b){
        return computingService.times(a,b);
    }

    @RequestMapping(path = "/divide/{a:[0-9]+}/{b:[0-9]+}")
    public Double divide(@PathVariable("a") Double a, @PathVariable("b") Double b){
        return computingService.divide(a,b);
    }
}
