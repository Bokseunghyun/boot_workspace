package com.spring.controller;

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
	
	
	@PostMapping("/comment/insert")
	public String comment(@AuthenticationPrincipal AccountDetails AcDetails, @RequestParam("user_Id") int user_Id, @RequestParam("image_Id")int image_Id,@RequestParam("content")String content,Model model){
		Optional<Images> OpImages = ImageReposit.findById(image_Id);
		Optional<UserVO> OpUsers = AcReposit.findById(AcDetails.getVo().getId());
		Images image = OpImages.get();
		UserVO vo = OpUsers.get();
		
		Comments comments = new Comments();
		comments.setContent(content);
		comments.setImage(image);
		comments.setUser(vo);
		CommentReposit.save(comments);
		model.addAttribute("co",comments);
		ImageReposit.findById(image_Id);
		
		System.out.println("코멘트"+comments);
		System.out.println("컨텐츠"+comments.getContent());
		return "/feed";
	}
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<?> commentDelete(@PathVariable int id) {
		CommentReposit.deleteById(id);
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/comment/list") public List<Comments>
	 * findByImageId(@RequestParam("image_Id") int imageId, Model model){ return
	 * CommentReposit.findByImageId(imageId); }
	 */
}
