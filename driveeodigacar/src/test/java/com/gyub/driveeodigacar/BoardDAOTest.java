package com.gyub.driveeodigacar;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gyub.driveeodigacar.board.dao.BoardDAO;
import com.gyub.driveeodigacar.board.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {

	"classpath:spring/root-context.xml",

	"classpath:spring/dataSource-context.xml"

})

public class BoardDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Inject

	private BoardDAO boardDAO;

	@Test
	@Ignore

	public void testGetBoardList() throws Exception {

		List<BoardVO> boardList = boardDAO.getBoardList();

		logger.info("\n Board List \n ");

		if (boardList.size() > 0) {

			for (BoardVO list : boardList) {

				logger.info(list.getTitle());

			}

		} else {

			logger.info("�����Ͱ� �����ϴ�.");

		}

	}

	@Test
	@Ignore

	public void testGetBoardContent() throws Exception {

		BoardVO boardVO = boardDAO.getBoardContent(1L);

		logger.info("\n Board List \n ");

		if (boardVO != null) {

			logger.info("�۹�ȣ : " + boardVO.getId());

			logger.info("������ : " + boardVO.getTitle());

			logger.info("�۳��� : " + boardVO.getContent());

			logger.info("���±� : " + boardVO.getTag());

			logger.info("��ȸ�� : " + boardVO.getViewCount());

			logger.info("�ۼ��� : " + boardVO.getMemberId());

			logger.info("�ۼ��� : " + boardVO.getCreateAt());

			logger.info("������ : " + boardVO.getUpdateAt());

		} else {

			logger.info("�����Ͱ� �����ϴ�.");

		}

	}

	@Test

	public void testInsertBoard() throws Exception {

		BoardVO boardVO = new BoardVO();

		boardVO.setCategoryCode("1");

		//	boardVO.setTitle("ù��° �Խù� �Դϴ�.");

		//	boardVO.setContent("ù��° �Խù��Դϴ�.");

		boardVO.setTag("1");

		boardVO.setMemberId(1L);

		for (int i = 1; i < 1234; i++) {

			boardVO.setTitle(i + " ��° �Խù� �Դϴ�.");

			boardVO.setContent(i + " ��° �Խù� �Դϴ�.");

			int result = boardDAO.insertBoard(boardVO);

			logger.info("\n Insert Board Result " + result);

			if (result == 1) {

				logger.info("\n �Խù� ��� ���� ");

			} else {

				logger.info("\n �Խù� ��� ����");

			}

		}

	}

	@Test
	@Ignore

	public void testUpdateBoard() throws Exception {

		BoardVO boardVO = new BoardVO();

		boardVO.setId(1L);

		boardVO.setCategoryCode("1");

		boardVO.setTitle("ù��° �Խù� �Դϴ�-���� �մϴ�.");

		boardVO.setContent("ù��° �Խù��Դϴ�-�����մϴ�.");

		boardVO.setTag("1-1");

		int result = boardDAO.updateBoard(boardVO);

		logger.info("\n Update Board Result \n ");

		if (result > 0) {

			logger.info("\n �Խù� ���� ���� ");

		} else {

			logger.info("\n �Խù� ���� ����");

		}

	}

	@Test
	@Ignore
	public void tesDeleteBoard() throws Exception {

		int result = boardDAO.deleteBoard(4L);

		logger.info("\n Delete Board Result \n ");

		if (result > 0) {

			logger.info("\n �Խù� ���� ���� ");

		} else {

			logger.info("\n �Խù� ���� ����");

		}

	}

	@Test
	@Ignore

	public void testUpdateViewCnt() throws Exception {

		int result = boardDAO.updateViewCnt(1L);

		logger.info("\n Update View Count Result \n ");

		if (result > 0) {

			logger.info("\n �Խù� ��ȸ�� ������Ʈ ���� ");

		} else {

			logger.info("\n �Խù� ��ȸ�� ������Ʈ ����");

		}

	}

}