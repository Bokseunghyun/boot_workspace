package com.spring.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue(generator = "user_seq_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "user_seq", name = "user_seq_gen")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserVO user;
	
	@ManyToOne
	@JoinColumn(name = "postid")
	private Images image;
	
	@CreationTimestamp
	private Timestamp regDate; //등록일
	
	private String content;
}