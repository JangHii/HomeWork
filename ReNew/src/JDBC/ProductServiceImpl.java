package JDBC;

import com.mysql.cj.protocol.x.XProtocolDecoder;

public class ProductServiceImpl implements Service {

	// ServiceImpl <=> DAO
	
	private DAO dao ; // interface�� ���� -> DAOImpl�� ����
	public ProductServiceImpl() {
		dao = new ProductDAOImpl(); //����ü 
	}
	
	//����
	
}
