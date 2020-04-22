package edu.upenn.cit594.data;

import java.util.HashMap;

public class Parking {
	private HashMap<Integer, Integer> parkingData;
	
	Parking() {
		this.parkingData = null;
	}
	/*
	public HashMap<Integer,Integer> returnParkingData() {
		return parkingData;
	}
	*/
	
	public boolean containsZipcode(Integer zipcode) {
		return parkingData.containsKey(zipcode);
	}
	
	public Integer getFine(Integer zipcode) {
		return parkingData.get(zipcode);
		
	}

	public HashMap<Integer, Integer> getParkingData() {
		return parkingData;
	}

	
}
