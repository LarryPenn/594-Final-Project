package edu.upenn.cit594.datamanagement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Parking;

public class JSONParkingReader extends Reader implements ParkingReader{
	String filename;
	
	JSONParkingReader(String fn) {
		this.filename = fn;
	}

	public Parking readParkingData() {
		
		Parking parkingData = new Parking(); 
		JSONParser parser = new JSONParser();
		JSONArray JSONparkingData = null;
		try {
			JSONparkingData = (JSONArray)parser.parse(new FileReader(filename));
			@SuppressWarnings("rawtypes")
			Iterator iter = JSONparkingData.iterator();
			while (iter.hasNext()) {
				JSONObject line = (JSONObject) iter.next();
				String potentialZipcode = line.get("zip_code").toString();
				String potentialFine = line.get("fine").toString();
				if (zipcodeCheck(potentialZipcode) && valueCheck(potentialFine)) {
					parkingData.updateData(getZipcode(potentialZipcode), getValue(potentialFine));
				}
			}
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parkingData;
	}

}
