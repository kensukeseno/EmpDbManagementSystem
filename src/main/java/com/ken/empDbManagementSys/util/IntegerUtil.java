package com.ken.empDbManagementSys.util;

public class IntegerUtil {
	/**
	 * Integer.parseIntのnull・空文字許容版
	 * null・空文字の場合0に変換する
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
