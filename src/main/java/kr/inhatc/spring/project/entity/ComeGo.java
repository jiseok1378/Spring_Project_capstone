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
@Table(name = "comingAndGoing")
@NoArgsConstructor
@Data
public class ComeGo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;

	@Column(length=1000)
	private String personName;
	private int identifiedNum;
	
	@Column(insertable = false, updatable = false)
	private LocalDateTime cometInTime;
	@PrePersist
    public void cometInTime() {
        this.cometInTime = LocalDateTime.now();
    }
	
	private float temperate;
	private String storedFilePath; 
	
}