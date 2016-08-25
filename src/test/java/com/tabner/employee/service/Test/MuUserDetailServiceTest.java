package com.tabner.employee.service.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tabner.employee.service.Application;
import com.tabner.employee.service.MyUserDetailService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MuUserDetailServiceTest {
	@Autowired
	@Qualifier("userDetailsService")
	MyUserDetailService userDetailsService;

	@Test
	public void test() {
		
		String email = userDetailsService.loadUserByUsername("venkata@gmail.com").getUsername();
		String password = userDetailsService.loadUserByUsername("venkata@gmail.com").getPassword();
		assertEquals(email+password,"venkata@gmail.comtest");
		
		
	}

}
