package com.ken.empDbManagementSys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	// Sate format
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * Change string format
	 * @param value
	 * @return
	 */
	public static Date parseDate(String value,String format){
		Date date = null;
		if(value != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try{
				// Change data type
				date = sdf.parse(value);
			}
			catch(ParseException e){
			}
		}
		return date;
	}
	/**
	 * Change string format
	 * @param value
	 * @return
	 */
	public static String parseString(Date value,String format){
		String  result;
		if(value == null) {
			result = null;
		} else {
			result = new SimpleDateFormat(format).format(value);
		}
		return result;
	}
}