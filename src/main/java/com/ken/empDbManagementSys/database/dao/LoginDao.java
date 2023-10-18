package com.ken.empDbManagementSys.database.dao;

/**
 * EmployeeDao
 * @author ken
 *
 */
public interface LoginDao extends Dao<Login,String>{
	/**
	 * Search by ID and password
	 * @param id
	 * @param pass
	 * @return
	 */
	public Login selectByMailaddressAndPass(String mailaddress,String pass);
}