package edu.upenn.cit594.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

#import edu.upenn.cit594.processor.propertiesProcessor;
import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.data.Properties;
#import edu.upenn.cit594.datamanagement.ParkingReader;
import edu.upenn.cit594.logging.Logger;
#import edu.upenn.cit594.processor.ParkingProcessor;
#import edu.upenn.cit594.processor.Strategy;
#import edu.upenn.cit594.processor.StrategyAveResidentialMV;
#import edu.upenn.cit594.processor.StrategyAveResidentialTLA;
#import edu.upenn.cit594.processor.populationProcessor;

public class userInterface {
    HashMap<Integer, Integer> population;
    ArrayList<Parking> parking;
    ArrayList<Properties> properties;

    public userInterface(HashMap<Integer, Integer> population2, ArrayList<Parking> parking2, ArrayList<Properties> properties2) {
        this.population=population2;
        this.parking=parking2;
        this.properties=properties2;
    }

    public void askUserForStep() {
        int step;
        int zipCode;
        int totalPopulation=0;

        //for memorization purpose:
        HashMap<Integer, Double> totalFinesPerCapita=new HashMap<>();
        HashMap<Integer, Double> aveResidentialMV = new HashMap<>() ;
        HashMap<Integer, Double> aveResidentialTLA = new HashMap<>() ;
        HashMap<Integer, Double> mktValuePerCapita = new HashMap<>() ;


        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        while(true) {
            System.out.println("please specify the action to be performed (type 0~6)"+"\n");

            String userStep = myObj.nextLine();  // Read user input
            Logger l = Logger.getInstance(); l.log(userStep); //Logging

            if()
            {
                }
                else if (step == 1) {

                }
                else if (step == 2) {

                }
                else if (step == 3) {

                }
                else if (step == 4) {


                }
                else if (step == 5) {


                }
                else if (step == 6) {

                }
            }
            askUserForStep();
        }
    }

    public int askUserForZipCode() {
        int zipCode;
        System.out.println("please specify the Zip Code");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        String userZipCode = myObj.nextLine();  // Read user input
        Logger l = Logger.getInstance(); l.log(userZipCode); //Logging

        Set<Integer> ZipCodes = Population.getZipCodes();
        if (!ZipCodes.contains(Integer.parseInt(userZipCode))) {
            return 0;
        }

        if(userZipCode.matches("[0-9]+") && userZipCode.length()==5){
            zipCode=Integer.parseInt(userZipCode);
            return zipCode;
        }
        else {
            return 0;
        }
    }


    //public static void main(String[] args) {

    //	userInterface testInput = new userInterface();
    //	testInput.askUserForStep();
    //	testInput.askUserForZipCode();

    //	}

}