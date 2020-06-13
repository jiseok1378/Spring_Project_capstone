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
@Table(name = "covid19live")
@NoArgsConstructor
@Data
public class Live {

	@Id
	private int idx;
	private String con_w;
	private String incon_w;
	private String dead_w;
	private String indead_w;
	private String iso_w;
	private String iniso_w;
	private String fatality_w;
	private String contry_w;
	private String incontry_w;
	private String con_k;
	private String incon_k;
	private String dead_k;
	private String indead_k;
	private String iso_k;
	private String iniso_k;
	private String fatality_k;
	private String check_k;
	private String incheck_k;
	private String checking_k;
	private String inchecking_k;
	private String neg_k;
	private String inneg_k;
	private String update_time;

}