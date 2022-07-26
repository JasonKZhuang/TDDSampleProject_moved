package com.jasonz.tddsampleproject.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	public String greet() {
		return "Hey this is from Greeting Service";
	}
}