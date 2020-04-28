package edu.upenn.cit594.datamanagement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Parking;
/*
 * reads a JSON file to find total fines
 * by zipcode
 */
public class JSONParkingReader implements ParkingReader{
	String filename;
	
	public JSONParkingReader(String fn) {
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
				String state = line.get("state").toString();
				if (ReaderUtils.zipcodeCheck(potentialZipcode) && ReaderUtils.valueCheck(potentialFine) && state.equals("PA")) {
					parkingData.updateData(ReaderUtils.getZipcode(potentialZipcode), ReaderUtils.getValue(potentialFine));
				}
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parkingData;
	}

}