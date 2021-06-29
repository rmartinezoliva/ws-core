package ec.blaze.wscore.services;



import ec.blaze.wscore.model.Order;
import ec.blaze.wscore.model.Product;

public interface OrderService {
	  
	public Iterable<Order> findAll();
	public Order save(Order product);	
	public Iterable<Order> orderByPage(int pageNumber, int pageSize);
	public Order findOneById(String id);
	public void delete(Order Order);
	    
	
}	