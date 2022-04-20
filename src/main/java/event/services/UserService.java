package event.services;

import java.util.List;

import event.model.User;

public interface UserService{
	public User addUser(User user);
	public List<User> getAllUser();
}
