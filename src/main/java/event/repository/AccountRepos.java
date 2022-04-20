package event.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import event.model.Account;

public interface AccountRepos  extends JpaRepository<Account,Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Account a SET a.balance=?2 WHERE a.accountId=?1")
	public void refund(int accid,double amount);

}
