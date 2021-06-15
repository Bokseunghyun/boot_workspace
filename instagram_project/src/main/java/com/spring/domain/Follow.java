package com.spring.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class Follow {
	@Id
	@GeneratedValue(generator = "follow_seq_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "follow_seq", name = "follow_seq_gen")
	private int id;
	

	@ManyToOne
	@JoinColumn(name="followingId")	//~부터
	@JsonIgnoreProperties({"image"})
	private UserVO following;
	
	@ManyToOne
	@JoinColumn(name="followerId")	//~에게
	@JsonIgnoreProperties({"image"})
	private UserVO follower;
	
	@Transient
	//맞팔
	private boolean followState;
	
	@CreationTimestamp
	private Timestamp regDate;
	@CreationTimestamp
	private Timestamp updateDate;
}
