package com.spring.repository;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.domain.UserVO;

@Repository
public interface AccountRepository extends JpaRepository<UserVO, Integer>{
	
	UserVO findByUsername(String username); //username로 유저 찾기
	
}
