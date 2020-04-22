package edu.upenn.cit594.data;

import java.util.HashMap;

public class Population {
	private HashMap<Integer, Integer> populationData;
	
	Population(){
		this.populationData = null;
	}
	
	public boolean containsZipcode(Integer zipcode) {
		return populationData.containsKey(zipcode);
	}
	
	public Integer getPopulation(Integer zipcode) {
		return populationData.get(zipcode);
		
	}
}
