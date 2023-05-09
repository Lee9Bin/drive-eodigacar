package com.gyub.driveeodigacar.member.dao;

import com.gyub.driveeodigacar.member.model.MemberVO;

public interface MemberDAO {
	void register(MemberVO vo) throws Exception;

	MemberVO login(MemberVO vo) throws Exception;

	int idChk(MemberVO vo) throws Exception;
}
