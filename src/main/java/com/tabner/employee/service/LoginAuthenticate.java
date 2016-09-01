package com.tabner.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled =true)
public class LoginAuthenticate  extends WebSecurityConfigurerAdapter{
	@Autowired
	@Qualifier("userDetailsService")
	MyUserDetailService userDetailsService;
	
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService);
   }
	
   @Override
   public void configure(WebSecurity web) throws Exception {
     web.ignoring().antMatchers("/js/**","/css/**","/username","/SignUp");
   }
   
	@Override
	protected void configure(HttpSecurity http) throws Exception{     
		 http.authorizeRequests()
		 .antMatchers("/resources/**","/RegisterSuccess")
		 .permitAll()
		 .anyRequest().authenticated()
		 .and().formLogin().loginPage("/login").failureUrl("/login?error")
		 .permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").invalidateHttpSession(true)
		 .deleteCookies("JSESSIONID","LOGINID").permitAll();
		 http.csrf().disable();
		 
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
