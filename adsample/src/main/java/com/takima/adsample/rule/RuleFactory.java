package com.takima.adsample.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleFactory {

	@Autowired
	RuleFirstNameLength ruleFirstNameLength;

	@Autowired
	RuleLastNameLength ruleLastNameLength;

	@Autowired
	RuleEmailAlphaRate ruleEmailAlphaRate;

	@Autowired
	RuleEmailNumberRate ruleEmailNumberRate;

	@Autowired
	RulePriceQuotationRate rulePriceQuotationRate;

	@Autowired
	RuleRegisterNumberBlackList ruleRegisterNumberBlackList;


	public List<IadSampleRule> getRules(){

		List<IadSampleRule> rules = new ArrayList<>();

		rules.add(ruleFirstNameLength);
		rules.add(ruleLastNameLength);
		rules.add(ruleEmailAlphaRate);	
		rules.add(ruleEmailNumberRate);
		rules.add(rulePriceQuotationRate);
		rules.add(ruleRegisterNumberBlackList);

		return rules;

	}
}
