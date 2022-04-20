package event.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	//@DecimalMin(value="1" , message = "minimum value shoud be one")
	private int productId;
	
	@OneToOne
	@JoinColumn(name="eventId")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	//@Column(columnDefinition = "Date default 2022-04-20")
	private Date date;
	//private Time time;
	private String venue;
	
	private boolean breakfast,lunch,dinner;
	private int noOfAttendees;
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	//Getters and Setters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
//	public Time getTime() {
//		return time;
//	}
//	public void setTime(Time time) {
//		this.time = time;
//	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public boolean isBreakfast() {
		return breakfast;
	}
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}
	public boolean isLunch() {
		return lunch;
	}
	public void setLunch(boolean lunch) {
		this.lunch = lunch;
	}
	public boolean isDinner() {
		return dinner;
	}
	public void setDinner(boolean dinner) {
		this.dinner = dinner;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getAttendees() {
		return noOfAttendees;
	}
	public void setAttendees(int attendees) {
		this.noOfAttendees = attendees;
	}
	
}
