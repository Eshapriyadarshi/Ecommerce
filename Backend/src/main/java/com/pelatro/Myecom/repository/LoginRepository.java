package com.pelatro.Myecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pelatro.Myecom.model.User;

public interface LoginRepository extends JpaRepository<User, Long>{
	
    @Query(value = "from User u where u.emailId = :emailId and u.password = :password")
	public User findbyEmailIdAndPassword(@Param("emailId") String emailId, @Param("password") String password);
}
