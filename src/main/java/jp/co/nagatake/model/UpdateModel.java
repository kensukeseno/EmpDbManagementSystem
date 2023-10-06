package jp.co.nagatake.model;

import jp.co.nagatake.database.dao.Employee;
import jp.co.nagatake.database.dao.EmployeeDao;
import jp.co.nagatake.database.dao.EmployeeDaoImpl;

/**
 * Input処理のModelクラス
 * @author matsumoto
 *
 */
public class UpdateModel {
	public int update(Employee emp){
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		// updateの実行
		return dao.update(emp);
	}
}