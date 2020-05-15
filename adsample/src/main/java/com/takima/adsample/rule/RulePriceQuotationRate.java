package com.takima.adsample.rule;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
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

	@Override
	public Optional<Rule> validate(AdSample adSample) throws InterruptedException, ExecutionException, TimeoutException {

			Rule rule = null;

			float quotationClient = quotationClientService.getQuotation(adSample.getItem()).get(100, TimeUnit.MILLISECONDS);

			float diff = Math.abs(adSample.getPrice()-quotationClient);
			
			if (diff/quotationClient>0.2f) rule = Rule.RULE_PRICE_QUOTATION_RATE;

			return Optional.ofNullable(rule);
	}

}
