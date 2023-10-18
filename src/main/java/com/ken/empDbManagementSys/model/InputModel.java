package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Model class for input process
 * @author ken
 *
 */
public class InputModel {
	/**
	 * insert
	 * @param emp
	 * @return
	 */
	public int insert(Employee emp){
		// Get DAO object
		EmployeeDao dao = new EmployeeDaoImpl();
		// Implement insertion
		return dao.insert(emp);
	}
}