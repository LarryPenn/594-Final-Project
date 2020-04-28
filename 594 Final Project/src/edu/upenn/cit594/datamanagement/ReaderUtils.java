package edu.upenn.cit594.datamanagement;
/*
 * class is responsible for methods used across readers
 */
public class ReaderUtils {
	
	public ReaderUtils() {
	}
	
	// will see if a string zipcode is a correct zip code input
	public static boolean zipcodeCheck(String potentialZipcode) {
		if (potentialZipcode.length() >= 5) {
			try {
				Integer.parseInt(potentialZipcode.substring(0,5));
				return true;
			}
			catch (NumberFormatException nfe){
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	// returns a properly formatted integer zipcode from a string
	public static Integer getZipcode(String potentialZipcode) {
		Integer zipcode = Integer.parseInt(potentialZipcode.substring(0,5));
		return zipcode;
	}
	
	// checks if an expected integer value parses correctly
	public static boolean valueCheck(String val) {
		if (val.length() > 0) {
		try {
			Integer.parseInt(val.replaceAll(",",  ""));
			return true;
		} 
		catch (NumberFormatException nfe) {
			return false;
		}
		} else {
			return false;
		}
	}
	
	// converts some potential value to an integer
	public static Integer getValue(String val) {
		Integer value = Integer.parseInt(val.replaceAll(",",  ""));
		return value;
	}
	
	// checks if an expected double value parses correctly
	public static boolean propertiesValueCheck(String val) {
		if (val.length() > 0) {
			try {
				Double.parseDouble(val.replaceAll(",",  ""));
				return true;
			} 
			catch (NumberFormatException nfe) {
				return false;
			}
			} else {
				return false;
			}
		}
	// converts some potential value to a double
	public static Double getValueAsDouble(String val) {
		Double result = Double.parseDouble(val.replaceAll(",",  ""));
		return result;
	}
	
}
