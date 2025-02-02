package com.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.domain.Likes;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Integer>{
	
	//좋아요 누른 이미지 찾기
	Likes findByUserIdAndImageId(int userId, int imageId);
	
	//좋아요 수 카운트
	int countByImageId(int imageId);
	// 내 이미지를 좋아요 하는 알림 정보
	@Query(value="select * from likes where image_Id in (select id from images where user_Id = ?1) ", nativeQuery = true)
	List<Likes> findAlert(int userId);
	
}
