package ec.blaze.wscore.services;



import ec.blaze.wscore.model.Product;

public interface ProductService {
	  
	public Iterable<Product> findAll();
	public Product save(Product product);	
	public Iterable<Product> productByPage(int pageNumber, int pageSize);
	public Product findOneById(String id);
	public void delete(Product product);
	    
	
}	