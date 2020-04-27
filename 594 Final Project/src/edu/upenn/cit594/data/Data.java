package edu.upenn.cit594.data;

import java.util.HashMap;
import java.util.Map;
/*
 * used to create data for mapping a zipcode
 * to one type of integer data
 */
public class Data {
    protected HashMap<Integer, Integer> data;

    public Data() {
        this.data = new HashMap<Integer, Integer>();
    }

    public boolean containsZipcode(Integer zipcode) {
        return data.containsKey(zipcode);
    }

    public Integer getValueByZipcode(Integer zipcode) {
        return data.get(zipcode);
    }
    public void updateData(Integer zipcode, Integer updateData) {
        if (containsZipcode(zipcode)) {
            updateData = getValueByZipcode(zipcode) + updateData;
        }
        data.put(zipcode, updateData);
    }

    public HashMap<Integer, Integer> getData() {
        return data;
    }


    //testing methods
    public void printCurrentData() {
        for (Map.Entry<Integer, Integer> ele : data.entrySet()) {
            System.out.println("The zipcode is: " +ele.getKey().toString());
            System.out.println("The value is: "+ele.getValue().toString());
        }
    }
}