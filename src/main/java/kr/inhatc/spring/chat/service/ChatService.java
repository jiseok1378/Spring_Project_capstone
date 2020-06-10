package kr.inhatc.spring.chat.service;

import java.util.List;

import kr.inhatc.spring.chat.entity.ChatLog;
import kr.inhatc.spring.chat.entity.Room;

public interface ChatService {

	// 상담원 페이지에 보이는 유저리스트
	List<Room> showUserList();
	// ChatRoomState (채팅방상태 관리)
	void saveRoom(Room room);
	// userId check
	int findId(int randId);
	int findId(String uid);
	void updateState(Room room);
	void roomDelete(Room room);
	Room findRoom(String userId);
	
	void saveMessage(ChatLog chatLog);
}
