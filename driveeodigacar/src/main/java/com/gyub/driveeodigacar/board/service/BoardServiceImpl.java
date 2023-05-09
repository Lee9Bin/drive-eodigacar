package com.gyub.driveeodigacar.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gyub.driveeodigacar.board.dao.BoardDAO;
import com.gyub.driveeodigacar.board.model.BoardVO;
import com.gyub.driveeodigacar.common.Search;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}

	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return boardDAO.getBoardList(search);
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public BoardVO getBoardContent(Long id) throws Exception {
		boardDAO.updateViewCnt(id); // Increase view count when fetching content
		return boardDAO.getBoardContent(id);
	}

	@Override
	public void deleteBoard(Long id) throws Exception {
		boardDAO.deleteBoard(id);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return boardDAO.getBoardListCnt(search);
	}
}
