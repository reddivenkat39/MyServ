package com.tabner.employee.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tabner.employee.service.jpaconnection.IUsers;

@Controller
public class Login {
@Autowired
IUsers user;
@RequestMapping("/login")
public String LoginPage(Model m){
	return "login";
}
@RequestMapping("/success")
public String success(Model m){
	return "success";
}
}
