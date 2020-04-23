import edu.upenn.cit594.datamanagement.*;

import java.util.Scanner;

import edu.upenn.cit594.data.*;
import edu.upenn.cit594.processor.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TXTPopulationReader populationReader = new TXTPopulationReader("population.txt");
		PopulationProcessor populationProcessor = new PopulationProcessor(populationReader);
		//System.out.println(populationProcessor.getTotalPopulation());
		
		CSVParkingReader parkingReader = new CSVParkingReader("parking.csv");
		ParkingProcessor parkingProcessor = new ParkingProcessor(populationProcessor, parkingReader);
		//parkingProcessor.finesPerCapita();
		
		CSVPropertiesReader propertiesReader = new CSVPropertiesReader("properties.csv");
		PropertiesProcessor propertiesProcessor = new PropertiesProcessor(propertiesReader, populationProcessor, parkingProcessor);
		
		
		while(true) {
		System.out.println("Please input zipcode:");
		Scanner in = new Scanner(System.in);
		int zipcode = in.nextInt();
		if (zipcode == 0) {
			break;
		}
		
		propertiesProcessor.averageMarketValue(zipcode);
		propertiesProcessor.averageLiveableArea(zipcode);
		propertiesProcessor.averageValuePerCapita(zipcode);
		propertiesProcessor.additionalAnalysis();
		}

	}

}
