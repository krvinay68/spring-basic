package com.krvinay.circulardi;


class DependecyA{
	
	private DependecyB dependecyB;
	
	public DependecyA(DependecyB dependecyB) {
		this.dependecyB=dependecyB;
		
	}
	
}
class DependecyB{
	
	private DependecyA dependecyA;
	public DependecyB(DependecyA dependecyA) {
		this.dependecyA=dependecyA;
		
	}
}

public class Circular {

}
