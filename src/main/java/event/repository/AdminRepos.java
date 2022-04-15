package event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import event.model.Admin;

@Repository
public interface AdminRepos extends JpaRepository<Admin,Integer> {
}
