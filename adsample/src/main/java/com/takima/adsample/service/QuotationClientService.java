package com.takima.adsample.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

import com.takima.adsample.entity.Item;



@Component
public class QuotationClientService {
	
	private static final Float QUOTATION_DEFAULT = 35000f;
	
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	
	public Future<Float> getQuotation(Item item) {        
		return executor.submit(() -> {
            Thread.sleep(50);
            return QUOTATION_DEFAULT;
        });
    }

}
