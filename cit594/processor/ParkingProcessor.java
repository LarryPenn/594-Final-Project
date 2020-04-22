package edu.upenn.cit594.processor;

import java.util.*;

import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Population;

public class ParkingProcessor {

	private Population populationData;
	private Parking parkingData;
	
	
	public ParkingProcessor(Population populationData, Parking parkingData) {
		this.populationData = populationData;
		this.parkingData = parkingData;	
	}
	
	public void finesPerCapita() {
		
		HashMap<Integer, Integer> populationMap = populationData.getPopulationData();
		HashMap<Integer, Integer> parkingMap = parkingData.getParkingData();
		TreeMap<Integer, Double> tmap = new TreeMap<Integer, Double>(); 
		
		populationMap.forEach((key,value) -> tmap.put(key, (double) (parkingMap.get(key)/value)));
		
		for (Map.Entry m:tmap.entrySet()) {
	          System.out.println(m.getKey() +  " " +  Math.floor((Double) m.getValue() *10000) / 10000); 
		}
	}
}
