package com.pelatro.Myecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pelatro.Myecom.model.User;

@Repository
public interface SignupRepository extends JpaRepository<User, Long>{
	
    @Query(value = "from User u where u.emailId = :emailId")
    public User findbyEmailId(@Param( "emailId" )String emailId);
}
