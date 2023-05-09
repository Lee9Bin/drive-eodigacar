package com.gyub.driveeodigacar.board.service;

import java.util.List;

import com.gyub.driveeodigacar.board.model.BoardVO;
import com.gyub.driveeodigacar.common.Search;

public interface BoardService {

	public List<BoardVO> getBoardList() throws Exception;

	public void insertBoard(BoardVO boardVO) throws Exception;

	public BoardVO getBoardContent(Long id) throws Exception;

	public void deleteBoard(Long id) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;

	//총 게시글 개수 확인
	public List<BoardVO> getBoardList(Search search) throws Exception;

	public int getBoardListCnt(Search search) throws Exception;
}