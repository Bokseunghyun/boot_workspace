package com.spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.domain.Images;

public interface ImageRepository extends JpaRepository<Images, Integer>{
	
	//페이징 처리를 위해 사용 pageable은 페이징처리 sort 정렬 
	//Page<T>를 사용 하면 호출하는 쪽에서 sort,page,size 파라미터 를 던져주기만 하면되기때문에  페이징처리가 간단해짐
	
	@Query(value = "select * from images where user_Id in (select following_Id from follow where follower_Id = ?1) or user_Id = ?1", nativeQuery = true)
	Page<Images> findImage(int userId, Pageable pageable);
}
