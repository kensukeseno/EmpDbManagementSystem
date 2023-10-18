package com.ken.empDbManagementSys.model;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Model class for delete process
 * @author ken
 *
 */
public class DeleteModel {
	/**
	 * delete
	 * @param emp
	 * @return
	 */
	public int delete(int emp){
		// Get DAO object
		EmployeeDao dao = new EmployeeDaoImpl();
		Employee employee = new Employee();
		employee.setEmpid(emp);
		// Implement deletion
		return dao.delete(employee);
	}
}