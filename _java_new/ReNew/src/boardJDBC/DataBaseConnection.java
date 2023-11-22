package boardJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	private static DataBaseConnection dbc = new DataBaseConnection();
	private Connection conn = null ; //자바sql
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
	private String user = "javaUser";
	private String password = "mysql";
	
	private DataBaseConnection() {
		
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버를 찾을수 없습니다.");
		} catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("연결정보가 올바르지 않습니다.");
		}
	}
	
	
	public static DataBaseConnection getInstance() {
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	
	
}
