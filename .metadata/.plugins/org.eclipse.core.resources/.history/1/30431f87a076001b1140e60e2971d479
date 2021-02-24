package com.spring.domain;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity	//독립체
public class Tag {
	
	@Id
	@GeneratedValue(generator = "user_seq_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "user_seq", name = "user_seq_gen")
	private int id;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "image_Id")
	@JsonBackReference	//!@->Image (순한참조 안됨)
	private Images image;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
	
	
}
