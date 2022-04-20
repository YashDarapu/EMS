package event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import event.model.Admin;
import event.model.Event;
import event.repository.AdminRepos;
import event.repository.EventRepo;

@SpringBootTest
class EmsApplicationTests {
	
	@Autowired
	AdminRepos arep;
	
	@Autowired
	EventRepo erep;

	@Test
	public void testAddAdmin() {
		Admin a=new Admin();
		a.setAdminId(4);
		a.setAdminName("Wen");
		a.setAdminPassword("wen123");
		arep.save(a);
		assertNotNull(arep.findById(4).get());
	}
	
	@Test
	public void testDisplayAdmin() {
		List<Admin> l=arep.findAll();
		assertThat(l).size().isGreaterThan(0);
	}
	
	@Test
	public void testAddEvent() {
		Event e=new Event();
		e.setEventId(12);
		e.setEventName("Marraige");
		e.setCostPerHead(50);
		erep.save(e);
		assertNotNull(erep.findById(12).get());
	}
	
	@Test
	public void testDisplayEvents() {
		List<Event> l=erep.findAll();
		assertThat(l).size().isGreaterThan(0);
	}
}
