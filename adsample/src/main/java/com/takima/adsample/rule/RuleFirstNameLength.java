package com.takima.adsample.rule;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;

@Component
public class RuleFirstNameLength implements IadSampleRule {

	@Override
	public Optional<Rule> validate(AdSample adSample) {
		Rule rule = null;
		if (adSample.getContacts().getFirstName().length() <= 2 ) rule = Rule.RULE_FIRST_NAME_LENGTH;
		return Optional.ofNullable(rule);
	}

}
