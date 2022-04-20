package event.services;

import java.util.List;

import event.exception.ProductException;
import event.exception.UserException;
import event.model.Product;
import event.model.Status;

public interface ProductService {
public Product addProduct(Product product);
public List<Product> getProducts();
public List<Product> getUserEvents(int userid) throws UserException;
public String cancel(int productId) throws ProductException, UserException;
}
