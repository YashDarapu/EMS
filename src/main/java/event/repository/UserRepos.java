package event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import event.model.User;

@Repository
public interface UserRepos extends JpaRepository<User,Integer> {

	@Query("SELECT u FROM User u WHERE u.userName=?1")
	public User getByName(int userName);

	@Query("SELECT u FROM User u WHERE u.userName=?1 AND u.userPassword=?2")
	public User getUser(String name, String pwd);
}
