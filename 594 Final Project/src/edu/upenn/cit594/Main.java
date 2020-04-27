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

public class Main {

    public static void main(String[] args){

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

        Logger l = Logger.getInstance(logFile);l.log(args); //Logging

        CSVParkingReader csvParkingReader = new CSVParkingReader(propertyFile);
        CSVPropertiesReader csvPropertiesReader = new CSVPropertiesReader(propertyFile);
        TXTPopulationReader txtPopulationReader = new TXTPopulationReader(propertyFile);
        PopulationProcessor populationProcessor = new PopulationProcessor(txtPopulationReader);
        //Initialize our readers
        if (parkingFileFormat == "csv"){
            CSVParkingReader CSVParkingReader = new CSVParkingReader(parkingFile);
            ParkingProcessor parkingProcessor = new ParkingProcessor(populationProcessor, CSVParkingReader);
            PropertiesProcessor propertiesProcessor = new PropertiesProcessor(csvPropertiesReader, populationProcessor, parkingProcessor);

        } else {
            JSONParkingReader JSONParkingReader= new JSONParkingReader(parkingFile);
            ParkingProcessor parkingProcessor = new ParkingProcessor(populationProcessor, JSONParkingReader);
            PropertiesProcessor propertiesProcessor = new PropertiesProcessor(csvPropertiesReader, populationProcessor, parkingProcessor);
        }

    }


}
