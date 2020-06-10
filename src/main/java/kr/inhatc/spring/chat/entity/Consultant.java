package kr.inhatc.spring.chat.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consultant")
@NoArgsConstructor
@Data
public class Consultant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int conId;
	
	@OneToMany(mappedBy = "conId")
	private List<ChatLog> cl = new ArrayList<ChatLog>();
//	@OneToMany(mappedBy = "conId")
//	private List<Room> rr = new ArrayList<Room>();
	
	
	@Column(length = 20)
	private String id; 
	@Column(length = 20)
	private String pw; 
	@Column(length = 20)
	private String name;


}