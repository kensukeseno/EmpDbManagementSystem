package com.ken.empDbManagementSys.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ken.empDbManagementSys.database.dao.Login;
import com.ken.empDbManagementSys.form.LoginForm;
import com.ken.empDbManagementSys.model.LoginModel;
import com.ken.empDbManagementSys.util.ValidationUtil;

public class LoginServlet extends AbstractServlet<LoginForm> {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// input.htmlから送られたリクエストパラメータの文字コードUTF-8に設定
		req.setCharacterEncoding("UTF-8");
		// リクエストパラメータからフォームオブジェクトを生成
		LoginForm form = new LoginForm();
		form.setMailaddress(req.getParameter("mailaddress"));;
		form.setPass(req.getParameter("pass"));
		// 画面遷移用
		String url = null;
		// バリデーションチェック
		Map<String,String> map = validation(form);
		if(map.isEmpty()){
			// ログインチェック
			// DAOを使用してDBからテーブルのレコードを取得（Modelクラスに委譲）
			LoginModel model = new LoginModel();
			Login login = model.selectByMailaddressAndPass(form.getMailaddress(), form.getPass());
			if(login != null){
				// ログイン情報をセッションに格納
				req.getSession().setAttribute("loginId", form.getMailaddress());
				//正常ページに遷移
				url = "/OutputServlet";
			}else{
				// エラーメッセージをセッションに設定
				map.put("loginerrmsg","ログインに失敗しました");
				req.setAttribute("errMsg", map);
				//正常ページに遷移
				url = "/login.jsp";
			}
		}else{
			// エラーメッセージをセッションに設定
			req.setAttribute("errMsg", map);
			//正常ページに遷移
			url = "/login.jsp";
		}
		// ページ遷移
		req.getRequestDispatcher(url).forward(req,resp);
	}

	@Override
	public Map<String,String> validation(LoginForm form) {
		HashMap<String,String> map = new HashMap<>();
		if(!ValidationUtil.validationRequired(form.getMailaddress())){
			map.put("mailaddress","ユーザ名は必須入力です");
		}
		if(!ValidationUtil.validationRequired(form.getPass())){
			map.put("pass","パスワードは必須入力です");
		}
		return map;
	}
}
