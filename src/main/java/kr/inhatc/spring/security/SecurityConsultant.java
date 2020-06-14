package kr.inhatc.spring.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import kr.inhatc.spring.consultant.entity.Consultant;

public class SecurityConsultant extends User {
	
	/**
	 * 
	 */
	

	
	private static final long serialVersionUID = 1L;
	private Consultant consultant;
	private HttpServletRequest request;
	public SecurityConsultant(Consultant consultant) {
		// 암호화 처리 전까진 패스워드 앖에 {noop}추가
		super(consultant.getCId(), consultant.getPw(), AuthorityUtils.createAuthorityList(consultant.getRole()));
		// TODO Auto-generated constructor stub
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!" + consultant.getCId());
		this.consultant = consultant;
	}


}
