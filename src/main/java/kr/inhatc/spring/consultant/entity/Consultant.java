package kr.inhatc.spring.consultant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(length = 20, unique=true)
	private String CId; 
	@Column(length = 20)
	private String pw; 
	@Column(length = 20)
	private String name;
	
	private String role;
	private String id;


}
