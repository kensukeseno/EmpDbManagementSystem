package jp.co.nagatake.database.dao;

import java.util.List;

import jp.co.nagatake.database.DatabaseAccesser;
import jp.co.nagatake.util.DateUtil;
import jp.co.nagatake.util.StringUtil;

/**
 * EmployeeテーブルDao
 * @author matsumoto
 *
 */
public class EmployeeDaoImpl implements EmployeeDao{
	// テーブル定数
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
	 * コンストラクタ
	 * @param db データベースアクセスオブジェクト
	 */
	public EmployeeDaoImpl(){
		this.db = new DatabaseAccesser();
	}

	/**
	 * Select文（全データ）のSQL実行
	 * @return Employeeエンティティを格納したList
	 */
	@Override
	public List<Employee> selectAll() {
		return db.executeQueryEmployee(SELECT + ALL_COUMNS + FROM + TABLE_NAME + ORDERBY + COL_EMPID);
	}

	/**
	 * Select文（プライマリキー検索）のSQL実行
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
	 * Select文（名前によるあいまい検索）のSQL実行
	 * @param 名前カラムに対するあいまい検索キーワード
	 * @return Employeeエンティティを格納したList
	 */
	@Override
	public List<Employee> selectByName(String name) {
		return db.executeQueryEmployee(SELECT + ALL_COUMNS + FROM + TABLE_NAME + WHERE + COL_NAME + LIKE + StringUtil.addSymbol(StringUtil.addSymbol(name,"%"),"'") + ORDERBY + COL_EMPID);
	}

	/**
	 * Update文のSQL実行
	 * @param sql SQL文
	 * @return 更新件数
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
	 * Insert文のSQL実行（ID自動採番）
	 * @param sql SQL文
	 * @return 更新件数
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
	 * Delete文のSQL実行
	 * @param sql SQL文
	 * @return 更新件数
	 */
	@Override
	public int delete(Employee employee){
		int result = 0;
		result = db.executeUpdate(DELETE + FROM + TABLE_NAME + WHERE + COL_EMPID + "=" + employee.getEmpid());
		return result;
	}

}