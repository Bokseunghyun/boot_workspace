package com.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.Images;
import com.spring.domain.Likes;
import com.spring.repository.ImageRepository;
import com.spring.repository.LikeRepository;
import com.spring.security.AccountDetails;

public class LikeController {

	
	@Autowired
	private LikeRepository LikeReposit;
	
	@Autowired
	private ImageRepository ImageReposit;
	
	@PostMapping("/like/{id}")
	public @ResponseBody String like(@PathVariable int id, @AuthenticationPrincipal AccountDetails AcDetails) {
		
		Likes toLike = LikeReposit.findByUserIdAndImageId(AcDetails.getVo().getId(), id);
		
		Optional<Images> OpImage = ImageReposit.findById(id);
		Images images = OpImage.get();
	
		System.out.println("이미지"+images);
		try {
		
			//좋아요 안한 상태
			if(toLike == null) {
			
				Likes newLike =  Likes.builder().image(images).user(AcDetails.getVo()).build();
				
				LikeReposit.save(newLike);
				
			}else { // 좋아요 삭제
				LikeReposit.delete(toLike);
				
			}
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "fail";
	}
	
	
	
}
