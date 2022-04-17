package event.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import event.model.Admin;
import event.model.User;
import event.repository.UserRepos;

@Service
public class UserDao {
	
	@Autowired
	UserRepos urep;
	
	public User addUser(User user) {
		return urep.save(user);
	}

	public List<User> display() {
		return urep.findAll();
	}
}
