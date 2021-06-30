package com.smv.sistemas_operativos.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.sistemas_operativos.models.Response;
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

	public Response insert(User user) {
		try {

			userRepository.save(user);
			Response response = new Response(true, "El usuario fue guardado con éxito");
			return response;
		} catch (Exception e) {
			Response response = new Response(false, "Se presento un error al guardar el usuario");
			return response;
		}
	}

	public User findById(Integer id) {
		User user = userRepository.findById(id).orElse(null);
		return user;
	}

	public Response delete(Integer id) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {			
			userRepository.delete(user);
			Response response = new Response(true, "Usuario eliminado con éxito");
			return response;
		}
		Response response = new Response(false, "Error al guardar el usuario");
		return response;
	}
}
