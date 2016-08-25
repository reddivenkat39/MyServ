package com.tabner.employee.service.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tabner.employee.service.Application;
import com.tabner.employee.service.entities.User;
import com.tabner.employee.service.jpaconnection.IUsers;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class JpaTest {
@Autowired
IUsers user;
	@Test
	public void test() {
		User u = user.finduserByUserName("venkata@gmail.com");
		String actual = u.getFirstName();
		String asserting = "venkat";
		assertEquals(actual,asserting);
	}

}
