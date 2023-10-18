package com.ken.empDbManagementSys.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ken.empDbManagementSys.form.EmployeeForm;
import com.ken.empDbManagementSys.model.DeleteModel;
import com.ken.empDbManagementSys.model.OutputModel;
import com.ken.empDbManagementSys.util.ValidationUtil;

/**
 * Delete sevlet（Controller）
 * @author ken
 *
 */
public class DeleteServlet extends AbstractServlet<EmployeeForm> {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Page url to transition to
		String url = "";
		// Login check
		if(!loginCheck(req)){
			url = "/login.jsp";
		}
		else{
			// Set character code of request param from input.html to UTF-8
			req.setCharacterEncoding("UTF-8");
			// Create form object having request param
			EmployeeForm form = new EmployeeForm();			
			form.setEmpid(req.getParameter("empid"));
			// Validation
			Map<String,String> list = validation(form);
			if(list.isEmpty()){
				// Get records from db using dao
				DeleteModel model = new DeleteModel();
				model.delete(Integer.parseInt(form.getEmpid()));
			}else{
				// Set error messege in cession
				req.setAttribute("errMsg", list);
			}
			// Get all records from db using db
			OutputModel outputModel = new OutputModel();
			req.setAttribute("list", outputModel.getEmployeeList());
			url = "/output.jsp";
		}
		// Page transitio
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
