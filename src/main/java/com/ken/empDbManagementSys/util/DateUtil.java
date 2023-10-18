package com.ken.empDbManagementSys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	// 日付フォーマット
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * 文字列を指定したフォーマットで日付型に変換
	 * @param value
	 * @return
	 */
	public static Date parseDate(String value,String format){
		Date date = null;
		if(value != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try{
				// Date型変換
				date = sdf.parse(value);
			}
			catch(ParseException e){
			}
		}
		return date;
	}
	/**
	 * 日付を指定したフォーマットで文字列型に変換
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