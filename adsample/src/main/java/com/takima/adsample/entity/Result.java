package com.takima.adsample.entity;

import java.util.List;

import com.takima.adsample.rule.Rule;

public class Result {
	
	private String reference;
	private boolean scam;
	private List<Rule> rules;
	public Result(String reference, boolean scam, List<Rule> rules) {
		super();
		this.reference = reference;
		this.scam = scam;
		this.rules = rules;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public boolean isScam() {
		return scam;
	}
	public void setScam(boolean scam) {
		this.scam = scam;
	}
	public List<Rule> getRules() {
		return rules;
	}
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
	@Override
	public String toString() {
		return "{reference=" + reference + ", scam=" + scam + ", rules=" + rules + "}";
	}
}
