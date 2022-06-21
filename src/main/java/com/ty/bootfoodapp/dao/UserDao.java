package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User saveUser( User user) {
		return userRepository.save(user);
	}

	public List<User> allUser() {
		return userRepository.findAll();
	}

	public User getUserById( int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	public User deleteUser( int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			User user = userRepository.getById(id);
			userRepository.delete(user);
			return user;
		}

	}

	public User updateUser( User user,  int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return userRepository.save(user);

		}
	}

	public List<User> findUserByEmail( String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> findByPhone( long phone) {
		return userRepository.findByPhone(phone);
	}

	public User validateUser( String email,  String password) {
		return userRepository.validateUser(email, password);
	}

}
