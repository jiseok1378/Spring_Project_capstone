package kr.inhatc.spring.login.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.consultant.entity.Consultant;
import kr.inhatc.spring.consultant.repository.ConsultantRepository;
import kr.inhatc.spring.security.SecurityConsultant;

@Service
public class SecurityUserDetailService implements UserDetailsService{
	
	
	@Autowired
	private ConsultantRepository consultantRepository;
	@Autowired
	private HttpServletRequest request;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Consultant> optional = consultantRepository.findByCId(username);
		
		
		if(optional.isPresent()) {
			Consultant consultant = optional.get();
			return new SecurityConsultant(consultant);
		}
		else {
			throw new UsernameNotFoundException("사용자 없음");
		}
	}
	
}
