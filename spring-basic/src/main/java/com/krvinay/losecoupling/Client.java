package com.krvinay.losecoupling;

public class Client {

	public static void main(String []args) {
		
		Vehicle vehicle=new Car();	
		//Vehicle vehicle=new Bike();		
		Traveler traveler=new Traveler(vehicle);
		traveler.startJourney();
	}
}
