package com.takima.adsample.rule;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;

@Component
public class RuleEmailAlphaRate implements IadSampleRule {

	@Override
	public Optional<Rule> validate(AdSample adSample) {
		Rule rule = null;

		String email = adSample.getContacts().getEmail();
		int index = email.indexOf('@');
		
		if(index!=-1) {
			float countAlphaAndNumber = 0f;
			float countTotal = 0f;
			List<Character> emailCut = email.substring(0, index).chars()
		      .mapToObj(item -> (char) item)
		      .collect(Collectors.toList());
			
			for(Character c : emailCut) {
				if(Character.isDigit(c) || Character.isLetter(c)) countAlphaAndNumber++;
				countTotal++;
			}
			
			if(countTotal>0f && countAlphaAndNumber/countTotal<=0.7) {
				rule = Rule.RULE_EMAIL_ALPHA_RATE;
			}

		}
		return Optional.ofNullable(rule);
	}

}
