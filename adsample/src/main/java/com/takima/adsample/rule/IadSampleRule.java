package com.takima.adsample.rule;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import com.takima.adsample.entity.AdSample;

public interface IadSampleRule {
	
	Future<Optional<Rule>> validate(AdSample adSample) throws InterruptedException, ExecutionException, TimeoutException;

}
