package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Login;
import com.ken.empDbManagementSys.database.dao.LoginDaoImpl;

/**
 * Login処理のModelクラス
 * @author matsumoto
 *
 */
public class LoginModel {
	/**
	 * select処理
	 * @param
	 * @return
	 */
	public Login selectByMailaddressAndPass(String mailaddress,String pass){
		// DAOの準備
		LoginDaoImpl dao = new LoginDaoImpl();
		// Deleteの実行
		return dao.selectByMailaddressAndPass(mailaddress, pass);
	}
}