package jp.co.nagatake.model;

import jp.co.nagatake.database.dao.Employee;
import jp.co.nagatake.database.dao.EmployeeDao;
import jp.co.nagatake.database.dao.EmployeeDaoImpl;

/**
 * UpdateSelctServlet処理のModelクラス
 * @author matsumoto
 *
 */
public class UpdateSelectModel {
	public Employee selectById(int empId){
		// DAOの準備
		EmployeeDao dao = new EmployeeDaoImpl();
		// Selectの実行
		return dao.selectById(empId);
	}
}