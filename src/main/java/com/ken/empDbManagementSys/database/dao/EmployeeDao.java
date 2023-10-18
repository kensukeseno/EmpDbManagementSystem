package com.ken.empDbManagementSys.database.dao;

import java.util.List;

/**
 * EmployeeDao
 * @author ken
 *
 */
public interface EmployeeDao extends Dao<Employee,Integer>{
	/**
	 * Pattern Matching by name
	 * @param name
	 */
	public abstract List<Employee> selectByName(String name);
}