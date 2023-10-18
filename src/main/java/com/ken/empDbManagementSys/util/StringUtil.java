package com.ken.empDbManagementSys.util;

import java.util.Date;

/**
 * String utility class
 * @author ken
 *
 */
public class StringUtil {
	/**
	 * Convert string to string surrounded by single quotations（no convertion for null）
	 * @param value
	 * @return
	 */
	public static <E> String addSymbol(String value,String symbol){
		if(value != null){
			value = symbol + value + symbol;
		}
		return value;
	}

	public static String addSymbol(Date value,String format,String symbol){
		String result = null;
		if(value != null){
			result = symbol + DateUtil.parseString(value, format) + symbol;
		}
		return result;
	}
}
