package kr.inhatc.spring.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room")
@NoArgsConstructor
@Data
public class Room {

	@Id
	private int roomId;
	@OneToMany(mappedBy = "roomId")
	private List<Questions> qu = new ArrayList<Questions>();
	
	private char help;
	private char personYn;
	@OneToOne(targetEntity = Member.class)
    @JoinColumn(name="member_id")
	private int memberId;

}