package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	// executeQuery() / select �������� ��� ResultSet�� ����
	// executeUpdate() / insert , update , delete ������ ������ ���� , 0/1 �θ� ����
	
	@Override
	public int insert(Product p) {
		// db�� ��������
		System.out.println("insert DAO success!!");
		query = "insert into product(pname , price , madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			
			// ? ���� setting
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

	@Override
	public List<Product> selectList() {
		// TODO Auto-generated method stub
		System.out.println("list DAO success!!");
		query = "select * from product order by pno desc";
		List<Product> list = new ArrayList<Product>();
		
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int pno = rs.getInt("pno");
				list.add(new Product(pno,
						rs.getString("pname"),
						rs.getInt("price")));
			}
			return list ;
		} catch (SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Product selectOne(int pno) {
		System.out.println("detail DAO success!!");
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));
			}
		} catch (SQLException e) {
			System.out.println("dettail error");
			e.printStackTrace();
		}
		return null;
	}


	
	
	
}
