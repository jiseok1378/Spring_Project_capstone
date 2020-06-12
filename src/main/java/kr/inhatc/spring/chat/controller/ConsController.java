package kr.inhatc.spring.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.chat.entity.Room;
import kr.inhatc.spring.chat.service.ChatService;

@Controller
public class ConsController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ChatService chatService;
	
	@RequestMapping(value = "/main/mainCon", method=RequestMethod.GET)
	public String mainCon(Model model) {
		List<Room> list =chatService.showUserList();
		model.addAttribute("list", list);
		return "main/mainCon";
	}
	
	@RequestMapping(value = "/chat/deleteState/{userId}", method=RequestMethod.GET)
	public String deleteState(@PathVariable("userId") String userId) {
		Room room = chatService.findRoom(userId);
		chatService.roomDelete(room);
		return "redirect:/main/mainCon";
	}
	
	@RequestMapping(value = "/chat/ConQA/{userId}", method=RequestMethod.GET)
	public String conQA(@PathVariable("userId") String userId, Model model,HttpServletRequest request) {
		//로그인 안되있어서 우선 상수로
		HttpSession session = request.getSession();
		//Integer conId = (Integer) session.getAttribute("conIdId");
		String conId="1";
//		if(conId==null) conId=1;
		
		//상담상태 변경 및 상담원 번호 등록
		Room room = chatService.findRoom(userId);
		room.setConsId(Integer.parseInt(conId));
		room.setState("상담중");
		chatService.saveRoom(room);
		
		//상담원은 전달가능
		model.addAttribute("receiver", userId);
		model.addAttribute("sender", conId);
		model.addAttribute("who","상담원");
		
		return "chat/ConQA";
	}
	
	@RequestMapping(value = {"/main/mainQA","/main/mainQA/{userId}"}, method=RequestMethod.GET)
	public String confirmerList(@PathVariable("userId") Optional<String> userId, Model model) {
		if (userId.isPresent()){
			//log.debug("==========   >" + "사용자식별번호 있음");
			String uid = userId.get();
			model.addAttribute("sender", uid);
			
			int conId = chatService.findId(uid);
			model.addAttribute("receiver", Integer.toString(conId));
			model.addAttribute("who","사용자");
			return "main/mainQAInfoHuman";
			
		} else {
			//log.debug("============>" + "기본");
			return "main/mainQAInfoAI";
		}

		
	}
	
	// 새로운 사용자 번호 생성
	@RequestMapping(value = "/chat/idMake", method=RequestMethod.GET)
	public String idMake(Room room) {
		Random rand = new Random();
		long seed = System.currentTimeMillis();
		rand = new Random(seed);
		int randId = rand.nextInt(2147483547)+100;
		//중복 방지 - 이미 있는 사용자인지 확인
		while (chatService.findId(randId)!=-1) {
			randId = rand.nextInt(2147483647);
//			log.debug("다시다시다시다싣");
		}
//		randId = 2;
		room.setUserId(randId);
		room.setState("대기중");
//		log.debug("==========>"+room.getUserId());
//		log.debug("==========>"+room.getState());
//		log.debug("==========>"+room.getCreatedTime());
		
		chatService.saveRoom(room);
		
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.println("<script>alert('상담원과 연결중입니다. 잠시만 기다려주세요.');location.href='/main/mainQA/"+randId+"';</script>");
//			out.flush();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return "redirect:/main/mainQA/" + randId;
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
