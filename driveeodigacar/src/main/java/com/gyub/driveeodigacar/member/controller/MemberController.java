package com.gyub.driveeodigacar.member.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gyub.driveeodigacar.member.model.MemberVO;
import com.gyub.driveeodigacar.member.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		return "/member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("�α��� ó�� �õ�");

		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);

		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", "�̸��� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
			return "redirect:/member/login";
		} else {
			session.setAttribute("member", login);
			rttr.addFlashAttribute("msg", "�α��� ����!");
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinPage() throws Exception {
		return "/member/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postRegister(MemberVO vo, Model model) throws Exception {
		logger.info("ȸ������ ó��");

		int result = service.idChk(vo);
		if (result == 1) {
			model.addAttribute("msg", "�̹� ��� ���� �̸����Դϴ�.");
			model.addAttribute("url", "/member/join");
		} else {
			service.register(vo);
			model.addAttribute("msg", "ȸ�������� ���������� �Ϸ�Ǿ����ϴ�!");
			model.addAttribute("url", "/member/login");
		}
		return "/member/redirect";
	}

	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST, consumes = "application/json")
	public int idChk(@RequestBody
	MemberVO vo) throws Exception {
		return service.idChk(vo);
	}
}
