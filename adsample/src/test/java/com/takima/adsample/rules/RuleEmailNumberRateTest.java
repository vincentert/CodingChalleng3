package com.takima.adsample.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.takima.adsample.entity.AdSample;
import com.takima.adsample.rule.RuleEmailNumberRate;
import com.takima.adsample.utils.UtilParser;

@SpringBootTest
public class RuleEmailNumberRateTest {
	
	@Autowired
	RuleEmailNumberRate ruleEmailNumberRate;
	
	@Test
	void validateTest() throws IOException, URISyntaxException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.getContacts().setEmail("vincentgiraud88@gmail.com");;
		assertFalse(ruleEmailNumberRate.validate(adSample).isPresent());
	}
	
	@Test
	void NotValideTest() throws IOException, URISyntaxException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.getContacts().setEmail("8888888888ab@gmail.com");
		assertTrue(ruleEmailNumberRate.validate(adSample).isPresent());
	}

}
