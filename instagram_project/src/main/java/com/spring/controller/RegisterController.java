package com.spring.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.UserVO;
import com.spring.repository.AccountRepository;
import com.spring.repository.FollowRepository;


@Controller
public class RegisterController {
	
	@Autowired
	private AccountRepository acReposit;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/user/register")
	public void getRegister(Model model) {
		model.addAttribute("userVO",new UserVO());
		
		System.out.println("회원가입페이지");
	}
	
	@PostMapping("/user/register")
	public String Register(@ModelAttribute("userVO") @Valid UserVO vo, BindingResult bindingresult)throws Exception {
		
			String encodingPassword = encoder.encode(vo.getPassword());
			vo.setPassword(encodingPassword);
			
			acReposit.save(vo);
			System.out.println(vo);
		
		return "redirect:/";
	}
	
	
}
