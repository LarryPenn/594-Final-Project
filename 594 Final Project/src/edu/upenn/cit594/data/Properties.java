package edu.upenn.cit594.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Properties {
	private HashMap<Integer, ArrayList<Double>> propertyData;
	// ArrayList.get(0) = totalLiveableArea
	// ArrayList.get(1) = totalMarketValue;
	// ArrayList.get(2) = numberOfResidencies
	
	public Properties() {
		this.propertyData = new HashMap<Integer, ArrayList<Double>>();
	}
	
	public boolean containsZipcode(Integer zipcode) {
		return propertyData.containsKey(zipcode);
	}
	
	public Double getTotalLiveableArea(Integer zipcode) {
		return propertyData.get(zipcode).get(0);
	}
	
	public Double getTotalMarketValue(Integer zipcode) {
		return propertyData.get(zipcode).get(1);
	}
	public Double getTotalResidencies(Integer zipcode) {
		return propertyData.get(zipcode).get(2);
	}
	
	public void addPropertyData(Integer zipcode, Double liveableArea, Double marketValue) {
		Double numberOFResidencies = 0.0;
		if (containsZipcode(zipcode) == false) {
			numberOFResidencies = 1.0;
		} else {
			liveableArea = getTotalLiveableArea(zipcode) + liveableArea;
			marketValue = getTotalMarketValue(zipcode) + marketValue;
			numberOFResidencies = getTotalResidencies(zipcode)+1;
		} 
		ArrayList<Double> currentPropertyData = new ArrayList<Double>();
		currentPropertyData.add(0, liveableArea);
		currentPropertyData.add(1, marketValue);
		currentPropertyData.add(2, numberOFResidencies);
		propertyData.put(zipcode, currentPropertyData);
	}
	public void printData() {
		for (Entry<Integer, ArrayList<Double>> test : propertyData.entrySet()) {
			System.out.println("The key is: " + test.getKey().toString());
			System.out.println("The total liveable area is: " +test.getValue().get(0).toString());
			System.out.println("The total market value is: " +test.getValue().get(1).toString());
			System.out.println("The total number of residencies is: " +test.getValue().get(2).toString());
		}
	}

}
