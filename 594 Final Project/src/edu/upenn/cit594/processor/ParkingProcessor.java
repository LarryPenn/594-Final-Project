package edu.upenn.cit594.processor;

import java.util.*;
import java.util.Map.Entry;

import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.datamanagement.CSVParkingReader;
import edu.upenn.cit594.datamanagement.JSONParkingReader;
import edu.upenn.cit594.datamanagement.ParkingReader;

public class ParkingProcessor {

    private Population populationData;
    private Parking parkingData;

    public ParkingProcessor(PopulationProcessor processor, CSVParkingReader reader) {
        this.populationData = processor.getData();
        this.parkingData = reader.readParkingData();
    }

    public ParkingProcessor(PopulationProcessor processor, JSONParkingReader reader) {
        this.populationData = processor.getData();
        this.parkingData = reader.readParkingData();
    }

    public void finesPerCapita() {

        HashMap<Integer, Integer> populationMap = populationData.getData();
        HashMap<Integer, Integer> parkingMap = parkingData.getData();
        TreeMap<Integer, Double> tmap = new TreeMap<Integer, Double>();

        for (Integer key : populationMap.keySet() ) {

            if(parkingMap.containsKey(key)) {
                double finesPerCapita = Math.floor((double) parkingMap.get(key)/ (double) populationMap.get(key)*10000)/10000;
                tmap.put(key, finesPerCapita);
            }
        }

        for (Integer key : tmap.keySet()) {
            System.out.print(key+ " " );
            String s = String.format("%.4f", tmap.get(key));
            System.out.println(s);
        }



    }

    public Parking getParkingData() {
        return parkingData;
    }


}