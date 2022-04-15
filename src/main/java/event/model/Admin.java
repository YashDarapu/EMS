package event.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	private @Getter@Setter int adminId;
	private @Getter@Setter String adminName,adminPassword;
	
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	//@JoinColumn(name = "userId")
//	private @Getter@Setter List<User> users=new ArrayList<>();

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
