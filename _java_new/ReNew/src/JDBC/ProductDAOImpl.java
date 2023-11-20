package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	@Override
	public int insert(Product p) {
		// db와 직접연결
		System.out.println("insert DAO success!!");
		query = "insert into product(pname , price , madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			
			// ? 값을 setting
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
