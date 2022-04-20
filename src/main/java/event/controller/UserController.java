package event.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import event.dao.UserDao;
import event.model.User;

@RestController
public class UserController {
	
	org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDao udao;
	
	@PostMapping(path="/newUser")
	public User addUser(@RequestBody User user){
		if(udao.addUser(user)!=null)
			log.info("User object created");
			else
				log.error("User object not created");
		return udao.addUser(user);
	}
	@GetMapping(path="/displayUsers")
	public List<User> display(){
		if(udao.display()!=null)
			log.info("All User's details are displayed");
		else
			log.info("Users not found");
		return udao.display();
	}

}
