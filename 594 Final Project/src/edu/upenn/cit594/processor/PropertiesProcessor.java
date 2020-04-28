package edu.upenn.cit594.processor;

import java.util.*;
import java.util.Map.Entry;

import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.data.Properties;
import edu.upenn.cit594.datamanagement.CSVPropertiesReader;
import edu.upenn.cit594.datamanagement.ReaderUtils;

public class PropertiesProcessor {

    Properties propertyData;
    Population populationData;
    Parking parkingData;
    HashMap<Integer, Integer> avgMV; //memoization: stores average market value for a given zip code
    HashMap<Integer, Integer> avgLA; //memoization: stores average liveable area for a given zip code
    HashMap<Integer, Integer> avgMVperCap; //memoization: stores average market value per capita for a given zip code


    public PropertiesProcessor(CSVPropertiesReader reader, PopulationProcessor populationProcessor, ParkingProcessor parkingProcessor) {
        this.propertyData = reader.readPropertiesData();
        this.populationData = populationProcessor.getData();
        this.parkingData = parkingProcessor.getParkingData();
        this.avgMV = new HashMap<Integer, Integer>();
        this.avgLA = new HashMap<Integer, Integer>();
        this.avgMVperCap = new HashMap<Integer, Integer>();
    }

    public void averageMarketValue(int zipCode) {

        if (!propertyData.containsZipcode(zipCode)) {
            System.out.println("0");
        }else {

            if (!avgMV.isEmpty() && avgMV.containsKey(zipCode)){                       //memoization
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
            if (!avgLA.isEmpty() && avgLA.containsKey(zipCode)){                       //memoization
                System.out.println(avgLA.get(zipCode));
            }else {
                int average = (int) Math.floor(average(zipCode, new AreaParameter()));  // Strategy design pattern
                System.out.println(average);
                avgLA.put(zipCode, average);
            }
        }
    }

    public double average(int zipCode, Parameter param){

        Double sum = param.total(zipCode, propertyData);
        return sum/propertyData.getTotalResidencies(zipCode);
    }

    public void averageValuePerCapita (int zipCode) {

        if (!propertyData.containsZipcode(zipCode) ||!populationData.containsZipcode(zipCode) ) {
            System.out.println("0");
        }else {
            if (!avgMVperCap.isEmpty() && avgMVperCap.containsKey(zipCode)){
                System.out.println(avgMVperCap.get(zipCode));
            }else {
                Double totalValue = propertyData.getTotalMarketValue(zipCode);
                int population = populationData.getValueByZipcode(zipCode);
                int averageValue = (int) Math.floor(totalValue/population);
                System.out.println(averageValue);
                avgMVperCap.put(zipCode, averageValue);
            }
        }
    }

    public void additionalAnalysis() {

        // For all the zipcodes user has provided, this analysis shows the zipcode with the highest, lowest, and median residential market value and its corresponding fines per capita

        ArrayList<Integer> MVlist = new ArrayList<Integer>(avgMVperCap.values());
        Collections.sort(MVlist);

        if (MVlist.size() > 0) {
            int highest = MVlist.get(MVlist.size() - 1);
            int lowest = MVlist.get(0);
            int median = MVlist.get(Math.round(MVlist.size() / 2));

            int zipcodeHi = 0;
            int zipcodeLo = 0;
            int zipcodeMedian = 0;

            Iterator<Entry<Integer, Integer>> iter = avgMVperCap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) iter.next();
                if (pair.getValue() == highest) {
                    zipcodeHi = pair.getKey();
                }
                if (pair.getValue() == lowest) {
                    zipcodeLo = pair.getKey();
                }
                if (pair.getValue() == median) {
                    zipcodeMedian = pair.getKey();
                }
            }

            double hiFine = 0;
            double loFine = 0;
            double medianFine = 0;
            if(parkingData.containsZipcode(zipcodeHi)){
                hiFine = Math.floor(parkingData.getValueByZipcode(zipcodeHi)/populationData.getValueByZipcode(zipcodeHi)*10000)/10000;
            }
            if(parkingData.containsZipcode(zipcodeLo)){
                loFine = Math.floor(parkingData.getValueByZipcode(zipcodeLo)/populationData.getValueByZipcode(zipcodeLo)*10000)/10000;
            }
            if(parkingData.containsZipcode(zipcodeMedian)){
                medianFine = Math.floor(parkingData.getValueByZipcode(zipcodeMedian)/populationData.getValueByZipcode(zipcodeMedian)*10000)/10000;
            }

            System.out.println("The zipcode with the highest residential value per capita is " + zipcodeHi);
            System.out.println("Its residential value per capita is " + avgMVperCap.get(zipcodeHi) + " and its fines per capita is " + hiFine);
            System.out.println("The zipcode with the lowest residential value per capita is " + zipcodeLo);
            System.out.println("Its residential value per capita is " + avgMVperCap.get(zipcodeLo) + " and its fines per capita is " + loFine);
            System.out.println("The zipcode with the median residential value per capita is " + zipcodeMedian);
            System.out.println("Its residential value per capita is " + avgMVperCap.get(zipcodeMedian) + " and its fines per capita is " + medianFine);

        }
    }

}