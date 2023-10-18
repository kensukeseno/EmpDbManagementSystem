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
		// Set character code of request param from input.html to UTF-8
		req.setCharacterEncoding("UTF-8");
		// Create form object having request param
		LoginForm form = new LoginForm();
		form.setMailaddress(req.getParameter("mailaddress"));;
		form.setPass(req.getParameter("pass"));
		// Page url to transition to
		String url = null;
		// Validation
		Map<String,String> map = validation(form);
		if(map.isEmpty()){
			// Login check
			// Get data from database using dao
			LoginModel model = new LoginModel();
			Login login = model.selectByMailaddressAndPass(form.getMailaddress(), form.getPass());
			if(login != null){
				// Set login ingo in cession
				req.getSession().setAttribute("loginId", form.getMailaddress());
				//Transition to normal page
				url = "/OutputServlet";
			}else{
				// Set error messege in cession
				map.put("loginerrmsg","login failed");
				req.setAttribute("errMsg", map);
				//Transition to normal page
				url = "/login.jsp";
			}
		}else{
			// Set error messege in cession
			req.setAttribute("errMsg", map);
			//Transition to normal page
			url = "/login.jsp";
		}
		// Page transition
		req.getRequestDispatcher(url).forward(req,resp);
	}

	@Override
	public Map<String,String> validation(LoginForm form) {
		HashMap<String,String> map = new HashMap<>();
		if(!ValidationUtil.validationRequired(form.getMailaddress())){
			map.put("mailaddress","username is required");
		}
		if(!ValidationUtil.validationRequired(form.getPass())){
			map.put("pass","password is required");
		}
		return map;
	}
}
