package com.gyub.driveeodigacar.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gyub.driveeodigacar.member.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sql;

	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert("memberMapper.register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.login", vo);
	}

	@Override
	public int idChk(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.idChk", vo);
	}
}
