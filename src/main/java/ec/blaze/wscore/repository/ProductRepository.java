package ec.blaze.wscore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ec.blaze.wscore.model.Product;

@Repository
public interface  ProductRepository extends MongoRepository<Product, Integer>,PagingAndSortingRepository<Product, Integer>{
		public List<Product> findAll();
		public Product findOneById(String id);
}
