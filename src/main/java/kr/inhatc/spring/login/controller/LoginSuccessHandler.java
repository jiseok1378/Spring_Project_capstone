package kr.inhatc.spring.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import kr.inhatc.spring.consultant.entity.Consultant;
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req,HttpServletResponse res, 
    							Authentication authdata)
			throws IOException, ServletException {
		//인증된 사용자의 정보를 추출
		Consultant dto = 
				(Consultant)authdata.getPrincipal();
		System.out.println("인증후=>"+dto);
		//권한리스트를 추출
		String role = dto.getRole();
		System.out.println("!!!!!!!_!_!_!_!_!_" + role);
		req.getSession().setAttribute("role", role);
		res.sendRedirect("/main");
	}
}
