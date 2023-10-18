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
import com.ken.empDbManagementSys.model.UpdateModel;
import com.ken.empDbManagementSys.util.DateUtil;
import com.ken.empDbManagementSys.util.ValidationUtil;

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
			map.put("name","employee name is required");
		}
		if(!ValidationUtil.validationRequired(form.getSectionid())){
			map.put("sectionid","section id is required");
		}
		if(!ValidationUtil.validationRequired(form.getPositionid())){
			map.put("positionid","position id is required");
		}
		if(!ValidationUtil.validationDate(form.getBirthday(),DateUtil.DATE_FORMAT)){
			map.put("birthday","birthday must be in" + DateUtil.DATE_FORMAT );
		}
		if(!ValidationUtil.validationInteger(form.getSectionid())){
			map.put("sectionid","section id must be number");
		}
		if(!ValidationUtil.validationInteger(form.getPositionid())){
			map.put("positionid","position id must be number");
		}
		if(!ValidationUtil.validationInteger(form.getBasepay())){
			map.put("basepay","basepay must be number");
		}
		if(!ValidationUtil.validationInteger(form.getAllowance())){
			map.put("allowance","allowance must be number");
		}
		return map;
	}
}
