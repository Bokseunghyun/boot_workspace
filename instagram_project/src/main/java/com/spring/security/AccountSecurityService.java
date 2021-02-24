package com.spring.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.spring.domain.UserVO;
import com.spring.repository.AccountRepository;

@Service
public class AccountSecurityService implements UserDetailsService{
	
	@Autowired
	private AccountRepository AcReposit;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("loadUserByUsername : "+username);
		UserVO vo = AcReposit.findByUsername(username);
		
		AccountDetails AcDetails = null;
		if(vo != null) {
			
			AcDetails = new AccountDetails();
			AcDetails.setVo(vo);
			
		}
		else{
			throw new UsernameNotFoundException("존재하지않는 아이디 : "+ username);
		}
		return AcDetails;
	}

}
