package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.Follow;
import com.spring.domain.UserVO;
import com.spring.repository.AccountRepository;
import com.spring.repository.FollowRepository;
import com.spring.security.AccountDetails;


@Controller
public class FollowController {

	@Autowired
	private AccountRepository AcReposit;
	
	@Autowired
	private FollowRepository FollowReposit;
		
	
	//팔로우
	@PostMapping("/follow/{id}")
	public @ResponseBody String follow(@AuthenticationPrincipal AccountDetails AcDetails, @PathVariable int id) {
		UserVO following = AcDetails.getVo();
		Optional<UserVO> oToUser = AcReposit.findById(id);
		UserVO follower = oToUser.get();

		Follow follow = new Follow();
		follow.setFollowing(following);
		follow.setFollower(follower);

		FollowReposit.save(follow);

		return "ok";
	}

	//언팔로우
	@DeleteMapping("/follow/{id}")
	public @ResponseBody String unFollow(@AuthenticationPrincipal AccountDetails AcDetails, @PathVariable int id) {
		UserVO following = AcDetails.getVo();
		Optional<UserVO> oToUser = AcReposit.findById(id);
		UserVO follower = oToUser.get();

		FollowReposit.deleteByFollowingIdAndFollowerId(following.getId(), follower.getId());

		List<Follow> follows = FollowReposit.findAll();
		return "ok"; 
	}
	
	//팔로우 리스트
	@GetMapping("/follow/follow/{id}")
	public String FollowList(@PathVariable int id, @AuthenticationPrincipal AccountDetails AcDetails, Model model) {
		
		//팔로우 리스트
		List<Follow> follows = FollowReposit.findByFollowingId(id);
		
		//팔로우 리스트2
		List<Follow> follows2 = FollowReposit.findByFollowingId(AcDetails.getVo().getId());
		
		//맞팔중인지 확인
		for(Follow f1: follows) {
			for(Follow f2: follows2) {
				//서로의 팔로워 id값이 일치하면 맞팔상태 ex)1->2 , 2->1 맞팔상태
				if(f1.getFollower().getId()==f2.getFollower().getId()) {
					f1.setFollowState(true);
				}
			}
		}
		
		model.addAttribute("follows",follows);
		
		return "follow/follow";
	}
	
	@GetMapping("/follow/follower/{id}")
	public String follower(@PathVariable int id, @AuthenticationPrincipal AccountDetails Acdetails, Model model) {
		
		//내가 팔로우한 사람들(팔로워 리스트)
		List<Follow> followers = FollowReposit.findByFollowerId(id);
		
		//나를 팔로우한 사람들(팔로잉 리스트)
		List<Follow> Follows_user = FollowReposit.findByFollowingId(Acdetails.getVo().getId());
		
		//나를 팔로잉 하고 있는 사람을 나도 팔로우 했는지 
		for(Follow f1 : followers) {
			for(Follow f2 : Follows_user) {
				if(f1.getFollowing().getId()==f2.getFollower().getId()) {
					f1.setFollowState(true);
				}
			}
		}
		
		model.addAttribute("followers",followers);
		return "follow/follower";
	}
}
