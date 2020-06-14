package kr.inhatc.spring.consultant.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.consultant.entity.Consultant;
import kr.inhatc.spring.consultant.service.ConsultantService;

@Controller
public class ConsultantController {

	@Autowired
	private ConsultantService consultantService;
	@Autowired
	private PasswordEncoder encoder;
	
	
	@RequestMapping(value = "/con/consultantList", method=RequestMethod.GET)
	public String conList(Model model, HttpServletRequest request) {
		List<Consultant> list = consultantService.consultantList(); 
		model.addAttribute("list", list);
		return "consultant/consultantList";
	}
	@RequestMapping(value = "/con/consultantDetail/{conId}", method=RequestMethod.GET)
	public String userDetail(@PathVariable("conId") String conId, Model model) {
		
		Consultant user = consultantService.consultantDetail(Integer.parseInt(conId));
		model.addAttribute("user", user);
		return "/consultant/consultantDetail";
	}
	@RequestMapping(value = "/con/consultantWrite", method=RequestMethod.GET)
	public String userWrite(Model model) {
		List<String> enabledList = new ArrayList<>();
		enabledList.add("가능");
		enabledList.add("불가능");
		
		List<String> authorityList = new ArrayList<>();
		authorityList.add("ROLE_GUEST");
		authorityList.add("ROLE_MEMBER");
		authorityList.add("ROLE_CONSULTANT");
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("enabledList", enabledList);
		map.put("authorityList", authorityList);
		
		model.addAttribute("map", map);
		return "consultant/consultantWrite";
	}
	@RequestMapping(value = "/con/consultantInsert", method=RequestMethod.POST)
	public String userInsert(Consultant user) {
		if(user != null) {
			System.out.println("변경 전" + user.getPw());
			String pw = encoder.encode(user.getPw());
			System.out.println("변경 후 " + pw);
			user.setPw(pw);
			consultantService.saveConsultant(user);
		}
		
		
		
		return "redirect:/con/consultantList";
	}
	@RequestMapping(value = "/con/consultantUpdate/{id}", method=RequestMethod.POST)
	public String userUpdate(@PathVariable("id") int id, Consultant user) {
		user.setConId(id);
		System.out.println(user.getConId());
		consultantService.saveConsultant(user);
		return "redirect:/con/consultantList";
	}
	@RequestMapping(value = "/con/consultantDelete/{id}", method=RequestMethod.GET)
	public String userDelete(@PathVariable("id") String id, Consultant user) {
		
		consultantService.consultantDelete(Integer.parseInt(id));
		return "redirect:/con/consultantList";
	}
}
