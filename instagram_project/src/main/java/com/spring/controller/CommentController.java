package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.repository.CommentRepository;
import com.spring.repository.ImageRepository;

@Controller
public class CommentController {

	@Autowired
	private ImageRepository ImageReposit;
	
	@Autowired
	private CommentRepository CommentReposit;
	
	
	public String insertComment() {
		
		return "";
	}
}
