package edu.upenn.cit594.data;

import java.util.ArrayList;
import java.util.HashMap;

public class Properties {
	private HashMap<Integer, ArrayList<Integer>> propertyData;
	// ArrayList.get(0) = totalLiveableArea
	// ArrayList.get(1) = marketValue;
	
	public Properties() {
		this.propertyData = new HashMap<Integer, ArrayList<Integer>>();
	}
	
	public boolean containsZipcode(Integer zipcode) {
		return propertyData.containsKey(zipcode);
	}
	
	public Integer getTotalLiveableArea(Integer zipcode) {
		return propertyData.get(zipcode).get(0);
	}
	
	public Integer getTotalMarketValue(Integer zipcode) {
		return propertyData.get(zipcode).get(1);
	}
	
	public void addPropertyData(Integer zipcode, Integer liveableArea, Integer marketValue) {
		if (containsZipcode(zipcode) == true) {
			liveableArea = getTotalLiveableArea(zipcode) + liveableArea;
			marketValue = getTotalMarketValue(zipcode) + marketValue;
		} 
		ArrayList<Integer> currentPropertyData = new ArrayList<Integer>();
		currentPropertyData.add(0, liveableArea);
		currentPropertyData.add(1, marketValue);
		propertyData.put(zipcode, currentPropertyData);
	}
}
