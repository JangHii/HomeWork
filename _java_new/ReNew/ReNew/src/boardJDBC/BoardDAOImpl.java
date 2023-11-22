package boardJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import JDBC.DatabaseConnection;

public class BoardDAOImpl implements DAO {

	
	//db����
	
	private Connection conn ; 
	private PreparedStatement pst ;
	private String query ;
	private ResultSet rs ;
	
	public BoardDAOImpl() {
		// �����ͺ��̽� ���� ���� ��ü ����
		DataBaseConnection dbc = DataBaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	
	// �޼��� ó��
	
	@Override
	public int insert(BoardVO bv) {
		// 1.�Խ��ǵ��
		System.out.println("insert DAO suceess!!");
		query = "insert into board(title , writer , content) values(?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, bv.getTitle());
			pst.setString(2, bv.getWriter());
			pst.setString(3, bv.getContent());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public List<BoardVO> selectlist() {
		// 2. �۸�Ϻ���
		System.out.println("list DAO suceess!!");
		query = "select * from board";
		List<BoardVO> list = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			 
			while(rs.next()) {
				int bno = rs.getInt("bno"); 
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				String moddate = rs.getString("moddate");
				int readcount = rs.getInt("readcount");
				
				list.add(new BoardVO(bno , title , writer , content , regdate , moddate , readcount));
							
			}
			return list ;
			
		} catch (SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public BoardVO detail(int bno) {
		// 3. �Խñ� �� ����
		System.out.println("Detail DAO success!!");
		query = "select * from board where bno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				return new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getString("moddate"),
						rs.getInt("readcount"));
						
			}
			
		} catch (SQLException e) {
			System.out.println("Detail error");
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int modify(BoardVO bv) {
		// 4. �Խñ� ����
		System.out.println("modify DAO success!!");
		query = "update board set title=? , content=? where bno =?";
		
		try {
			
			pst = conn.prepareStatement(query);
			
			pst.setString(1, bv.getTitle());
			pst.setString(2, bv.getContent());
			pst.setInt(3, bv.getBon());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("modify error");
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public int remove(int bno) {
		// 5. �Խñۻ���
		System.out.println("delete DAO success!!");
		query = "delete from board where bno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("remove error");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
}
