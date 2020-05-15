package com.takima.adsample.rule;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;

@Component
public class RuleLastNameLength implements IadSampleRule {

	@Override
	public Optional<Rule> validate(AdSample adSample) {
		Rule rule = null;
		if ( adSample.getContacts().getLastName().length() <= 2 ) rule = Rule.RULE_LAST_NAME_LENGTH;
		return Optional.ofNullable(rule);
	}

}
