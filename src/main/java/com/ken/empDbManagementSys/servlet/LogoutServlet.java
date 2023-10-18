package com.ken.empDbManagementSys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Logoutサーブレットサンプル（Controller）
 * @author matsumoto
 *
 */
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ログアウト
		req.getSession().invalidate();
		// ページ遷移先
		req.getRequestDispatcher("/login.jsp").forward(req,resp);
	}
}
