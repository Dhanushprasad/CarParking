package com;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingAllocation {
	static int[] parkingArray = null;
	static int total = 0;
	static int numOfCarsParked = 0;
	static ArrayList<Car> car = new ArrayList<Car>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Car c = new Car();

		String[] splitdata = takeInput();

		// create_parking_lot
		if (splitdata[0].equalsIgnoreCase("create_parking_lot")) {
			create_parking_lot(splitdata);
			main(args);
		}

		// park
		else if (splitdata[0].equalsIgnoreCase("park")) {
			if (numOfCarsParked < total) {
				c.setRegNumber(splitdata[1]);
				c.setColour(splitdata[2]);
				for (int i = 0; i < total; i++) {
					if (parkingArray[i] == 0) {
						parkingArray[i] = 1;
						c.setParkingLot(i + 1);
						car.add(c);
						numOfCarsParked++;
						System.out.println("Allocated slot number: " + c.getParkingLot());
						break;
					}
				}
			} else {
				System.out.println("Sorry, parking lot is full");
			}
			main(args);
		}

		// leave parking lot
		else if (splitdata[0].equalsIgnoreCase("leave")) {
			int index = Integer.parseInt(splitdata[1]);
			for (Car a : car) {
				if (a.getParkingLot() == index) {
					car.remove(a);
					break;
				}
			}
			parkingArray[index - 1] = 0;
			numOfCarsParked--;
			System.out.println("Slot number " + index + " is free");
			main(args);
		}

		// status
		else if (splitdata[0].equalsIgnoreCase("status")) {
			System.out.println("Slot No. Registration No.   Color");
			for (Car a : car) {
				System.out.println(
						a.getParkingLot() + "             " + a.getRegNumber() + "             " + a.getColour());
			}
			main(args);
		}

		// Cars with a particular color
		else if (splitdata[0].equalsIgnoreCase("registration_numbers_for_cars_with_colour")) {
			String color = splitdata[1];
			ArrayList<String> sameColorCar = new ArrayList<String>();
			for (Car a : car) {
				if (a.getColour().equalsIgnoreCase(color)) {
					sameColorCar.add(a.getRegNumber());
				}
			}
			for (String s : sameColorCar) {
				System.out.println(s);
			}
			main(args);
		}

		// slot_number_for_registration_number
		else if (splitdata[0].equalsIgnoreCase("slot_number_for_registration_number")) {
			String regNum = splitdata[1];
			int flag = 0;
			for (Car a : car) {
				if (a.getRegNumber().equalsIgnoreCase(regNum)) {
					System.out.println(a.getParkingLot());
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println("Not found");
			}
			main(args);
		}

		// slot_numbers_for_cars_with_colour
		else if (splitdata[0].equalsIgnoreCase("slot_numbers_for_cars_with_colour")) {
			String color = splitdata[1];
			ArrayList<Integer> carsWithSameColor = new ArrayList<Integer>();
			for (Car a : car) {
				if (a.getColour().equalsIgnoreCase(color)) {
					carsWithSameColor.add(a.getParkingLot());
				}
			}
			for (Integer in : carsWithSameColor) {
				System.out.println(in);
			}
			main(args);
		} else {
			System.out.println("Wrong inputs given!! Please check");
			main(args);
		}
	}

	public static int create_parking_lot(String[] splitdata) {
		total = Integer.parseInt(splitdata[1]);
		parkingArray = new int[Integer.parseInt(splitdata[1])];
		System.out.println("Created a parking lot with " + splitdata[1] + " slots");
		for (int i = 0; i < total; i++) {
			parkingArray[i] = 0;
		}
		return 1;
	}

	public static String[] takeInput() {

		String data = sc.nextLine();
		String[] splitData = splitTheString(data);
		return splitData;
	}

	public static String[] splitTheString(String data) {
		String[] splitData = data.split("\\s");
		return splitData;

	}

}
