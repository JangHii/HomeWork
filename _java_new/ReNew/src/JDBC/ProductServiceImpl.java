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
		// dao���� ���Ǵ� �޼���� ���� db���� ����ϴ� ���ɾ�� ����ϰ� �޼��带 �ۼ�
		return dao.insert(p);
	}


	@Override
	public List<Product> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}


	@Override
	public Product detail(int pno) {
		System.out.println("detail_service success!!");
		return dao.selectOne(pno);
	}
	
	
}