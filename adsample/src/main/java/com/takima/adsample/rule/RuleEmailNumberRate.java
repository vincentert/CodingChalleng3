package com.takima.adsample.rule;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;

@Component
public class RuleEmailNumberRate implements IadSampleRule {

    private ExecutorService executor 
    = Executors.newSingleThreadExecutor();
	
	@Override
	public Future<Optional<Rule>> validate(AdSample adSample) {
		
		return executor.submit(() -> {
		Rule rule = null;

		String email = adSample.getContacts().getEmail();
		int index = email.indexOf('@');
		
		if(index!=-1) {
			float countNumber = 0f;
			float countTotal = 0f;
			List<Character> emailCut = email.substring(0, index).chars()
		      .mapToObj(item -> (char) item)
		      .collect(Collectors.toList());
			
			for(Character c : emailCut) {		
				if(Character.isDigit(c)) countNumber++;
				countTotal++;
			}
			
			if(countTotal>0f && countNumber/countTotal>0.3) {
				rule = Rule.RULE_EMAIL_NUM_RATE;
			}

		}
		return Optional.ofNullable(rule);
		});
	}

}
