package com.ken.empDbManagementSys.model;

import java.util.ArrayList;
import java.util.List;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * Model class for output process
 * @author ken
 *
 */
public class OutputModel {

	public List<Employee> getEmployeeList(){
		return getEmployeeList(null);
	}

	public List<Employee> getEmployeeList(String key){
		List<Employee> result = new ArrayList<Employee>();
		// Get DAO object
		EmployeeDao dao = new EmployeeDaoImpl();
		if(key != null && !key.equals("")){
			result = dao.selectByName(key);
		}else{
			result = dao.selectAll();
		}
		return result;
	}
}