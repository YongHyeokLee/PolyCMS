package kr.ac.kopo.polycms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.polycms.model.Member;
import kr.ac.kopo.polycms.service.MemberService;

@Controller
public class RootController {
	
	@Autowired
	MemberService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member item, HttpSession session) {
		if(service.login(item)) {
			session.setAttribute("member", item);
			
			return "redirect:.";
		}
		
		return "redirect:login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:.";
	}
	
	
	
	
	
	
	
	
}
