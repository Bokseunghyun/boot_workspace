package com.spring.domain;

import java.sql.Timestamp;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

	@Id
	@GeneratedValue(generator = "comment_seq_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "comment_seq", name = "comment_seq_gen")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private UserVO user;
	
	@ManyToOne
	@JoinColumn(name = "image_Id")
	private Images image;
	
	
	private String content;
	
	@CreationTimestamp
	private Timestamp regDate; //등록일
}
