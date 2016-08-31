package com.tabner.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tabner.employee.service.entities.User;
import com.tabner.employee.service.jpaconnection.IUsers;
/*
 * This is to override the userDetailService
 */
@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService{
@Autowired	
 IUsers userrepo;

public String error = null;
		@Override
		public UserDetails loadUserByUsername(String username)
				throws UsernameNotFoundException {
			error = username;
			User user = userrepo.finduserByUserName(username);
			if (user == null) {
				throw new BadCredentialsException("User not found");
			}
			
			List<GrantedAuthority> auth = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
			if(user.getEmailAddress()!=null){
			if (user.getEmailAddress().equals("swamy@gmail.com")) {
				auth = AuthorityUtils
						.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
			}
			}
			
			String password = user.getLoginPassword();
			String Email = user.getEmailAddress();
			System.out.println(password+ " "+ Email+" ");
			return new org.springframework.security.core.userdetails.User(Email, password,
					auth);
}
}
