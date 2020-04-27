package edu.upenn.cit594.datamanagement;

import java.io.Reader;

public class ReaderUtils {

    public ReaderUtils(){

    }

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

    public static Integer getZipcode(String potentialZipcode) {
        Integer zipcode = Integer.parseInt(potentialZipcode.substring(0,5));
        return zipcode;
    }

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

    public static Integer getValue(String val) {
        Integer value = Integer.parseInt(val.replaceAll(",",  ""));
        return value;
    }

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

    public static Double getValueAsDouble(String val) {
        Double result = Double.parseDouble(val.replaceAll(",",  ""));
        return result;
    }

}