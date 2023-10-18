package com.ken.empDbManagementSys.database.dao;

import java.util.List;

import com.ken.empDbManagementSys.database.DatabaseAccesser;
import com.ken.empDbManagementSys.util.DateUtil;
import com.ken.empDbManagementSys.util.StringUtil;

/**
 * Employee table Dao
 * @author ken
 *
 */
public class EmployeeDaoImpl implements EmployeeDao{
	// table constants
	private static final String SELECT = " SELECT ";
	private static final String UPDATE = " UPDATE ";
	private static final String INSERT = " INSERT ";
	private static final String DELETE = " DELETE ";
	private static final String INTO = " INTO ";
	private static final String VALUES = " VALUES ";
	private static final String SET = " SET ";
	private static final String FROM = " FROM ";
	private static final String WHERE = " WHERE ";
	private static final String LIKE = " LIKE ";
	private static final String ORDERBY = " ORDER BY ";
	private static final String TABLE_NAME = " EMPLOYEE ";
	private static final String ALL_COUMNS = " EMPID,NAME,PHONE,BIRTHDAY,ADDRESS,SECTIONID,POSITIONID,BASEPAY,ALLOWANCE";
	private static final String COL_EMPID = " EMPID ";
	private static final String COL_NAME = " NAME ";
	private static final String COL_PHONE = " PHONE ";
	private static final String COL_BIRTHDAY = " BIRTHDAY ";
	private static final String COL_ADDRESS = " ADDRESS ";
	private static final String COL_SECTIONID = " SECTIONID ";
	private static final String COL_POSITIONID = " POSITIONID ";
	private static final String COL_BASEPAY = " BASEPAY ";
	private static final String COL_ALLOWANCE = " ALLOWANCE ";
	private static final String AUTO_ID = "NEXTVAL('employee_empid_seq')";
	private static final String FORMAT = "yyyy-MM-dd";
	private DatabaseAccesser db;

	/**
	 * Constructor
	 * @param db database access object
	 */
	public EmployeeDaoImpl(){
		this.db = new DatabaseAccesser();
	}

	/**
	 * SQL implementation of select statement (all data)
	 * @return List of employee entities
	 */
	@Override
	public List<Employee> selectAll() {
		return db.executeQueryEmployee(SELECT + ALL_COUMNS + FROM + TABLE_NAME + ORDERBY + COL_EMPID);
	}

	/**
	 * SQL implementation of select statement (with primary key constraint)
	 */
	@Override
	public Employee selectById(Integer empid) {
		List<Employee> list = db.executeQueryEmployee(SELECT + ALL_COUMNS + FROM + TABLE_NAME + WHERE + COL_EMPID + "=" + empid);
		Employee result = new Employee();
		if(list != null && list.size() != 0){
			result = list.get(0);
		}
		return result;
	}

	/**
	 * SQL implementation of select statement (pattern Matching by name) 
	 * @param pattern word for name column
	 * @return List of employee entities
	 */
	@Override
	public List<Employee> selectByName(String name) {
		return db.executeQueryEmployee(SELECT + ALL_COUMNS + FROM + TABLE_NAME + WHERE + COL_NAME + LIKE + StringUtil.addSymbol(StringUtil.addSymbol(name,"%"),"'") + ORDERBY + COL_EMPID);
	}

	/**
	 * SQL implementation of update statement
	 * @param sql SQL statement
	 * @return the number of updated data
	 */
	@Override
	public int update(Employee employee){
		int result = 0;
		result = db.executeUpdate(
				UPDATE + TABLE_NAME + SET
				+ COL_EMPID + "=" + employee.getEmpid() + ","
				+ COL_NAME + "=" + StringUtil.addSymbol(employee.getName(),"'") +  ","
				+ COL_PHONE + "=" + StringUtil.addSymbol(employee.getPhone(),"'") +  ","
				+ COL_BIRTHDAY + "=" +  StringUtil.addSymbol(DateUtil.parseString(employee.getBirthday(), FORMAT),"'")  +  ","
				+ COL_ADDRESS + "=" + StringUtil.addSymbol(employee.getAddress(),"'") +  ","
				+ COL_SECTIONID + "=" + employee.getSectionid() +  ","
				+ COL_POSITIONID + "=" + employee.getPositionid() +  ","
				+ COL_BASEPAY + "=" + employee.getBasepay() +  ","
				+ COL_ALLOWANCE + "=" + employee.getAllowance()
				+ WHERE + COL_EMPID + "=" + employee.getEmpid());
		return result;
	}

	/**
	 * SQL implementation of insert statement（auto id assigning）
	 * @param sql SQL statement
	 * @return the number of inserted data
	 */
	@Override
	public int insert(Employee employee){
		int result = 0;
		result = db.executeUpdate(
				INSERT + INTO + TABLE_NAME + VALUES + "(" +
						AUTO_ID + "," +
						StringUtil.addSymbol(employee.getName(),"'") + ","
						+ StringUtil.addSymbol(employee.getPhone(),"'") + ","
						+ StringUtil.addSymbol(employee.getBirthday(),DateUtil.DATE_FORMAT,"'") + ","
						+ StringUtil.addSymbol(employee.getAddress(),"'") + ","
						+ employee.getSectionid() +  ","
						+ employee.getPositionid() +  ","
						+ employee.getBasepay() +  ","
						+ employee.getAllowance() +
				")");
		return result;
	}

	/**
	 * SQL implementation of delete statement
	 * @param sql SQL statement
	 * @return the number of deleted data
	 */
	@Override
	public int delete(Employee employee){
		int result = 0;
		result = db.executeUpdate(DELETE + FROM + TABLE_NAME + WHERE + COL_EMPID + "=" + employee.getEmpid());
		return result;
	}

}