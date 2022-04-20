package event.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import event.exception.AdminException;
import event.model.Admin;
import event.model.Event;
import event.repository.AdminRepos;
import event.repository.EventRepo;
import event.services.EventService;

@Service
public class EventDao implements EventService{
	
	@Autowired
	EventRepo rep;
	
	@Autowired
	AdminRepos arep;

	public Event addEvent(Event event) throws AdminException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter adminName:");
		String name=sc.next();
		System.out.println("Enter adminPassword:");
		String pwd=sc.next();
	
		if(arep.getAdmin(name,pwd) instanceof Admin)
			return rep.save(event);
		else
			throw new AdminException("Admin Authentication failed..");
	}

	@Override
	public List<Event> getEvents() {
		return rep.findAll();
	}

	@Override
	public String delete(int id) throws AdminException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter adminName:");
		String name=sc.next();
		System.out.println("Enter adminPassword:");
		String pwd=sc.next();
		
		if(arep.getAdmin(name,pwd) instanceof Admin)
		{	
			rep.deleteById(id);
			return "Delete Event";
		}
		else
			throw new AdminException("Admin Authentication failed..");
	}
}
