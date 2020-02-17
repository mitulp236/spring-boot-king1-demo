package com.project.king1.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.king1.model.User;
import com.project.king1.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> get(){
		return userService.get();
	}
	
	@GetMapping("/user/{id}")
	public User get(@PathVariable int id){
		User affecteduser = userService.get(id);
		if(affecteduser == null) {
			throw new RuntimeException("User with id "+id+" is not found !");
		}
		return affecteduser;
	}

	@PostMapping("/user")
	public User save(@RequestBody User user){
		userService.save(user);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		 return "User Successfully deleted with id "+id;
	}
	
	@PutMapping("/user")
	public User update(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	
}



