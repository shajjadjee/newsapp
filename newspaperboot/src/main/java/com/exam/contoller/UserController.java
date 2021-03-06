package com.exam.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.UserModel;
import com.exam.repo.UserDao;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDao userDao;
	
	@PostMapping("/add")
	public UserModel addUser(@RequestBody UserModel user) {
		System.out.println(user.toString());
		UserModel uM = userDao.saveAndFlush(user);
		
		return uM;
	}
	@GetMapping("/list")
	public List<UserModel> getAll() {
		List<UserModel> uM = userDao.findAll();		
		return uM;
	}
	@GetMapping("/one/{id}")
	public UserModel getById(@PathVariable("id") long id) {
		UserModel uM = userDao.findById(id).get();
		return uM;
	}
	@GetMapping("/delete/{id}")
	public UserModel deleteById(@PathVariable("id") long id) {
		userDao.deleteById(id);
		return new UserModel();
	}
	@PostMapping("/login")
	public UserModel login(@RequestBody UserModel user) {
		UserModel uM = userDao.getByUsername(user.getUsername());
		if(uM !=null) {
			if(uM.getPassword().equals(user.getPassword()) ) {
				return uM;
			}
		}
		return new UserModel();
	}
}
