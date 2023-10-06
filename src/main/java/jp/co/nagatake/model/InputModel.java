package jp.co.nagatake.model;

import jp.co.nagatake.database.dao.Employee;
import jp.co.nagatake.database.dao.EmployeeDao;
import jp.co.nagatake.database.dao.EmployeeDaoImpl;

/**
 * Delete処理のModelクラス
 * @author matsumoto
 *
 */
public class InputModel {
	/**
	 * insert処理
	 * @param emp
	 * @return
	 */
	public int insert(Employee emp){
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		// Insertの実行
		return dao.insert(emp);
	}
}