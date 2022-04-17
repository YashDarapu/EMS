package event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import event.dao.UserDao;
import event.model.Admin;
import event.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserDao dao;
	
	@PostMapping(path="/newUser")
	public User addUser(@RequestBody User user){
		return dao.addUser(user);
	}
	@GetMapping(path="/displayUsers")
	public List<User> display(){
		return dao.display();
	}

}
