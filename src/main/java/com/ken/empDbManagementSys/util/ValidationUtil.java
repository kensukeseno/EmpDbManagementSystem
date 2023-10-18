package com.ken.empDbManagementSys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationUtil {

	/**
	 * 必須入力判定
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
	 * 数値型入力チェック（null許容）
	 * @param value
	 * @return
	 */
	public static boolean validationInteger(String value){
		// null値を許容
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
	 * 日付型入力チェック（null許容）
	 * @param value
	 * @return
	 */
	public static boolean validationDate(String value,String format){
		// null値を許容
		if(!validationRequired(value)){
			return true;
		}
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			// Date型変換
			sdf.parse(value);
		}catch(ParseException e){
			return false;
		}
		return true;
	}


	/**
	 * ログインチェック
	 */
	public static boolean loginCheck(String id){
		if(id != null){
			return true;
		}
		return false;
	}
}
