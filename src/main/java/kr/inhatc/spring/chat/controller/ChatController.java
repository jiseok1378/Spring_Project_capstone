package kr.inhatc.spring.chat.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.inhatc.spring.chat.entity.ChatData;
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
		if(chatLog.getConId()!=0) {
//		consultant든 user든 userId에 가져옴 현재는
		int receiver = chatLog.getUserId();
		int m = chatLog.getConId();

		log.debug("==========>"+chatLog.getConId());
		log.debug("==========>"+chatLog); 
		// receiver에게 보냄
		simpMessagingTemplate.convertAndSend("/topic/"+receiver, chatLog);
		
		if(receiver < 100) {
			chatLog.setConId(receiver);
			chatLog.setUserId(m);
		}
		 chatService.saveMessage(chatLog); }
	}
	
	@RequestMapping(value = "/chat/combineQA", method=RequestMethod.POST)
	@ResponseBody
	public void combineQA(ChatData chatData) {
		chatService.saveRealData(chatData);
	}
	
	@RequestMapping(value = "/chat/showQA", method=RequestMethod.POST)
	@ResponseBody
	public List<ChatData> showQA(ChatData chatData) {
		int userId = chatData.getUserId();
		List<ChatData> reallist = chatService.showData(userId);
		return reallist;
	}
	
	@RequestMapping(value = "/chat/deleteQA/{id}", method=RequestMethod.GET)
	@ResponseBody
	public void deleteQA(@PathVariable("id")int id) {
		ChatData data = chatService.findContent(id);
		chatService.contentDelete(data);
	}
	
	@RequestMapping("/chat/chatbot")
	public String hello() {
		return "chat/chatbot";
	}
	
	@RequestMapping("/mask")
	public String mask() {
		
		return "chat/mask";
	}

}
