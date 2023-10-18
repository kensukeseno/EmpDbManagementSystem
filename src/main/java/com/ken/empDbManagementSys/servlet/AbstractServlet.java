package com.ken.empDbManagementSys.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.ken.empDbManagementSys.util.ValidationUtil;

/**
 * 基底サーブレットサンプル
 * サーブレットとしてパラメータのバリデーションチェックを行うことは必須のため、
 * 個々のサーブレットではなく基底クラスに定義する
 *
 * @author matsumoto
 *
 */
public abstract class AbstractServlet<E> extends HttpServlet {
	public static boolean loginCheck(HttpServletRequest req) {
		// ログインチェック
		if(!ValidationUtil.loginCheck((String)req.getSession().getAttribute("loginId"))){
			// エラーメッセージをセッションに設定
			Map<String,String> list = new HashMap<>();
			list.put("loginErrorMsg","セッション情報がタイムアウトしたか不正なログインです");
			req.setAttribute("errMsg", list);
			return false;
		}
		return true;
	}
	/**
	 * 入力チェック
	 * @return
	 */
	abstract protected Map<String,String> validation(E e);
}