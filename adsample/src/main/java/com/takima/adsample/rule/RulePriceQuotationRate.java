package com.takima.adsample.rule;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.takima.adsample.entity.AdSample;
import com.takima.adsample.service.QuotationClientService;

@Component
public class RulePriceQuotationRate implements IadSampleRule {

	@Autowired
	QuotationClientService quotationClientService;

	private ExecutorService executor 
	= Executors.newSingleThreadExecutor();

	@Override
	public Future<Optional<Rule>> validate(AdSample adSample) throws InterruptedException, ExecutionException, TimeoutException {
		return executor.submit(() -> {
			Rule rule = null;

			float quotationClient = quotationClientService.getQuotation(adSample.getItem()).get(100, TimeUnit.MILLISECONDS);

			float diff = Math.abs(adSample.getPrice()-quotationClient);

			if (diff/quotationClient>0.2f) rule = Rule.RULE_PRICE_QUOTATION_RATE;

			return Optional.ofNullable(rule);
		});
	}

}
