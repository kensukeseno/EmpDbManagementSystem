package com.ken.empDbManagementSys.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.database.dao.Login;

/**
 * Database access class
 * @author ken
 *
 */
public class DatabaseAccesser{
	// Assign JDBC driver
	private static final String DRIVER = "org.postgresql.Driver";
	// IP and port of database server
	private static final String SERVER = "localhost";
	// Database name
	private static final String DBNAME = "empManagement_db";
	// URI
	private static final String URL = "jdbc:postgresql://" + SERVER + "/" + DBNAME;
	// Password of database user
	private static final String USER = "postgres";
	private static final String PASSWORD = "postgre";


	private Statement stmt;
	private Connection con;

	/**
	 * Open connection（create connection and statement）
	 */
	public void open(){
		try{
			// Assign driver
			Class.forName (DRIVER);
			// Connect with databas
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// Create statement（Object to send sql to database）
			stmt = con.createStatement();
		}catch(ClassNotFoundException e){
			System.err.println("driver error");
			e.printStackTrace ();
		}
		catch (SQLException e) {
			System.err.println("connection open exception");
			// Print stack trace
			e.printStackTrace ();
		}
	}

	/**
	 * Close connection
	 */
	public void close(){
		try{
			// Close statement
			stmt.close();
			// Close connection
			con.close();
		}
		catch (SQLException e) {
			System.err.println("connection close error");
			// Print stack trace
			e.printStackTrace ();
		}
	}

	/**
	 * SQL implementation of select statement （OR mapping）
	 * Auto-boxing
	 * @param sql
	 * @return
	 */
	public List<Employee> executeQueryEmployee(String sql) {
		// Open db
		open();
		List<Employee> result = new ArrayList<Employee>();
		try {
			// Get data
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
			// Close RS
			rs.close();
		}catch(SQLException e){
			System.err.println("executeQuery:err");
			// Print stack trace
			e.printStackTrace ();
		}finally{
			// debug
			System.out.println(sql);
			// Close db
			close();
		}
		return result;
	}

	/**
	 * SQL implementation of select statement （OR mapping）
	 * Auto-boxing
	 * @param sql
	 * @return
	 */
	public List<Login> executeQueryLogin(String sql) {
		// Open db
		open();
		List<Login> result = new ArrayList<Login>();
		try {
			// Get data
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Login login = new Login();
				login.setId(rs.getInt("id"));
				login.setMailaddress(rs.getString("mailaddress"));
				login.setPass(rs.getString("passwd"));
				result.add(login);
			}
			// Close RS
			rs.close();
		}catch(SQLException e){
			System.err.println("executeQuery:err");
			// Print stack trace
			e.printStackTrace ();
		}finally{
			// debug
			System.out.println(sql);
			// Close DB
			close();
		}
		return result;
	}

	/**
	 * Implementation of Insert,Update,Delete statements
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql) {
		// Open db
		open();
		int result = 0;
		try {
			// Update
			result = stmt.executeUpdate(sql);
		}catch(SQLException e){
			System.err.println("executeUpdate:err");
			// Print stack trace
			e.printStackTrace ();
		}finally{
			// debug
			System.out.println(sql);
			// Close db
			close();
		}
		return result;
	}
}