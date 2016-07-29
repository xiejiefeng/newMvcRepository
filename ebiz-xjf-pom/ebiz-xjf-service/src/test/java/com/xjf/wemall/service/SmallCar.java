package com.xjf.wemall.service;

import java.util.HashMap;
import java.util.Map;

public class SmallCar extends Car {
	public void dirve(HashMap<String, String> hash) {
		System.out.println("SmallCar");
	}
	
	public void dirve2(Map<String, String> hash) {
		System.out.println("SmallCar");
	}
}
