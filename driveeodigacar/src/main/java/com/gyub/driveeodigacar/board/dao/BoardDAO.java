package com.gyub.driveeodigacar.board.dao;

import java.util.List;

import com.gyub.driveeodigacar.board.model.BoardVO;
import com.gyub.driveeodigacar.common.Search;

public interface BoardDAO {

	public List<BoardVO> getBoardList() throws Exception;

	public BoardVO getBoardContent(Long idd) throws Exception;

	public int insertBoard(BoardVO boardVO) throws Exception;

	public int updateBoard(BoardVO boardVO) throws Exception;

	public int deleteBoard(Long id) throws Exception;

	public int updateViewCnt(Long id) throws Exception;

	//총 개시글 개수 확인
	public List<BoardVO> getBoardList(Search search) throws Exception;

	public int getBoardListCnt(Search search) throws Exception;
}