package edu.upenn.cit594.data;

import java.util.ArrayList;
import java.util.HashMap;

public class Properties {
	private HashMap<Integer, ArrayList<Integer>> propertyData;
	// ArrayList.get(0) = totalLiveableArea
	// ArrayList.get(1) = marketValue;
	// ArrayList.get(2) = numberOfResidence;
	
	Properties() {
		this.propertyData = null;
	}
	/*
	private HashMap<Integer, ArrayList<Integer>> returnParkingData() {
		return populationData;
	}
	*/
	public boolean containsZipcode(Integer zipcode) {
		return propertyData.containsKey(zipcode);
	}
	
	public Integer getTotalLiveableArea(Integer zipcode) {
		return propertyData.get(zipcode).get(0);
	}
	
	public Integer getMarketValue(Integer zipcode) {
		return propertyData.get(zipcode).get(1);
	}
	
	public Integer getNumberOfResidence(Integer zipcode) {
		return propertyData.get(zipcode).get(2);
	}
}
