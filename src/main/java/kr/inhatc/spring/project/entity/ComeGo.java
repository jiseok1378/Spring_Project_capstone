package kr.inhatc.spring.project.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comingAndGoing")
@NoArgsConstructor
@Data
public class ComeGo {

	@Id
	private int idc;
	@ManyToOne(targetEntity = Member.class)
	@JoinColumn(name = "member_id")
	private int memberId;
	
	@Column(insertable = false, updatable = false)
	private LocalDateTime entranceTime;
	@PrePersist
    public void entranceTime() {
        this.entranceTime = LocalDateTime.now();
    }
	@Column(insertable = false, updatable = false)
	private LocalDateTime exitTime;
	
	private String position; 
	
}