package jp.co.nagatake.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.nagatake.form.EmployeeForm;
import jp.co.nagatake.model.DeleteModel;
import jp.co.nagatake.model.OutputModel;
import jp.co.nagatake.util.ValidationUtil;

/**
 * Deleteサーブレットサンプル（Controller）
 * @author matsumoto
 *
 */
public class DeleteServlet extends AbstractServlet<EmployeeForm> {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ページ遷移先
		String url = "";
		// ログインチェック
		if(!loginCheck(req)){
			url = "/login.jsp";
		}
		else{
			// input.htmlから送られたリクエストパラメータの文字コードUTF-8に設定
			req.setCharacterEncoding("UTF-8");
			// リクエストパラメータ値を持つフォームオブジェクトを生成（リフレクションを使えば冗長性の解消は可能）
			EmployeeForm form = new EmployeeForm();			
			form.setEmpid(req.getParameter("empid"));
			// バリデーションチェック
			Map<String,String> list = validation(form);
			if(list.isEmpty()){
				// DAOを使用してDBからレコードを取得（Modelクラスに委譲）
				DeleteModel model = new DeleteModel();
				model.delete(Integer.parseInt(form.getEmpid()));
			}else{
				// エラーメッセージをセッションに設定
				req.setAttribute("errMsg", list);
			}
			// DAOを使用してDBからテーブルの全レコードを取得（Modelクラスに委譲）
			OutputModel outputModel = new OutputModel();
			req.setAttribute("list", outputModel.getEmployeeList());
			url = "/output.jsp";
		}
		// ページ遷移
		req.getRequestDispatcher(url).forward(req,resp);
	}

	@Override
	public Map<String,String> validation(EmployeeForm form) {
		HashMap<String,String> map = new HashMap<>();
		if(!ValidationUtil.validationRequired(form.getEmpid())){
			map.put("empId","select data to delete");
		}
		return map;
	}
}
