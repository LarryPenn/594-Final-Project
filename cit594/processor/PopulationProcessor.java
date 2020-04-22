package edu.upenn.cit594.processor;

import java.util.*;

import edu.upenn.cit594.data.Population;

public class PopulationProcessor {
	
	private Population data;
	private int totalPopulation;

	public PopulationProcessor(Population data) {
		this.data = data;
		totalPopulation = sumPopulation();
	}
	
	public int sumPopulation() {
		
		HashMap<Integer, Integer> map = data.getPopulationData();
		
		map.forEach((key,value) -> totalPopulation = totalPopulation + value);
		
		return totalPopulation;
	}

	public int getTotalPopulation() {
		return totalPopulation;
	}
	

}
