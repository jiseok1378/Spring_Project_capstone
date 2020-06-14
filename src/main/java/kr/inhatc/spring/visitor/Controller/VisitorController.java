package kr.inhatc.spring.visitor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.visitor.dto.visitorDTO;
import kr.inhatc.spring.visitor.service.visitorService;



@Controller
public class VisitorController {

	@Autowired
	private visitorService visitorService;
	
	@RequestMapping("/visitor/visitorcheck")
	public String visitorList(Model model) {
		List<visitorDTO> list = visitorService.visitorList();
		model.addAttribute("list",list);
		return "visitor/visitorcheck";
	} 
	
}
