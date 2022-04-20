package event.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import event.dao.EventDao;
import event.exception.AdminException;
import event.model.Event;

@RestController
public class EventController {

	org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(EventController.class);

	@Autowired
    EventDao edao;
	
	@PostMapping(path="/addEvent")
	public Event addEvent(@Valid @RequestBody Event event) throws AdminException {
		if(edao.addEvent(event)!=null)
			log.info("Event object created");
			else
				log.error("Event object not created");
		return edao.addEvent(event);
	}
	
	@GetMapping(path="/displayEvents")
	public List<Event> getEvents(){
		if(edao.getEvents()!=null)
			log.info("All events are displayed");
		else
			log.info("No events");
		return edao.getEvents();
	}
	
	@DeleteMapping(path="/deleteEvent/{eventId}")
	public String delete(@PathVariable int eventId) throws AdminException {
		return edao.delete(eventId);
	}
}
