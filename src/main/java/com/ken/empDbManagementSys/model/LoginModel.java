package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Login;
import com.ken.empDbManagementSys.database.dao.LoginDaoImpl;

/**
 * Model class for login process
 * @author ken
 *
 */
public class LoginModel {
	/**
	 * select
	 * @param
	 * @return
	 */
	public Login selectByMailaddressAndPass(String mailaddress,String pass){
		// Get DAO object
		LoginDaoImpl dao = new LoginDaoImpl();
		// Implement selection
		return dao.selectByMailaddressAndPass(mailaddress, pass);
	}
}