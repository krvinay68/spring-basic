package com.krvinay.withjavabasedconfig.dependecyinjection;

public class Car implements Vehicle{

	@Override
	public void move() {		
		System.out.println("car is moving");
	}
}
