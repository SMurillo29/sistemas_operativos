package com.smv.sistemas_operativos.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.sistemas_operativos.models.User;
import com.smv.sistemas_operativos.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	IUserRepository userRepository;

	public long getCount() {
		long count = userRepository.count();
		return count;
	}

	public List<User> findAll() {
		List<User> user = new ArrayList<>();
		userRepository.findAll().forEach(user::add);
		return user;

	}

	public boolean insert(User user) {
		try {

			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public User findById(Integer id) {
		User user = userRepository.findById(id).orElse(null);
		return user;
	}

	public boolean delete(Integer id) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}
}
