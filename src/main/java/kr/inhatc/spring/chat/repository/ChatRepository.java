package kr.inhatc.spring.chat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.chat.entity.ChatLog;


@Repository
public interface ChatRepository extends CrudRepository<ChatLog, String>{
	
	
}
