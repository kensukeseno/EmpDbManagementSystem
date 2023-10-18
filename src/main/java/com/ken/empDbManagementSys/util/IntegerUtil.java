package com.ken.empDbManagementSys.util;

public class IntegerUtil {
	/**
	 * Allow null or empty input to Integer.parseInt
	 * Convert null or empty input to 0
	 * @param value
	 * @return
	 */
	public static int parseInt(String value){
		try{
			return Integer.parseInt(value);
		}
		catch(NumberFormatException e){
			return 0;
		}
	}
}
