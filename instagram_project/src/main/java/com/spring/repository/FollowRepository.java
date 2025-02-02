package com.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.domain.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer>{
	
	//팔로우 유무
	int countByFollowingIdAndFollowerId(int followingId, int followerId); //팔로우 카운트
	
	@Transactional
	int deleteByFollowingIdAndFollowerId(int followingId, int followerId); //언팔로우

	//팔로잉 리스트
	List<Follow> findByFollowingId(int followingId);
	//팔로워 리스트
	List<Follow> findByFollowerId(int followerId);
	
	//팔로잉 카운트
	int countByFollowingId(int followingId);
	//팔로워 카운트
	int countByFollowerId(int followerId);

}
