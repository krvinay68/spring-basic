package com.krvinay.annotationbased.dependecyinjection;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{

	@Override
	public void move() {		
		System.out.println("bike is moving");
	}
}
