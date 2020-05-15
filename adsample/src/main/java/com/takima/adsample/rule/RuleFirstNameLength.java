package com.takima.adsample.rule;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;

@Component
public class RuleFirstNameLength implements IadSampleRule {

	private ExecutorService executor 
	= Executors.newSingleThreadExecutor();

	@Override
	public Future<Optional<Rule>> validate(AdSample adSample) {

		return executor.submit(() -> {
			Rule rule = null;
			if (adSample.getContacts().getFirstName().length() <= 2 ) rule = Rule.RULE_FIRST_NAME_LENGTH;
			return Optional.ofNullable(rule);
		});
	}

}
