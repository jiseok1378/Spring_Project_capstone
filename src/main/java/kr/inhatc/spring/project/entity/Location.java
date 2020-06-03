package kr.inhatc.spring.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "location")
@NoArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(name = "longitude", columnDefinition = "위도")
	private float x;
	@Column(name = "latitude", columnDefinition = "경도")
	private float y;
	private String name; 
	@Column(length = 100)
	private String date;

}