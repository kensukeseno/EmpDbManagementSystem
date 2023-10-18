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
 * UpdateSelect servlet（Controller）
 * @author ken
 *
 */
public class UpdateSelectServlet extends AbstractServlet<EmployeeForm> {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Set character code of request param from input.html to UTF-8
		req.setCharacterEncoding("UTF-8");
		// Page url to transition to
		String url = "";
		// Login check
		if(!loginCheck(req)){
			url = "/login.jsp";
		}else{
			// Create form object having request param
			EmployeeForm form = new EmployeeForm();
			form.setEmpid(req.getParameter("empid"));
			// Validation
			Map<String,String> map = validation(form);
			if(map.isEmpty()){
				// Get records from database using dao
				UpdateSelectModel model = new UpdateSelectModel();
				// Set entity in cession
				req.setAttribute("employeeForm", EmployeeConverter.repositoryToForm(model.selectById(Integer.parseInt(form.getEmpid()))));
				// Transition to normal page
				url = "/update.jsp";
			}else{
				// Set error messege in cession
				req.setAttribute("errMsg", map);
				// Get all records from database using dao
				OutputModel outputModel = new OutputModel();
				req.setAttribute("list", outputModel.getEmployeeList());
				url = "/output.jsp";
			}
		}
		// Page transition
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
