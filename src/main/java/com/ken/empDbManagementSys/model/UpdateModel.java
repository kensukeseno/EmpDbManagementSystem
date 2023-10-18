package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Model class for update process
 * @author ken
 *
 */
public class UpdateModel {
	public int update(Employee emp){
		// Get DAO object
		EmployeeDao dao = new EmployeeDaoImpl();
		// Implement update
		return dao.update(emp);
	}
}