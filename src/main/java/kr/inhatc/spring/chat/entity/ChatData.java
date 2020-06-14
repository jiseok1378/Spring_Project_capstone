package kr.inhatc.spring.chat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chatdata")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatData {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private int userId;
		@Column(length=5000)
		private String question;
		@Column(length=5000)
		private String answer;
}
