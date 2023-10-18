package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Model class for update and select process
 * @author ken
 *
 */
public class UpdateSelectModel {
	public Employee selectById(int empId){
		// Get DAO object
		EmployeeDao dao = new EmployeeDaoImpl();
		// Implement selection
		return dao.selectById(empId);
	}
}