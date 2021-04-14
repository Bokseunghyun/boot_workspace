package com.spring.controller;

import java.awt.Image;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class CommentController {

	@Autowired
	private ImageRepository ImageReposit;
	
	@Autowired
	private CommentRepository CommentReposit;
	
	@Autowired
	private AccountRepository AcReposit;
	
	
	@PostMapping("/comment/insert/{image_Id}")
	public @ResponseBody Comments comment(@AuthenticationPrincipal AccountDetails AcDetails,@PathVariable int image_Id,@RequestBody String content,Model model){
		
		Images image = Images.builder().id(image_Id).build();
		
		Comments comment = Comments.builder().content(content).image(image).user(AcDetails.getVo()).build();
		
		model.addAttribute("co",comment);
		
		System.out.println("코멘트 = " +comment);
		return CommentReposit.save(comment);
	}
	@DeleteMapping("/comment/{id}")
	public void commentDelete(@PathVariable int id, @AuthenticationPrincipal AccountDetails AcDetails) {
		
		Comments comment = CommentReposit.findById(id).get();
		
		if(comment.getUser().getId() == AcDetails.getVo().getId()) {
			CommentReposit.deleteById(id);
		}
		
	}
	
}
