package JDBC;


public class ProductServiceImpl implements Service {

	// ServiceImpl <=> DAO
	
	private DAO dao ; // interface로 생성 -> DAOImpl로 구현
	public ProductServiceImpl() {
		dao = new ProductDAOImpl(); //구현체 
	}
	
	
	//구현
	
	
	@Override
	public int register(Product p) {
		// 상품등록 메서드
		System.out.println("register_service success!!");
		// dao에서 사용되는 메서드는 실제 db에서 사용하는 명령어와 비슷하게 메서드를 작성
		return dao.insert(p);
	}
	
	
}
