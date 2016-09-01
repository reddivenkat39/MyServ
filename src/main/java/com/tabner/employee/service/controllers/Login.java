package com.tabner.employee.service.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tabner.employee.service.entities.User;
import com.tabner.employee.service.jpaconnection.IUsers;

@Controller
public class Login {
@Autowired
IUsers user;
@RequestMapping(value="/login",method = RequestMethod.GET)
public String LoginPage(Model m,HttpServletRequest request){
	Cookie[] cookie = request.getCookies();
	boolean flag = false;
	int i=0;
	if(cookie!=null){
	while(cookie.length>i){
	if(cookie[i].getName().equals("LOGINID")){
	flag = true;
	}
	i++;
	}
	}

	if(flag){
		return "redirect:";
	}
	else
	 return "login";
}


@RequestMapping("/SignUp")
public String signuppage(Model m){
	return "SignUpForm";
}


@RequestMapping("/RegisterSuccess")
public String createUser(@RequestParam("email")String email,@RequestParam("firstname")String fname,@RequestParam("lastname")String lname,
		@RequestParam("password")String password) {
	User users = new User();
	users.setEmailAddress(email);
	users.setFirstName(fname);
	users.setLastName(lname);
	users.setLoginPassword(password);
	user.saveAndFlush(users);
   return "login";
}


}
