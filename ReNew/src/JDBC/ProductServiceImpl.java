package JDBC;

import com.mysql.cj.protocol.x.XProtocolDecoder;

public class ProductServiceImpl implements Service {

	// ServiceImpl <=> DAO
	
	private DAO dao ; // interface로 생성 -> DAOImpl로 구현
	public ProductServiceImpl() {
		dao = new ProductDAOImpl(); //구현체 
	}
	
	//구현
	
}
