package kr.inhatc.spring.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Data
public class Questions {

	@Id
	private int quesId;
	@OneToMany(mappedBy = "quesId")
	private List<Answers> an = new ArrayList<Answers>();
	
	@ManyToOne(targetEntity = Room.class)
	@JoinColumn(name = "roomId")
	private int roomId;
	@Column(length = 500)
	private String question;

}