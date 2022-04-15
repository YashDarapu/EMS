package event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import event.dao.UserDao;
import event.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserDao dao;
	
	@PostMapping(path="/newUser")
	public User addUser(@RequestBody User user){
		return dao.addUser(user);
	}

}
