package com.ken.empDbManagementSys.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ken.empDbManagementSys.form.EmployeeConverter;
import com.ken.empDbManagementSys.form.EmployeeForm;
import com.ken.empDbManagementSys.model.OutputModel;
import com.ken.empDbManagementSys.model.UpdateSelectModel;
import com.ken.empDbManagementSys.util.ValidationUtil;

/**
 * UpdateSelectサーブレットサンプル（Controller）
 * @author matsumoto
 *
 */
public class UpdateSelectServlet extends AbstractServlet<EmployeeForm> {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// input.htmlから送られたリクエストパラメータの文字コードUTF-8に設定
		req.setCharacterEncoding("UTF-8");
		// ページ遷移先
		String url = "";
		// ログインチェック
		if(!loginCheck(req)){
			url = "/login.jsp";
		}else{
			// リクエストパラメータ値を持つフォームオブジェクトを生成（リフレクションを使えば冗長性の解消は可能）
			EmployeeForm form = new EmployeeForm();
			form.setEmpid(req.getParameter("empid"));
			// バリデーションチェック
			Map<String,String> map = validation(form);
			if(map.isEmpty()){
				// DAOを使用してDBからレコードを取得（Modelクラスに委譲）
				UpdateSelectModel model = new UpdateSelectModel();
				// セッションにエンティティを登録
				req.setAttribute("employeeForm", EmployeeConverter.repositoryToForm(model.selectById(Integer.parseInt(form.getEmpid()))));
				// 正常ページに遷移
				url = "/update.jsp";
			}else{
				// エラーメッセージをセッションに設定
				req.setAttribute("errMsg", map);
				// DAOを使用してDBからテーブルの全レコードを取得（Modelクラスに委譲）
				OutputModel outputModel = new OutputModel();
				req.setAttribute("list", outputModel.getEmployeeList());
				url = "/output.jsp";
			}
		}
		// ページ遷移
		req.getRequestDispatcher(url).forward(req,resp);
	}
	@Override
	public Map<String,String> validation(EmployeeForm form) {
		HashMap<String,String> map = new HashMap<>();
		if(!ValidationUtil.validationRequired(form.getEmpid())){
			map.put("empId","select data to update");
		}
		return map;
	}
}
