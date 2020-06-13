package kr.inhatc.spring.chat.entity;

import java.io.Serializable;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
public class ChatLogPK implements Serializable {
	private int userId;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num; 
	private LocalDateTime sendTime;
}
