package event.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import event.model.Product;
import event.model.Status;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
	
	@Modifying //Used for insert/update/delete queries
	@Transactional
	@Query("UPDATE Product p SET p.status=?2 WHERE p.productId=?1")
	public void cancel(int productId,Status status);

	@Query("SELECT p FROM Product p WHERE userId=?1")
	public List<Product> userProducts(int userId);

}
