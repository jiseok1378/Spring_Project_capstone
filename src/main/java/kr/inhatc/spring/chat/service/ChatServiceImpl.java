package kr.inhatc.spring.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.chat.entity.MemberQnA;
import kr.inhatc.spring.chat.repository.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatRepository chatRepository;

	@Override
	public List<MemberQnA> chatList(int id) {
		chatRepository.findById(id);
		return null;
	}
	

}
