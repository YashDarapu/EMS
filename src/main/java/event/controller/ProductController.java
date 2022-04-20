package event.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import event.dao.ProductDao;
import event.exception.ProductException;
import event.exception.UserException;
import event.model.Product;


@RestController
public class ProductController {

	org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductDao pdao;
	
	@PostMapping(path="/addProduct")
	public Product addProduct(@RequestBody Product product) {
		if(pdao.addProduct(product)!=null)
			log.info("Product object created");
			else
				log.error("Product object not created");
		return pdao.addProduct(product);
	}
	
	@GetMapping(path="/dispalyAll")
	public List<Product> getProduct(){
		if(pdao.getProducts()!=null)
			log.info("All Product details are displayed");
		else
			log.info("No Products displayed");
		return pdao.getProducts();
	}
		
	@GetMapping(path="/customerProducts/{userName}")
	public List<Product> getUserEvents(@PathVariable int userName) throws UserException {
		if(pdao.getUserEvents(userName)!=null)
			log.info("User products are displayed");
		else
			log.info("User has no products");
		return pdao.getUserEvents(userName);
	}
	
	@PutMapping(path="/cancelEvent/{productId}")
	public String cancel(@PathVariable int productId) throws ProductException{
		return pdao.cancel(productId);
	}
	
}
