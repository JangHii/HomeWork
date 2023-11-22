package JDBC;

import java.util.List;

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


	@Override
	public List<Product> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}


	@Override
	public Product detail(int pno) {
		// detail 페이지 열기
		System.out.println("detail_service success!!");
		// readcount update 잘 처리되면 isOk = 1
		int isOk = dao.readcountUpdate(pno);
		return (isOk > 0)? dao.selectOne(pno) : null ;
	}


	@Override
	public int modify(Product p) {
		System.out.println("modify_service success!!");
		return dao.update(p);
	}


	@Override
	public int remove(int pno) {
		System.out.println("romove_service success!!");
		return dao.delete(pno);
	}
	
	
}
