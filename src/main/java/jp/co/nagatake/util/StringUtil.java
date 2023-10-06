package jp.co.nagatake.util;

import java.util.Date;

/**
 * String汎用クラス
 * @author matsumoto
 *
 */
public class StringUtil {
	/**
	 * 渡された文字列をシングルクォーテーションで囲った文字列に変換する（nullはそのまま）
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
