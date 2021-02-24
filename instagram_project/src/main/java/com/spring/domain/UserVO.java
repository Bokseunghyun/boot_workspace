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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="users")
@ToString(exclude = "image")
public class UserVO {
	@Id
	@GeneratedValue(generator = "user_seq_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "user_seq", name = "user_seq_gen")
	private int id;
	@NotNull
	@Size(min = 3, max = 8, message = "3자리이상 8자리 이하 아이디를 입력하세요")
	private String username; //아이디
	@NotNull
	@Size(min = 2, max = 10, message = "2자리이상 10자리 이하 이름을 입력하세요")
	private String name; //회원이름
	@NotNull
	@Size(min = 3, max = 16, message = "3자리이상 16자리 이하 비밀번호를 입력하세요")
	private String password; //비밀번호
	private String website; //홈페이지 주소
	private String intro; //소개글
	private String phone; //전화번호
	private String email; //이메일
	private String gender; //성별
	@Column(name="profile_Image")
	private String profileImage; //프로필사진
	
	
	@CreationTimestamp
	@Column(name = "reg_Date")
	private Timestamp regDate; //등록일
	
	@CreationTimestamp
	@Column(name = "update_Date")
	private Timestamp updateDate;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER) //Image가 uservo(fk)의 부모 uservo는 참조만 가능
	@JsonIgnoreProperties({"user","tags","likes"})
	private List<Images> image = new ArrayList<>(); 
	
	
}
