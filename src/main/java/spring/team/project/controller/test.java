package spring.team.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
	@RequestMapping("/")
	public String test() {
		return "index";
				
	}
}
