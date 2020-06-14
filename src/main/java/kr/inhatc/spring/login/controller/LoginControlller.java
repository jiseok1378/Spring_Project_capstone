package kr.inhatc.spring.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginControlller {
	
	@GetMapping("/login/login")
	public void login() {

	}
	@GetMapping("/login/accessDenied")
	public void accessDenied() {

	}
	@GetMapping("/login/logout")
	public void logout() {
		log.debug("로그아웃");
	}
 
	
}
