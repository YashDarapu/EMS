package event.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="event")
public class Event {
	
		@Id
		@DecimalMin(value="1" , message = "minimum value shoud be one")
		private int eventId;
		@NotBlank(message = "Enter event name")
		private String eventName;
		@NotNull(message="Enter cost/head")
		private double costPerHead;
		
		public int getEventId() {
			return eventId;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
		}
		public String getEventName() {
			return eventName;
		}
		public void setEventName(String eventName) {
			this.eventName = eventName;
		}
		public double getCostPerHead() {
			return costPerHead;
		}
		public void setCostPerHead(double costPerHead) {
			this.costPerHead = costPerHead;
		}
}
