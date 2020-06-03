package kr.inhatc.spring.chat.service;

import java.util.List;

import kr.inhatc.spring.chat.entity.MemberQnA;

public interface ChatService {

	List<MemberQnA> chatList(int i);
	
}
