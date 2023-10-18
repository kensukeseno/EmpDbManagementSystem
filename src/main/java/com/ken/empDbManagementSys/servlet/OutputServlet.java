package com.ken.empDbManagementSys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ken.empDbManagementSys.model.OutputModel;

/**
 * Output sevlet（Controller）
 * @author ken
 *
 */
public class OutputServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Page url to transition to
		String url = null;
		// Login check
		if(!AbstractServlet.loginCheck(req)){
			url = "/login.jsp";
		}else{
			// Set character code of request param from input.html to UTF-8
			req.setCharacterEncoding("UTF-8");
			// Get request param
			String key = req.getParameter("name");
			// Get records from database using dao
			OutputModel model = new OutputModel();
			req.setAttribute("list", model.getEmployeeList(key));
			url = "/output.jsp";
		}
		// Page transition
		req.getRequestDispatcher(url).forward(req,resp);
	}
}
