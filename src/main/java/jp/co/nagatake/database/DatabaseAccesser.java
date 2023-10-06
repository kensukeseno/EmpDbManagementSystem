package jp.co.nagatake.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.nagatake.database.dao.Employee;
import jp.co.nagatake.database.dao.Login;

/**
 * データベースのアクセサクラス
 * @author matsumoto
 *
 */
public class DatabaseAccesser{
	// JDBCドライバ指定
	private static final String DRIVER = "org.postgresql.Driver";
	// データベースサーバのIPおよびポート
	// データベースサーバのIPおよびポート
	private static final String SERVER = "localhost";
	// データベース名
	private static final String DBNAME = "seno_db";
	// URI
	private static final String URL = "jdbc:postgresql://" + SERVER + "/" + DBNAME;
	// データベース作成ユーザパスワード
	private static final String USER = "seno_dbuser";
	private static final String PASSWORD = "seno";


	private Statement stmt;
	private Connection con;

	/**
	 * コネクションオープン（コネクション生成およびステートメントの作成）
	 */
	public void open(){
		try{
			// ドライバの指定
			Class.forName (DRIVER);
			// データベースとの接続
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// ステートメントの作成（SQLをDBに発行するためのオブジェクト）
			stmt = con.createStatement();
		}catch(ClassNotFoundException e){
			System.err.println("ドライバエラー");
			e.printStackTrace ();
		}
		catch (SQLException e) {
			System.err.println("コネクションオープンエラー");
			// スタックトレースの出力
			e.printStackTrace ();
		}
	}

	/**
	 * コネクションクローズ
	 */
	public void close(){
		try{
			// ステートメントのクローズ
			stmt.close();
			// コネクションのクローズ
			con.close();
		}
		catch (SQLException e) {
			System.err.println("コネクションクローズエラー");
			// スタックトレースの出力
			e.printStackTrace ();
		}
	}

	/**
	 * Select文の実行（ORマッピング（DatabaseAccesserに持たせたくはなかった…））
	 * Auto-boxingを使用している
	 * @param sql
	 * @return
	 */
	public List<Employee> executeQueryEmployee(String sql) {
		// DBオープン
		open();
		List<Employee> result = new ArrayList<Employee>();
		try {
			// テーブル照会実行
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Employee employee = new Employee();
				employee.setEmpid(rs.getInt("empid"));
				employee.setName(rs.getString("name"));
				employee.setPhone(rs.getString("phone"));
				employee.setBirthday(rs.getDate("birthday"));
				employee.setAddress(rs.getString("address"));
				employee.setSectionid(rs.getInt("sectionid"));
				employee.setPositionid(rs.getInt("positionid"));
				employee.setBasepay(rs.getInt("basepay"));
				employee.setAllowance(rs.getInt("allowance"));
				result.add(employee);
			}
			// RSのクローズ
			rs.close();
		}catch(SQLException e){
			System.err.println("executeQuery:err");
			// スタックトレースの出力
			e.printStackTrace ();
		}finally{
			// デバッグ用コード
			System.out.println(sql);
			// DBクローズ
			close();
		}
		return result;
	}

	/**
	 * Select文の実行（ORマッピング（DatabaseAccesserに持たせたくはなかった…））
	 * Auto-boxingを使用している
	 * @param sql
	 * @return
	 */
	public List<Login> executeQueryLogin(String sql) {
		// DBオープン
		open();
		List<Login> result = new ArrayList<Login>();
		try {
			// テーブル照会実行
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Login login = new Login();
				login.setId(rs.getInt("id"));
				login.setMailaddress(rs.getString("mailaddress"));
				login.setPass(rs.getString("passwd"));
				result.add(login);
			}
			// RSのクローズ
			rs.close();
		}catch(SQLException e){
			System.err.println("executeQuery:err");
			// スタックトレースの出力
			e.printStackTrace ();
		}finally{
			// デバッグ用コード
			System.out.println(sql);
			// DBクローズ
			close();
		}
		return result;
	}

	/**
	 * Insert,Update,Delete文の実行
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql) {
		// DBオープン
		open();
		int result = 0;
		try {
			// テーブル更新実行
			result = stmt.executeUpdate(sql);
		}catch(SQLException e){
			System.err.println("executeUpdate:err");
			// スタックトレースの出力
			e.printStackTrace ();
		}finally{
			// デバッグ用コード
			System.out.println(sql);
			// DBクローズ
			close();
		}
		return result;
	}

	/*
    public ArrayList<HashMap<String,String>> executeQuery(String sql) {
        ArrayList<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
        try {
            ListUtil util = new ListUtil();
            // テーブル照会実行
            ResultSet rs = stmt.executeQuery(sql);
            // テーブル照会結果を出力
            result = util.arrayListFromResultSet(rs);
            // RSのクローズ
            rs.close();
        }catch(SQLException e){
            System.err.println("executeQuery:err");
            // スタックトレースの出力
            e.printStackTrace ();
        }
        return result;
    }
	 */
}