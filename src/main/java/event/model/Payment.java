package event.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

@Entity
@Table(name="payment")
public class Payment {
	
		@Id
		@DecimalMin(value="1" , message = "minimum value shoud be one")
		private int paymentId;
		private int accountId;
		private double amountPriorTransaction;
		private double amountPostTransaction;
		private LocalDate date;
		public int getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public double getAmountPriorTransaction() {
			return amountPriorTransaction;
		}
		public void setAmountPriorTransaction(double amountPriorTransaction) {
			this.amountPriorTransaction = amountPriorTransaction;
		}
		public double getAmountPostTransaction() {
			return amountPostTransaction;
		}
		public void setAmountPostTransaction(double amountPostTransaction) {
			this.amountPostTransaction = amountPostTransaction;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = LocalDate.now();
		}
}

