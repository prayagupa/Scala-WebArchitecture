package com.pseudononymous;

public class LicenseNumber {
	
	String number;

	public LicenseNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString(){
		return number;
	}
	
}