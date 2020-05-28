package kr.inhatc.spring.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.project.entity.Member;
import kr.inhatc.spring.project.service.MemberService;

//// 메모리에 올라와야 사용할 수 있음
@Controller
public class MainController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	//컨트롤러에 서비스를 불러옴
	@Autowired
	private MemberService userService;

	@RequestMapping("/")
	public String hello() {
		log.debug("===========>" + "메인페이지임다!!!");
		return "redirect:/main";
	}

	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public String userList(Model model) {
		return "main";
	}
//	
//	@RequestMapping(value = "/user/userInsert", method=RequestMethod.GET)
//	public String userWrite() {
//		return "user/userWrite";
//	}
//	
//	@RequestMapping(value = "/user/userInsert", method=RequestMethod.POST)
//	public String userInsert(Users user) {
//		userService.saveUsers(user);
//		return "redirect:/user/userList";
//	}
//	
//	@RequestMapping(value = "/user/userDetail/{id}", method=RequestMethod.GET)
//	public String userDetail(@PathVariable("id") String id, Model model) { //@PathVariable 경로처럼 가져옴
//		Users user = userService.userDetail(id);
//		model.addAttribute("user", user);
//		//System.out.println("============> " + user);
//		return "user/userDetail";
//	}
//	
//	@RequestMapping(value = "/user/userUpdate/{id}", method=RequestMethod.POST)
//	public String userUpdate(@PathVariable("id") String id, Users user) {
//		
//		// 아이디 설정
//		user.setId(id);
//		//System.out.println("=========> " + user);
//		userService.saveUsers(user);
//		return "redirect:/user/userList";
//	}
//	
//	@RequestMapping(value = "/user/userDelete/{id}", method=RequestMethod.GET)
//	public String useDelete(@PathVariable("id") String id) {
//		userService.userDelete(id);
//		return "redirect:/user/userList";
//	}
}
