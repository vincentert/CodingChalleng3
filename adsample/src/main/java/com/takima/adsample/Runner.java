package com.takima.adsample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;
import com.takima.adsample.entity.Result;
import com.takima.adsample.rule.IadSampleRule;
import com.takima.adsample.rule.Rule;
import com.takima.adsample.rule.RuleFactory;
import com.takima.adsample.utils.UtilParser;

@Component
public class Runner implements CommandLineRunner{

	@Autowired
	RuleFactory ruleFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	@Override
	public void run(String... args) throws IOException, InterruptedException, ExecutionException, TimeoutException  {

		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");

		List<Future<Optional<Rule>>> listFuturOptionalRules = new ArrayList<>();
		
		List<Rule> listRules = new ArrayList<>();

		long msSinceEpoch = System.currentTimeMillis();
		
		

		for(IadSampleRule rule : ruleFactory.getRules()) {
			listFuturOptionalRules.add(rule.validate(adSample));
		}

		listFuturOptionalRules.forEach(e -> {
				try {
					e.get().ifPresent(listRules::add);
				} catch (InterruptedException | ExecutionException e1) {
					logger.error(e1.getMessage());
					Thread.currentThread().interrupt();
				}
		});
		
		logger.debug("Time to execute : {0} ", System.currentTimeMillis()-msSinceEpoch);
			    
		logger.info(new Result(adSample.getReference(), !listRules.isEmpty(), listRules).toString());
			    
	}

}
