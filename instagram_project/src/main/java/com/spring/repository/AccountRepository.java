package com.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.domain.UserVO;

public interface AccountRepository extends JpaRepository<UserVO, Integer>{
	
	UserVO findOneByUsername(String username); //username로 유저찾기
	UserVO findByUsername(String username); //username로 유저 찾기
}
