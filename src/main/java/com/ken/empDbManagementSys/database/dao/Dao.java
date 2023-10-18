package com.ken.empDbManagementSys.database.dao;

import java.util.List;

/**
 * Dao
 * @author ken
 *
 */
public interface Dao<E,P> {
	/**
	 * Get data
	 * @return result set
	 */
	public abstract List<E> selectAll();

	/**
	 * Get data by primary key
	 */
	public abstract E selectById(P primaryKey);

	/**
	 * update
	 * @param employee
	 * @return the number of updated data
	 */
	public abstract int update(E entity);

	/**
	 * insert
	 * @param employee
	 * @return the number of updated data
	 */
	public abstract int insert(E entity);

	/**
	 * delete
	 * @param employee
	 * @return the number of updated data
	 */
	public abstract int delete(E entity);

}