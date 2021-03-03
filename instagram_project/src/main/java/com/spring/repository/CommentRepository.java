package com.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

	List<Comment> findByImageId(int imageId);
	
	@Transactional
	void deleteById(int id);
}

