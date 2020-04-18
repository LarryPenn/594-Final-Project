package edu.upenn.cit594.data;

import java.util.HashMap;

/*
 *  I would like to rename this: this will
 *  represent the hashmap of zipcodes to
 *  zipcode data
 */
public class Results {
	HashMap<Integer, ZipcodeData> dataByZipCode;
	
	private Results() {
		this.dataByZipCode = new HashMap<Integer,ZipcodeData>();
		
	}
	
	private static Results r = new Results();
	
	public static Results getResults() {
		return r;
	}
}
