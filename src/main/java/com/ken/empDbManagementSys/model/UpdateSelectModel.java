package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * UpdateSelctServlet処理のModelクラス
 * @author matsumoto
 *
 */
public class UpdateSelectModel {
	public Employee selectById(int empId){
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		// Selectの実行
		return dao.selectById(empId);
	}
}