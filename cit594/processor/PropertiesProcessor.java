package edu.upenn.cit594.processor;

import java.util.*;

import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.data.Properties;

public class PropertiesProcessor {
	
	Properties propertyData;
	Population populationData;
	Parking parkingData;
	HashMap<Integer, Integer> avgMV; //memoization: stores average market value for a given zip code
	HashMap<Integer, Integer> avgLA; //memoization: stores average liveable area for a given zip code
	HashMap<Integer, Integer> avgMVperCap; //memoization: stores average market value per capita for a given zip code
	
	
	public PropertiesProcessor(Properties propertyData, Population populationData, Parking parkingData) {
		this.propertyData = propertyData;
		this.populationData = populationData;
		this.parkingData = parkingData;
	}

	public void averageMarketValue(int zipCode) {
		
		if (!propertyData.containsZipcode(zipCode)) {
			System.out.println("0");
		}else {
		if (avgMV.containsKey(zipCode)){                       //memoization
			System.out.println(avgMV.get(zipCode));
		}else {
		int average = (int) Math.floor(average(zipCode, new ValueParameter()));  // Strategy design pattern
		System.out.println(average);
		avgMV.put(zipCode, average);
		}
		}
	}

	public void averageLiveableArea(int zipCode) {
		
		if (!propertyData.containsZipcode(zipCode)) {
			System.out.println("0");
		}else {
			if (avgLA.containsKey(zipCode)){                       //memoization
				System.out.println(avgLA.get(zipCode));
			}else {
		int average = (int) Math.floor(average(zipCode, new AreaParameter()));  // Strategy design pattern
		System.out.println(average);
		avgLA.put(zipCode, average);
		}
		}
	}
		
	public double average(int zipCode, Parameter param){
		
		int sum = param.total(zipCode, propertyData);
		return sum/propertyData.getNumberOfResidence(zipCode);
	}
	
	public void averageValuePerCapita (int zipCode) {
		
		if (avgMVperCap.containsKey(zipCode)){
			System.out.println(avgMVperCap.get(zipCode));
		}else {
		int totalValue = propertyData.getMarketValue(zipCode);
		int population = populationData.getPopulation(zipCode);
		int averageValue = (int) Math.floor(totalValue/population);
		System.out.println(averageValue);
		avgMVperCap.put(zipCode, averageValue);
		}
	}
	
	public void correlationAnalysis() {
		
		/* This analysis shows the correlation between average market value and fines per capita, 
		    by showing the highest, lowest, mean, and median average market value 
		   and their respective fines per capita for that zip code
		*/ 
	
		
		
	
	
	}
	
	
}
