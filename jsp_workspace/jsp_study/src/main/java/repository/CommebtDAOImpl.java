package repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import orm.DatabaseBuilder;

public class CommebtDAOImpl implements CommentDAO {

	private static Logger log = LoggerFactory.getLogger(CommebtDAOImpl.class);
	
	private SqlSession sql ;
	private int isOk ;
	
	public CommebtDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
}
