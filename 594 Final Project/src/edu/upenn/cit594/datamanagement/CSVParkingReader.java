package edu.upenn.cit594.datamanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import edu.upenn.cit594.data.Parking;

public class CSVParkingReader extends Reader implements ParkingReader  {
	protected String filename;
	
	public CSVParkingReader(String name) {
		filename = name;
	}
	
	public Parking readParkingData() {
		Parking parkingData = new Parking();
		
		BufferedReader br = null;
		String line = null;
		try { 
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
			line = br.readLine();
			
			while (line != null) {
				String[] splitLine = line.split(",");
				if (splitLine.length == 7) {
					System.out.println(line);
					String potentialZipcode = splitLine[6];
					String potentialFine = splitLine[1];
					if (zipcodeCheck(potentialZipcode) && valueCheck(potentialFine)) {
						parkingData.updateData(getZipcode(potentialZipcode), getValue(potentialFine));

								}
							}
		
				line = br.readLine();
			}
			br.close();
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
		
		
		return parkingData;
	}
}
