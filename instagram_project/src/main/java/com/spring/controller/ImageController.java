package com.spring.controller;

import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.Images;
import com.spring.domain.Likes;
import com.spring.domain.Tag;
import com.spring.domain.UserVO;
import com.spring.repository.ImageRepository;
import com.spring.repository.LikeRepository;
import com.spring.repository.TagRepository;
import com.spring.security.AccountDetails;


@Controller
public class ImageController {

	@Autowired
	private ImageRepository ImageReposit;
	
	@Autowired
	private TagRepository TagReposit;
	
	
	@Value("${spring.servlet.multipart.location}") // application.properties에 설정한 logging.file.path에 해당하는 프로퍼티를 fileRealPath에 넣음
	private String fileRealPath;

	
	@GetMapping("/image/upload")
	public String imageUpload() {
		System.out.println("이미지 업로드");
		
		return "/image/image_upload";
	}
	
	@PostMapping("/image/imageUpload")
	public String ImageUpload(@AuthenticationPrincipal AccountDetails AcDetails, @RequestParam("file")MultipartFile file, @RequestParam("caption") String caption, @RequestParam("location")String location, @RequestParam("tags")String tags, Model model) throws IOException {
		
		UserVO vo = AcDetails.getVo();
		
		UUID uuid = UUID.randomUUID();
		String uuidFileName = uuid + "_" + file.getOriginalFilename();
		
		Path filePath = Paths.get(fileRealPath+uuidFileName);
		Files.write(filePath,file.getBytes());
		
		
		Images images = new Images();
		images.setCaption(caption);
		images.setLocation(location);
		images.setUser(vo);
		images.setPostImage(uuidFileName);
		
		ImageReposit.save(images);
		List<String> tagList = tagParser(tags);
		System.out.println(images);
		
		for(String tag : tagList) {
			Tag t = new Tag();
			t.setName(tag);
			t.setImage(images);
			
			TagReposit.save(t);
			images.getTags().add(t);
		}
		model.addAttribute("images",vo);
		return "redirect:/feed";
	}
	

	
	
	
	
	
	
	
	
	
public static List<String> tagParser(String tags){
		
		String temp[] = tags.split("#"); //#을 기준으로 문자열을 나눔
		
		List<String> tagList = new ArrayList<String>();
		
		int length = temp.length;
		
		for(int i=1; i<length; i++) {
			tagList.add(temp[i]);
		}
		
		return tagList;
	}
	

}