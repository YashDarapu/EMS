package event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import event.model.Admin;

@Repository
public interface AdminRepos extends JpaRepository<Admin,Integer> {

	@Query("SELECT a FROM Admin a WHERE a.adminName=?1 AND a.adminPassword=?2")
	public Admin getAdmin(String name,String pwd);
}
