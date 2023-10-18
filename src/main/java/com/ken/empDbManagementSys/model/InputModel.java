package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Delete処理のModelクラス
 * @author matsumoto
 *
 */
public class InputModel {
	/**
	 * insert処理
	 * @param emp
	 * @return
	 */
	public int insert(Employee emp){
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		// Insertの実行
		return dao.insert(emp);
	}
}