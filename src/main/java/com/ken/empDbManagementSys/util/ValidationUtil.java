package com.ken.empDbManagementSys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationUtil {

	/**
	 * Required field validation
	 * @param value
	 * @return
	 */
	public static boolean validationRequired(String value){
		if(value == null || value.equals("")){
			return false;
		}
		return true;
	}

	/**
	 * Number type input check（accept null）
	 * @param value
	 * @return
	 */
	public static boolean validationInteger(String value){
		// Accept null
		if(!validationRequired(value)){
			return true;
		}
		try{
			Integer.parseInt(value);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}

	/**
	 * Date type input vakidation（accept null）
	 * @param value
	 * @return
	 */
	public static boolean validationDate(String value,String format){
		// Accept null
		if(!validationRequired(value)){
			return true;
		}
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			// Date type convertion
			sdf.parse(value);
		}catch(ParseException e){
			return false;
		}
		return true;
	}


	/**
	 * Login check
	 */
	public static boolean loginCheck(String id){
		if(id != null){
			return true;
		}
		return false;
	}
}
