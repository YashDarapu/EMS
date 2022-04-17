package event.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import event.model.Admin;
import event.repository.AdminRepos;

@Service
public class AdminDao {
	
	@Autowired
	AdminRepos arep;
	
	public Admin addAdmin(Admin admin) {
		return arep.save(admin);
	}
	
	public List<Admin> display(){
		return arep.findAll();
	}

}
