package com.krvinay.tightcoupling;

public class Traveler {
	
	Car car=null;
	//Bike bike=null;
	
	public Traveler() {
		
	car=new Car();
	//bike=new Bike();
	}
	public void startJourney() {
		car.move();
		//bike.move();
	}
	

}
