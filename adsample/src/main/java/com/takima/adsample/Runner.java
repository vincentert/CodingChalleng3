package com.takima.adsample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;
import com.takima.adsample.entity.Result;
import com.takima.adsample.rule.IadSampleRule;
import com.takima.adsample.rule.Rule;
import com.takima.adsample.rule.RuleFactory;
import com.takima.adsample.utils.UtilParser;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;

@Component
public class Runner implements CommandLineRunner{
	
	@Autowired
	RuleFactory ruleFactory;
	

	@Override
	public void run(String... args) throws Exception {

		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");

		List<Rule> listRules = new ArrayList<>();
		
	    Observable<IadSampleRule> observable = Observable.fromIterable(ruleFactory.getRules());
			    
		observable.toFlowable(BackpressureStrategy.BUFFER).subscribe(rule -> rule.validate(adSample).ifPresent(listRules::add));		    
		
		System.out.println(new Result(adSample.getReference(), !listRules.isEmpty(), listRules));
	}

}
