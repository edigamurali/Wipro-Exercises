package com.wipro.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) 
	{
		
		Map<String,String> currencyCode=new TreeMap();
        	currencyCode.put("INR", "Indian Rupee");
	        currencyCode.put("USD", "United States Dollar");
	        currencyCode.put("JPY", "Japanese Yen");
	        currencyCode.put("GBP", "British Pound");
	        System.out.println(currencyCode);
	    Iterator<Map.Entry<String, String>> iterator =currencyCode.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String, String> data = iterator.next();
	        System.out.println(data .getKey() + " - " + data .getValue());
	    }
	    
		
	}

}
