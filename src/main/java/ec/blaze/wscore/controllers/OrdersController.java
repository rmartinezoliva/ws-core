package ec.blaze.wscore.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.blaze.wscore.model.Order;
import ec.blaze.wscore.model.Product;
import ec.blaze.wscore.request.RequestId;
import ec.blaze.wscore.request.RequestOrder;
import ec.blaze.wscore.request.RequestProduct;
import ec.blaze.wscore.services.OrderService;
import ec.blaze.wscore.services.ProductService;
import io.swagger.annotations.ApiOperation;


/**
 * Class ws admin orders
 * @author Ruben Martínez
 *
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	@Autowired
	public OrderService orderService;
	
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@GetMapping
	public ResponseEntity<?> list() {		
		return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
	}
	
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(
				err -> errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));

		return ResponseEntity.badRequest().body(errores);
	}
	
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody RequestOrder payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Order order = new Order();
		order.setConsumer(payload.getConsumer());
		order.setStatus(payload.getStatus());
		order.setDate(new Date());		
		
		try {
			order = orderService.save(order);
		}catch(Exception e) {}
		
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody RequestOrder payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Order order = new Order();
		order.setConsumer(payload.getConsumer());
		order.setStatus(payload.getStatus());
		order.setDate(new Date());	
		
		try {
			order = orderService.save(order);
		}catch(Exception e) {}
		
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@PostMapping("/order")
	@ApiOperation(value = "Get order" , notes = "Get order")
	public ResponseEntity<?> getorder(@Valid @RequestBody RequestId payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		return new ResponseEntity<>(orderService.findOneById(payload.getId()), HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@PostMapping("/delete")
	@ApiOperation(value = "Delete order" , notes = "Delete order")
	public ResponseEntity<?> delete(@Valid @RequestBody RequestId payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		int a=0;
		try {
		Order order =orderService.findOneById(payload.getId());
		orderService.delete(order);
		a=1;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

}
