package event.services;

import java.util.List;

import event.exception.AdminException;
import event.model.Event;

public interface EventService {
	public Event addEvent(Event event) throws AdminException;
	public List<Event> getEvents();
	public String delete(int id) throws AdminException;
}
