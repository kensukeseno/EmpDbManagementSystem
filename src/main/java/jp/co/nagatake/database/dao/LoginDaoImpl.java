package jp.co.nagatake.database.dao;

import java.util.ArrayList;
import java.util.List;

import jp.co.nagatake.database.DatabaseAccesser;
import jp.co.nagatake.util.StringUtil;

/**
 * EmployeeテーブルDao
 * @author matsumoto
 *
 */
public class LoginDaoImpl implements LoginDao{
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
	private static final String AND = " AND ";
	private static final String TABLE_NAME = " LOGIN ";
	private static final String ALL_COUMNS = " ID,MAILADDRESS,PASSWD";
	private static final String COL_ID = " ID ";
	private static final String COL_PASS = " PASSWD ";
	private static final String COL_MAILADDRESS = " MAILADDRESS ";
	private DatabaseAccesser db;

	/**
	 * コンストラクタ
	 * @param db データベースアクセスオブジェクト
	 */
	public LoginDaoImpl(){
		this.db = new DatabaseAccesser();
	}

	/**
	 * Select文（IDとPASSをキーとした）のSQL実行
	 * @param mailaddress
	 * @param passwd
	 * @return Loginエンティティ
	 */
	@Override
	public Login selectByMailaddressAndPass(String mailaddress, String pass) {
		List<Login> list = new ArrayList<Login>();
		list = db.executeQueryLogin(SELECT + ALL_COUMNS + FROM + TABLE_NAME + WHERE + COL_MAILADDRESS + "=" + StringUtil.addSymbol(mailaddress,"'") + AND + COL_PASS + "=" + StringUtil.addSymbol(pass,"'"));
		if(list == null || list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

	@Override
	public Login selectById(String primaryKey) {
		return null;
	}

	@Override
	public List<Login> selectAll() {
		return db.executeQueryLogin(SELECT + ALL_COUMNS + FROM + TABLE_NAME);
	}

	@Override
	public int update(Login employee) {
		return 0;
	}

	@Override
	public int insert(Login employee) {
		return 0;
	}

	@Override
	public int delete(Login employee) {
		return 0;
	}

}