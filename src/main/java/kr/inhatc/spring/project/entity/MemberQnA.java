package kr.inhatc.spring.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "memberQna")
@NoArgsConstructor
@Data
public class MemberQnA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;

	private int userId;
	
	@Column(length = 500)
	private String question;
	@Column(length = 5000)
	private String answer;

	@Column(insertable = false, updatable = false)
	private LocalDateTime writeTime;
	@PrePersist
    public void entranceTime() {
        this.writeTime = LocalDateTime.now();
    }
}