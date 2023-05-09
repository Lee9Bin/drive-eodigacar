package com.gyub.driveeodigacar.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gyub.driveeodigacar.board.model.BoardVO;
import com.gyub.driveeodigacar.board.service.BoardService;
import com.gyub.driveeodigacar.common.Search;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model,
		@RequestParam(required = false, defaultValue = "1")
		int page,
		@RequestParam(required = false, defaultValue = "1")
		int range,
		@RequestParam(required = false, defaultValue = "title")
		String searchType,
		@RequestParam(required = false)
		String keyword,
		@ModelAttribute("search")
		Search search) throws Exception {
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		// Get total count
		int listCnt = boardService.getBoardListCnt(search);
		search.pageInfo(page, range, listCnt);

		model.addAttribute("pagination", search);
		model.addAttribute("boardList", boardService.getBoardList(search));

		return "board/index";
	}

	@RequestMapping("/boardForm")
	public String boardForm(@ModelAttribute("boardVO")
	BoardVO vo, Model model) {
		return "board/boardForm";
	}

	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("id")
	Long id) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(id));
		return "board/boardContent";
	}

	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("id")
	Long id,
		@RequestParam("mode")
		String mode,
		Model model) throws Exception {
		BoardVO boardContent = boardService.getBoardContent(id);

		model.addAttribute("boardContent", boardContent);
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", boardContent);

		return "board/boardForm";
	}

	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("boardVO")
	BoardVO boardVO,
		@RequestParam("mode")
		String mode,
		RedirectAttributes rttr) throws Exception {
		if ("edit".equals(mode)) {
			boardService.updateBoard(boardVO);
		} else {
			boardService.insertBoard(boardVO);
		}
		return "redirect:/board/getBoardList";
	}

	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(@RequestParam("id")
	Long id) throws Exception {
		boardService.deleteBoard(id);
		return "redirect:/board/getBoardList";
	}
}
