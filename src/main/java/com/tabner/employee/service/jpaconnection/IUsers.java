package com.tabner.employee.service.jpaconnection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tabner.employee.service.entities.User;
@Repository
public interface IUsers extends JpaRepository<User,Long>{

	@Query("SELECT a FROM User a where a.emailAddress=?1")
	public User finduserByUserName(String username);
}
