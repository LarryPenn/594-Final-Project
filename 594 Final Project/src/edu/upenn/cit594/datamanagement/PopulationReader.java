package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.Population;
/*
 * interface to read population files for
 * population by zipcode 
 */
public interface PopulationReader {

	public Population readPopulationData();
}
