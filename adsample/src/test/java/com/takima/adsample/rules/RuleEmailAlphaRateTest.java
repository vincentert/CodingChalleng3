package com.takima.adsample.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.takima.adsample.entity.AdSample;
import com.takima.adsample.rule.RuleEmailAlphaRate;
import com.takima.adsample.utils.UtilParser;

@SpringBootTest
public class RuleEmailAlphaRateTest {
	
	@Autowired
	RuleEmailAlphaRate ruleEmailAlphaRate;
	
	@Test
	void validateTest() throws IOException, URISyntaxException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.getContacts().setEmail("vincentgiraud91@gmail.com");
		assertFalse(ruleEmailAlphaRate.validate(adSample).isPresent());
	}
	
	@Test
	void NotValideTest() throws IOException, URISyntaxException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.getContacts().setEmail("........raud91@gmail.com");
		assertTrue(ruleEmailAlphaRate.validate(adSample).isPresent());
	}

}
