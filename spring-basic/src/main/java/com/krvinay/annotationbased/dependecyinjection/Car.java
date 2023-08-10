package com.krvinay.annotationbased.dependecyinjection;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

	@Override
	public void move() {		
		System.out.println("car is moving");
	}
}
