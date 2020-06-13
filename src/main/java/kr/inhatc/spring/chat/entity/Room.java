package kr.inhatc.spring.chat.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 채팅방 상태 생성
 *
 */
@Entity
@Table(name = "room")
@NoArgsConstructor
@Data
public class Room {
	
	@Id //매일 디비 초기화, auto_increment 초기화
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId; 
	private int userId; 

	@Column(columnDefinition = "int default 0")
	private int consId; 
	
	@Column(columnDefinition = "varchar(10) default '대기중'")
	private String state;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private LocalDateTime createdTime;
	@PrePersist
    public void createdTime() {
        this.createdTime = LocalDateTime.now();
    }
}
