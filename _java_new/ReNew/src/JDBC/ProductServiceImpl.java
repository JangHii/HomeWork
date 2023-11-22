package JDBC;

import java.util.List;

public class ProductServiceImpl implements Service {

	// ServiceImpl <=> DAO
	
	private DAO dao ; // interface�� ���� -> DAOImpl�� ����
	public ProductServiceImpl() {
		dao = new ProductDAOImpl(); //����ü 
	}
	
	
	//����
	
	
	@Override
	public int register(Product p) {
		// ��ǰ��� �޼���
		System.out.println("register_service success!!");
		// dao���� ���Ǵ� �޼���� ���� db���� ����ϴ� ��ɾ�� ����ϰ� �޼��带 �ۼ�
		return dao.insert(p);
	}


	@Override
	public List<Product> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}


	@Override
	public Product detail(int pno) {
		// detail ������ ����
		System.out.println("detail_service success!!");
		// readcount update �� ó���Ǹ� isOk = 1
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
