package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAOImpl implements DAO {
	
	// DB�� ����
	// DB�� ���� �����ϴ� ����
	
	// DB�� �����ϴ� ����
	private Connection conn ;
	// sql������ �����Ű�� ����� ���� ��ü
	private PreparedStatement pst;
	// ������ ����
	private String query="";
	
	public ProductDAOImpl() {
		// DB���������� �����ϴ� calss / �̱������� ����
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	// sql ���� ó��
	
	
}
