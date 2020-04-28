package edu.upenn.cit594;

import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Properties;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.ParkingProcessor;
import edu.upenn.cit594.processor.PopulationProcessor;
import edu.upenn.cit594.processor.PropertiesProcessor;
import edu.upenn.cit594.ui.userInterface;
import edu.upenn.cit594.data.Data;
public class Main {

    public static void main(String[] args){

        //String parkingFileFormat = "json";
        //String parkingFile = "/Users/sid.sathi/Downloads/CIT594GroupProject-master/parking.json";
        //String propertyFile = "/Users/sid.sathi/594-Final-Project/data/properties_sample2.csv";
        //String populationFile = "/Users/sid.sathi/594-Final-Project/data/population.txt";
        //String logFile = "/Users/sid.sathi/594-Final-Project/data/log.txt";

        if (args.length != 5) {
            System.out.println("invalid args");
            System.exit(0);
        }

        if (!(args[0].equals("csv") || args[0].equals("json"))) {
            System.out.println("invalid args");
            System.exit(0);
        }

        String parkingFileFormat = args[0];
        String parkingFile = args[1];
        String propertyFile = args[2];
        String populationFile = args[3];
        String logFile = args[4];


        Logger l = Logger.getInstance(logFile);l.log("Log is working"); //Logging

        //Initialize our reader
        CSVParkingReader csvParkingReader = new CSVParkingReader(parkingFile);
        CSVPropertiesReader csvPropertiesReader = new CSVPropertiesReader(propertyFile);
        TXTPopulationReader txtPopulationReader = new TXTPopulationReader(populationFile);

        //Do our processing
        PopulationProcessor populationProcessor = new PopulationProcessor(txtPopulationReader);
        if (parkingFileFormat.equals("csv")){
                CSVParkingReader CSVParkingReader = new CSVParkingReader(parkingFile);
                System.out.println("Loaded CSV Parking Reader");
                ParkingProcessor parkingProcessor = new ParkingProcessor(populationProcessor, CSVParkingReader);
                System.out.println("Parking Processor initialized");
                PropertiesProcessor propertiesProcessor = new PropertiesProcessor(csvPropertiesReader, populationProcessor, parkingProcessor);
                System.out.println("Properties Processor initialized");

                userInterface ui = new userInterface(txtPopulationReader, csvParkingReader , csvPropertiesReader, populationProcessor, parkingProcessor, propertiesProcessor);
                ui.askUserForStep();

            } else {
                JSONParkingReader jsonParkingReader= new JSONParkingReader(parkingFile);
                System.out.println("Loaded JSON Parking Reader");
                ParkingProcessor parkingProcessor = new ParkingProcessor(populationProcessor, jsonParkingReader);
                System.out.println("Parking Processor initialized");
                PropertiesProcessor propertiesProcessor = new PropertiesProcessor(csvPropertiesReader, populationProcessor, parkingProcessor);
                userInterface ui = new userInterface(txtPopulationReader, jsonParkingReader , csvPropertiesReader, populationProcessor, parkingProcessor, propertiesProcessor);
                ui.askUserForStep();
        };

    }


}
