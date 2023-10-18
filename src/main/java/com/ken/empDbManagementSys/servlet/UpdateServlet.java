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
 * Update servlet（Controller）
 * @author ken
 *
 */
public class UpdateServlet extends AbstractServlet<EmployeeForm> {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
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
			form.setName(req.getParameter("name"));
			form.setPhone(req.getParameter("phone"));
			form.setAddress(req.getParameter("address"));
			form.setBirthday(req.getParameter("birthday"));			
			form.setSectionid(req.getParameter("sectionid"));
			form.setPositionid(req.getParameter("positionid"));
			form.setBasepay(req.getParameter("basepay"));
			form.setAllowance(req.getParameter("allowance"));			
			// Validation
			Map<String,String> list = validation(form);
			if(list.isEmpty()){
				// Update database using dao
				UpdateModel updateModel = new UpdateModel();
				updateModel.update(EmployeeConverter.formToRepository(form));
				// Get all records from database using dao
				OutputModel outputModel = new OutputModel();
				req.setAttribute("list", outputModel.getEmployeeList());
				url = "/output.jsp";
			}else{
				// Set error messege in cession
				req.setAttribute("errMsg", list);
				// Set user input info in cession
				req.setAttribute("employeeForm", form);
				url = "/update.jsp";
			}
		}
		// Page transition
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
