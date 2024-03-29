package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;

public class CommentDAOImpl implements CommentDAO {

	private static Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	
	private SqlSession sql ;
	private int isOk ;
	
	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		log.info("comment post check3");
		isOk = sql.insert("CommentMapper.post" , cvo);
		if(isOk > 0) sql.commit();
		return isOk;
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info("comment list check3");
		return sql.selectList("CommentMapper.list" , bno);
	}

	@Override
	public int delete(int cno) {
		log.info("comment dlelete check3");
		isOk = sql.delete("CommentMapper.del", cno);
		if(isOk > 0)sql.commit();
		return isOk;
	}

	@Override
	public int modify(CommentVO cvo) {
		log.info("comment modify check3");
		isOk = sql.update("CommentMapper.mod" , cvo);
		if(isOk > 0)sql.commit();
		return isOk;
	}
	
}