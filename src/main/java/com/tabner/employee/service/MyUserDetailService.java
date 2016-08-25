package com.tabner.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
private final IUsers userrepo;
	@Autowired
	public MyUserDetailService(IUsers user){
		this.userrepo = user;
	}

		@Override
		public UserDetails loadUserByUsername(String username)
				throws UsernameNotFoundException {
			User user = userrepo.finduserByUserName(username);
			if (user == null) {
				return null;
			}
			List<GrantedAuthority> auth = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
			if (username.equals("admin")) {
				auth = AuthorityUtils
						.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
			}
			String password = user.getLoginPassword();
			String Email = user.getEmailAddress();
			return new org.springframework.security.core.userdetails.User(Email, password,
					auth);
}
}
