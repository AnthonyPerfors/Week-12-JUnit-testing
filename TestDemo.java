package com.promineotech;

import java.util.Random;

public class TestDemo {

	//Our method we will be testing to add positive numbers if they are not positive it will throw an exception
	public int addPositive(int a, int b) {
	
		
		if(a > 0 && b > 0 ) {	
			return a+b;
		}else {
		 throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	//Our method we will be testing to multiply positive random numbers if they are not positive it will throw an exception
	public int multiplyPositive(int a, int b) {
		
		if(a > 0 && b > 0 ) {	
			return a*b;
		}else {
		 throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	//This is selecting a random number from a different method and multiplying itself 
	public int randomNumberSquared() {
		int randomNumber = getRandomInt();
		int result = randomNumber * randomNumber;
		
		return result;
	}
//The method that pulls a random number from 0-10 and adds 1
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}
}
