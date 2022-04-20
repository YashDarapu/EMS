package event.dao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import event.exception.ProductException;
import event.exception.UserException;
import event.model.Account;
import event.model.Admin;
import event.model.Product;
import event.model.Status;
import event.model.User;
import event.repository.AccountRepos;
import event.repository.ProductRepo;
import event.repository.UserRepos;
import event.services.ProductService;

@Service
public class ProductDao implements ProductService{

	@Autowired
	ProductRepo prep;
	@Autowired
	AccountRepos arep;
	@Autowired
	UserRepos urep;
	
	@Override
	public Product addProduct(Product product) {
		
		return prep.save(product);
	}
	
	@Override
	public List<Product> getProducts() {
		return prep.findAll();
	}
	
	@Override
	public List<Product> getUserEvents(int userName) throws UserException {
		
		User u=urep.getByName(userName);
		
		if(u==null)
			throw new UserException("Customer not found..");
		else 
			return prep.userProducts(u.getUserId());
	}
	
	@Override
	public String cancel(int productId) throws ProductException, UserException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter userName:");
		String name=sc.next();
		System.out.println("Enter userPassword:");
		String pwd=sc.next();
		
		if(urep.getUser(name,pwd) instanceof User)
		{	
			Product p=prep.getById(productId);
		
		if(p==null)
			throw new ProductException("Product not found..");
		
		else if(p.getStatus()==Status.Canceled)
			throw new ProductException("Event is already canceled..");
		
		else {
		prep.cancel(productId, Status.Canceled);	
		double price=p.getAmount();
		Account acc=p.getUser().getAcc();
		arep.refund(acc.getAccountId(),price+acc.getBalance());
		return "Event Canceled";
		}
		}
		else
			throw new UserException("User Authentication Failed");
	}

}
