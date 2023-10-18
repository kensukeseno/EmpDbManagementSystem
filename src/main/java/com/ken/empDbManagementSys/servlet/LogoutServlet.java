package com.ken.empDbManagementSys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Logout servlet（Controller）
 * @author ken
 *
 */
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Logout
		req.getSession().invalidate();
		// Page transition
		req.getRequestDispatcher("/login.jsp").forward(req,resp);
	}
}
