package com.takima.adsample.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.takima.adsample.entity.AdSample;
import com.takima.adsample.utils.UtilParser;

@SpringBootTest
public class QuotationClientServiceTest {
	
	@Autowired
	QuotationClientService quotationClientService;
	
	@Test
	void testServiceQuotation() throws IOException, URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		assertEquals(35000f, quotationClientService.getQuotation(adSample.getItem()).get(100, TimeUnit.MILLISECONDS));

	}
	
	
}
