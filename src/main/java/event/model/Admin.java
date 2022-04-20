package event.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@DecimalMin(value="1" , message = "minimum value shoud be one")
	private int adminId;
	@NotBlank(message = "Enter admin name and password")
	private String adminName,adminPassword;
	
	@JsonManagedReference
	@OneToMany(mappedBy="admin",cascade=CascadeType.ALL)
	private List<User> users;

	//Getters and Setters
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
