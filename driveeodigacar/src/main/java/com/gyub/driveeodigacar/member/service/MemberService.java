package com.gyub.driveeodigacar.member.service;

import com.gyub.driveeodigacar.member.model.MemberVO;

public interface MemberService {

	public void register(MemberVO vo) throws Exception;

	public MemberVO login(MemberVO vo) throws Exception;

	public int idChk(MemberVO vo) throws Exception;

}
