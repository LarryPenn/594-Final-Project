package edu.upenn.cit594.datamanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import edu.upenn.cit594.data.Population;

public class TXTPopulationReader extends Reader{
	protected String filename;
	
	public TXTPopulationReader(String name) {
		filename = name;
	}
	
	public Population readPopulationData() {
		
		Population populationData = new Population();
		BufferedReader br = null;
		String line = null;
		try { 
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
			line = br.readLine();
			while (line != null) {
				String[] lineSplit = line.split("\\s+");
				if (lineSplit.length == 2) {
					if (zipcodeCheck(lineSplit[0]) && valueCheck(lineSplit[1])) {
						populationData.updateData(getZipcode(lineSplit[0]), getValue(lineSplit[1]));
					}
				}
				line = br.readLine();
			}
			
			br.close();
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
		return populationData;
		
	}
}
