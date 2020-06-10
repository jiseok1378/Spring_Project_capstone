package kr.inhatc.spring.chat.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chat")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chat {
	@Id
	private String name;
	private String message;
}
