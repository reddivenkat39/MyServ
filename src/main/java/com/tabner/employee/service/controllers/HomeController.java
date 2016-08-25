package com.tabner.employee.service.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tabner.employee.service.entities.User;
import com.tabner.employee.service.jpaconnection.IUsers;


@Controller
public class HomeController {

	@Autowired
	IUsers users;
    @RequestMapping("/users")
    public ResponseEntity<List<User>> greeting() {
    	List<User> all = users.findAll();
        return new ResponseEntity<List<User>>(all,HttpStatus.OK);
    }
}
