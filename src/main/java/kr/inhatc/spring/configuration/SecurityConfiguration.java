package kr.inhatc.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(HttpSecurity security) throws Exception{
		
	      //인증되지 않은 사용자 접근 경로
	     security.authorizeRequests().antMatchers("/main").permitAll();
	      
	      //상담원 권한
	     security.authorizeRequests().antMatchers("/chat/**").hasAnyRole("CONSULTANT","ADMIN");
	     security.authorizeRequests().antMatchers("/con/**").hasAnyRole("ADMIN");
		
		//RestFull 사용하기 위해서는 비활성화.
		security.csrf().disable();
		
		//로그인 관련 페이지와 성공시 이동할 페이지 설정
		security.formLogin().loginPage("/login/login").defaultSuccessUrl("/",true);
		
		//실패시 이동할 페이지
		security.exceptionHandling().accessDeniedPage("/login/accessDenied");
		
		// 로그아웃요청시 세션 강제 종료, 시작 페이지로 이동
		
		security.logout().logoutUrl("/login/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
