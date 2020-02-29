package com.yvette.gym.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yvette.gym.domain.Member;
import com.yvette.gym.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("createmember")
	public ModelAndView createMember(Member member) {
		ModelAndView model = new ModelAndView("/login.jsp");

		if (member != null && !member.getUsername().isBlank()) {
			memberService.saveMember(member);
			model.addObject("message", "Account created successfully.");
		}

		return model;
	}

	@PostMapping("login")
	public ModelAndView login(Member credentials, HttpSession session) {
		ModelAndView model = new ModelAndView("/login.jsp");

		if (session.getAttribute("session") == null) {
			if (credentials != null && !credentials.getUsername().isBlank()) {
				Member member = memberService.getMember(credentials.getUsername());

				if (member != null && member.getPassword().equals(credentials.getPassword())) {
					model.setViewName("getWorkouts");
					model.addObject("session", member);
					session.setAttribute("session", member);
				} else {
					model.addObject("invalidMessage", "Incorrect credentials provided. Please try again");
				}
			}
		} else {
			model.setViewName("getWorkouts");
		}

		return model;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("session") != null) {
			session.invalidate();
		}
		
		return "redirect:login.jsp";
	}
}
