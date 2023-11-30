package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	int lastLogin(String id);

	List<MemberVO> getList();

	int modify(MemberVO mvo);

	int remove(String id);


	
}
