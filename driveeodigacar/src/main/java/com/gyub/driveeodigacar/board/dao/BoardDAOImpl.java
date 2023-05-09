package com.gyub.driveeodigacar.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gyub.driveeodigacar.board.model.BoardVO;
import com.gyub.driveeodigacar.common.Search;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return sqlSession.selectList("boardMapper.getBoardList");
	}

	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return sqlSession.selectList("boardMapper.getBoardList", search);
	}

	@Override
	public BoardVO getBoardContent(Long id) throws Exception {
		return sqlSession.selectOne("boardMapper.getBoardContent", id);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("boardMapper.insertBoard", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("boardMapper.updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(Long id) throws Exception {
		return sqlSession.delete("boardMapper.deleteBoard", id);
	}

	@Override
	public int updateViewCnt(Long id) throws Exception {
		return sqlSession.update("boardMapper.updateViewCnt", id);
	}

	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return sqlSession.selectOne("boardMapper.getBoardListCnt", search);
	}
}
