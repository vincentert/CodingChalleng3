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
import com.takima.adsample.rule.RuleRegisterNumberBlackList;
import com.takima.adsample.utils.UtilParser;

@SpringBootTest
public class RuleRegisterNumberBlackListTest {
	
	@Autowired
	RuleRegisterNumberBlackList RuleRegisterNumberBlackList;
	
	@Test
	void validateTest() throws IOException, URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.getItem().setEanCode("7-7777777-199617");
		assertFalse(RuleRegisterNumberBlackList.validate(adSample).get().isPresent());
	}
	
	@Test
	void NotValideTest() throws IOException, URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		adSample.getItem().setEanCode("9-782940-199617");
		assertTrue(RuleRegisterNumberBlackList.validate(adSample).get().isPresent());
	}

}
