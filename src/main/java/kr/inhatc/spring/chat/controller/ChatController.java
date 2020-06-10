package kr.inhatc.spring.chat.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.chat.entity.Chat;
import kr.inhatc.spring.chat.entity.ChatLog;
import kr.inhatc.spring.chat.service.ChatService;

@Controller
public class ChatController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	//
	//컨트롤러에 서비스를 불러옴
	@Autowired
	private ChatService chatService;
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/chat/send")
	public void chat(ChatLog chatLog) throws Exception {
//		consultant든 user든 userId에 가져옴 현재는
		int receiver = chatLog.getUserId();
		/* chatService.saveMessage(chatLog); */
		log.debug("==================>" + chatLog);
		// receiver에게 보냄
		simpMessagingTemplate.convertAndSend("/topic/"+receiver, chatLog);
	}
	
	@RequestMapping("/chat/chatbot")
	public String hello() {
		return "chat/chatbot";
	}
	
//	//채팅 뷰
//	@RequestMapping(value="/chat/chatList",method= {RequestMethod.GET,RequestMethod.POST} )
//	@ResponseBody
//	public List<MemberQnA> chatList() {
//		List<MemberQnA> list = chatService.chatList(1);
//		return list;
//	}
	
//	@RequestMapping(value="/hello")
//	public String sdChat() {
//		return "hello";
//	}
//	@RequestMapping(value="/chat")
//	@ResponseBody
//	public String sendChat(MemberQnA qa) {
//		return qa.getQuestion();
//	}
	
	//		@RequestMapping(value = "/chat/sendChat/{Q}", method=RequestMethod.POST)
	//		public String sendChat(@PathVariable("Q") String Q, Chat chat) {
	//			
	//			// 아이디 설정
	//			//user.setId(id);
	//			//System.out.println("=========> " + user);
	//			//chatService.saveUsers(user);
	//			String ques = chat.getMessage();
	//			return "http://4e885ede18c6.ngrok.io/dto/" + ques;
	//		}
	//	
	//	@RequestMapping(value = {"/confirmerList","/confirmerList/{area}"}, method=RequestMethod.GET)
	//	public String confirmerList(@PathVariable("area") Optional<String> areaId, Model model) {
	//		if (areaId.isPresent()){
	//			String area = areaId.get();
	//			//log.debug("==========   >" + "실행 돼");
	//			List<Location> confirmer = normalService.confirmerList(area);
	//			model.addAttribute("list", confirmer);
	//		} else {
	//			//log.debug("============>" + "ㄴㄴㄴㄴㄴ");
	//			List<Location> confirmer = normalService.confirmerList("%");
	//			model.addAttribute("list", confirmer);
	//		}
	//
	//		return "confirmerList";
	//	}
}
