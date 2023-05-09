package com.gyub.driveeodigacar.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gyub.driveeodigacar.member.dao.MemberDAO;
import com.gyub.driveeodigacar.member.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO dao;

	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}

	@Override
	public int idChk(MemberVO vo) throws Exception {
		return dao.idChk(vo);
	}
}
