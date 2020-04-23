package edu.upenn.cit594.processor;

import java.util.*;

import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.datamanagement.*;

public class PopulationProcessor {
	
	private Population data;
	private int totalPopulation;

	public PopulationProcessor(TXTPopulationReader reader) {
		this.data = reader.readPopulationData();
		totalPopulation = sumPopulation();
	}
	
	public int sumPopulation() {
		
		HashMap<Integer, Integer> map = data.getData();
		
		map.forEach((key,value) -> totalPopulation = totalPopulation + value);
		
		return totalPopulation;
	}

	public int getTotalPopulation() {
		return totalPopulation;
	}

	public Population getData() {
		return data;
	}

	

}
