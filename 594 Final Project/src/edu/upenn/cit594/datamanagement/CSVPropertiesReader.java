package edu.upenn.cit594.datamanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import edu.upenn.cit594.data.Properties;

public class CSVPropertiesReader extends Reader{
	protected String filename;
	
	public CSVPropertiesReader(String name) {
		filename = name;
	}
	
	public Properties readPropertiesData() {
		Properties myPropertiesData = new Properties();
		
		BufferedReader br = null;
		String line = null;
		try { 
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
			line = br.readLine();
			while (line != null) {
				
				//code here
				
				line = br.readLine();
			}
			
			br.close();
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
		
		return myPropertiesData;
	}
}
