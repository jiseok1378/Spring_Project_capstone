package kr.inhatc.spring.project.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.project.entity.Location;
import kr.inhatc.spring.project.service.NormalService;

@Controller
public class MainController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NormalService normalService;

	@RequestMapping("/")
	public String hello() {
		log.debug("===========>" + "메인페이지임다!!!");
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public String mainPage() {
		return "main/mainInfo";
	}
	@RequestMapping(value = "/main/mainInfo", method=RequestMethod.GET)
	public String info() {
		return "main/mainInfo";
	}
	@RequestMapping(value = "/main/mainLive", method=RequestMethod.GET)
	public String live() {
		return "main/mainLive";
	}

	
	@RequestMapping(value = "/main/mainQA", method=RequestMethod.GET)
	public String main(Model model) {
		return "main/mainQA";
	}

	@RequestMapping(value = {"/main/mainMove","/main/mainMove/{area}"}, method=RequestMethod.GET)
	public String confirmerList(@PathVariable("area") Optional<String> areaId, Model model) {
		if (areaId.isPresent()){
			String area = areaId.get();
			//log.debug("==========   >" + "실행 돼");
			List<Location> confirmer = normalService.confirmerList(area);
			model.addAttribute("list", confirmer);
		} else {
			//log.debug("============>" + "ㄴㄴㄴㄴㄴ");
			List<Location> confirmer = normalService.confirmerList("%");
			model.addAttribute("list", confirmer);
		}

		return "main/mainMove";
	}
	
	
	
	// 테스트 및 만들기용
	@RequestMapping(value = "/main/a", method=RequestMethod.GET)
	public String userList(Model model) {
		return "main";
	}
	
	

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
