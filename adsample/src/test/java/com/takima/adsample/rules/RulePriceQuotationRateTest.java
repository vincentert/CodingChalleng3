package com.takima.adsample.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.takima.adsample.entity.AdSample;
import com.takima.adsample.rule.RulePriceQuotationRate;
import com.takima.adsample.utils.UtilParser;

@SpringBootTest
public class RulePriceQuotationRateTest {
	
	@Autowired
	RulePriceQuotationRate rulePriceQuotationRate;
	
	@Test
	void validateTest() throws IOException, URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.setPrice(33000l);
		assertFalse(rulePriceQuotationRate.validate(adSample).get().isPresent());
	}
	
	@Test
	void NotValideTest() throws IOException, URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.setPrice(50000l);
		assertTrue(rulePriceQuotationRate.validate(adSample).get().isPresent());
	}

}
