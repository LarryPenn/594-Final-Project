package edu.upenn.cit594.datamanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import edu.upenn.cit594.data.Properties;
/*
 * reads properties data from csv to find market value and
 * total liveable area by zipcode
 *
 */
public class CSVPropertiesReader implements PropertiesReader{
	protected String filename;
	
	public CSVPropertiesReader(String name) {
		filename = name;
	}
	
	public Properties readPropertiesData() {
		Properties propertiesData = new Properties();

		BufferedReader br = null;
		String line = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
			line = br.readLine();

			String[] splitLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

			ArrayList<String> lineAsArray = new ArrayList<String>(Arrays.asList(splitLine));

			Integer zipCodePosition = lineAsArray.indexOf("zip_code");
			Integer marketValuePosition = lineAsArray.indexOf("market_value");
			Integer totalLiveableAreaPosition = lineAsArray.indexOf("total_livable_area");

			Integer size = splitLine.length;
			while (line != null) {
				//System.out.println(line);
				splitLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				if (splitLine.length == size) { //this should be the number of categories?
					String potentialZipcode = splitLine[zipCodePosition];

					String potentialMarketValue = splitLine[marketValuePosition];

					String totalLiveableArea = splitLine[totalLiveableAreaPosition];

					if (ReaderUtils.zipcodeCheck(potentialZipcode) && ReaderUtils.propertiesValueCheck(potentialMarketValue) && ReaderUtils.propertiesValueCheck(totalLiveableArea)) {
						propertiesData.addPropertyData(ReaderUtils.getZipcode(potentialZipcode), ReaderUtils.getValueAsDouble(totalLiveableArea), ReaderUtils.getValueAsDouble(potentialMarketValue));
					}

				}

				line = br.readLine();
			}

			br.close();
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}

		return propertiesData;
	}



}
