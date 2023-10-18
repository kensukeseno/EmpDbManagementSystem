package com.ken.empDbManagementSys.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.ken.empDbManagementSys.util.ValidationUtil;

/**
 * Base servlet
 * Validation method is written in this base class since it is necessary in every servlet
 *
 * @author ken
 *
 */
public abstract class AbstractServlet<E> extends HttpServlet {
	public static boolean loginCheck(HttpServletRequest req) {
		// Login check
		if(!ValidationUtil.loginCheck((String)req.getSession().getAttribute("loginId"))){
			// Set error messege in ces·sion
			Map<String,String> list = new HashMap<>();
			list.put("loginErrorMsg","cession timeout or invalid login");
			req.setAttribute("errMsg", list);
			return false;
		}
		return true;
	}
	/**
	 * Input check
	 * @return
	 */
	abstract protected Map<String,String> validation(E e);
}