package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.Properties;

public class AreaParameter implements Parameter{

	@Override
	public int total(int zipCode, Properties properties) {
		
		return properties.getTotalLiveableArea(zipCode);
	}

}
