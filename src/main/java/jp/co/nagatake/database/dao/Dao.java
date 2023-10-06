package jp.co.nagatake.database.dao;

import java.util.List;

/**
 * Dao
 * @author matsumoto
 *
 */
public interface Dao<E,P> {
	/**
	 * データの取得
	 * @return 結果セット
	 */
	public abstract List<E> selectAll();

	/**
	 * プライマリキーによるデータの取得
	 */
	public abstract E selectById(P primaryKey);

	/**
	 * update
	 * @param employee
	 * @return 更新件数
	 */
	public abstract int update(E entity);

	/**
	 * insert
	 * @param employee
	 * @return 更新件数
	 */
	public abstract int insert(E entity);

	/**
	 * delete
	 * @param employee
	 * @return 更新件数
	 */
	public abstract int delete(E entity);

}