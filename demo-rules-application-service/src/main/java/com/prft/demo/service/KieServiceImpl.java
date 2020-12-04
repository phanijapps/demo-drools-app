package com.prft.demo.service;

import java.util.logging.Logger;

import com.prft.demo.model.ProductPricing;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.server.services.api.KieServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KieServiceImpl {

    private final KieContainer kieContainer;

    private static final Logger LOG = Logger.getLogger("KieSession");

	@Autowired
	public KieServiceImpl(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

    public ProductPricing executePricingRules(ProductPricing pricing){
        
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("DemoRuleKS");
        
        LOG.info("Got Kie Session");

       kieSession.execute(pricing);
       
        LOG.info("Rules execution is done");
        return pricing;
    }



}