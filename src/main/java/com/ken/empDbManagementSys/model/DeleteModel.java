package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Input処理のModelクラス
 * @author matsumoto
 *
 */
public class DeleteModel {
	/**
	 * delete処理
	 * @param emp
	 * @return
	 */
	public int delete(int emp){
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		Employee employee = new Employee();
		employee.setEmpid(emp);
		// Deleteの実行
		return dao.delete(employee);
	}
}