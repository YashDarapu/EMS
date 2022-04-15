package event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import event.model.User;

@Repository
public interface UserRepos extends JpaRepository<User,Integer> {
}
