package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.Population;

import java.io.*;
import java.util.*;

public class TXTPopulationReader implements PopulationReader{

	String fileName;
	public TXTPopulationReader(String inputFile){
		fileName  = inputFile;
	}
	
	public HashMap<Integer, Integer> readPopulation(){
		//Hashmap for storing the zipcode and population number
		HashMap<Integer,Integer> population = new HashMap<>();
		String line;
		String txtSplitBy =" "; //Split the text by space
		
			BufferedReader in = null;
				try {
					in = new  BufferedReader(new FileReader(fileName));
					//Logger l = Logger.getInstance(); l.log(fileName); //Logging
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while ((line=in.readLine())!= null) {
						String[] populationString=line.split(txtSplitBy);
						if(populationString.length<2)
							continue;
						population.put(Integer.parseInt(populationString[0]), Integer.parseInt(populationString[1]));
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	return population;
	}

	//public static void main(String[] args) {

		//TXTPopulationReader test3 = new TXTPopulationReader("/Users/sid.sathi/594-Final-Project/594 Final Project/population.txt");
		//HashMap<Integer,Integer> population_hashmap = test3.readPopulation();
		//Population population = new Population(population_hashmap);
		//System.out.println(population.getZipCodes());

	//}
}
