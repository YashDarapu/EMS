package event.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import event.model.Account;
import event.repository.AccountRepos;

@Service
public class AccountDao {
	
	@Autowired
	AccountRepos arep;
	
	public Account addProduct(Account acc) {
		return arep.save(acc);
	}
	

}
