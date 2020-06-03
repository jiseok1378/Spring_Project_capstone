package kr.inhatc.spring.project.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import kr.inhatc.spring.chat.entity.MemberQnA;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor
@Data
public class Member {

	@Id
	@Column(name = "MEMBER_ID")
	private int idx;
	
	@OneToMany(mappedBy = "memberId")
	private List<MemberQnA> qu = new ArrayList<MemberQnA>();
	
	@Column(length = 20)
	private String id; 
	@Column(length = 20)
	private String pw; 
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String tel;
	private String address;
	@ColumnDefault("0") 
	private char role;	

}