package kr.inhatc.spring.chat.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
/***
 * 채팅 로그
 * 채팅 내용 및 누가 말햇는지 등 모두 기록
 * @author heeju
 *
 */
@Entity
@Table(name = "chatlog")
@NoArgsConstructor
@Data
@IdClass(ChatLogPK.class)
public class ChatLog {
	@Id
	private int userId;
	private int conId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num; 
	
	@Id
	@Column(insertable = false, updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private LocalDateTime sendTime;
	@PrePersist
    public void sendTime() {
        this.sendTime = LocalDateTime.now();
    }
	
	@Column(length=5000)
	private String content; 
	@Column(length=10)
	private String who;
}
