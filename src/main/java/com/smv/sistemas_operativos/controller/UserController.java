package com.smv.sistemas_operativos.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.smv.sistemas_operativos.models.User;
import com.smv.sistemas_operativos.services.UserService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class UserController {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	 UserService userService;
	
	
	@RequestMapping("/user/count")
	public long count() {
		log.info("Total de registros en la base de datos siso, tabla user");
		return userService.getCount();
	}
	
	@RequestMapping("/user/all")
	public List<User> getAll(){
		log.info("Obtiene todos los datos de la base de datos siso");
		return userService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/user/add")
	public boolean add(@RequestBody User user) {		
		log.info("Creando/Actualizando ubicacionr - "+ user.toString());
		return userService.insert(user);		
	}
	
	@RequestMapping("/user/id/{id}" )
	public User findById(@PathVariable Integer id) {
		log.info("Searching user with ID - "+ id);		
		return userService.findById(id);
	}	

	
	@RequestMapping(method=RequestMethod.DELETE, value="/user/delete/{id}")
	public boolean delete(@PathVariable Integer id) {		
		return userService.delete(id);
	}	

}
