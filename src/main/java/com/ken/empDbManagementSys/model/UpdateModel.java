package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Input処理のModelクラス
 * @author matsumoto
 *
 */
public class UpdateModel {
	public int update(Employee emp){
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		// updateの実行
		return dao.update(emp);
	}
}