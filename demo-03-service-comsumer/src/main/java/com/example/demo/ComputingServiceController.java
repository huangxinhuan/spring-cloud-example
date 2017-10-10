package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputingServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("computing-service")
    private String computingService;

    @RequestMapping(path = "/info")
    public String info(){
        return "I'm Computing Service Consumer!";
    }

    @RequestMapping(path = "/{op:add|minus|times|divide}/{first:[0-9\\.]+}/{second:[0-9\\.]+}")
    public String compute(@PathVariable("op") String op,
                          @PathVariable("first") String first,
                          @PathVariable("second") String second){
        String url = String.format("http://%s/%s/%s/%s",computingService,op,first,second);
        Double ans = restTemplate.getForObject(url,Double.class);
        return ans.toString();
    }

}
