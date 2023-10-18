package com.ken.empDbManagementSys.database.dao;

/**
 * EmployeeDao
 * @author matsumoto
 *
 */
public interface LoginDao extends Dao<Login,String>{
	/**
	 * IDとパスワードによる検索
	 * @param id
	 * @param pass
	 * @return
	 */
	public Login selectByMailaddressAndPass(String mailaddress,String pass);
}