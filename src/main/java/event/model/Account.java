package event.model;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
	
		@Id
		private int accountId;
		private double balance;
		private int accountPin;
		
		@OneToOne
		@JoinColumn(name="userId")
		private User user;
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public int getAccountPin() {
			return accountPin;
		}
		public void setAccountPin(int accountPin) {
			this.accountPin = accountPin;
		}

}
