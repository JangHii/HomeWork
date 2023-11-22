package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDAOImpl implements DAO {
	
	//DB�� ����
	//DB�� ���� �����ϴ� ����
	
	//DB�� �����ϴ� ����
	private Connection conn;
	//sql������ �����Ű�� ����� ���� ��ü
	private PreparedStatement pst;
	//������ ����
	private String query="";
	
	public ProductDAOImpl() {
		//DB ���������� �����ϴ� class  �̱������� ����
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	//sql ���� ó��
	// executeQuery() / select �������� ��� ResultSet�� ����
	// executeUpdate() / insert, update, delete ������ ������ ����, 0 / 1 �θ� ����
	@Override
	//DB�� ����ϱ�
	public int insert(Product p) {
		// db�� ���� ����
		System.out.println("insert DAO success!!");
		query = "insert into product(pname, price, madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			
			//? ���� setting
			pst.setString(1, p.getPname());
			pst.setInt(2,  p.getPrice());
			pst.setString(3, p.getMadeby());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	//DB���� �� �ҷ�����
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
						rs.getInt("price"),
						rs.getInt("readcount")));
			}
			return list;
			
		} catch (SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		
		return null;
	}
	
	//1���� ��ġ�ؼ� ��������
	@Override
	public Product selectOne(int pno) {
		// TODO Auto-generated method stub
		System.out.println("Detail DAO success!!");
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
						rs.getString("madeby"),
						rs.getInt("readcount"));
			}
				
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("detail error");
			e.printStackTrace();
		}
		return null;
	}
	
	//��ǰ ����
	@Override
	public int update(Product p) {
		// TODO Auto-generated method stub
		System.out.println("update DAO success!!");
		query = "update product set pname=?, price=?, regdate=now(), madeby=? where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			//insert, update, delete : executeUpdate();
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("update error");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public int delete(int pno) {
		System.out.println("delete DAO success!!");
		query = "delete from product where pno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete error");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	@Override
	public int readcountUpdate(int pno) {
		System.out.println("readcount DAO success!!");
		query = "update product set readcount = readcount+1 where pno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,pno);
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("readcount error");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}