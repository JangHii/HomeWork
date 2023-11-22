package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	// DB 접속
	// DB Driver , URL , user , password
	// driver :  com.mysql.cj.jdbc.Driver
	// url : jdbc:mysql://localhost:3306/db명(javadb)
	// user : javaUser
	// password : mysql
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null ;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
	
	private DatabaseConnection() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "javaUser", "mysql");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
	}
	
	public static DatabaseConnection getInstance() {
		return dbc ;
	}
	
	public Connection getConnection() {
		return conn ;
	}

}
