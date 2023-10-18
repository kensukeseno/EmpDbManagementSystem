package com.ken.empDbManagementSys.model;

import java.util.ArrayList;
import java.util.List;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.EmployeeDao;
import com.ken.empDbManagementSys.database.dao.EmployeeDaoImpl;

/**
 * OutPut処理のModelクラス
 * @author matsumoto
 *
 */
public class OutputModel {

	public List<Employee> getEmployeeList(){
		return getEmployeeList(null);
	}

	public List<Employee> getEmployeeList(String key){
		List<Employee> result = new ArrayList<Employee>();
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		if(key != null && !key.equals("")){
			result = dao.selectByName(key);
		}else{
			result = dao.selectAll();
		}
		return result;
	}
}