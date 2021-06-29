package ec.blaze.wscore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ec.blaze.wscore.model.Order;
import ec.blaze.wscore.model.Product;

@Repository
public interface  OrderRepository extends MongoRepository<Order, Integer>,PagingAndSortingRepository<Order, Integer>{
		public List<Order> findAll();
		public Order findOneById(String id);
}
