package com.krvinay.annotationbased.dependecyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String []args) {
		
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		
		/*Car car=context.getBean(Car.class);
		car.move();
		
		Bike bike=context.getBean(Bike.class);
		bike.move();*/
		
		Traveler traveler=context.getBean(Traveler.class);
	    traveler.startJourney();;
		
	}
}
