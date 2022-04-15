package event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import event.dao.AdminDao;
import event.model.Admin;

@RestController
public class AdminController {
	
	@Autowired
	AdminDao dao;
	
	@PostMapping(path="/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return dao.addAdmin(admin);
	}
}