package JDBC;

import java.util.List;

public interface DAO {

	int insert(Product p);

	List<Product> selectList();

	Product selectOne(int pno);

	int update(Product p);

	int delete(int pno);

	int readcountUpdate(int pno);


}
