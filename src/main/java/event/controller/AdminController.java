package event.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import event.dao.AdminDao;
import event.model.Admin;

@RestController
public class AdminController {
	
	org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminDao dao;
	
	@PostMapping(path="/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		if(dao.addAdmin(admin)!=null)
			log.info("Admin object created");
			else
				log.error("Not able to create admin object");
		return dao.addAdmin(admin);
	}
	
	@GetMapping(path="/displayAdmins")
	public List<Admin> display(){
		
		if(dao.display()!=null)
			log.info("All Admin's details are displayed");
		else
			log.info("Admin Details not found");
		return dao.display();
	}
}