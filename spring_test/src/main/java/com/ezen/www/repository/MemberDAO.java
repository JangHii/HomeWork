package com.ezen.www.repository;

import com.ezen.www.domain.MemberVO;

public interface MemberDAO {

	MemberVO getUser(String id);

	int insrt(MemberVO mvo);

	void lastLogin(String id);

	void modify(MemberVO mvo);

}
