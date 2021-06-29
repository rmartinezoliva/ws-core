package ec.blaze.wscore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ec.blaze.wscore.model.Product;
import ec.blaze.wscore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public void delete(Product product) {
		 productRepository.delete(product);
	}
	@Override
	public Product findOneById(String id) {
		return productRepository.findOneById(id);
	}
	
	@Override
	public Iterable<Product> productByPage(int pageNumber, int pageSize){	     
	      Iterable<Product> res = productRepository.findAll(PageRequest.of(pageNumber,pageSize));
	      return  res;
	   }
}