package com.spring.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Likes {
	
	@Id
	@GeneratedValue(generator = "likes_seq_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "likes_seq", name = "likes_seq_gen")
	private int id;
	
	@ManyToOne
	@JoinColumn(name= "user_Id")
	@JsonIgnoreProperties(
		{"image","password", "name", "website", "intro", "email", "phone", 
			"gender","regDate", "updateDate"})
	private UserVO user;
	
	@ManyToOne
	@JoinColumn(name= "image_Id")
	@JsonIgnoreProperties({"tags","user", "likes"})
	private Images image;
	
	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
}
