package com;

public class Car {
	private String regNumber;
	private String colour;
	private int parkingLot;
	
	public Car() {
		super();
	}
	
	public Car(String regNumber, String colour, int parkingLot) {
		super();
		this.regNumber = regNumber;
		this.colour = colour;
		this.parkingLot = parkingLot;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", colour=" + colour + ", parkingLot=" + parkingLot + "]";
	}

	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(int parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	
}
