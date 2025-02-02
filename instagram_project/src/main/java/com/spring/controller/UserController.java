package com.spring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.Comments;
import com.spring.domain.Images;
import com.spring.domain.Likes;
import com.spring.domain.UserVO;
import com.spring.repository.AccountRepository;
import com.spring.repository.FollowRepository;
import com.spring.repository.ImageRepository;
import com.spring.repository.LikeRepository;
import com.spring.security.AccountDetails;

@Controller
public class UserController {

	@Autowired
	private FollowRepository FollowReposit;

	@Autowired
	private AccountRepository AcReposit;

	@Autowired
	private ImageRepository ImageReposit;
	
	@Autowired
	private LikeRepository LikeReposit;
	
	@Value("${spring.servlet.multipart.location}") // application.properties에 설정한 logging.file.path에 해당하는 프로퍼티를 fileRealPath에 넣음
	private String fileRealPath;
	
	@GetMapping(value = { "/", "/index" })
	public String index() {
		System.out.println("index호출");
		return "/index";
	}

	@GetMapping("/main")
	public String main() {
		System.out.println("main페이지");
		return "/main";
	}
	
	
	@GetMapping("/feed")
	public String feed(@AuthenticationPrincipal AccountDetails AcDetails, @PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable,Model model) {
	
		
		//팔로우한 사람들의 사진
		Page<Images> pageImages = ImageReposit.findImage(AcDetails.getVo().getId(), pageable);
		
		//나의 사진
		List<Images> images = pageImages.getContent();
		
		for(Images image : images) {
			Likes like = LikeReposit.findByUserIdAndImageId(AcDetails.getVo().getId(), image.getId());
		
			if(like != null) {
				image.setHeart(true);
			}
		}

		//feed 좋아요 수 누적
		for (Images image : images) {
			int likeCount = LikeReposit.countByImageId(image.getId());
			image.setLikeCount(likeCount);
		
		}
		model.addAttribute("images", images);

		System.out.println("feed페이지");
		return "/feed";
	}

	@GetMapping("/feed/scroll")
	public @ResponseBody List<Images> imageFeedScroll(@AuthenticationPrincipal AccountDetails AcDetails,
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable,Model model) {

		// 내가 팔로우한 사람들의 사진
		Page<Images> pageImages = ImageReposit.findImage(AcDetails.getVo().getId(), pageable);
		System.out.println("스크롤");
		List<Images> images = pageImages.getContent();
		
		
		model.addAttribute("images", images);
		
		for(Images image : images) {
			Likes like = LikeReposit.findByUserIdAndImageId(AcDetails.getVo().getId(), image.getId());
		
			if(like != null) {
				image.setHeart(true);
			}
		}
		
		//feed 좋아요 수 누적
		for (Images image : images) {
			int likeCount = LikeReposit.countByImageId(image.getId());
			image.setLikeCount(likeCount);
		}
		return images;
	}

	
	@GetMapping("/explore")
	public String explore(Model model, @PageableDefault(size = 9, sort = "id",direction = Direction.DESC) Pageable pageable) {
		
		Page<Images> pImages = ImageReposit.findAll(pageable);
		List<Images> lImages = pImages.getContent();
		for(Images image : lImages) {
			int likeCount = LikeReposit.countByImageId(image.getId());
			image.setLikeCount(likeCount);
		}
		model.addAttribute("images",lImages);
		
		System.out.println("explore페이지");
		return "/explore";
	}

	@GetMapping("/user/profile/{id}")
	public String profile(@PathVariable int id, @AuthenticationPrincipal AccountDetails AcDetails, Model model) {
		
		Optional<UserVO> oUser = AcReposit.findById(id);
		UserVO user = oUser.get();

		model.addAttribute("user",user);
		
		//업로드 이미지 카운트
		int imageCount = user.getImage().size();
		model.addAttribute("imageCount", imageCount);

		//팔로우 수 카운트
		int followCount = FollowReposit.countByFollowingId(user.getId());
		model.addAttribute("followCount", followCount);

		//팔로워 수 카운트
		int followerCount = FollowReposit.countByFollowerId(user.getId());
		model.addAttribute("followerCount", followerCount);

		for (Images images : user.getImage()) {
			int likeCount = LikeReposit.countByImageId(images.getId());
			images.setLikeCount(likeCount);
		}
		
		int followCheck = FollowReposit.countByFollowingIdAndFollowerId(user.getId(), id);
		model.addAttribute("followCheck", followCheck);
		System.out.println("followCheck = "+followCheck );
		return "/user/profile";
	}

	@GetMapping("/user/edit-profile")
	public String editProfile(@AuthenticationPrincipal AccountDetails AcDetails,Model model) {
		
		Optional<UserVO> OpUser = AcReposit.findById(AcDetails.getVo().getId());
		UserVO user = OpUser.get();
		model.addAttribute("user",user);
		
		return "/user/edit-profile";
	}
	
	@PutMapping("/user/UpdateProfile")
	public String UpdateEditProfile(@AuthenticationPrincipal AccountDetails AcDetails,Model model, UserVO uservo) {
		
		Optional<UserVO> OpUser = AcReposit.findById(AcDetails.getVo().getId());
		UserVO user = OpUser.get();
		user.setUsername(uservo.getUsername());
		user.setName(uservo.getName());
		user.setWebsite(uservo.getWebsite());
		user.setIntro(uservo.getIntro());
		user.setPhone(uservo.getPhone());
		user.setEmail(uservo.getEmail());
		AcReposit.save(user);
		System.out.println("수정된유저정보"+user);
		return "redirect:/user/profile/"+AcDetails.getVo().getId();
	}

	@PostMapping("/user/profileUpload")
	// @AuthenticationPrincipal 현재 세션의 사용자정보를 가져옴
	public String userProfileUpload(@RequestParam("profileImage") MultipartFile file,
			@AuthenticationPrincipal AccountDetails AcDetails) throws IOException {

		
		UserVO vo = AcDetails.getVo();

		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid+"_"+file.getOriginalFilename();
		Path filePath = Paths.get(fileRealPath+uuidFilename);
		Files.write(filePath,file.getBytes());
		
		Optional<UserVO> OpUser =AcReposit.findById(vo.getId());
		UserVO user = OpUser.get();
		user.setProfileImage(uuidFilename);
		AcReposit.save(user);

		return "redirect:/user/profile/" + vo.getId();
	}

}
