package jp.co.nagatake.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.nagatake.form.EmployeeConverter;
import jp.co.nagatake.form.EmployeeForm;
import jp.co.nagatake.model.OutputModel;
import jp.co.nagatake.model.UpdateModel;
import jp.co.nagatake.util.DateUtil;
import jp.co.nagatake.util.ValidationUtil;

/**
 * Updateサーブレットサンプル（Controller）
 * @author matsumoto
 *
 */
public class UpdateServlet extends AbstractServlet<EmployeeForm> {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// input.htmlから送られたリクエストパラメータの文字コードUTF-8に設定
		req.setCharacterEncoding("UTF-8");
		// ページ遷移先
		String url = "";
		// ログインチェック
		// ログインチェック
		if(!loginCheck(req)){
			url = "/login.jsp";
		}else{
			// リクエストパラメータ値を持つフォームオブジェクトを生成（リフレクションを使えば冗長性の解消は可能）
			EmployeeForm form = new EmployeeForm();
			form.setEmpid(req.getParameter("empid"));			
			form.setName(req.getParameter("name"));
			form.setPhone(req.getParameter("phone"));
			form.setAddress(req.getParameter("address"));
			form.setBirthday(req.getParameter("birthday"));			
			form.setSectionid(req.getParameter("sectionid"));
			form.setPositionid(req.getParameter("positionid"));
			form.setBasepay(req.getParameter("basepay"));
			form.setAllowance(req.getParameter("allowance"));			
			// バリデーションチェック
			Map<String,String> list = validation(form);
			if(list.isEmpty()){
				// DAOを使用してDBのデータを更新（Modelクラスに委譲）
				UpdateModel updateModel = new UpdateModel();
				updateModel.update(EmployeeConverter.formToRepository(form));
				// DAOを使用してDBからテーブルの全レコードを取得（Modelクラスに委譲）
				OutputModel outputModel = new OutputModel();
				req.setAttribute("list", outputModel.getEmployeeList());
				url = "/output.jsp";
			}else{
				// エラーメッセージをセッションに設定
				req.setAttribute("errMsg", list);
				// ユーザ入力情報をセッションに登録
				req.setAttribute("employeeForm", form);
				url = "/update.jsp";
			}
		}
		// ページ遷移
		req.getRequestDispatcher(url).forward(req,resp);
	}

	@Override
	public Map<String,String> validation(EmployeeForm form) {
		HashMap<String,String> map = new HashMap<>();
		if(!ValidationUtil.validationRequired(form.getName())){
			map.put("name","社員名は必須入力です");
		}
		if(!ValidationUtil.validationRequired(form.getSectionid())){
			map.put("sectionid","部署IDは必須入力です");
		}
		if(!ValidationUtil.validationRequired(form.getPositionid())){
			map.put("positionid","役職IDは必須入力です");
		}
		if(!ValidationUtil.validationDate(form.getBirthday(),DateUtil.DATE_FORMAT)){
			map.put("birthday","誕生日は日付型（" + DateUtil.DATE_FORMAT + "）で入力して下さい");
		}
		if(!ValidationUtil.validationInteger(form.getSectionid())){
			map.put("sectionid","部署IDは数値型で入力して下さい");
		}
		if(!ValidationUtil.validationInteger(form.getPositionid())){
			map.put("positionid","役職IDは数値型で入力して下さい");
		}
		if(!ValidationUtil.validationInteger(form.getBasepay())){
			map.put("basepay","基本給は数値型で入力して下さい");
		}
		if(!ValidationUtil.validationInteger(form.getAllowance())){
			map.put("allowance","手当は数値型で入力して下さい");
		}
		return map;
	}
}
