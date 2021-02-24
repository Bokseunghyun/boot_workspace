package com.spring.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.ToString;


@Entity
@Data
@ToString(exclude = {"user","likes"})
public class Images {
	
	@Id
	@GeneratedValue(generator = "user_seq_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "user_seq", name = "user_seq_gen")
	private int id;
	private String location;	// 사진 찍은 위치
	private String caption;	// 사진 설명
	@Column(name = "post_Image")
	private String postImage;	// 포스팅 사진 경로 + 이름 
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	@JsonIgnoreProperties({"password","images"})	//무시할 속성이나 속성 목록을 표시하는 데 사용됨
	private UserVO user;	
	
	//(1) Tag List
	@OneToMany(mappedBy = "image",fetch = FetchType.EAGER)
	@JsonManagedReference	
	private List<Tag> tags = new ArrayList<>();
	

	@OneToMany(mappedBy = "image", fetch = FetchType.EAGER) 
	private List<Likes> likes = new ArrayList<>();
	
	@Transient	//DB 테이블 컬럼과 매핑X (DB에 영향끼치지않음)
	private int likeCount;
	
	@Transient
	private boolean heart;
	
	
	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
	
}
