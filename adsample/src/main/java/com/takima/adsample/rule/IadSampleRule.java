package com.takima.adsample.rule;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import com.takima.adsample.entity.AdSample;

public interface IadSampleRule {
	
	Optional<Rule> validate(AdSample adSample) throws InterruptedException, ExecutionException, TimeoutException;

}
