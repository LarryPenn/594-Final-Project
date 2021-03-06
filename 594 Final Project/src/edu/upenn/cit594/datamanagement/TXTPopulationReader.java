package edu.upenn.cit594.datamanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import edu.upenn.cit594.data.Population;
/*
 * reads population data from a text file to find the total population
 * per zip code
 */
public class TXTPopulationReader implements PopulationReader{
	protected String filename;
	
	public TXTPopulationReader(String name) {
		filename = name;
	}
	
	// finds a "population" from the file
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
					if (ReaderUtils.zipcodeCheck(lineSplit[0]) && ReaderUtils.valueCheck(lineSplit[1])) {
						populationData.updateData(ReaderUtils.getZipcode(lineSplit[0]), ReaderUtils.getValue(lineSplit[1]));
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
