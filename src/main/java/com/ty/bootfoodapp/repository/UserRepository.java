package com.ty.bootfoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.bootfoodapp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

	List<User> findByPhone(long phone);

	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
	User validateUser(@Param("email") String email, @Param("password") String password);

}
