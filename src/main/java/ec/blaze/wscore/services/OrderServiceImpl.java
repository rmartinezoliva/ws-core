package ec.blaze.wscore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ec.blaze.wscore.model.Order;
import ec.blaze.wscore.model.Product;
import ec.blaze.wscore.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}
	
	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	@Override
	public Iterable<Order> orderByPage(int pageNumber, int pageSize){	     
	      Iterable<Order> res = orderRepository.findAll(PageRequest.of(pageNumber,pageSize));
	      return  res;
	   }
	
	
	@Override
	public Order findOneById(String id) {
		return orderRepository.findOneById(id);
	}

	@Override
	public void delete(Order Order) {
		orderRepository.delete(Order);
		
	}
	
}