package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAOImpl implements DAO {
	
	// DB와 연결
	// DB와 실제 연결하는 구문
	
	// DB와 연결하는 역할
	private Connection conn ;
	// sql구문을 실행시키는 기능을 갖는 객체
	private PreparedStatement pst;
	// 쿼리문 저장
	private String query="";
	
	public ProductDAOImpl() {
		// DB연결정보를 설정하는 calss / 싱글톤으로 생성
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	// sql 구문 처리
	
	
}
