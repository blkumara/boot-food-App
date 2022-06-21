package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ty.bootfoodapp.dao.UserDao;
import com.ty.bootfoodapp.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	public List<User> allUser() {
		return userDao.allUser();
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public User deleteUser(int id) {
		return userDao.deleteUser(id);

	}

	public User updateUser(User user, int id) {
		return userDao.updateUser(user, id);
	}

	public List<User> findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	public List<User> findByPhone(long phone) {
		return userDao.findByPhone(phone);
	}

	public User validateUser(String email, String password) {
		return userDao.validateUser(email, password);
	}

}
