package com.prft.demo.service;

import java.util.logging.Logger;

import com.github.javaparser.utils.Log;
import com.prft.demo.model.ProductPricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @Autowired
    private KieServiceImpl service;

    private static final Logger LOG = Logger.getLogger("DemoController");

    @GetMapping("/echo")
    public String getEcho(){
        return "Hello";
    }

    @PostMapping("/pricing")
    public ProductPricing getPricing(@RequestBody ProductPricing pricing){
        LOG.info("Inside Pricing");
        return service.executePricingRules(pricing);
    }

}
