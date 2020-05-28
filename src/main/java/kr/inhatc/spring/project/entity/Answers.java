package kr.inhatc.spring.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answers")
@NoArgsConstructor
@Data
public class Answers {

	@Id
	private int answerId;
	@ManyToOne(targetEntity = Questions.class)
	@JoinColumn(name = "quesId")
	private int quesId;
	@Column(length = 1000)
	private String answer;
	private char predictYn;
	private char assistYn;

}