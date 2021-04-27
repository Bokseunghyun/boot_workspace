package com.spring.service;

import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Comments;
import com.spring.domain.Images;
import com.spring.domain.UserVO;
import com.spring.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
	private final CommentRepository CommentReposit;
	@Transactional
	public Comments commentInsert(UserVO principal, String content, int imageId) {
		Images image = Images.builder()
				.id(imageId)
				.build();
				
		Comments comment = Comments.builder()
				.content(content)
				.image(image)
				.user(principal)
				.build();
		
		return CommentReposit.save(comment);
	}
	
	@Transactional
	public Comments commentDelete(int id, int principalId) {
		
		Comments comment = CommentReposit.findById(id).get();
		if(comment.getUser().getId() == principalId) {
			CommentReposit.deleteById(id);
		}
		return CommentReposit.save(comment);
		
}
}