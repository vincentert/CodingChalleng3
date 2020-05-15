package com.takima.adsample.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

@Service
public class BlackListClientService {

	private static final List<String> BLACK_LIST_CLIENT = Arrays.asList("9-782940-199617");
	
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<List<String>> getBlackListedClients(String codeEAN) {        
        return executor.submit(() -> {
            Thread.sleep(50);
            return BLACK_LIST_CLIENT;
        });
    }
	
}
