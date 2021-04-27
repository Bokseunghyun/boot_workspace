package com.spring.controller;

import java.awt.Image;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Comments;
import com.spring.domain.Follow;
import com.spring.domain.Images;
import com.spring.domain.UserVO;
import com.spring.repository.AccountRepository;
import com.spring.repository.CommentRepository;
import com.spring.repository.ImageRepository;
import com.spring.security.AccountDetails;
import com.spring.service.CommentService;

import oracle.jdbc.proxy.annotation.Post;

@RestController
public class CommentController {

	@Autowired
	private CommentService CoService;
	
	
	@PostMapping("/comment/insert/{image_Id}")
	public ResponseEntity<Comments> comment(@AuthenticationPrincipal AccountDetails AcDetails,@PathVariable int image_Id,@RequestBody String content){
		
		Comments com = CoService.commentInsert(AcDetails.getVo(), content, image_Id);
		System.out.println("코멘트 = " +com);
		return new ResponseEntity<Comments>(com,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<Comments> commentDelete(@PathVariable int id, @AuthenticationPrincipal AccountDetails AcDetails) {
		
		Comments comment = CoService.commentDelete(id, AcDetails.getVo().getId());
		
		return new ResponseEntity<Comments>(comment,HttpStatus.OK);
	}
	
}
