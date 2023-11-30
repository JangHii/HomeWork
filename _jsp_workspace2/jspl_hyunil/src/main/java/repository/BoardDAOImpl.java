package repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import domain.BoardVO;
import orm.DatabaseBuilder;
import service.BoardServiceImpl;

public class BoardDAOImpl implements BoardDAO {

	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	// DB연결
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	// 메서드 구현
	
	@Override
	public int insert(BoardVO bvo) {
		log.info(">>>>>> insert check 3 <<<<<<");
		
		// 실제 DB에 저장 => mybatis / mapper
		
		int isOk = sql.insert("boardMapper.add", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> selecList() {
		log.info(">>>>>> selecList check 3 <<<<<<");
		return sql.selectList("boardMapper.list");
	}

	@Override
	public int readcountUpdate(int bno) {
		log.info(">>>>>> readcountUpdate check 3 <<<<<<");
		
		int isOk = sql.update("boardMapper.read",bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info(">>>>>> getDetail check 3 <<<<<<");
		return sql.selectOne("boardMapper.detail" , bno);
	}


	@Override
	public int update(BoardVO bvo) {
		log.info(">>>>>> update check 3 <<<<<<");
		
		int isOk = sql.update("boardMapper.up", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		log.info(">>>>>> delete check 3 <<<<<<");
		
		int isOk = sql.delete("boardMapper.det", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
