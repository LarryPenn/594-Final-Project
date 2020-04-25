package edu.upenn.cit594.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.upenn.cit594.logging.Logger;

public class Population {

    private static HashMap<Integer, Integer> populations;

    // Constructor
    public Population(HashMap<Integer, Integer> population) {
        this.populations = population;
    }

    //Get methods
    public void add(int i, Integer pop) {
        populations.put(i, pop);
    }

    public static Integer getPopulation(Integer Zip) {
        return populations.get(Zip);
    }

    public static Set<Integer> getZipCodes() {
        return (populations.keySet());
    }

    public static HashMap<Integer, Integer> get() { return populations;}
    }


