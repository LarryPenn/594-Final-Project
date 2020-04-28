package edu.upenn.cit594.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

//import edu.upenn.cit594.processor.propertiesProcessor;
import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.data.Properties;
//import edu.upenn.cit594.datamanagement.ParkingReader;
import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.ParkingProcessor;
import edu.upenn.cit594.processor.PopulationProcessor;
import edu.upenn.cit594.data.Data;
import edu.upenn.cit594.processor.PropertiesProcessor;
//import edu.upenn.cit594.processor.ParkingProcessor;
//import edu.upenn.cit594.processor.Strategy;
//import edu.upenn.cit594.processor.StrategyAveResidentialMV;
//import edu.upenn.cit594.processor.StrategyAveResidentialTLA;
//import edu.upenn.cit594.processor.populationProcessor;

public class userInterface {

    TXTPopulationReader txtPopulationReader;
    CSVParkingReader csvparkingReader;
    CSVPropertiesReader csvPropertiesReader;
    JSONParkingReader jsonParkingReader;
    PopulationProcessor popProcessor;
    ParkingProcessor parkingProcessor;
    PropertiesProcessor propertiesProcessor;


    public userInterface(TXTPopulationReader txtPopulationReader, CSVParkingReader csvparkingReader, CSVPropertiesReader csvPropertiesReader,
                         PopulationProcessor popProcessor, ParkingProcessor parkingProcessor, PropertiesProcessor propertiesProcessor) {
        this.txtPopulationReader = txtPopulationReader;
        this.csvparkingReader = csvparkingReader;
        this.csvPropertiesReader = csvPropertiesReader;
        this.popProcessor = popProcessor;
        this.parkingProcessor = parkingProcessor;
        this.propertiesProcessor = propertiesProcessor;
    }

    public userInterface(TXTPopulationReader txtPopulationReader, JSONParkingReader jsonParkingReader, CSVPropertiesReader csvPropertiesReader,
                         PopulationProcessor popProcessor, ParkingProcessor parkingProcessor, PropertiesProcessor propertiesProcessor) {
        this.txtPopulationReader = txtPopulationReader;
        this.jsonParkingReader = jsonParkingReader;
        this.csvPropertiesReader = csvPropertiesReader;
        this.popProcessor = popProcessor;
        this.parkingProcessor = parkingProcessor;
        this.propertiesProcessor = propertiesProcessor;
    }

    public void askUserForStep() {
        int step;
        int zipCode;

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        while(true) {
            System.out.println("please specify the action to be performed (type 0~6)"+"\n");
            String userStep = myObj.nextLine();  // Read user input
            Logger l = Logger.getInstance(); l.log(userStep); //Logging

            if(userStep.matches("[0-9]+") && (Integer.parseInt(userStep))<=6&&Integer.parseInt(userStep)>=0)
            {
                step = Integer.parseInt(userStep);
                if (step == 0) {
                    System.exit(0);
                }
                else if (step == 1) {
                    System.out.println(popProcessor.getTotalPopulation());

                }
                else if (step == 2) {
                    // Total fines per capita
                    parkingProcessor.finesPerCapita();
                }

                else if (step == 3) {
                    //Average residential market value
                    //Read user provided zip code
                    zipCode = askUserForZipCode();
                    propertiesProcessor.averageMarketValue(zipCode);
                }

                else if (step == 4) {
                    //Average Residential Total Livable Area
                    //Read user provided zip code
                    zipCode = askUserForZipCode();
                    propertiesProcessor.averageLiveableArea(zipCode);

                }
                else if (step == 5) {
                    //Total Residential Market Value Per Capita
                    zipCode = askUserForZipCode();
                    propertiesProcessor.averageValuePerCapita(zipCode);
                }
                else if (step == 6) {
                    propertiesProcessor.additionalAnalysis();

                }
            }

        }


    }

    public int askUserForZipCode(){
        int zipCode;
        System.out.println("please specify the Zip Code");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        String userZipCode = myObj.nextLine();  // Read user input
        Logger l = Logger.getInstance(); l.log(userZipCode); //Logging
        Data data = new Data();

        if(userZipCode.matches("[0-9]+") && userZipCode.length()==5){
            zipCode=Integer.parseInt(userZipCode);
            return zipCode;
        }
        else {
            return 0;
        }

    }















}


    //public static void main(String[] args) {

    //	userInterface testInput = new userInterface();
    //	testInput.askUserForStep();
    //	testInput.askUserForZipCode();

    //	}
