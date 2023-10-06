package jp.co.nagatake.database.dao;

import java.util.List;

/**
 * EmployeeDao
 * @author matsumoto
 *
 */
public interface EmployeeDao extends Dao<Employee,Integer>{
	/**
	 * 名前によるあいまい検索
	 * @param name
	 */
	public abstract List<Employee> selectByName(String name);
}