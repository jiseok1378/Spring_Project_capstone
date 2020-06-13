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

import kr.inhatc.spring.project.entity.Live;
import kr.inhatc.spring.project.entity.Location;
import kr.inhatc.spring.project.service.LiveService;
import kr.inhatc.spring.project.service.NormalService;

@Controller
public class MainController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NormalService normalService;
	
	@Autowired
	private LiveService liveService;

	@RequestMapping("/")
	public String hello() {
		log.debug("===========>" + "메인페이지임다!!!");
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public String mainPage() {
		return "main/mainMain";
	}
	@RequestMapping(value = "/main/mainInfo", method=RequestMethod.GET)
	public String info() {
		return "main/mainInfo";
	}
	@RequestMapping(value = "/main/mainLive", method=RequestMethod.GET)
	public String live(Model model) {
		List<Live> list = liveService.liveList();
		model.addAttribute("list",list);
		return "main/mainLive";
	}

	@RequestMapping(value = {"/main/mainMove","/main/mainMove/{area}"}, method=RequestMethod.GET)
	public String confirmerList(@PathVariable("area") Optional<String> areaId, Model model) {
		if (areaId.isPresent()){
			String area = areaId.get();
			List<Location> confirmer = normalService.confirmerList(area);
			model.addAttribute("list", confirmer);
		} else {
			List<Location> confirmer = normalService.confirmerList("%");
			model.addAttribute("list", confirmer);
		}

		return "main/mainMove";
	}

}
