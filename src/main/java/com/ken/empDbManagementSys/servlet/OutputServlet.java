package com.ken.empDbManagementSys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ken.empDbManagementSys.model.OutputModel;

/**
 * Outputサーブレットサンプル（Controller）
 * @author matsumoto
 *
 */
public class OutputServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 画面遷移用
		String url = null;
		// ログインチェック
		if(!AbstractServlet.loginCheck(req)){
			url = "/login.jsp";
		}else{
			// output.jspから送られたリクエストパラメータの文字コードUTF-8に設定
			req.setCharacterEncoding("UTF-8");
			// リクエストパラメータの取得
			String key = req.getParameter("name");
			// DAOを使用してDBからテーブルのレコードを取得（Modelクラスに委譲）
			OutputModel model = new OutputModel();
			req.setAttribute("list", model.getEmployeeList(key));
			url = "/output.jsp";
		}
		// ページ遷移
		req.getRequestDispatcher(url).forward(req,resp);
	}
}
