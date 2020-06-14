package kr.inhatc.spring.chat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.chat.entity.ChatData;


@Repository
public interface RealRepository extends CrudRepository<ChatData, String>{

	List<ChatData> findByUserId(int userId);

	ChatData findById(int id);
	
}